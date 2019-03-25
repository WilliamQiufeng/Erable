// Generated from erable.g4 by ANTLR 4.7.2

  import java.util.*;
  import com.qiufeng.erable.*;
  import com.qiufeng.erable.ast.*;

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
		T__0=1, T__1=2, T__2=3, T__3=4, EQU=5, BINOPS=6, COLON=7, SPLIT=8, COMMA=9, 
		LPA=10, RPA=11, LCB=12, RCB=13, ALPA=14, ARPA=15, VAR_ID=16, FUNC=17, 
		WHILE=18, IF=19, ELIF=20, ELSE=21, RETURN=22, BREAK=23, NAME=24, INT=25, 
		BIN=26, OCT=27, HEX=28, ESC=29, UNICODE=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "EQU", "BINOPS", "POW", "ULS", "URS", 
			"SWITCH", "LTE", "GTE", "LS", "RS", "AND", "OR", "XOR", "ADDEQ", "SUBEQ", 
			"MULEQ", "DIVEQ", "MODEQ", "EQ", "NEQ", "LT", "GT", "COLON", "SPLIT", 
			"DOT", "COMMA", "ADD", "SUB", "MUL", "DIV", "MOD", "BAND", "BOR", "BXOR", 
			"BNOT", "LPA", "RPA", "LCB", "RCB", "ALPA", "ARPA", "VAR_SC", "VAR_CG", 
			"VAR_TP", "VAR_ID", "FUNC", "WHILE", "IF", "ELIF", "ELSE", "RETURN", 
			"BREAK", "NAME", "LETT", "DIGITS", "INT", "BIN", "OCT", "HEX", "ESC", 
			"UNICODE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\"'", "'0x'", "'0b'", "'0o'", "'='", null, "':'", "';'", "','", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", null, "'function'", "'while'", 
			"'if'", "'elif'", "'else'", "'return'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "EQU", "BINOPS", "COLON", "SPLIT", "COMMA", 
			"LPA", "RPA", "LCB", "RCB", "ALPA", "ARPA", "VAR_ID", "FUNC", "WHILE", 
			"IF", "ELIF", "ELSE", "RETURN", "BREAK", "NAME", "INT", "BIN", "OCT", 
			"HEX", "ESC", "UNICODE", "WS"
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


	  Scope root=new Scope(null,Scope.Type.CODEBLOCK);
	  Scope current=root;


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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u0197\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b2"+
		"\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-"+
		"\3-\3.\3.\3/\3/\3/\3/\3/\3/\5/\u011d\n/\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u012e\n\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\5\61\u0136\n\61\3\62\3\62\3\62\5\62\u013b\n\62\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3"+
		"8\38\38\38\38\38\38\39\39\39\39\39\39\3:\3:\3:\7:\u0169\n:\f:\16:\u016c"+
		"\13:\3;\3;\3<\3<\3=\6=\u0173\n=\r=\16=\u0174\3>\6>\u0178\n>\r>\16>\u0179"+
		"\3?\6?\u017d\n?\r?\16?\u017e\3@\6@\u0182\n@\r@\16@\u0183\3A\3A\3A\5A\u0189"+
		"\nA\3B\3B\3B\3B\3B\3B\3C\6C\u0192\nC\rC\16C\u0193\3C\3C\2\2D\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2"+
		"\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\t9\n;\2=\13?\2A\2C\2E\2G\2I\2K\2M\2"+
		"O\2Q\fS\rU\16W\17Y\20[\21]\2_\2a\2c\22e\23g\24i\25k\26m\27o\30q\31s\32"+
		"u\2w\2y\33{\34}\35\177\36\u0081\37\u0083 \u0085!\3\2\n\6\2&&C\\aac|\3"+
		"\2\62;\3\2\62\63\3\2\62:\5\2\62;CHch\t\2$$^^ddhhppttvv\4\2WWww\5\2\13"+
		"\f\17\17\"\"\2\u019c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2=\3\2\2\2\2Q\3\2\2\2"+
		"\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2c\3\2\2\2\2e"+
		"\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2"+
		"\2\2\2s\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\3\u0087\3\2\2\2\5\u0089\3\2\2"+
		"\2\7\u008c\3\2\2\2\t\u008f\3\2\2\2\13\u0092\3\2\2\2\r\u00b1\3\2\2\2\17"+
		"\u00b3\3\2\2\2\21\u00b6\3\2\2\2\23\u00ba\3\2\2\2\25\u00be\3\2\2\2\27\u00c2"+
		"\3\2\2\2\31\u00c5\3\2\2\2\33\u00c8\3\2\2\2\35\u00cb\3\2\2\2\37\u00ce\3"+
		"\2\2\2!\u00d1\3\2\2\2#\u00d4\3\2\2\2%\u00d7\3\2\2\2\'\u00da\3\2\2\2)\u00dd"+
		"\3\2\2\2+\u00e0\3\2\2\2-\u00e3\3\2\2\2/\u00e6\3\2\2\2\61\u00e9\3\2\2\2"+
		"\63\u00ec\3\2\2\2\65\u00ee\3\2\2\2\67\u00f0\3\2\2\29\u00f2\3\2\2\2;\u00f4"+
		"\3\2\2\2=\u00f6\3\2\2\2?\u00f8\3\2\2\2A\u00fa\3\2\2\2C\u00fc\3\2\2\2E"+
		"\u00fe\3\2\2\2G\u0100\3\2\2\2I\u0102\3\2\2\2K\u0104\3\2\2\2M\u0106\3\2"+
		"\2\2O\u0108\3\2\2\2Q\u010a\3\2\2\2S\u010c\3\2\2\2U\u010e\3\2\2\2W\u0110"+
		"\3\2\2\2Y\u0112\3\2\2\2[\u0114\3\2\2\2]\u011c\3\2\2\2_\u012d\3\2\2\2a"+
		"\u0135\3\2\2\2c\u013a\3\2\2\2e\u013c\3\2\2\2g\u0145\3\2\2\2i\u014b\3\2"+
		"\2\2k\u014e\3\2\2\2m\u0153\3\2\2\2o\u0158\3\2\2\2q\u015f\3\2\2\2s\u0165"+
		"\3\2\2\2u\u016d\3\2\2\2w\u016f\3\2\2\2y\u0172\3\2\2\2{\u0177\3\2\2\2}"+
		"\u017c\3\2\2\2\177\u0181\3\2\2\2\u0081\u0185\3\2\2\2\u0083\u018a\3\2\2"+
		"\2\u0085\u0191\3\2\2\2\u0087\u0088\7$\2\2\u0088\4\3\2\2\2\u0089\u008a"+
		"\7\62\2\2\u008a\u008b\7z\2\2\u008b\6\3\2\2\2\u008c\u008d\7\62\2\2\u008d"+
		"\u008e\7d\2\2\u008e\b\3\2\2\2\u008f\u0090\7\62\2\2\u0090\u0091\7q\2\2"+
		"\u0091\n\3\2\2\2\u0092\u0093\7?\2\2\u0093\f\3\2\2\2\u0094\u00b2\5;\36"+
		"\2\u0095\u00b2\5\17\b\2\u0096\u00b2\5G$\2\u0097\u00b2\5E#\2\u0098\u00b2"+
		"\5C\"\2\u0099\u00b2\5A!\2\u009a\u00b2\5? \2\u009b\u00b2\5\37\20\2\u009c"+
		"\u00b2\5!\21\2\u009d\u00b2\5#\22\2\u009e\u00b2\5I%\2\u009f\u00b2\5K&\2"+
		"\u00a0\u00b2\5M\'\2\u00a1\u00b2\5%\23\2\u00a2\u00b2\5\'\24\2\u00a3\u00b2"+
		"\5)\25\2\u00a4\u00b2\5+\26\2\u00a5\u00b2\5-\27\2\u00a6\u00b2\5\61\31\2"+
		"\u00a7\u00b2\5/\30\2\u00a8\u00b2\5\25\13\2\u00a9\u00b2\5\21\t\2\u00aa"+
		"\u00b2\5\23\n\2\u00ab\u00b2\5\27\f\2\u00ac\u00b2\5\31\r\2\u00ad\u00b2"+
		"\5\33\16\2\u00ae\u00b2\5\35\17\2\u00af\u00b2\5\63\32\2\u00b0\u00b2\5\65"+
		"\33\2\u00b1\u0094\3\2\2\2\u00b1\u0095\3\2\2\2\u00b1\u0096\3\2\2\2\u00b1"+
		"\u0097\3\2\2\2\u00b1\u0098\3\2\2\2\u00b1\u0099\3\2\2\2\u00b1\u009a\3\2"+
		"\2\2\u00b1\u009b\3\2\2\2\u00b1\u009c\3\2\2\2\u00b1\u009d\3\2\2\2\u00b1"+
		"\u009e\3\2\2\2\u00b1\u009f\3\2\2\2\u00b1\u00a0\3\2\2\2\u00b1\u00a1\3\2"+
		"\2\2\u00b1\u00a2\3\2\2\2\u00b1\u00a3\3\2\2\2\u00b1\u00a4\3\2\2\2\u00b1"+
		"\u00a5\3\2\2\2\u00b1\u00a6\3\2\2\2\u00b1\u00a7\3\2\2\2\u00b1\u00a8\3\2"+
		"\2\2\u00b1\u00a9\3\2\2\2\u00b1\u00aa\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1"+
		"\u00ac\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b1\u00b0\3\2\2\2\u00b2\16\3\2\2\2\u00b3\u00b4\7,\2\2\u00b4\u00b5"+
		"\7,\2\2\u00b5\20\3\2\2\2\u00b6\u00b7\7>\2\2\u00b7\u00b8\7>\2\2\u00b8\u00b9"+
		"\7>\2\2\u00b9\22\3\2\2\2\u00ba\u00bb\7@\2\2\u00bb\u00bc\7@\2\2\u00bc\u00bd"+
		"\7@\2\2\u00bd\24\3\2\2\2\u00be\u00bf\7>\2\2\u00bf\u00c0\7?\2\2\u00c0\u00c1"+
		"\7@\2\2\u00c1\26\3\2\2\2\u00c2\u00c3\7>\2\2\u00c3\u00c4\7?\2\2\u00c4\30"+
		"\3\2\2\2\u00c5\u00c6\7@\2\2\u00c6\u00c7\7?\2\2\u00c7\32\3\2\2\2\u00c8"+
		"\u00c9\7>\2\2\u00c9\u00ca\7>\2\2\u00ca\34\3\2\2\2\u00cb\u00cc\7@\2\2\u00cc"+
		"\u00cd\7@\2\2\u00cd\36\3\2\2\2\u00ce\u00cf\7(\2\2\u00cf\u00d0\7(\2\2\u00d0"+
		" \3\2\2\2\u00d1\u00d2\7~\2\2\u00d2\u00d3\7~\2\2\u00d3\"\3\2\2\2\u00d4"+
		"\u00d5\7`\2\2\u00d5\u00d6\7`\2\2\u00d6$\3\2\2\2\u00d7\u00d8\7-\2\2\u00d8"+
		"\u00d9\7?\2\2\u00d9&\3\2\2\2\u00da\u00db\7/\2\2\u00db\u00dc\7?\2\2\u00dc"+
		"(\3\2\2\2\u00dd\u00de\7,\2\2\u00de\u00df\7?\2\2\u00df*\3\2\2\2\u00e0\u00e1"+
		"\7\61\2\2\u00e1\u00e2\7?\2\2\u00e2,\3\2\2\2\u00e3\u00e4\7\'\2\2\u00e4"+
		"\u00e5\7?\2\2\u00e5.\3\2\2\2\u00e6\u00e7\7?\2\2\u00e7\u00e8\7?\2\2\u00e8"+
		"\60\3\2\2\2\u00e9\u00ea\7#\2\2\u00ea\u00eb\7?\2\2\u00eb\62\3\2\2\2\u00ec"+
		"\u00ed\7>\2\2\u00ed\64\3\2\2\2\u00ee\u00ef\7@\2\2\u00ef\66\3\2\2\2\u00f0"+
		"\u00f1\7<\2\2\u00f18\3\2\2\2\u00f2\u00f3\7=\2\2\u00f3:\3\2\2\2\u00f4\u00f5"+
		"\7\60\2\2\u00f5<\3\2\2\2\u00f6\u00f7\7.\2\2\u00f7>\3\2\2\2\u00f8\u00f9"+
		"\7-\2\2\u00f9@\3\2\2\2\u00fa\u00fb\7/\2\2\u00fbB\3\2\2\2\u00fc\u00fd\7"+
		",\2\2\u00fdD\3\2\2\2\u00fe\u00ff\7\61\2\2\u00ffF\3\2\2\2\u0100\u0101\7"+
		"\'\2\2\u0101H\3\2\2\2\u0102\u0103\7(\2\2\u0103J\3\2\2\2\u0104\u0105\7"+
		"~\2\2\u0105L\3\2\2\2\u0106\u0107\7`\2\2\u0107N\3\2\2\2\u0108\u0109\7#"+
		"\2\2\u0109P\3\2\2\2\u010a\u010b\7*\2\2\u010bR\3\2\2\2\u010c\u010d\7+\2"+
		"\2\u010dT\3\2\2\2\u010e\u010f\7}\2\2\u010fV\3\2\2\2\u0110\u0111\7\177"+
		"\2\2\u0111X\3\2\2\2\u0112\u0113\7]\2\2\u0113Z\3\2\2\2\u0114\u0115\7_\2"+
		"\2\u0115\\\3\2\2\2\u0116\u0117\7x\2\2\u0117\u0118\7c\2\2\u0118\u011d\7"+
		"t\2\2\u0119\u011a\7n\2\2\u011a\u011b\7g\2\2\u011b\u011d\7v\2\2\u011c\u0116"+
		"\3\2\2\2\u011c\u0119\3\2\2\2\u011d^\3\2\2\2\u011e\u011f\7e\2\2\u011f\u0120"+
		"\7q\2\2\u0120\u0121\7p\2\2\u0121\u0122\7u\2\2\u0122\u012e\7v\2\2\u0123"+
		"\u0124\7e\2\2\u0124\u0125\7j\2\2\u0125\u0126\7c\2\2\u0126\u0127\7p\2\2"+
		"\u0127\u0128\7i\2\2\u0128\u0129\7g\2\2\u0129\u012a\7c\2\2\u012a\u012b"+
		"\7d\2\2\u012b\u012c\7n\2\2\u012c\u012e\7g\2\2\u012d\u011e\3\2\2\2\u012d"+
		"\u0123\3\2\2\2\u012e`\3\2\2\2\u012f\u0130\7q\2\2\u0130\u0131\7d\2\2\u0131"+
		"\u0136\7l\2\2\u0132\u0133\7t\2\2\u0133\u0134\7g\2\2\u0134\u0136\7h\2\2"+
		"\u0135\u012f\3\2\2\2\u0135\u0132\3\2\2\2\u0136b\3\2\2\2\u0137\u013b\5"+
		"]/\2\u0138\u013b\5_\60\2\u0139\u013b\5a\61\2\u013a\u0137\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013bd\3\2\2\2\u013c\u013d\7h\2\2\u013d"+
		"\u013e\7w\2\2\u013e\u013f\7p\2\2\u013f\u0140\7e\2\2\u0140\u0141\7v\2\2"+
		"\u0141\u0142\7k\2\2\u0142\u0143\7q\2\2\u0143\u0144\7p\2\2\u0144f\3\2\2"+
		"\2\u0145\u0146\7y\2\2\u0146\u0147\7j\2\2\u0147\u0148\7k\2\2\u0148\u0149"+
		"\7n\2\2\u0149\u014a\7g\2\2\u014ah\3\2\2\2\u014b\u014c\7k\2\2\u014c\u014d"+
		"\7h\2\2\u014dj\3\2\2\2\u014e\u014f\7g\2\2\u014f\u0150\7n\2\2\u0150\u0151"+
		"\7k\2\2\u0151\u0152\7h\2\2\u0152l\3\2\2\2\u0153\u0154\7g\2\2\u0154\u0155"+
		"\7n\2\2\u0155\u0156\7u\2\2\u0156\u0157\7g\2\2\u0157n\3\2\2\2\u0158\u0159"+
		"\7t\2\2\u0159\u015a\7g\2\2\u015a\u015b\7v\2\2\u015b\u015c\7w\2\2\u015c"+
		"\u015d\7t\2\2\u015d\u015e\7p\2\2\u015ep\3\2\2\2\u015f\u0160\7d\2\2\u0160"+
		"\u0161\7t\2\2\u0161\u0162\7g\2\2\u0162\u0163\7c\2\2\u0163\u0164\7m\2\2"+
		"\u0164r\3\2\2\2\u0165\u016a\5u;\2\u0166\u0169\5u;\2\u0167\u0169\5w<\2"+
		"\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168"+
		"\3\2\2\2\u016a\u016b\3\2\2\2\u016bt\3\2\2\2\u016c\u016a\3\2\2\2\u016d"+
		"\u016e\t\2\2\2\u016ev\3\2\2\2\u016f\u0170\t\3\2\2\u0170x\3\2\2\2\u0171"+
		"\u0173\t\3\2\2\u0172\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0174\u0175\3\2\2\2\u0175z\3\2\2\2\u0176\u0178\t\4\2\2\u0177\u0176"+
		"\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"|\3\2\2\2\u017b\u017d\t\5\2\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2"+
		"\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f~\3\2\2\2\u0180\u0182\t"+
		"\6\2\2\u0181\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0080\3\2\2\2\u0185\u0188\7^\2\2\u0186\u0189\t\7"+
		"\2\2\u0187\u0189\5\u0083B\2\u0188\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u0189"+
		"\u0082\3\2\2\2\u018a\u018b\t\b\2\2\u018b\u018c\5\177@\2\u018c\u018d\5"+
		"\177@\2\u018d\u018e\5\177@\2\u018e\u018f\5\177@\2\u018f\u0084\3\2\2\2"+
		"\u0190\u0192\t\t\2\2\u0191\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0191"+
		"\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\bC\2\2\u0196"+
		"\u0086\3\2\2\2\20\2\u00b1\u011c\u012d\u0135\u013a\u0168\u016a\u0174\u0179"+
		"\u017e\u0183\u0188\u0193\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}