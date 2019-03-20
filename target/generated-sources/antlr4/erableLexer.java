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
		T__0=1, T__1=2, T__2=3, ADD=4, SUB=5, MUL=6, DIV=7, POW=8, EQU=9, COLON=10, 
		SPLIT=11, DOT=12, COMMA=13, LPA=14, RPA=15, LCB=16, RCB=17, VAR_ID=18, 
		FUNC=19, NAME=20, STRING=21, INT=22, BIN=23, OCT=24, HEX=25, UNICODE=26, 
		WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "ADD", "SUB", "MUL", "DIV", "POW", "EQU", "COLON", 
			"SPLIT", "DOT", "COMMA", "LPA", "RPA", "LCB", "RCB", "VAR_SC", "VAR_CG", 
			"VAR_TP", "VAR_ID", "FUNC", "NAME", "LETT", "STRING", "DIGITS", "INT", 
			"BIN", "OCT", "HEX", "ESC", "UNICODE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0x'", "'0b'", "'0o'", "'+'", "'-'", "'*'", "'/'", "'**'", "'='", 
			"':'", "';'", "'.'", "','", "'('", "')'", "'{'", "'}'", null, "'function'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ADD", "SUB", "MUL", "DIV", "POW", "EQU", "COLON", 
			"SPLIT", "DOT", "COMMA", "LPA", "RPA", "LCB", "RCB", "VAR_ID", "FUNC", 
			"NAME", "STRING", "INT", "BIN", "OCT", "HEX", "UNICODE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00d6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23r\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0083\n\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u008b"+
		"\n\25\3\26\3\26\3\26\5\26\u0090\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\7\30\u009e\n\30\f\30\16\30\u00a1\13\30\3\31"+
		"\3\31\3\32\3\32\3\32\7\32\u00a8\n\32\f\32\16\32\u00ab\13\32\3\32\3\32"+
		"\3\33\3\33\3\34\6\34\u00b2\n\34\r\34\16\34\u00b3\3\35\6\35\u00b7\n\35"+
		"\r\35\16\35\u00b8\3\36\6\36\u00bc\n\36\r\36\16\36\u00bd\3\37\6\37\u00c1"+
		"\n\37\r\37\16\37\u00c2\3 \3 \3 \5 \u00c8\n \3!\3!\3!\3!\3!\3!\3\"\6\""+
		"\u00d1\n\"\r\"\16\"\u00d2\3\"\3\"\3\u00a9\2#\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\2\'\2)\2+"+
		"\24-\25/\26\61\2\63\27\65\2\67\309\31;\32=\33?\2A\34C\35\3\2\n\6\2&&C"+
		"\\aac|\3\2\62;\3\2\62\63\3\2\62:\5\2\62;CHch\t\2$$^^ddhhppttvv\4\2WWw"+
		"w\5\2\13\f\17\17\"\"\2\u00de\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\63\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\3E\3\2\2\2\5H\3\2\2\2\7K\3\2\2\2\tN\3\2\2\2\13P\3\2\2\2\rR\3\2\2"+
		"\2\17T\3\2\2\2\21V\3\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27]\3\2\2\2\31_\3\2"+
		"\2\2\33a\3\2\2\2\35c\3\2\2\2\37e\3\2\2\2!g\3\2\2\2#i\3\2\2\2%q\3\2\2\2"+
		"\'\u0082\3\2\2\2)\u008a\3\2\2\2+\u008f\3\2\2\2-\u0091\3\2\2\2/\u009a\3"+
		"\2\2\2\61\u00a2\3\2\2\2\63\u00a4\3\2\2\2\65\u00ae\3\2\2\2\67\u00b1\3\2"+
		"\2\29\u00b6\3\2\2\2;\u00bb\3\2\2\2=\u00c0\3\2\2\2?\u00c4\3\2\2\2A\u00c9"+
		"\3\2\2\2C\u00d0\3\2\2\2EF\7\62\2\2FG\7z\2\2G\4\3\2\2\2HI\7\62\2\2IJ\7"+
		"d\2\2J\6\3\2\2\2KL\7\62\2\2LM\7q\2\2M\b\3\2\2\2NO\7-\2\2O\n\3\2\2\2PQ"+
		"\7/\2\2Q\f\3\2\2\2RS\7,\2\2S\16\3\2\2\2TU\7\61\2\2U\20\3\2\2\2VW\7,\2"+
		"\2WX\7,\2\2X\22\3\2\2\2YZ\7?\2\2Z\24\3\2\2\2[\\\7<\2\2\\\26\3\2\2\2]^"+
		"\7=\2\2^\30\3\2\2\2_`\7\60\2\2`\32\3\2\2\2ab\7.\2\2b\34\3\2\2\2cd\7*\2"+
		"\2d\36\3\2\2\2ef\7+\2\2f \3\2\2\2gh\7}\2\2h\"\3\2\2\2ij\7\177\2\2j$\3"+
		"\2\2\2kl\7x\2\2lm\7c\2\2mr\7t\2\2no\7n\2\2op\7g\2\2pr\7v\2\2qk\3\2\2\2"+
		"qn\3\2\2\2r&\3\2\2\2st\7e\2\2tu\7q\2\2uv\7p\2\2vw\7u\2\2w\u0083\7v\2\2"+
		"xy\7e\2\2yz\7j\2\2z{\7c\2\2{|\7p\2\2|}\7i\2\2}~\7g\2\2~\177\7c\2\2\177"+
		"\u0080\7d\2\2\u0080\u0081\7n\2\2\u0081\u0083\7g\2\2\u0082s\3\2\2\2\u0082"+
		"x\3\2\2\2\u0083(\3\2\2\2\u0084\u0085\7q\2\2\u0085\u0086\7d\2\2\u0086\u008b"+
		"\7l\2\2\u0087\u0088\7t\2\2\u0088\u0089\7g\2\2\u0089\u008b\7h\2\2\u008a"+
		"\u0084\3\2\2\2\u008a\u0087\3\2\2\2\u008b*\3\2\2\2\u008c\u0090\5%\23\2"+
		"\u008d\u0090\5\'\24\2\u008e\u0090\5)\25\2\u008f\u008c\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u008f\u008e\3\2\2\2\u0090,\3\2\2\2\u0091\u0092\7h\2\2\u0092\u0093"+
		"\7w\2\2\u0093\u0094\7p\2\2\u0094\u0095\7e\2\2\u0095\u0096\7v\2\2\u0096"+
		"\u0097\7k\2\2\u0097\u0098\7q\2\2\u0098\u0099\7p\2\2\u0099.\3\2\2\2\u009a"+
		"\u009f\5\61\31\2\u009b\u009e\5\61\31\2\u009c\u009e\5\65\33\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\60\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\t\2\2"+
		"\2\u00a3\62\3\2\2\2\u00a4\u00a9\7$\2\2\u00a5\u00a8\5? \2\u00a6\u00a8\13"+
		"\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ac\u00ad\7$\2\2\u00ad\64\3\2\2\2\u00ae\u00af\t\3\2\2\u00af\66"+
		"\3\2\2\2\u00b0\u00b2\t\3\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b48\3\2\2\2\u00b5\u00b7\t\4\2\2"+
		"\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9:\3\2\2\2\u00ba\u00bc\t\5\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be<\3\2\2\2"+
		"\u00bf\u00c1\t\6\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3>\3\2\2\2\u00c4\u00c7\7^\2\2\u00c5\u00c8"+
		"\t\7\2\2\u00c6\u00c8\5A!\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8"+
		"@\3\2\2\2\u00c9\u00ca\t\b\2\2\u00ca\u00cb\5=\37\2\u00cb\u00cc\5=\37\2"+
		"\u00cc\u00cd\5=\37\2\u00cd\u00ce\5=\37\2\u00ceB\3\2\2\2\u00cf\u00d1\t"+
		"\t\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\b\"\2\2\u00d5D\3\2\2\2"+
		"\21\2q\u0082\u008a\u008f\u009d\u009f\u00a7\u00a9\u00b3\u00b8\u00bd\u00c2"+
		"\u00c7\u00d2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}