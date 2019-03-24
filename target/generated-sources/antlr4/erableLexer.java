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
		T__0=1, T__1=2, T__2=3, POW=4, ULS=5, URS=6, SWITCH=7, LTE=8, GTE=9, LS=10, 
		RS=11, AND=12, OR=13, XOR=14, ADDEQ=15, SUBEQ=16, MULEQ=17, DIVEQ=18, 
		MODEQ=19, EQ=20, NEQ=21, EQU=22, LT=23, GT=24, COLON=25, SPLIT=26, DOT=27, 
		COMMA=28, ADD=29, SUB=30, MUL=31, DIV=32, MOD=33, BAND=34, BOR=35, BXOR=36, 
		BNOT=37, LPA=38, RPA=39, LCB=40, RCB=41, ALPA=42, ARPA=43, VAR_ID=44, 
		FUNC=45, WHILE=46, IF=47, ELIF=48, ELSE=49, RETURN=50, BREAK=51, NAME=52, 
		STRING=53, INT=54, BIN=55, OCT=56, HEX=57, UNICODE=58, WS=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "POW", "ULS", "URS", "SWITCH", "LTE", "GTE", 
			"LS", "RS", "AND", "OR", "XOR", "ADDEQ", "SUBEQ", "MULEQ", "DIVEQ", "MODEQ", 
			"EQ", "NEQ", "EQU", "LT", "GT", "COLON", "SPLIT", "DOT", "COMMA", "ADD", 
			"SUB", "MUL", "DIV", "MOD", "BAND", "BOR", "BXOR", "BNOT", "LPA", "RPA", 
			"LCB", "RCB", "ALPA", "ARPA", "VAR_SC", "VAR_CG", "VAR_TP", "VAR_ID", 
			"FUNC", "WHILE", "IF", "ELIF", "ELSE", "RETURN", "BREAK", "NAME", "LETT", 
			"STRING", "DIGITS", "INT", "BIN", "OCT", "HEX", "ESC", "UNICODE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0x'", "'0b'", "'0o'", "'**'", "'<<<'", "'>>>'", "'<=>'", "'<='", 
			"'>='", "'<<'", "'>>'", "'&&'", "'||'", "'^^'", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'=='", "'!='", "'='", "'<'", "'>'", "':'", "';'", "'.'", 
			"','", "'+'", "'-'", "'*'", "'/'", "'%'", "'&'", "'|'", "'^'", "'!'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", null, "'function'", "'while'", 
			"'if'", "'elif'", "'else'", "'return'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "POW", "ULS", "URS", "SWITCH", "LTE", "GTE", 
			"LS", "RS", "AND", "OR", "XOR", "ADDEQ", "SUBEQ", "MULEQ", "DIVEQ", "MODEQ", 
			"EQ", "NEQ", "EQU", "LT", "GT", "COLON", "SPLIT", "DOT", "COMMA", "ADD", 
			"SUB", "MUL", "DIV", "MOD", "BAND", "BOR", "BXOR", "BNOT", "LPA", "RPA", 
			"LCB", "RCB", "ALPA", "ARPA", "VAR_ID", "FUNC", "WHILE", "IF", "ELIF", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u017e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3-\3-\3-\3-\5-\u00fa\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\5.\u010b\n.\3/\3/\3/\3/\3/\3/\5/\u0113\n/\3\60\3\60\3\60"+
		"\5\60\u0118\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\38\38\38\78\u0146\n8\f8\168\u0149\138\39\39\3:\3:\3:\7:\u0150"+
		"\n:\f:\16:\u0153\13:\3:\3:\3;\3;\3<\6<\u015a\n<\r<\16<\u015b\3=\6=\u015f"+
		"\n=\r=\16=\u0160\3>\6>\u0164\n>\r>\16>\u0165\3?\6?\u0169\n?\r?\16?\u016a"+
		"\3@\3@\3@\5@\u0170\n@\3A\3A\3A\3A\3A\3A\3B\6B\u0179\nB\rB\16B\u017a\3"+
		"B\3B\3\u0151\2C\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[\2]\2_.a/c\60e\61g"+
		"\62i\63k\64m\65o\66q\2s\67u\2w8y9{:};\177\2\u0081<\u0083=\3\2\n\6\2&&"+
		"C\\aac|\3\2\62;\3\2\62\63\3\2\62:\5\2\62;CHch\t\2$$^^ddhhppttvv\4\2WW"+
		"ww\5\2\13\f\17\17\"\"\2\u0186\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2s\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\3\u0085\3\2\2\2\5\u0088\3\2\2\2\7\u008b\3\2\2"+
		"\2\t\u008e\3\2\2\2\13\u0091\3\2\2\2\r\u0095\3\2\2\2\17\u0099\3\2\2\2\21"+
		"\u009d\3\2\2\2\23\u00a0\3\2\2\2\25\u00a3\3\2\2\2\27\u00a6\3\2\2\2\31\u00a9"+
		"\3\2\2\2\33\u00ac\3\2\2\2\35\u00af\3\2\2\2\37\u00b2\3\2\2\2!\u00b5\3\2"+
		"\2\2#\u00b8\3\2\2\2%\u00bb\3\2\2\2\'\u00be\3\2\2\2)\u00c1\3\2\2\2+\u00c4"+
		"\3\2\2\2-\u00c7\3\2\2\2/\u00c9\3\2\2\2\61\u00cb\3\2\2\2\63\u00cd\3\2\2"+
		"\2\65\u00cf\3\2\2\2\67\u00d1\3\2\2\29\u00d3\3\2\2\2;\u00d5\3\2\2\2=\u00d7"+
		"\3\2\2\2?\u00d9\3\2\2\2A\u00db\3\2\2\2C\u00dd\3\2\2\2E\u00df\3\2\2\2G"+
		"\u00e1\3\2\2\2I\u00e3\3\2\2\2K\u00e5\3\2\2\2M\u00e7\3\2\2\2O\u00e9\3\2"+
		"\2\2Q\u00eb\3\2\2\2S\u00ed\3\2\2\2U\u00ef\3\2\2\2W\u00f1\3\2\2\2Y\u00f9"+
		"\3\2\2\2[\u010a\3\2\2\2]\u0112\3\2\2\2_\u0117\3\2\2\2a\u0119\3\2\2\2c"+
		"\u0122\3\2\2\2e\u0128\3\2\2\2g\u012b\3\2\2\2i\u0130\3\2\2\2k\u0135\3\2"+
		"\2\2m\u013c\3\2\2\2o\u0142\3\2\2\2q\u014a\3\2\2\2s\u014c\3\2\2\2u\u0156"+
		"\3\2\2\2w\u0159\3\2\2\2y\u015e\3\2\2\2{\u0163\3\2\2\2}\u0168\3\2\2\2\177"+
		"\u016c\3\2\2\2\u0081\u0171\3\2\2\2\u0083\u0178\3\2\2\2\u0085\u0086\7\62"+
		"\2\2\u0086\u0087\7z\2\2\u0087\4\3\2\2\2\u0088\u0089\7\62\2\2\u0089\u008a"+
		"\7d\2\2\u008a\6\3\2\2\2\u008b\u008c\7\62\2\2\u008c\u008d\7q\2\2\u008d"+
		"\b\3\2\2\2\u008e\u008f\7,\2\2\u008f\u0090\7,\2\2\u0090\n\3\2\2\2\u0091"+
		"\u0092\7>\2\2\u0092\u0093\7>\2\2\u0093\u0094\7>\2\2\u0094\f\3\2\2\2\u0095"+
		"\u0096\7@\2\2\u0096\u0097\7@\2\2\u0097\u0098\7@\2\2\u0098\16\3\2\2\2\u0099"+
		"\u009a\7>\2\2\u009a\u009b\7?\2\2\u009b\u009c\7@\2\2\u009c\20\3\2\2\2\u009d"+
		"\u009e\7>\2\2\u009e\u009f\7?\2\2\u009f\22\3\2\2\2\u00a0\u00a1\7@\2\2\u00a1"+
		"\u00a2\7?\2\2\u00a2\24\3\2\2\2\u00a3\u00a4\7>\2\2\u00a4\u00a5\7>\2\2\u00a5"+
		"\26\3\2\2\2\u00a6\u00a7\7@\2\2\u00a7\u00a8\7@\2\2\u00a8\30\3\2\2\2\u00a9"+
		"\u00aa\7(\2\2\u00aa\u00ab\7(\2\2\u00ab\32\3\2\2\2\u00ac\u00ad\7~\2\2\u00ad"+
		"\u00ae\7~\2\2\u00ae\34\3\2\2\2\u00af\u00b0\7`\2\2\u00b0\u00b1\7`\2\2\u00b1"+
		"\36\3\2\2\2\u00b2\u00b3\7-\2\2\u00b3\u00b4\7?\2\2\u00b4 \3\2\2\2\u00b5"+
		"\u00b6\7/\2\2\u00b6\u00b7\7?\2\2\u00b7\"\3\2\2\2\u00b8\u00b9\7,\2\2\u00b9"+
		"\u00ba\7?\2\2\u00ba$\3\2\2\2\u00bb\u00bc\7\61\2\2\u00bc\u00bd\7?\2\2\u00bd"+
		"&\3\2\2\2\u00be\u00bf\7\'\2\2\u00bf\u00c0\7?\2\2\u00c0(\3\2\2\2\u00c1"+
		"\u00c2\7?\2\2\u00c2\u00c3\7?\2\2\u00c3*\3\2\2\2\u00c4\u00c5\7#\2\2\u00c5"+
		"\u00c6\7?\2\2\u00c6,\3\2\2\2\u00c7\u00c8\7?\2\2\u00c8.\3\2\2\2\u00c9\u00ca"+
		"\7>\2\2\u00ca\60\3\2\2\2\u00cb\u00cc\7@\2\2\u00cc\62\3\2\2\2\u00cd\u00ce"+
		"\7<\2\2\u00ce\64\3\2\2\2\u00cf\u00d0\7=\2\2\u00d0\66\3\2\2\2\u00d1\u00d2"+
		"\7\60\2\2\u00d28\3\2\2\2\u00d3\u00d4\7.\2\2\u00d4:\3\2\2\2\u00d5\u00d6"+
		"\7-\2\2\u00d6<\3\2\2\2\u00d7\u00d8\7/\2\2\u00d8>\3\2\2\2\u00d9\u00da\7"+
		",\2\2\u00da@\3\2\2\2\u00db\u00dc\7\61\2\2\u00dcB\3\2\2\2\u00dd\u00de\7"+
		"\'\2\2\u00deD\3\2\2\2\u00df\u00e0\7(\2\2\u00e0F\3\2\2\2\u00e1\u00e2\7"+
		"~\2\2\u00e2H\3\2\2\2\u00e3\u00e4\7`\2\2\u00e4J\3\2\2\2\u00e5\u00e6\7#"+
		"\2\2\u00e6L\3\2\2\2\u00e7\u00e8\7*\2\2\u00e8N\3\2\2\2\u00e9\u00ea\7+\2"+
		"\2\u00eaP\3\2\2\2\u00eb\u00ec\7}\2\2\u00ecR\3\2\2\2\u00ed\u00ee\7\177"+
		"\2\2\u00eeT\3\2\2\2\u00ef\u00f0\7]\2\2\u00f0V\3\2\2\2\u00f1\u00f2\7_\2"+
		"\2\u00f2X\3\2\2\2\u00f3\u00f4\7x\2\2\u00f4\u00f5\7c\2\2\u00f5\u00fa\7"+
		"t\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8\7g\2\2\u00f8\u00fa\7v\2\2\u00f9\u00f3"+
		"\3\2\2\2\u00f9\u00f6\3\2\2\2\u00faZ\3\2\2\2\u00fb\u00fc\7e\2\2\u00fc\u00fd"+
		"\7q\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7u\2\2\u00ff\u010b\7v\2\2\u0100"+
		"\u0101\7e\2\2\u0101\u0102\7j\2\2\u0102\u0103\7c\2\2\u0103\u0104\7p\2\2"+
		"\u0104\u0105\7i\2\2\u0105\u0106\7g\2\2\u0106\u0107\7c\2\2\u0107\u0108"+
		"\7d\2\2\u0108\u0109\7n\2\2\u0109\u010b\7g\2\2\u010a\u00fb\3\2\2\2\u010a"+
		"\u0100\3\2\2\2\u010b\\\3\2\2\2\u010c\u010d\7q\2\2\u010d\u010e\7d\2\2\u010e"+
		"\u0113\7l\2\2\u010f\u0110\7t\2\2\u0110\u0111\7g\2\2\u0111\u0113\7h\2\2"+
		"\u0112\u010c\3\2\2\2\u0112\u010f\3\2\2\2\u0113^\3\2\2\2\u0114\u0118\5"+
		"Y-\2\u0115\u0118\5[.\2\u0116\u0118\5]/\2\u0117\u0114\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0117\u0116\3\2\2\2\u0118`\3\2\2\2\u0119\u011a\7h\2\2\u011a\u011b"+
		"\7w\2\2\u011b\u011c\7p\2\2\u011c\u011d\7e\2\2\u011d\u011e\7v\2\2\u011e"+
		"\u011f\7k\2\2\u011f\u0120\7q\2\2\u0120\u0121\7p\2\2\u0121b\3\2\2\2\u0122"+
		"\u0123\7y\2\2\u0123\u0124\7j\2\2\u0124\u0125\7k\2\2\u0125\u0126\7n\2\2"+
		"\u0126\u0127\7g\2\2\u0127d\3\2\2\2\u0128\u0129\7k\2\2\u0129\u012a\7h\2"+
		"\2\u012af\3\2\2\2\u012b\u012c\7g\2\2\u012c\u012d\7n\2\2\u012d\u012e\7"+
		"k\2\2\u012e\u012f\7h\2\2\u012fh\3\2\2\2\u0130\u0131\7g\2\2\u0131\u0132"+
		"\7n\2\2\u0132\u0133\7u\2\2\u0133\u0134\7g\2\2\u0134j\3\2\2\2\u0135\u0136"+
		"\7t\2\2\u0136\u0137\7g\2\2\u0137\u0138\7v\2\2\u0138\u0139\7w\2\2\u0139"+
		"\u013a\7t\2\2\u013a\u013b\7p\2\2\u013bl\3\2\2\2\u013c\u013d\7d\2\2\u013d"+
		"\u013e\7t\2\2\u013e\u013f\7g\2\2\u013f\u0140\7c\2\2\u0140\u0141\7m\2\2"+
		"\u0141n\3\2\2\2\u0142\u0147\5q9\2\u0143\u0146\5q9\2\u0144\u0146\5u;\2"+
		"\u0145\u0143\3\2\2\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148p\3\2\2\2\u0149\u0147\3\2\2\2\u014a"+
		"\u014b\t\2\2\2\u014br\3\2\2\2\u014c\u0151\7$\2\2\u014d\u0150\5\177@\2"+
		"\u014e\u0150\13\2\2\2\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150\u0153"+
		"\3\2\2\2\u0151\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0154\u0155\7$\2\2\u0155t\3\2\2\2\u0156\u0157\t\3\2\2\u0157"+
		"v\3\2\2\2\u0158\u015a\t\3\2\2\u0159\u0158\3\2\2\2\u015a\u015b\3\2\2\2"+
		"\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015cx\3\2\2\2\u015d\u015f\t"+
		"\4\2\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161z\3\2\2\2\u0162\u0164\t\5\2\2\u0163\u0162\3\2\2\2"+
		"\u0164\u0165\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166|\3"+
		"\2\2\2\u0167\u0169\t\6\2\2\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b~\3\2\2\2\u016c\u016f\7^\2\2\u016d"+
		"\u0170\t\7\2\2\u016e\u0170\5\u0081A\2\u016f\u016d\3\2\2\2\u016f\u016e"+
		"\3\2\2\2\u0170\u0080\3\2\2\2\u0171\u0172\t\b\2\2\u0172\u0173\5}?\2\u0173"+
		"\u0174\5}?\2\u0174\u0175\5}?\2\u0175\u0176\5}?\2\u0176\u0082\3\2\2\2\u0177"+
		"\u0179\t\t\2\2\u0178\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0178\3\2"+
		"\2\2\u017a\u017b\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\bB\2\2\u017d"+
		"\u0084\3\2\2\2\21\2\u00f9\u010a\u0112\u0117\u0145\u0147\u014f\u0151\u015b"+
		"\u0160\u0165\u016a\u016f\u017a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}