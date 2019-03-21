// Generated from erable.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class erableLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ADD=4, SUB=5, MUL=6, DIV=7, POW=8, EQ=9, NEQ=10, 
		EQU=11, ULS=12, URS=13, LTE=14, GTE=15, LS=16, RS=17, AND=18, OR=19, XOR=20, 
		LT=21, GT=22, COLON=23, SPLIT=24, DOT=25, COMMA=26, BAND=27, BOR=28, BXOR=29, 
		BNOT=30, LPA=31, RPA=32, LCB=33, RCB=34, VAR_ID=35, FUNC=36, WHILE=37, 
		IF=38, ELIF=39, ELSE=40, RETURN=41, BREAK=42, NAME=43, STRING=44, INT=45, 
		BIN=46, OCT=47, HEX=48, UNICODE=49, WS=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "ADD", "SUB", "MUL", "DIV", "POW", "EQ", "NEQ", 
			"EQU", "ULS", "URS", "LTE", "GTE", "LS", "RS", "AND", "OR", "XOR", "LT", 
			"GT", "COLON", "SPLIT", "DOT", "COMMA", "BAND", "BOR", "BXOR", "BNOT", 
			"LPA", "RPA", "LCB", "RCB", "VAR_SC", "VAR_CG", "VAR_TP", "VAR_ID", "FUNC", 
			"WHILE", "IF", "ELIF", "ELSE", "RETURN", "BREAK", "NAME", "LETT", "STRING", 
			"DIGITS", "INT", "BIN", "OCT", "HEX", "ESC", "UNICODE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0x'", "'0b'", "'0o'", "'+'", "'-'", "'*'", "'/'", "'**'", "'=='", 
			"'!='", "'='", "'<<<'", "'>>>'", "'<='", "'>='", "'<<'", "'>>'", "'&&'", 
			"'||'", "'^^'", "'<'", "'>'", "':'", "';'", "'.'", "','", "'&'", "'|'", 
			"'^'", "'!'", "'('", "')'", "'{'", "'}'", null, "'function'", "'while'", 
			"'if'", "'elif'", "'else'", "'return'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ADD", "SUB", "MUL", "DIV", "POW", "EQ", "NEQ", 
			"EQU", "ULS", "URS", "LTE", "GTE", "LS", "RS", "AND", "OR", "XOR", "LT", 
			"GT", "COLON", "SPLIT", "DOT", "COMMA", "BAND", "BOR", "BXOR", "BNOT", 
			"LPA", "RPA", "LCB", "RCB", "VAR_ID", "FUNC", "WHILE", "IF", "ELIF", 
			"ELSE", "RETURN", "BREAK", "NAME", "STRING", "INT", "BIN", "OCT", "HEX", 
			"UNICODE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public erableLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "erable.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0153\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\5$\u00cf\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\5%\u00e0\n%\3&\3&\3&\3&\3&\3&\5&\u00e8\n&\3\'\3\'\3"+
		"\'\5\'\u00ed\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3"+
		"*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3"+
		".\3/\3/\3/\7/\u011b\n/\f/\16/\u011e\13/\3\60\3\60\3\61\3\61\3\61\7\61"+
		"\u0125\n\61\f\61\16\61\u0128\13\61\3\61\3\61\3\62\3\62\3\63\6\63\u012f"+
		"\n\63\r\63\16\63\u0130\3\64\6\64\u0134\n\64\r\64\16\64\u0135\3\65\6\65"+
		"\u0139\n\65\r\65\16\65\u013a\3\66\6\66\u013e\n\66\r\66\16\66\u013f\3\67"+
		"\3\67\3\67\5\67\u0145\n\67\38\38\38\38\38\38\39\69\u014e\n9\r9\169\u014f"+
		"\39\39\3\u0126\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G\2I\2K\2M%O&Q\'S(U)W*Y+[,]-_\2a.c\2e/g\60"+
		"i\61k\62m\2o\63q\64\3\2\n\6\2&&C\\aac|\3\2\62;\3\2\62\63\3\2\62:\5\2\62"+
		";CHch\t\2$$^^ddhhppttvv\4\2WWww\5\2\13\f\17\17\"\"\2\u015b\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2a\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2o\3\2"+
		"\2\2\2q\3\2\2\2\3s\3\2\2\2\5v\3\2\2\2\7y\3\2\2\2\t|\3\2\2\2\13~\3\2\2"+
		"\2\r\u0080\3\2\2\2\17\u0082\3\2\2\2\21\u0084\3\2\2\2\23\u0087\3\2\2\2"+
		"\25\u008a\3\2\2\2\27\u008d\3\2\2\2\31\u008f\3\2\2\2\33\u0093\3\2\2\2\35"+
		"\u0097\3\2\2\2\37\u009a\3\2\2\2!\u009d\3\2\2\2#\u00a0\3\2\2\2%\u00a3\3"+
		"\2\2\2\'\u00a6\3\2\2\2)\u00a9\3\2\2\2+\u00ac\3\2\2\2-\u00ae\3\2\2\2/\u00b0"+
		"\3\2\2\2\61\u00b2\3\2\2\2\63\u00b4\3\2\2\2\65\u00b6\3\2\2\2\67\u00b8\3"+
		"\2\2\29\u00ba\3\2\2\2;\u00bc\3\2\2\2=\u00be\3\2\2\2?\u00c0\3\2\2\2A\u00c2"+
		"\3\2\2\2C\u00c4\3\2\2\2E\u00c6\3\2\2\2G\u00ce\3\2\2\2I\u00df\3\2\2\2K"+
		"\u00e7\3\2\2\2M\u00ec\3\2\2\2O\u00ee\3\2\2\2Q\u00f7\3\2\2\2S\u00fd\3\2"+
		"\2\2U\u0100\3\2\2\2W\u0105\3\2\2\2Y\u010a\3\2\2\2[\u0111\3\2\2\2]\u0117"+
		"\3\2\2\2_\u011f\3\2\2\2a\u0121\3\2\2\2c\u012b\3\2\2\2e\u012e\3\2\2\2g"+
		"\u0133\3\2\2\2i\u0138\3\2\2\2k\u013d\3\2\2\2m\u0141\3\2\2\2o\u0146\3\2"+
		"\2\2q\u014d\3\2\2\2st\7\62\2\2tu\7z\2\2u\4\3\2\2\2vw\7\62\2\2wx\7d\2\2"+
		"x\6\3\2\2\2yz\7\62\2\2z{\7q\2\2{\b\3\2\2\2|}\7-\2\2}\n\3\2\2\2~\177\7"+
		"/\2\2\177\f\3\2\2\2\u0080\u0081\7,\2\2\u0081\16\3\2\2\2\u0082\u0083\7"+
		"\61\2\2\u0083\20\3\2\2\2\u0084\u0085\7,\2\2\u0085\u0086\7,\2\2\u0086\22"+
		"\3\2\2\2\u0087\u0088\7?\2\2\u0088\u0089\7?\2\2\u0089\24\3\2\2\2\u008a"+
		"\u008b\7#\2\2\u008b\u008c\7?\2\2\u008c\26\3\2\2\2\u008d\u008e\7?\2\2\u008e"+
		"\30\3\2\2\2\u008f\u0090\7>\2\2\u0090\u0091\7>\2\2\u0091\u0092\7>\2\2\u0092"+
		"\32\3\2\2\2\u0093\u0094\7@\2\2\u0094\u0095\7@\2\2\u0095\u0096\7@\2\2\u0096"+
		"\34\3\2\2\2\u0097\u0098\7>\2\2\u0098\u0099\7?\2\2\u0099\36\3\2\2\2\u009a"+
		"\u009b\7@\2\2\u009b\u009c\7?\2\2\u009c \3\2\2\2\u009d\u009e\7>\2\2\u009e"+
		"\u009f\7>\2\2\u009f\"\3\2\2\2\u00a0\u00a1\7@\2\2\u00a1\u00a2\7@\2\2\u00a2"+
		"$\3\2\2\2\u00a3\u00a4\7(\2\2\u00a4\u00a5\7(\2\2\u00a5&\3\2\2\2\u00a6\u00a7"+
		"\7~\2\2\u00a7\u00a8\7~\2\2\u00a8(\3\2\2\2\u00a9\u00aa\7`\2\2\u00aa\u00ab"+
		"\7`\2\2\u00ab*\3\2\2\2\u00ac\u00ad\7>\2\2\u00ad,\3\2\2\2\u00ae\u00af\7"+
		"@\2\2\u00af.\3\2\2\2\u00b0\u00b1\7<\2\2\u00b1\60\3\2\2\2\u00b2\u00b3\7"+
		"=\2\2\u00b3\62\3\2\2\2\u00b4\u00b5\7\60\2\2\u00b5\64\3\2\2\2\u00b6\u00b7"+
		"\7.\2\2\u00b7\66\3\2\2\2\u00b8\u00b9\7(\2\2\u00b98\3\2\2\2\u00ba\u00bb"+
		"\7~\2\2\u00bb:\3\2\2\2\u00bc\u00bd\7`\2\2\u00bd<\3\2\2\2\u00be\u00bf\7"+
		"#\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7*\2\2\u00c1@\3\2\2\2\u00c2\u00c3\7+"+
		"\2\2\u00c3B\3\2\2\2\u00c4\u00c5\7}\2\2\u00c5D\3\2\2\2\u00c6\u00c7\7\177"+
		"\2\2\u00c7F\3\2\2\2\u00c8\u00c9\7x\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cf"+
		"\7t\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7g\2\2\u00cd\u00cf\7v\2\2\u00ce"+
		"\u00c8\3\2\2\2\u00ce\u00cb\3\2\2\2\u00cfH\3\2\2\2\u00d0\u00d1\7e\2\2\u00d1"+
		"\u00d2\7q\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7u\2\2\u00d4\u00e0\7v\2\2"+
		"\u00d5\u00d6\7e\2\2\u00d6\u00d7\7j\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9"+
		"\7p\2\2\u00d9\u00da\7i\2\2\u00da\u00db\7g\2\2\u00db\u00dc\7c\2\2\u00dc"+
		"\u00dd\7d\2\2\u00dd\u00de\7n\2\2\u00de\u00e0\7g\2\2\u00df\u00d0\3\2\2"+
		"\2\u00df\u00d5\3\2\2\2\u00e0J\3\2\2\2\u00e1\u00e2\7q\2\2\u00e2\u00e3\7"+
		"d\2\2\u00e3\u00e8\7l\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e8"+
		"\7h\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e8L\3\2\2\2\u00e9\u00ed"+
		"\5G$\2\u00ea\u00ed\5I%\2\u00eb\u00ed\5K&\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea"+
		"\3\2\2\2\u00ec\u00eb\3\2\2\2\u00edN\3\2\2\2\u00ee\u00ef\7h\2\2\u00ef\u00f0"+
		"\7w\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7e\2\2\u00f2\u00f3\7v\2\2\u00f3"+
		"\u00f4\7k\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7p\2\2\u00f6P\3\2\2\2\u00f7"+
		"\u00f8\7y\2\2\u00f8\u00f9\7j\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7n\2\2"+
		"\u00fb\u00fc\7g\2\2\u00fcR\3\2\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7h\2"+
		"\2\u00ffT\3\2\2\2\u0100\u0101\7g\2\2\u0101\u0102\7n\2\2\u0102\u0103\7"+
		"k\2\2\u0103\u0104\7h\2\2\u0104V\3\2\2\2\u0105\u0106\7g\2\2\u0106\u0107"+
		"\7n\2\2\u0107\u0108\7u\2\2\u0108\u0109\7g\2\2\u0109X\3\2\2\2\u010a\u010b"+
		"\7t\2\2\u010b\u010c\7g\2\2\u010c\u010d\7v\2\2\u010d\u010e\7w\2\2\u010e"+
		"\u010f\7t\2\2\u010f\u0110\7p\2\2\u0110Z\3\2\2\2\u0111\u0112\7d\2\2\u0112"+
		"\u0113\7t\2\2\u0113\u0114\7g\2\2\u0114\u0115\7c\2\2\u0115\u0116\7m\2\2"+
		"\u0116\\\3\2\2\2\u0117\u011c\5_\60\2\u0118\u011b\5_\60\2\u0119\u011b\5"+
		"c\62\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d^\3\2\2\2\u011e\u011c\3\2\2\2"+
		"\u011f\u0120\t\2\2\2\u0120`\3\2\2\2\u0121\u0126\7$\2\2\u0122\u0125\5m"+
		"\67\2\u0123\u0125\13\2\2\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125"+
		"\u0128\3\2\2\2\u0126\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0129\3\2"+
		"\2\2\u0128\u0126\3\2\2\2\u0129\u012a\7$\2\2\u012ab\3\2\2\2\u012b\u012c"+
		"\t\3\2\2\u012cd\3\2\2\2\u012d\u012f\t\3\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131f\3\2\2\2"+
		"\u0132\u0134\t\4\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136h\3\2\2\2\u0137\u0139\t\5\2\2\u0138"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2"+
		"\2\2\u013bj\3\2\2\2\u013c\u013e\t\6\2\2\u013d\u013c\3\2\2\2\u013e\u013f"+
		"\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140l\3\2\2\2\u0141"+
		"\u0144\7^\2\2\u0142\u0145\t\7\2\2\u0143\u0145\5o8\2\u0144\u0142\3\2\2"+
		"\2\u0144\u0143\3\2\2\2\u0145n\3\2\2\2\u0146\u0147\t\b\2\2\u0147\u0148"+
		"\5k\66\2\u0148\u0149\5k\66\2\u0149\u014a\5k\66\2\u014a\u014b\5k\66\2\u014b"+
		"p\3\2\2\2\u014c\u014e\t\t\2\2\u014d\u014c\3\2\2\2\u014e\u014f\3\2\2\2"+
		"\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152"+
		"\b9\2\2\u0152r\3\2\2\2\21\2\u00ce\u00df\u00e7\u00ec\u011a\u011c\u0124"+
		"\u0126\u0130\u0135\u013a\u013f\u0144\u014f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}