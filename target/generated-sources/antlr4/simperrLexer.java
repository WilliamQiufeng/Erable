// Generated from simperr.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class simperrLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR_IDS=1, LETTER=2, NUM=3, NAME=4, EQU=5, SPLIT=6, WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAR_IDS", "LETTER", "NUM", "NAME", "EQU", "SPLIT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR_IDS", "LETTER", "NUM", "NAME", "EQU", "SPLIT", "WS"
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


	public simperrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "simperr.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\62\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\6\2\30\n\2\r\2\16\2\31\3\3\3\3\3\4\3\4\3\5\3\5\3\5\7\5#\n\5\f\5\16"+
		"\5&\13\5\3\6\3\6\3\7\3\7\3\b\6\b-\n\b\r\b\16\b.\3\b\3\b\2\2\t\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\3\2\5\6\2&&C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2"+
		"\66\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\3\27\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37\3\2\2"+
		"\2\13\'\3\2\2\2\r)\3\2\2\2\17,\3\2\2\2\21\22\7x\2\2\22\23\7c\2\2\23\30"+
		"\7t\2\2\24\25\7n\2\2\25\26\7g\2\2\26\30\7v\2\2\27\21\3\2\2\2\27\24\3\2"+
		"\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\4\3\2\2\2\33\34\t\2"+
		"\2\2\34\6\3\2\2\2\35\36\t\3\2\2\36\b\3\2\2\2\37$\5\5\3\2 #\5\5\3\2!#\5"+
		"\7\4\2\" \3\2\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\n\3\2\2\2"+
		"&$\3\2\2\2\'(\7?\2\2(\f\3\2\2\2)*\7=\2\2*\16\3\2\2\2+-\t\4\2\2,+\3\2\2"+
		"\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\b\b\2\2\61\20\3\2\2"+
		"\2\b\2\27\31\"$.\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}