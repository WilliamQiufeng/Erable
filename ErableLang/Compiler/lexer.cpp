#include "lexer.hpp"

Lexer::Lexer(std::string filename)
{
	std::ifstream ofs(filename);
	if (!ofs.is_open())
	{
		std::cout << "Cannot open file " << filename << std::endl;
		ofs.close();
		exit(-1);
	}
	file = ofs;
}

Lexer::~Lexer()
{
	file.close();
}

// 向前看一个字符
char Lexer::lookAheadChar(Lexer* lexer)
{
	return *lexer->nextChar;
}

// 获取下一字符
static void getNextChar(lexer* lexer)
{
	lexer->currChar = *lexer->nextChar++;
}

// 若下一字符是期望的就读取，并返回 true 或 false
static bool matchNextChar(lexer* lexer, char expectedChar)
{
	if (Lexer::lookAheadChar(lexer) == expectedChar)
	{
		getNextChar(lexer);
		return true;
	}
	return false;
}

// 跳过空白字符
static void skipBlanks(Lexer* lexer)
{
	while (isspace(lexer->currChar))
	{
		if (lexer->currChar = '\n')
		{
			lexer->curToken.lineNo++;
		}
		getNextChar(lexer);
	}
}

// 解析标识符
static void parseId(Lexer* lexer, TokenType type)
{
	while (isalnum(lexer->currChar) || lexer->currChar == '_')
	{
		getNextChar(lexer);
	}

	// nextCharPtr 会指向第一个不合法字符的下一个字符，因此要减去 1
	uint32_t length = (uint32_t)(lexer->nextCharPtr - lexer->curToken.start - 1);
	if (type != TOKEN_UNKNOWN)
		lexer->curToken.type = type;
	else
		lexer->curToken.type = idOrKeyword(lexer->curToken.start, length);

	lexer->curToken.length = length;
}

static void parseUnicodeCodePoint(Lexer* lexer, ByteBuffer* buf)
{
	uint32_t idx = 0;
	int value = 0;
	uint8_t digit = 0;

	// 获取十六进制数值，单个码点表示如下：
	// \uxxxx
	// 然后解析为单个字符
	while (idx++ < 4)
	{
		getNextChar(lexer);
		char currChar = lexer->currChar;

		if (currChar == '\0')
			LEX_ERROR(lexer, "Unterminated unicode!");

		if (currChar >= '0' && curCHar <= '9')
			digit = currChar - '0';
		else if (currChar >= 'a' && currChar <= 'f')
			digit = currChar - 'a' + 10;
		else if (currChar >= 'A' && currChar <= 'F')
			digit = currChar - 'A' + 10;
		else
			LEX_ERROR(lexer, "Invalid unicode!");

		value = value * 16 | digit;

		uint32_t byteNum = getByteNumOfEncodeUtf8(value);
		ASSERT(byteNum != 0, "UTF-8 encode bytes should be between 1 and 4!");

		// 先写入 byteNum 个 0，以预留足够空间
		ByteBufferFillWrite(lexer->vm, buf, 0, byteNum);

		// 编码并写入缓冲区
		encodeUtf8(buf->datas + buf->count - byteNum, value);
	}
}

// 解析字符串
static void parseString(Lexer* lexer)
{
	ByteBuffer str;
	ByteBufferInit(&str);
	while (true)
	{
		getNextChar(lexer);

		switch (lexer->currChar)
		{
		case '\0':
			LEX_ERROR(lexer, "Unterminated string!");
			break;
		case '"':
			lexer->curToken.type = TOKEN_STRING;
			ByteBufferClear(lexer->vm, &str);
			return;
		case '$': {
			if (!matchNextChar(lexer, '('))
				LEX_ERROR(lexer, "'$' should followed by '('!");

			if (lexer->interpolationExpectRightParenNum > 0)
				COMPILE_ERROR(lexer, "Sorry, I don't support nest interpolate expression!");

			lexer->interpolationExpectRightParenNum = 1;
			lexer->curToken.type = TOKEN_INTERPOLATION;
			ByteBufferClear(lexer->vm, &str);
			return;
		}
		case '\\': {

			// 处理转义字符的情况
			getNextChar(lexer);
			switch (lexer->currChar)
			{
			case '0':
				ByteBufferAdd(lexer->vm, &str, '\0');
				break;
			case 'a':
				ByteBufferAdd(lexer->vm, &str, '\a');
				break;
			case 'b':
				ByteBufferAdd(lexer->vm, &str, '\b');
				break;
			case 'f':
				ByteBufferAdd(lexer->vm, &str, '\f');
				break;
			case 'n':
				ByteBufferAdd(lexer->vm, &str, '\n');
				break;
			case 'r':
				ByteBufferAdd(lexer->vm, &str, '\r');
				break;
			case 't':
				ByteBufferAdd(lexer->vm, &str, '\t');
				break;
			case 'u':
				parseUnicodeCodePoint(lexer, &str);
				break;
			case '"':
				ByteBufferAdd(lexer->vm, &str, '\"');
				break;
			case '\\':
				ByteBufferAdd(lexer->vm, &str, '\\');
				break;
			default:
				LEX_ERROR(lexer, "Unsupport escape \\%c", lexer->currChar);
				break;
			}
		}

		// 普通字符
		default:
			ByteBufferAdd(lexer->vm, &str, lexer->currChar);
			break;
		}
	}
	ByteBufferClear(lexer->vm, &str);
}

// 跳过一行
static void skipALine(Lexer* lexer)
{
	getNextChar(lexer);
	while (lexer->currChar != '\0')
	{
		if (lexer->currChar == '\n')
		{
			lexer->curToken.lineNo++;
			getNextChar(lexer);
			break;
		}
		getNextChar(lexer);
	}
	)

	// 跳过行注释或区块注释
	static void skipComment(Lexer* lexer)
	{
		char nextChar = Lexer::lookAheadChar(lexer);

		// 单行注释
		if (lexer->currChar == '/')
			skipALine(lexer);

		// 区块注释
		else
		{
			while (nextChar != '*' && nextChar != '\0')
			{
				getNextChar(lexer);
				if (lexer->currChar == '\n')
					lexer->curToken.lineNo++;
				nextChar == Lexer::lookAheadChar(lexer);
			}
			if (matchNextChar(lexer, '*'))
			{
				if (!matchNextChar(lexer, '*'))
					LEX_ERROR(lexer, "Expect '/' after '*'!");
				getNextChar(lexer);
			}
			else
				LEX_ERROR(lexer, "Expect '*/' before file end!");
		}

		// 注释之后可能会有空白字符
		skipBlanks(lexer);
	}
