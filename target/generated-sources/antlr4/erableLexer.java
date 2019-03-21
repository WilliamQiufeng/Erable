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
		BNOT=30, LPA=31, RPA=32, LCB=33, RCB=34, ALPA=35, ARPA=36, VAR_ID=37, 
		FUNC=38, WHILE=39, IF=40, ELIF=41, ELSE=42, RETURN=43, BREAK=44, NAME=45, 
		STRING=46, INT=47, BIN=48, OCT=49, HEX=50, UNICODE=51, WS=52;
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
			"LPA", "RPA", "LCB", "RCB", "ALPA", "ARPA", "VAR_SC", "VAR_CG", "VAR_TP", 
			"VAR_ID", "FUNC", "WHILE", "IF", "ELIF", "ELSE", "RETURN", "BREAK", "NAME", 
			"LETT", "STRING", "DIGITS", "INT", "BIN", "OCT", "HEX", "ESC", "UNICODE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0x'", "'0b'", "'0o'", "'+'", "'-'", "'*'", "'/'", "'**'", "'=='", 
			"'!='", "'='", "'<<<'", "'>>>'", "'<='", "'>='", "'<<'", "'>>'", "'&&'", 
			"'||'", "'^^'", "'<'", "'>'", "':'", "';'", "'.'", "','", "'&'", "'|'", 
			"'^'", "'!'", "'('", "')'", "'{'", "'}'", "'['", "']'", null, "'function'", 
			"'while'", "'if'", "'elif'", "'else'", "'return'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ADD", "SUB", "MUL", "DIV", "POW", "EQ", "NEQ", 
			"EQU", "ULS", "URS", "LTE", "GTE", "LS", "RS", "AND", "OR", "XOR", "LT", 
			"GT", "COLON", "SPLIT", "DOT", "COMMA", "BAND", "BOR", "BXOR", "BNOT", 
			"LPA", "RPA", "LCB", "RCB", "ALPA", "ARPA", "VAR_ID", "FUNC", "WHILE", 
			"IF", "ELIF", "ELSE", "RETURN", "BREAK", "NAME", "STRING", "INT", "BIN", 
			"OCT", "HEX", "UNICODE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u015b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\5&\u00d7\n&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u00e8\n\'\3"+
		"(\3(\3(\3(\3(\3(\5(\u00f0\n(\3)\3)\3)\5)\u00f5\n)\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3"+
		"/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\7\61\u0123"+
		"\n\61\f\61\16\61\u0126\13\61\3\62\3\62\3\63\3\63\3\63\7\63\u012d\n\63"+
		"\f\63\16\63\u0130\13\63\3\63\3\63\3\64\3\64\3\65\6\65\u0137\n\65\r\65"+
		"\16\65\u0138\3\66\6\66\u013c\n\66\r\66\16\66\u013d\3\67\6\67\u0141\n\67"+
		"\r\67\16\67\u0142\38\68\u0146\n8\r8\168\u0147\39\39\39\59\u014d\n9\3:"+
		"\3:\3:\3:\3:\3:\3;\6;\u0156\n;\r;\16;\u0157\3;\3;\3\u012e\2<\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\2M\2O\2Q\'S(U)W*Y+[,]-_.a/c\2e\60g\2i\61k\62m\63o\64q\2s\65u"+
		"\66\3\2\n\6\2&&C\\aac|\3\2\62;\3\2\62\63\3\2\62:\5\2\62;CHch\t\2$$^^d"+
		"dhhppttvv\4\2WWww\5\2\13\f\17\17\"\"\2\u0163\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3"+
		"\2\2\2\2a\3\2\2\2\2e\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\3w\3\2\2\2\5z\3\2\2\2\7}\3\2\2\2\t\u0080\3\2"+
		"\2\2\13\u0082\3\2\2\2\r\u0084\3\2\2\2\17\u0086\3\2\2\2\21\u0088\3\2\2"+
		"\2\23\u008b\3\2\2\2\25\u008e\3\2\2\2\27\u0091\3\2\2\2\31\u0093\3\2\2\2"+
		"\33\u0097\3\2\2\2\35\u009b\3\2\2\2\37\u009e\3\2\2\2!\u00a1\3\2\2\2#\u00a4"+
		"\3\2\2\2%\u00a7\3\2\2\2\'\u00aa\3\2\2\2)\u00ad\3\2\2\2+\u00b0\3\2\2\2"+
		"-\u00b2\3\2\2\2/\u00b4\3\2\2\2\61\u00b6\3\2\2\2\63\u00b8\3\2\2\2\65\u00ba"+
		"\3\2\2\2\67\u00bc\3\2\2\29\u00be\3\2\2\2;\u00c0\3\2\2\2=\u00c2\3\2\2\2"+
		"?\u00c4\3\2\2\2A\u00c6\3\2\2\2C\u00c8\3\2\2\2E\u00ca\3\2\2\2G\u00cc\3"+
		"\2\2\2I\u00ce\3\2\2\2K\u00d6\3\2\2\2M\u00e7\3\2\2\2O\u00ef\3\2\2\2Q\u00f4"+
		"\3\2\2\2S\u00f6\3\2\2\2U\u00ff\3\2\2\2W\u0105\3\2\2\2Y\u0108\3\2\2\2["+
		"\u010d\3\2\2\2]\u0112\3\2\2\2_\u0119\3\2\2\2a\u011f\3\2\2\2c\u0127\3\2"+
		"\2\2e\u0129\3\2\2\2g\u0133\3\2\2\2i\u0136\3\2\2\2k\u013b\3\2\2\2m\u0140"+
		"\3\2\2\2o\u0145\3\2\2\2q\u0149\3\2\2\2s\u014e\3\2\2\2u\u0155\3\2\2\2w"+
		"x\7\62\2\2xy\7z\2\2y\4\3\2\2\2z{\7\62\2\2{|\7d\2\2|\6\3\2\2\2}~\7\62\2"+
		"\2~\177\7q\2\2\177\b\3\2\2\2\u0080\u0081\7-\2\2\u0081\n\3\2\2\2\u0082"+
		"\u0083\7/\2\2\u0083\f\3\2\2\2\u0084\u0085\7,\2\2\u0085\16\3\2\2\2\u0086"+
		"\u0087\7\61\2\2\u0087\20\3\2\2\2\u0088\u0089\7,\2\2\u0089\u008a\7,\2\2"+
		"\u008a\22\3\2\2\2\u008b\u008c\7?\2\2\u008c\u008d\7?\2\2\u008d\24\3\2\2"+
		"\2\u008e\u008f\7#\2\2\u008f\u0090\7?\2\2\u0090\26\3\2\2\2\u0091\u0092"+
		"\7?\2\2\u0092\30\3\2\2\2\u0093\u0094\7>\2\2\u0094\u0095\7>\2\2\u0095\u0096"+
		"\7>\2\2\u0096\32\3\2\2\2\u0097\u0098\7@\2\2\u0098\u0099\7@\2\2\u0099\u009a"+
		"\7@\2\2\u009a\34\3\2\2\2\u009b\u009c\7>\2\2\u009c\u009d\7?\2\2\u009d\36"+
		"\3\2\2\2\u009e\u009f\7@\2\2\u009f\u00a0\7?\2\2\u00a0 \3\2\2\2\u00a1\u00a2"+
		"\7>\2\2\u00a2\u00a3\7>\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5\u00a6"+
		"\7@\2\2\u00a6$\3\2\2\2\u00a7\u00a8\7(\2\2\u00a8\u00a9\7(\2\2\u00a9&\3"+
		"\2\2\2\u00aa\u00ab\7~\2\2\u00ab\u00ac\7~\2\2\u00ac(\3\2\2\2\u00ad\u00ae"+
		"\7`\2\2\u00ae\u00af\7`\2\2\u00af*\3\2\2\2\u00b0\u00b1\7>\2\2\u00b1,\3"+
		"\2\2\2\u00b2\u00b3\7@\2\2\u00b3.\3\2\2\2\u00b4\u00b5\7<\2\2\u00b5\60\3"+
		"\2\2\2\u00b6\u00b7\7=\2\2\u00b7\62\3\2\2\2\u00b8\u00b9\7\60\2\2\u00b9"+
		"\64\3\2\2\2\u00ba\u00bb\7.\2\2\u00bb\66\3\2\2\2\u00bc\u00bd\7(\2\2\u00bd"+
		"8\3\2\2\2\u00be\u00bf\7~\2\2\u00bf:\3\2\2\2\u00c0\u00c1\7`\2\2\u00c1<"+
		"\3\2\2\2\u00c2\u00c3\7#\2\2\u00c3>\3\2\2\2\u00c4\u00c5\7*\2\2\u00c5@\3"+
		"\2\2\2\u00c6\u00c7\7+\2\2\u00c7B\3\2\2\2\u00c8\u00c9\7}\2\2\u00c9D\3\2"+
		"\2\2\u00ca\u00cb\7\177\2\2\u00cbF\3\2\2\2\u00cc\u00cd\7]\2\2\u00cdH\3"+
		"\2\2\2\u00ce\u00cf\7_\2\2\u00cfJ\3\2\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2"+
		"\7c\2\2\u00d2\u00d7\7t\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\u00d7\7v\2\2\u00d6\u00d0\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d7L\3\2\2\2\u00d8"+
		"\u00d9\7e\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7u\2\2"+
		"\u00dc\u00e8\7v\2\2\u00dd\u00de\7e\2\2\u00de\u00df\7j\2\2\u00df\u00e0"+
		"\7c\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2\7i\2\2\u00e2\u00e3\7g\2\2\u00e3"+
		"\u00e4\7c\2\2\u00e4\u00e5\7d\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e8\7g\2\2"+
		"\u00e7\u00d8\3\2\2\2\u00e7\u00dd\3\2\2\2\u00e8N\3\2\2\2\u00e9\u00ea\7"+
		"q\2\2\u00ea\u00eb\7d\2\2\u00eb\u00f0\7l\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ee"+
		"\7g\2\2\u00ee\u00f0\7h\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0"+
		"P\3\2\2\2\u00f1\u00f5\5K&\2\u00f2\u00f5\5M\'\2\u00f3\u00f5\5O(\2\u00f4"+
		"\u00f1\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5R\3\2\2\2"+
		"\u00f6\u00f7\7h\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa"+
		"\7e\2\2\u00fa\u00fb\7v\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7q\2\2\u00fd"+
		"\u00fe\7p\2\2\u00feT\3\2\2\2\u00ff\u0100\7y\2\2\u0100\u0101\7j\2\2\u0101"+
		"\u0102\7k\2\2\u0102\u0103\7n\2\2\u0103\u0104\7g\2\2\u0104V\3\2\2\2\u0105"+
		"\u0106\7k\2\2\u0106\u0107\7h\2\2\u0107X\3\2\2\2\u0108\u0109\7g\2\2\u0109"+
		"\u010a\7n\2\2\u010a\u010b\7k\2\2\u010b\u010c\7h\2\2\u010cZ\3\2\2\2\u010d"+
		"\u010e\7g\2\2\u010e\u010f\7n\2\2\u010f\u0110\7u\2\2\u0110\u0111\7g\2\2"+
		"\u0111\\\3\2\2\2\u0112\u0113\7t\2\2\u0113\u0114\7g\2\2\u0114\u0115\7v"+
		"\2\2\u0115\u0116\7w\2\2\u0116\u0117\7t\2\2\u0117\u0118\7p\2\2\u0118^\3"+
		"\2\2\2\u0119\u011a\7d\2\2\u011a\u011b\7t\2\2\u011b\u011c\7g\2\2\u011c"+
		"\u011d\7c\2\2\u011d\u011e\7m\2\2\u011e`\3\2\2\2\u011f\u0124\5c\62\2\u0120"+
		"\u0123\5c\62\2\u0121\u0123\5g\64\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2"+
		"\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"b\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\t\2\2\2\u0128d\3\2\2\2\u0129"+
		"\u012e\7$\2\2\u012a\u012d\5q9\2\u012b\u012d\13\2\2\2\u012c\u012a\3\2\2"+
		"\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012f\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7$\2\2\u0132"+
		"f\3\2\2\2\u0133\u0134\t\3\2\2\u0134h\3\2\2\2\u0135\u0137\t\3\2\2\u0136"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139j\3\2\2\2\u013a\u013c\t\4\2\2\u013b\u013a\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013el\3\2\2\2\u013f"+
		"\u0141\t\5\2\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143n\3\2\2\2\u0144\u0146\t\6\2\2\u0145\u0144"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"p\3\2\2\2\u0149\u014c\7^\2\2\u014a\u014d\t\7\2\2\u014b\u014d\5s:\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014b\3\2\2\2\u014dr\3\2\2\2\u014e\u014f\t\b\2\2"+
		"\u014f\u0150\5o8\2\u0150\u0151\5o8\2\u0151\u0152\5o8\2\u0152\u0153\5o"+
		"8\2\u0153t\3\2\2\2\u0154\u0156\t\t\2\2\u0155\u0154\3\2\2\2\u0156\u0157"+
		"\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015a\b;\2\2\u015av\3\2\2\2\21\2\u00d6\u00e7\u00ef\u00f4\u0122\u0124"+
		"\u012c\u012e\u0138\u013d\u0142\u0147\u014c\u0157\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}