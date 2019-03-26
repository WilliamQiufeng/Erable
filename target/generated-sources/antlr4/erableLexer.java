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
		T__0=1, T__1=2, T__2=3, T__3=4, EQU=5, UNARYOPS=6, BINOPS=7, POW=8, COLON=9, 
		SPLIT=10, DOT=11, COMMA=12, ADD=13, SUB=14, BNOT=15, LPA=16, RPA=17, LCB=18, 
		RCB=19, ALPA=20, ARPA=21, VAR_ID=22, FUNC=23, WHILE=24, IF=25, ELIF=26, 
		ELSE=27, RETURN=28, BREAK=29, NAME=30, INT=31, BIN=32, OCT=33, HEX=34, 
		ESC=35, UNICODE=36, WS=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "EQU", "UNARYOPS", "BINOPS", "POW", "ULS", 
			"URS", "SWITCH", "LTE", "GTE", "LS", "RS", "AND", "OR", "XOR", "ADDEQ", 
			"SUBEQ", "MULEQ", "DIVEQ", "MODEQ", "EQ", "NEQ", "LT", "GT", "COLON", 
			"SPLIT", "DOT", "COMMA", "ADD", "SUB", "MUL", "DIV", "MOD", "BAND", "BOR", 
			"BXOR", "BNOT", "LPA", "RPA", "LCB", "RCB", "ALPA", "ARPA", "VAR_SC", 
			"VAR_CG", "VAR_TP", "VAR_ID", "FUNC", "WHILE", "IF", "ELIF", "ELSE", 
			"RETURN", "BREAK", "NAME", "LETT", "DIGITS", "INT", "BIN", "OCT", "HEX", 
			"ESC", "UNICODE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\"'", "'0x'", "'0b'", "'0o'", "'='", null, null, "'**'", "':'", 
			"';'", "'.'", "','", "'+'", "'-'", "'!'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", null, "'function'", "'while'", "'if'", "'elif'", "'else'", 
			"'return'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "EQU", "UNARYOPS", "BINOPS", "POW", "COLON", 
			"SPLIT", "DOT", "COMMA", "ADD", "SUB", "BNOT", "LPA", "RPA", "LCB", "RCB", 
			"ALPA", "ARPA", "VAR_ID", "FUNC", "WHILE", "IF", "ELIF", "ELSE", "RETURN", 
			"BREAK", "NAME", "INT", "BIN", "OCT", "HEX", "ESC", "UNICODE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u01a0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7\u009c\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00bb\n\b\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\5\60\u0126\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0137\n\61\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\5\62\u013f\n\62\3\63\3\63\3\63\5\63\u0144\n\63\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3"+
		"\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\39\39\39\39\3:\3"+
		":\3:\3:\3:\3:\3;\3;\3;\7;\u0172\n;\f;\16;\u0175\13;\3<\3<\3=\3=\3>\6>"+
		"\u017c\n>\r>\16>\u017d\3?\6?\u0181\n?\r?\16?\u0182\3@\6@\u0186\n@\r@\16"+
		"@\u0187\3A\6A\u018b\nA\rA\16A\u018c\3B\3B\3B\5B\u0192\nB\3C\3C\3C\3C\3"+
		"C\3C\3D\6D\u019b\nD\rD\16D\u019c\3D\3D\2\2E\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61"+
		"\2\63\2\65\2\67\29\13;\f=\r?\16A\17C\20E\2G\2I\2K\2M\2O\2Q\21S\22U\23"+
		"W\24Y\25[\26]\27_\2a\2c\2e\30g\31i\32k\33m\34o\35q\36s\37u w\2y\2{!}\""+
		"\177#\u0081$\u0083%\u0085&\u0087\'\3\2\n\6\2&&C\\aac|\3\2\62;\3\2\62\63"+
		"\3\2\62:\5\2\62;CHch\t\2$$^^ddhhppttvv\4\2WWww\5\2\13\f\17\17\"\"\2\u01ae"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2"+
		"\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2{\3\2"+
		"\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\3\u0089\3\2\2\2\5\u008b\3\2\2\2\7\u008e\3\2\2"+
		"\2\t\u0091\3\2\2\2\13\u0094\3\2\2\2\r\u009b\3\2\2\2\17\u00ba\3\2\2\2\21"+
		"\u00bc\3\2\2\2\23\u00bf\3\2\2\2\25\u00c3\3\2\2\2\27\u00c7\3\2\2\2\31\u00cb"+
		"\3\2\2\2\33\u00ce\3\2\2\2\35\u00d1\3\2\2\2\37\u00d4\3\2\2\2!\u00d7\3\2"+
		"\2\2#\u00da\3\2\2\2%\u00dd\3\2\2\2\'\u00e0\3\2\2\2)\u00e3\3\2\2\2+\u00e6"+
		"\3\2\2\2-\u00e9\3\2\2\2/\u00ec\3\2\2\2\61\u00ef\3\2\2\2\63\u00f2\3\2\2"+
		"\2\65\u00f5\3\2\2\2\67\u00f7\3\2\2\29\u00f9\3\2\2\2;\u00fb\3\2\2\2=\u00fd"+
		"\3\2\2\2?\u00ff\3\2\2\2A\u0101\3\2\2\2C\u0103\3\2\2\2E\u0105\3\2\2\2G"+
		"\u0107\3\2\2\2I\u0109\3\2\2\2K\u010b\3\2\2\2M\u010d\3\2\2\2O\u010f\3\2"+
		"\2\2Q\u0111\3\2\2\2S\u0113\3\2\2\2U\u0115\3\2\2\2W\u0117\3\2\2\2Y\u0119"+
		"\3\2\2\2[\u011b\3\2\2\2]\u011d\3\2\2\2_\u0125\3\2\2\2a\u0136\3\2\2\2c"+
		"\u013e\3\2\2\2e\u0143\3\2\2\2g\u0145\3\2\2\2i\u014e\3\2\2\2k\u0154\3\2"+
		"\2\2m\u0157\3\2\2\2o\u015c\3\2\2\2q\u0161\3\2\2\2s\u0168\3\2\2\2u\u016e"+
		"\3\2\2\2w\u0176\3\2\2\2y\u0178\3\2\2\2{\u017b\3\2\2\2}\u0180\3\2\2\2\177"+
		"\u0185\3\2\2\2\u0081\u018a\3\2\2\2\u0083\u018e\3\2\2\2\u0085\u0193\3\2"+
		"\2\2\u0087\u019a\3\2\2\2\u0089\u008a\7$\2\2\u008a\4\3\2\2\2\u008b\u008c"+
		"\7\62\2\2\u008c\u008d\7z\2\2\u008d\6\3\2\2\2\u008e\u008f\7\62\2\2\u008f"+
		"\u0090\7d\2\2\u0090\b\3\2\2\2\u0091\u0092\7\62\2\2\u0092\u0093\7q\2\2"+
		"\u0093\n\3\2\2\2\u0094\u0095\7?\2\2\u0095\f\3\2\2\2\u0096\u009c\5Q)\2"+
		"\u0097\u009c\5q9\2\u0098\u009c\5s:\2\u0099\u009c\5A!\2\u009a\u009c\5C"+
		"\"\2\u009b\u0096\3\2\2\2\u009b\u0097\3\2\2\2\u009b\u0098\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\16\3\2\2\2\u009d\u00bb\5=\37"+
		"\2\u009e\u00bb\5\21\t\2\u009f\u00bb\5I%\2\u00a0\u00bb\5G$\2\u00a1\u00bb"+
		"\5E#\2\u00a2\u00bb\5C\"\2\u00a3\u00bb\5A!\2\u00a4\u00bb\5!\21\2\u00a5"+
		"\u00bb\5#\22\2\u00a6\u00bb\5%\23\2\u00a7\u00bb\5K&\2\u00a8\u00bb\5M\'"+
		"\2\u00a9\u00bb\5O(\2\u00aa\u00bb\5\'\24\2\u00ab\u00bb\5)\25\2\u00ac\u00bb"+
		"\5+\26\2\u00ad\u00bb\5-\27\2\u00ae\u00bb\5/\30\2\u00af\u00bb\5\63\32\2"+
		"\u00b0\u00bb\5\61\31\2\u00b1\u00bb\5\27\f\2\u00b2\u00bb\5\23\n\2\u00b3"+
		"\u00bb\5\25\13\2\u00b4\u00bb\5\31\r\2\u00b5\u00bb\5\33\16\2\u00b6\u00bb"+
		"\5\35\17\2\u00b7\u00bb\5\37\20\2\u00b8\u00bb\5\65\33\2\u00b9\u00bb\5\67"+
		"\34\2\u00ba\u009d\3\2\2\2\u00ba\u009e\3\2\2\2\u00ba\u009f\3\2\2\2\u00ba"+
		"\u00a0\3\2\2\2\u00ba\u00a1\3\2\2\2\u00ba\u00a2\3\2\2\2\u00ba\u00a3\3\2"+
		"\2\2\u00ba\u00a4\3\2\2\2\u00ba\u00a5\3\2\2\2\u00ba\u00a6\3\2\2\2\u00ba"+
		"\u00a7\3\2\2\2\u00ba\u00a8\3\2\2\2\u00ba\u00a9\3\2\2\2\u00ba\u00aa\3\2"+
		"\2\2\u00ba\u00ab\3\2\2\2\u00ba\u00ac\3\2\2\2\u00ba\u00ad\3\2\2\2\u00ba"+
		"\u00ae\3\2\2\2\u00ba\u00af\3\2\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b1\3\2"+
		"\2\2\u00ba\u00b2\3\2\2\2\u00ba\u00b3\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba"+
		"\u00b5\3\2\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00b9\3\2\2\2\u00bb\20\3\2\2\2\u00bc\u00bd\7,\2\2\u00bd\u00be"+
		"\7,\2\2\u00be\22\3\2\2\2\u00bf\u00c0\7>\2\2\u00c0\u00c1\7>\2\2\u00c1\u00c2"+
		"\7>\2\2\u00c2\24\3\2\2\2\u00c3\u00c4\7@\2\2\u00c4\u00c5\7@\2\2\u00c5\u00c6"+
		"\7@\2\2\u00c6\26\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8\u00c9\7?\2\2\u00c9\u00ca"+
		"\7@\2\2\u00ca\30\3\2\2\2\u00cb\u00cc\7>\2\2\u00cc\u00cd\7?\2\2\u00cd\32"+
		"\3\2\2\2\u00ce\u00cf\7@\2\2\u00cf\u00d0\7?\2\2\u00d0\34\3\2\2\2\u00d1"+
		"\u00d2\7>\2\2\u00d2\u00d3\7>\2\2\u00d3\36\3\2\2\2\u00d4\u00d5\7@\2\2\u00d5"+
		"\u00d6\7@\2\2\u00d6 \3\2\2\2\u00d7\u00d8\7(\2\2\u00d8\u00d9\7(\2\2\u00d9"+
		"\"\3\2\2\2\u00da\u00db\7~\2\2\u00db\u00dc\7~\2\2\u00dc$\3\2\2\2\u00dd"+
		"\u00de\7`\2\2\u00de\u00df\7`\2\2\u00df&\3\2\2\2\u00e0\u00e1\7-\2\2\u00e1"+
		"\u00e2\7?\2\2\u00e2(\3\2\2\2\u00e3\u00e4\7/\2\2\u00e4\u00e5\7?\2\2\u00e5"+
		"*\3\2\2\2\u00e6\u00e7\7,\2\2\u00e7\u00e8\7?\2\2\u00e8,\3\2\2\2\u00e9\u00ea"+
		"\7\61\2\2\u00ea\u00eb\7?\2\2\u00eb.\3\2\2\2\u00ec\u00ed\7\'\2\2\u00ed"+
		"\u00ee\7?\2\2\u00ee\60\3\2\2\2\u00ef\u00f0\7?\2\2\u00f0\u00f1\7?\2\2\u00f1"+
		"\62\3\2\2\2\u00f2\u00f3\7#\2\2\u00f3\u00f4\7?\2\2\u00f4\64\3\2\2\2\u00f5"+
		"\u00f6\7>\2\2\u00f6\66\3\2\2\2\u00f7\u00f8\7@\2\2\u00f88\3\2\2\2\u00f9"+
		"\u00fa\7<\2\2\u00fa:\3\2\2\2\u00fb\u00fc\7=\2\2\u00fc<\3\2\2\2\u00fd\u00fe"+
		"\7\60\2\2\u00fe>\3\2\2\2\u00ff\u0100\7.\2\2\u0100@\3\2\2\2\u0101\u0102"+
		"\7-\2\2\u0102B\3\2\2\2\u0103\u0104\7/\2\2\u0104D\3\2\2\2\u0105\u0106\7"+
		",\2\2\u0106F\3\2\2\2\u0107\u0108\7\61\2\2\u0108H\3\2\2\2\u0109\u010a\7"+
		"\'\2\2\u010aJ\3\2\2\2\u010b\u010c\7(\2\2\u010cL\3\2\2\2\u010d\u010e\7"+
		"~\2\2\u010eN\3\2\2\2\u010f\u0110\7`\2\2\u0110P\3\2\2\2\u0111\u0112\7#"+
		"\2\2\u0112R\3\2\2\2\u0113\u0114\7*\2\2\u0114T\3\2\2\2\u0115\u0116\7+\2"+
		"\2\u0116V\3\2\2\2\u0117\u0118\7}\2\2\u0118X\3\2\2\2\u0119\u011a\7\177"+
		"\2\2\u011aZ\3\2\2\2\u011b\u011c\7]\2\2\u011c\\\3\2\2\2\u011d\u011e\7_"+
		"\2\2\u011e^\3\2\2\2\u011f\u0120\7x\2\2\u0120\u0121\7c\2\2\u0121\u0126"+
		"\7t\2\2\u0122\u0123\7n\2\2\u0123\u0124\7g\2\2\u0124\u0126\7v\2\2\u0125"+
		"\u011f\3\2\2\2\u0125\u0122\3\2\2\2\u0126`\3\2\2\2\u0127\u0128\7e\2\2\u0128"+
		"\u0129\7q\2\2\u0129\u012a\7p\2\2\u012a\u012b\7u\2\2\u012b\u0137\7v\2\2"+
		"\u012c\u012d\7e\2\2\u012d\u012e\7j\2\2\u012e\u012f\7c\2\2\u012f\u0130"+
		"\7p\2\2\u0130\u0131\7i\2\2\u0131\u0132\7g\2\2\u0132\u0133\7c\2\2\u0133"+
		"\u0134\7d\2\2\u0134\u0135\7n\2\2\u0135\u0137\7g\2\2\u0136\u0127\3\2\2"+
		"\2\u0136\u012c\3\2\2\2\u0137b\3\2\2\2\u0138\u0139\7q\2\2\u0139\u013a\7"+
		"d\2\2\u013a\u013f\7l\2\2\u013b\u013c\7t\2\2\u013c\u013d\7g\2\2\u013d\u013f"+
		"\7h\2\2\u013e\u0138\3\2\2\2\u013e\u013b\3\2\2\2\u013fd\3\2\2\2\u0140\u0144"+
		"\5_\60\2\u0141\u0144\5a\61\2\u0142\u0144\5c\62\2\u0143\u0140\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144f\3\2\2\2\u0145\u0146\7h\2\2\u0146"+
		"\u0147\7w\2\2\u0147\u0148\7p\2\2\u0148\u0149\7e\2\2\u0149\u014a\7v\2\2"+
		"\u014a\u014b\7k\2\2\u014b\u014c\7q\2\2\u014c\u014d\7p\2\2\u014dh\3\2\2"+
		"\2\u014e\u014f\7y\2\2\u014f\u0150\7j\2\2\u0150\u0151\7k\2\2\u0151\u0152"+
		"\7n\2\2\u0152\u0153\7g\2\2\u0153j\3\2\2\2\u0154\u0155\7k\2\2\u0155\u0156"+
		"\7h\2\2\u0156l\3\2\2\2\u0157\u0158\7g\2\2\u0158\u0159\7n\2\2\u0159\u015a"+
		"\7k\2\2\u015a\u015b\7h\2\2\u015bn\3\2\2\2\u015c\u015d\7g\2\2\u015d\u015e"+
		"\7n\2\2\u015e\u015f\7u\2\2\u015f\u0160\7g\2\2\u0160p\3\2\2\2\u0161\u0162"+
		"\7t\2\2\u0162\u0163\7g\2\2\u0163\u0164\7v\2\2\u0164\u0165\7w\2\2\u0165"+
		"\u0166\7t\2\2\u0166\u0167\7p\2\2\u0167r\3\2\2\2\u0168\u0169\7d\2\2\u0169"+
		"\u016a\7t\2\2\u016a\u016b\7g\2\2\u016b\u016c\7c\2\2\u016c\u016d\7m\2\2"+
		"\u016dt\3\2\2\2\u016e\u0173\5w<\2\u016f\u0172\5w<\2\u0170\u0172\5y=\2"+
		"\u0171\u016f\3\2\2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171"+
		"\3\2\2\2\u0173\u0174\3\2\2\2\u0174v\3\2\2\2\u0175\u0173\3\2\2\2\u0176"+
		"\u0177\t\2\2\2\u0177x\3\2\2\2\u0178\u0179\t\3\2\2\u0179z\3\2\2\2\u017a"+
		"\u017c\t\3\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017b\3\2"+
		"\2\2\u017d\u017e\3\2\2\2\u017e|\3\2\2\2\u017f\u0181\t\4\2\2\u0180\u017f"+
		"\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183"+
		"~\3\2\2\2\u0184\u0186\t\5\2\2\u0185\u0184\3\2\2\2\u0186\u0187\3\2\2\2"+
		"\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0080\3\2\2\2\u0189\u018b"+
		"\t\6\2\2\u018a\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018a\3\2\2\2\u018c"+
		"\u018d\3\2\2\2\u018d\u0082\3\2\2\2\u018e\u0191\7^\2\2\u018f\u0192\t\7"+
		"\2\2\u0190\u0192\5\u0085C\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2\u0192"+
		"\u0084\3\2\2\2\u0193\u0194\t\b\2\2\u0194\u0195\5\u0081A\2\u0195\u0196"+
		"\5\u0081A\2\u0196\u0197\5\u0081A\2\u0197\u0198\5\u0081A\2\u0198\u0086"+
		"\3\2\2\2\u0199\u019b\t\t\2\2\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\bD"+
		"\2\2\u019f\u0088\3\2\2\2\21\2\u009b\u00ba\u0125\u0136\u013e\u0143\u0171"+
		"\u0173\u017d\u0182\u0187\u018c\u0191\u019c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}