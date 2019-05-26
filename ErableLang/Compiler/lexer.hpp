#ifndef _ERABLE_COMPILER_LEXER_HPP_
#define _ERABLE_COMPILER_LEXER_HPP_

#include <string>
#include <fstream>
#include <iostream>
#include "token.hpp"

class Lexer
{
public:
	Lexer(char filename);
	~Lexer();

	char lookAheadChar(Lexer* lexer);
	void getNextToken(Lexer* lexer);
	bool matchToken(Lexer* lexer, TokenType expected);
	void consumeCurToken(Lexer* lexer, TokenType expected);
	void consumeNextToken(Lexer* lexer, TokenType expected);
	uint32_t getByteNumOfEncodingUtf8(uint8_t* buf, int value);

	inline int getLine()
	{
		return line;
	}

	std::ifstream file;
	std::string   sourceCode;
	char   nextChar;
	char   currChar;
	Token currToken;
	Token preToken;

	// 处于内联表达式之中时，期望的右括号数量
	// 用于跟踪小括号对的嵌套
	int interpolationExpectRightParenNum;

	int line;
};

inline void reportError(int line, const char* type, const char* msg)
{
	std::cerr << type << " Error.\n" <<
		"In line " << line << ":\n\t" <<
		msg << '\n';
	abort();
}

#define LEX_ERROR(obj, msg) \
	reportError(obj.line, "Lex", msg);

#define COMPILE_ERROR(obj, msg) \
	reportError(obj.line, "Compile", msg);

#define 

#endif // !_ERABLE_COMPILER_LEXER_HPP_
