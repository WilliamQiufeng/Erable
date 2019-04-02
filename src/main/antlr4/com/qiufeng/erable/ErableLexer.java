// Generated from Erable.g4 by ANTLR 4.7.1

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
public class ErableLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, EQU=5, UNARYOPS=6, BINOPS=7, POW=8, COLON=9, 
		SPLIT=10, DOT=11, COMMA=12, ADD=13, SUB=14, MUL=15, DIV=16, MOD=17, BNOT=18, 
		LPA=19, RPA=20, LCB=21, RCB=22, ALPA=23, ARPA=24, VAR_ID=25, FUNC=26, 
		WHILE=27, IF=28, ELIF=29, ELSE=30, RETURN=31, BREAK=32, NAME=33, INT=34, 
		BIN=35, OCT=36, HEX=37, HEXD=38, ESC=39, UNICODE=40, WS=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "EQU", "UNARYOPS", "BINOPS", "POW", "ULS", 
		"URS", "SWITCH", "LTE", "GTE", "LS", "RS", "ADDEQ", "SUBEQ", "MULEQ", 
		"DIVEQ", "MODEQ", "EQ", "NEQ", "LT", "GT", "COLON", "SPLIT", "DOT", "COMMA", 
		"ADD", "SUB", "MUL", "DIV", "MOD", "BAND", "BOR", "BXOR", "BNOT", "LPA", 
		"RPA", "LCB", "RCB", "ALPA", "ARPA", "VAR_SC", "VAR_CG", "VAR_TP", "VAR_ID", 
		"FUNC", "WHILE", "IF", "ELIF", "ELSE", "RETURN", "BREAK", "NAME", "LETT", 
		"DIGITS", "INT", "BIN", "OCT", "HEX", "HEXD", "ESC", "UNICODE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\"'", "'0x'", "'0b'", "'0o'", "'='", null, null, "'**'", "':'", 
		"';'", "'.'", "','", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'('", 
		"')'", "'{'", "'}'", "'['", "']'", null, "'function'", "'while'", "'if'", 
		"'elif'", "'else'", "'return'", "'break'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "EQU", "UNARYOPS", "BINOPS", "POW", "COLON", 
		"SPLIT", "DOT", "COMMA", "ADD", "SUB", "MUL", "DIV", "MOD", "BNOT", "LPA", 
		"RPA", "LCB", "RCB", "ALPA", "ARPA", "VAR_ID", "FUNC", "WHILE", "IF", 
		"ELIF", "ELSE", "RETURN", "BREAK", "NAME", "INT", "BIN", "OCT", "HEX", 
		"HEXD", "ESC", "UNICODE", "WS"
	};
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


	    


	public ErableLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Erable.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0184\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\5\7\u0096\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a6\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 "+
		"\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3-\3-\3-\3-\5-\u0108\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\5.\u0119\n.\3/\3/\3/\3/\3/\3/\5/\u0121\n/\3\60\3\60\3\60"+
		"\5\60\u0126\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\38\38\38\78\u0154\n8\f8\168\u0157\138\39\39\3:\3:\3;\6;\u015e"+
		"\n;\r;\16;\u015f\3<\6<\u0163\n<\r<\16<\u0164\3=\6=\u0168\n=\r=\16=\u0169"+
		"\3>\6>\u016d\n>\r>\16>\u016e\3?\3?\3@\3@\3@\5@\u0176\n@\3A\3A\3A\3A\3"+
		"A\3A\3B\6B\u017f\nB\rB\16B\u0180\3B\3B\2\2C\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61"+
		"\2\63\13\65\f\67\r9\16;\17=\20?\21A\22C\23E\2G\2I\2K\24M\25O\26Q\27S\30"+
		"U\31W\32Y\2[\2]\2_\33a\34c\35e\36g\37i k!m\"o#q\2s\2u$w%y&{\'}(\177)\u0081"+
		"*\u0083+\3\2\n\6\2&&C\\aac|\3\2\62;\3\2\62\63\3\2\62:\5\2\62;CHch\t\2"+
		"$$^^ddhhppttvv\4\2WWww\5\2\13\f\17\17\"\"\2\u0187\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\3\u0085\3\2\2\2\5\u0087\3\2\2"+
		"\2\7\u008a\3\2\2\2\t\u008d\3\2\2\2\13\u0090\3\2\2\2\r\u0095\3\2\2\2\17"+
		"\u00a5\3\2\2\2\21\u00a7\3\2\2\2\23\u00aa\3\2\2\2\25\u00ae\3\2\2\2\27\u00b2"+
		"\3\2\2\2\31\u00b6\3\2\2\2\33\u00b9\3\2\2\2\35\u00bc\3\2\2\2\37\u00bf\3"+
		"\2\2\2!\u00c2\3\2\2\2#\u00c5\3\2\2\2%\u00c8\3\2\2\2\'\u00cb\3\2\2\2)\u00ce"+
		"\3\2\2\2+\u00d1\3\2\2\2-\u00d4\3\2\2\2/\u00d7\3\2\2\2\61\u00d9\3\2\2\2"+
		"\63\u00db\3\2\2\2\65\u00dd\3\2\2\2\67\u00df\3\2\2\29\u00e1\3\2\2\2;\u00e3"+
		"\3\2\2\2=\u00e5\3\2\2\2?\u00e7\3\2\2\2A\u00e9\3\2\2\2C\u00eb\3\2\2\2E"+
		"\u00ed\3\2\2\2G\u00ef\3\2\2\2I\u00f1\3\2\2\2K\u00f3\3\2\2\2M\u00f5\3\2"+
		"\2\2O\u00f7\3\2\2\2Q\u00f9\3\2\2\2S\u00fb\3\2\2\2U\u00fd\3\2\2\2W\u00ff"+
		"\3\2\2\2Y\u0107\3\2\2\2[\u0118\3\2\2\2]\u0120\3\2\2\2_\u0125\3\2\2\2a"+
		"\u0127\3\2\2\2c\u0130\3\2\2\2e\u0136\3\2\2\2g\u0139\3\2\2\2i\u013e\3\2"+
		"\2\2k\u0143\3\2\2\2m\u014a\3\2\2\2o\u0150\3\2\2\2q\u0158\3\2\2\2s\u015a"+
		"\3\2\2\2u\u015d\3\2\2\2w\u0162\3\2\2\2y\u0167\3\2\2\2{\u016c\3\2\2\2}"+
		"\u0170\3\2\2\2\177\u0172\3\2\2\2\u0081\u0177\3\2\2\2\u0083\u017e\3\2\2"+
		"\2\u0085\u0086\7$\2\2\u0086\4\3\2\2\2\u0087\u0088\7\62\2\2\u0088\u0089"+
		"\7z\2\2\u0089\6\3\2\2\2\u008a\u008b\7\62\2\2\u008b\u008c\7d\2\2\u008c"+
		"\b\3\2\2\2\u008d\u008e\7\62\2\2\u008e\u008f\7q\2\2\u008f\n\3\2\2\2\u0090"+
		"\u0091\7?\2\2\u0091\f\3\2\2\2\u0092\u0096\5K&\2\u0093\u0096\5k\66\2\u0094"+
		"\u0096\5m\67\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2"+
		"\2\2\u0096\16\3\2\2\2\u0097\u00a6\5E#\2\u0098\u00a6\5G$\2\u0099\u00a6"+
		"\5I%\2\u009a\u00a6\5-\27\2\u009b\u00a6\5+\26\2\u009c\u00a6\5\27\f\2\u009d"+
		"\u00a6\5\23\n\2\u009e\u00a6\5\25\13\2\u009f\u00a6\5\31\r\2\u00a0\u00a6"+
		"\5\33\16\2\u00a1\u00a6\5\35\17\2\u00a2\u00a6\5\37\20\2\u00a3\u00a6\5/"+
		"\30\2\u00a4\u00a6\5\61\31\2\u00a5\u0097\3\2\2\2\u00a5\u0098\3\2\2\2\u00a5"+
		"\u0099\3\2\2\2\u00a5\u009a\3\2\2\2\u00a5\u009b\3\2\2\2\u00a5\u009c\3\2"+
		"\2\2\u00a5\u009d\3\2\2\2\u00a5\u009e\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5"+
		"\u00a0\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a5\u00a4\3\2\2\2\u00a6\20\3\2\2\2\u00a7\u00a8\7,\2\2\u00a8\u00a9"+
		"\7,\2\2\u00a9\22\3\2\2\2\u00aa\u00ab\7>\2\2\u00ab\u00ac\7>\2\2\u00ac\u00ad"+
		"\7>\2\2\u00ad\24\3\2\2\2\u00ae\u00af\7@\2\2\u00af\u00b0\7@\2\2\u00b0\u00b1"+
		"\7@\2\2\u00b1\26\3\2\2\2\u00b2\u00b3\7>\2\2\u00b3\u00b4\7?\2\2\u00b4\u00b5"+
		"\7@\2\2\u00b5\30\3\2\2\2\u00b6\u00b7\7>\2\2\u00b7\u00b8\7?\2\2\u00b8\32"+
		"\3\2\2\2\u00b9\u00ba\7@\2\2\u00ba\u00bb\7?\2\2\u00bb\34\3\2\2\2\u00bc"+
		"\u00bd\7>\2\2\u00bd\u00be\7>\2\2\u00be\36\3\2\2\2\u00bf\u00c0\7@\2\2\u00c0"+
		"\u00c1\7@\2\2\u00c1 \3\2\2\2\u00c2\u00c3\7-\2\2\u00c3\u00c4\7?\2\2\u00c4"+
		"\"\3\2\2\2\u00c5\u00c6\7/\2\2\u00c6\u00c7\7?\2\2\u00c7$\3\2\2\2\u00c8"+
		"\u00c9\7,\2\2\u00c9\u00ca\7?\2\2\u00ca&\3\2\2\2\u00cb\u00cc\7\61\2\2\u00cc"+
		"\u00cd\7?\2\2\u00cd(\3\2\2\2\u00ce\u00cf\7\'\2\2\u00cf\u00d0\7?\2\2\u00d0"+
		"*\3\2\2\2\u00d1\u00d2\7?\2\2\u00d2\u00d3\7?\2\2\u00d3,\3\2\2\2\u00d4\u00d5"+
		"\7#\2\2\u00d5\u00d6\7?\2\2\u00d6.\3\2\2\2\u00d7\u00d8\7>\2\2\u00d8\60"+
		"\3\2\2\2\u00d9\u00da\7@\2\2\u00da\62\3\2\2\2\u00db\u00dc\7<\2\2\u00dc"+
		"\64\3\2\2\2\u00dd\u00de\7=\2\2\u00de\66\3\2\2\2\u00df\u00e0\7\60\2\2\u00e0"+
		"8\3\2\2\2\u00e1\u00e2\7.\2\2\u00e2:\3\2\2\2\u00e3\u00e4\7-\2\2\u00e4<"+
		"\3\2\2\2\u00e5\u00e6\7/\2\2\u00e6>\3\2\2\2\u00e7\u00e8\7,\2\2\u00e8@\3"+
		"\2\2\2\u00e9\u00ea\7\61\2\2\u00eaB\3\2\2\2\u00eb\u00ec\7\'\2\2\u00ecD"+
		"\3\2\2\2\u00ed\u00ee\7(\2\2\u00eeF\3\2\2\2\u00ef\u00f0\7~\2\2\u00f0H\3"+
		"\2\2\2\u00f1\u00f2\7`\2\2\u00f2J\3\2\2\2\u00f3\u00f4\7#\2\2\u00f4L\3\2"+
		"\2\2\u00f5\u00f6\7*\2\2\u00f6N\3\2\2\2\u00f7\u00f8\7+\2\2\u00f8P\3\2\2"+
		"\2\u00f9\u00fa\7}\2\2\u00faR\3\2\2\2\u00fb\u00fc\7\177\2\2\u00fcT\3\2"+
		"\2\2\u00fd\u00fe\7]\2\2\u00feV\3\2\2\2\u00ff\u0100\7_\2\2\u0100X\3\2\2"+
		"\2\u0101\u0102\7x\2\2\u0102\u0103\7c\2\2\u0103\u0108\7t\2\2\u0104\u0105"+
		"\7n\2\2\u0105\u0106\7g\2\2\u0106\u0108\7v\2\2\u0107\u0101\3\2\2\2\u0107"+
		"\u0104\3\2\2\2\u0108Z\3\2\2\2\u0109\u010a\7e\2\2\u010a\u010b\7q\2\2\u010b"+
		"\u010c\7p\2\2\u010c\u010d\7u\2\2\u010d\u0119\7v\2\2\u010e\u010f\7e\2\2"+
		"\u010f\u0110\7j\2\2\u0110\u0111\7c\2\2\u0111\u0112\7p\2\2\u0112\u0113"+
		"\7i\2\2\u0113\u0114\7g\2\2\u0114\u0115\7c\2\2\u0115\u0116\7d\2\2\u0116"+
		"\u0117\7n\2\2\u0117\u0119\7g\2\2\u0118\u0109\3\2\2\2\u0118\u010e\3\2\2"+
		"\2\u0119\\\3\2\2\2\u011a\u011b\7q\2\2\u011b\u011c\7d\2\2\u011c\u0121\7"+
		"l\2\2\u011d\u011e\7t\2\2\u011e\u011f\7g\2\2\u011f\u0121\7h\2\2\u0120\u011a"+
		"\3\2\2\2\u0120\u011d\3\2\2\2\u0121^\3\2\2\2\u0122\u0126\5Y-\2\u0123\u0126"+
		"\5[.\2\u0124\u0126\5]/\2\u0125\u0122\3\2\2\2\u0125\u0123\3\2\2\2\u0125"+
		"\u0124\3\2\2\2\u0126`\3\2\2\2\u0127\u0128\7h\2\2\u0128\u0129\7w\2\2\u0129"+
		"\u012a\7p\2\2\u012a\u012b\7e\2\2\u012b\u012c\7v\2\2\u012c\u012d\7k\2\2"+
		"\u012d\u012e\7q\2\2\u012e\u012f\7p\2\2\u012fb\3\2\2\2\u0130\u0131\7y\2"+
		"\2\u0131\u0132\7j\2\2\u0132\u0133\7k\2\2\u0133\u0134\7n\2\2\u0134\u0135"+
		"\7g\2\2\u0135d\3\2\2\2\u0136\u0137\7k\2\2\u0137\u0138\7h\2\2\u0138f\3"+
		"\2\2\2\u0139\u013a\7g\2\2\u013a\u013b\7n\2\2\u013b\u013c\7k\2\2\u013c"+
		"\u013d\7h\2\2\u013dh\3\2\2\2\u013e\u013f\7g\2\2\u013f\u0140\7n\2\2\u0140"+
		"\u0141\7u\2\2\u0141\u0142\7g\2\2\u0142j\3\2\2\2\u0143\u0144\7t\2\2\u0144"+
		"\u0145\7g\2\2\u0145\u0146\7v\2\2\u0146\u0147\7w\2\2\u0147\u0148\7t\2\2"+
		"\u0148\u0149\7p\2\2\u0149l\3\2\2\2\u014a\u014b\7d\2\2\u014b\u014c\7t\2"+
		"\2\u014c\u014d\7g\2\2\u014d\u014e\7c\2\2\u014e\u014f\7m\2\2\u014fn\3\2"+
		"\2\2\u0150\u0155\5q9\2\u0151\u0154\5q9\2\u0152\u0154\5s:\2\u0153\u0151"+
		"\3\2\2\2\u0153\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156p\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\t\2\2\2"+
		"\u0159r\3\2\2\2\u015a\u015b\t\3\2\2\u015bt\3\2\2\2\u015c\u015e\t\3\2\2"+
		"\u015d\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160"+
		"\3\2\2\2\u0160v\3\2\2\2\u0161\u0163\t\4\2\2\u0162\u0161\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165x\3\2\2\2"+
		"\u0166\u0168\t\5\2\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0167"+
		"\3\2\2\2\u0169\u016a\3\2\2\2\u016az\3\2\2\2\u016b\u016d\t\6\2\2\u016c"+
		"\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2"+
		"\2\2\u016f|\3\2\2\2\u0170\u0171\t\6\2\2\u0171~\3\2\2\2\u0172\u0175\7^"+
		"\2\2\u0173\u0176\t\7\2\2\u0174\u0176\5\u0081A\2\u0175\u0173\3\2\2\2\u0175"+
		"\u0174\3\2\2\2\u0176\u0080\3\2\2\2\u0177\u0178\t\b\2\2\u0178\u0179\5}"+
		"?\2\u0179\u017a\5}?\2\u017a\u017b\5}?\2\u017b\u017c\5}?\2\u017c\u0082"+
		"\3\2\2\2\u017d\u017f\t\t\2\2\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\bB"+
		"\2\2\u0183\u0084\3\2\2\2\21\2\u0095\u00a5\u0107\u0118\u0120\u0125\u0153"+
		"\u0155\u015f\u0164\u0169\u016e\u0175\u0180\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}