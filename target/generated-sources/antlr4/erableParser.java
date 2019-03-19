// Generated from erable.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class erableParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ADD=4, SUB=5, MUL=6, DIV=7, POW=8, EQU=9, SPLIT=10, 
		DOT=11, COMMA=12, LPA=13, RPA=14, INT=15, BIN=16, OCT=17, HEX=18, VAR_SC=19, 
		VAR_CG=20, VAR_TP=21, VAR_IDS=22, LETT=23, NAME=24, STRING=25, UNICODE=26, 
		WS=27;
	public static final int
		RULE_prog = 0, RULE_progo = 1, RULE_exprs = 2, RULE_field_and_types = 3, 
		RULE_types = 4, RULE_field = 5, RULE_ops = 6, RULE_minus_plus = 7, RULE_mul_div = 8, 
		RULE_change = 9, RULE_dot = 10, RULE_atom = 11, RULE_string = 12, RULE_unsigned_num = 13, 
		RULE_unsigned_int = 14, RULE_unsigned_float = 15, RULE_var = 16, RULE_funccall = 17, 
		RULE_name = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "progo", "exprs", "field_and_types", "types", "field", "ops", 
			"minus_plus", "mul_div", "change", "dot", "atom", "string", "unsigned_num", 
			"unsigned_int", "unsigned_float", "var", "funccall", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0x'", "'0b'", "'0o'", "'+'", "'-'", "'*'", "'/'", "'**'", "'='", 
			"';'", "'.'", "','", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ADD", "SUB", "MUL", "DIV", "POW", "EQU", "SPLIT", 
			"DOT", "COMMA", "LPA", "RPA", "INT", "BIN", "OCT", "HEX", "VAR_SC", "VAR_CG", 
			"VAR_TP", "VAR_IDS", "LETT", "NAME", "STRING", "UNICODE", "WS"
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

	@Override
	public String getGrammarFileName() { return "erable.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public erableParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(erableParser.EOF, 0); }
		public List<ProgoContext> progo() {
			return getRuleContexts(ProgoContext.class);
		}
		public ProgoContext progo(int i) {
			return getRuleContext(ProgoContext.class,i);
		}
		public List<TerminalNode> SPLIT() { return getTokens(erableParser.SPLIT); }
		public TerminalNode SPLIT(int i) {
			return getToken(erableParser.SPLIT, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << LPA) | (1L << INT) | (1L << VAR_SC) | (1L << VAR_CG) | (1L << VAR_TP) | (1L << NAME) | (1L << STRING))) != 0)) {
				{
				{
				setState(38);
				progo();
				setState(39);
				match(SPLIT);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgoContext extends ParserRuleContext {
		public OpsContext ops() {
			return getRuleContext(OpsContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ProgoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterProgo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitProgo(this);
		}
	}

	public final ProgoContext progo() throws RecognitionException {
		ProgoContext _localctx = new ProgoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_progo);
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case LPA:
			case INT:
			case NAME:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				ops();
				}
				break;
			case VAR_SC:
			case VAR_CG:
			case VAR_TP:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprsContext extends ParserRuleContext {
		public Field_and_typesContext field_and_types() {
			return getRuleContext(Field_and_typesContext.class,0);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitExprs(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exprs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			field_and_types();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_and_typesContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public Field_and_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_and_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterField_and_types(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitField_and_types(this);
		}
	}

	public final Field_and_typesContext field_and_types() throws RecognitionException {
		Field_and_typesContext _localctx = new Field_and_typesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field_and_types);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				field();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case LPA:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				types();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitTypes(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_types);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				string();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case LPA:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_field);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				funccall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpsContext extends ParserRuleContext {
		public Minus_plusContext minus_plus() {
			return getRuleContext(Minus_plusContext.class,0);
		}
		public OpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitOps(this);
		}
	}

	public final OpsContext ops() throws RecognitionException {
		OpsContext _localctx = new OpsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ops);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			minus_plus();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Minus_plusContext extends ParserRuleContext {
		public List<Mul_divContext> mul_div() {
			return getRuleContexts(Mul_divContext.class);
		}
		public Mul_divContext mul_div(int i) {
			return getRuleContext(Mul_divContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(erableParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(erableParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(erableParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(erableParser.SUB, i);
		}
		public Minus_plusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minus_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterMinus_plus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitMinus_plus(this);
		}
	}

	public final Minus_plusContext minus_plus() throws RecognitionException {
		Minus_plusContext _localctx = new Minus_plusContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_minus_plus);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			mul_div();
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(69);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(70);
					mul_div();
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mul_divContext extends ParserRuleContext {
		public List<ChangeContext> change() {
			return getRuleContexts(ChangeContext.class);
		}
		public ChangeContext change(int i) {
			return getRuleContext(ChangeContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(erableParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(erableParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(erableParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(erableParser.DIV, i);
		}
		public Mul_divContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul_div; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterMul_div(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitMul_div(this);
		}
	}

	public final Mul_divContext mul_div() throws RecognitionException {
		Mul_divContext _localctx = new Mul_divContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mul_div);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			change();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(77);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(78);
				change();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChangeContext extends ParserRuleContext {
		public List<DotContext> dot() {
			return getRuleContexts(DotContext.class);
		}
		public DotContext dot(int i) {
			return getRuleContext(DotContext.class,i);
		}
		public List<TerminalNode> EQU() { return getTokens(erableParser.EQU); }
		public TerminalNode EQU(int i) {
			return getToken(erableParser.EQU, i);
		}
		public ChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitChange(this);
		}
	}

	public final ChangeContext change() throws RecognitionException {
		ChangeContext _localctx = new ChangeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_change);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			dot();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQU) {
				{
				{
				setState(85);
				match(EQU);
				setState(86);
				dot();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DotContext extends ParserRuleContext {
		public Field_and_typesContext field_and_types() {
			return getRuleContext(Field_and_typesContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(erableParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(erableParser.DOT, i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public DotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitDot(this);
		}
	}

	public final DotContext dot() throws RecognitionException {
		DotContext _localctx = new DotContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			field_and_types();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(93);
				match(DOT);
				setState(94);
				field();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
		public Unsigned_numContext unsigned_num() {
			return getRuleContext(Unsigned_numContext.class,0);
		}
		public TerminalNode ADD() { return getToken(erableParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(erableParser.SUB, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atom);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(LPA);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << LPA) | (1L << INT) | (1L << VAR_SC) | (1L << VAR_CG) | (1L << VAR_TP) | (1L << NAME) | (1L << STRING))) != 0)) {
					{
					setState(101);
					progo();
					}
				}

				setState(104);
				match(RPA);
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(105);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(108);
				unsigned_num();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(erableParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_numContext extends ParserRuleContext {
		public Unsigned_intContext unsigned_int() {
			return getRuleContext(Unsigned_intContext.class,0);
		}
		public Unsigned_floatContext unsigned_float() {
			return getRuleContext(Unsigned_floatContext.class,0);
		}
		public Unsigned_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterUnsigned_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitUnsigned_num(this);
		}
	}

	public final Unsigned_numContext unsigned_num() throws RecognitionException {
		Unsigned_numContext _localctx = new Unsigned_numContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unsigned_num);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				unsigned_int();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				unsigned_float();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_intContext extends ParserRuleContext {
		public TerminalNode HEX() { return getToken(erableParser.HEX, 0); }
		public TerminalNode BIN() { return getToken(erableParser.BIN, 0); }
		public TerminalNode OCT() { return getToken(erableParser.OCT, 0); }
		public TerminalNode INT() { return getToken(erableParser.INT, 0); }
		public Unsigned_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterUnsigned_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitUnsigned_int(this);
		}
	}

	public final Unsigned_intContext unsigned_int() throws RecognitionException {
		Unsigned_intContext _localctx = new Unsigned_intContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unsigned_int);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(T__0);
				setState(118);
				match(HEX);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(T__1);
				setState(120);
				match(BIN);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(T__2);
				setState(122);
				match(OCT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unsigned_floatContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(erableParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(erableParser.INT, i);
		}
		public TerminalNode DOT() { return getToken(erableParser.DOT, 0); }
		public Unsigned_floatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_float; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterUnsigned_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitUnsigned_float(this);
		}
	}

	public final Unsigned_floatContext unsigned_float() throws RecognitionException {
		Unsigned_floatContext _localctx = new Unsigned_floatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unsigned_float);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(INT);
			setState(127);
			match(DOT);
			setState(128);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public Token VAR_SC;
		public List<Token> modifiers = new ArrayList<Token>();
		public Token VAR_CG;
		public Token VAR_TP;
		public Token _tset241;
		public Token var_name;
		public ProgoContext val;
		public List<TerminalNode> NAME() { return getTokens(erableParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(erableParser.NAME, i);
		}
		public List<TerminalNode> VAR_SC() { return getTokens(erableParser.VAR_SC); }
		public TerminalNode VAR_SC(int i) {
			return getToken(erableParser.VAR_SC, i);
		}
		public List<TerminalNode> VAR_CG() { return getTokens(erableParser.VAR_CG); }
		public TerminalNode VAR_CG(int i) {
			return getToken(erableParser.VAR_CG, i);
		}
		public List<TerminalNode> VAR_TP() { return getTokens(erableParser.VAR_TP); }
		public TerminalNode VAR_TP(int i) {
			return getToken(erableParser.VAR_TP, i);
		}
		public List<TerminalNode> EQU() { return getTokens(erableParser.EQU); }
		public TerminalNode EQU(int i) {
			return getToken(erableParser.EQU, i);
		}
		public List<ProgoContext> progo() {
			return getRuleContexts(ProgoContext.class);
		}
		public ProgoContext progo(int i) {
			return getRuleContext(ProgoContext.class,i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_var);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(130);
					((VarContext)_localctx)._tset241 = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR_SC) | (1L << VAR_CG) | (1L << VAR_TP))) != 0)) ) {
						((VarContext)_localctx)._tset241 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((VarContext)_localctx).modifiers.add(((VarContext)_localctx)._tset241);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(133); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(140); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(135);
					((VarContext)_localctx).var_name = match(NAME);
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==EQU) {
						{
						setState(136);
						match(EQU);
						setState(137);
						((VarContext)_localctx).val = progo();
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(142); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunccallContext extends ParserRuleContext {
		public ProgoContext progo;
		public List<ProgoContext> args = new ArrayList<ProgoContext>();
		public TerminalNode NAME() { return getToken(erableParser.NAME, 0); }
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public List<ProgoContext> progo() {
			return getRuleContexts(ProgoContext.class);
		}
		public ProgoContext progo(int i) {
			return getRuleContext(ProgoContext.class,i);
		}
		public FunccallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funccall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitFunccall(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_funccall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(NAME);
			setState(145);
			match(LPA);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(146);
					((FunccallContext)_localctx).progo = progo();
					((FunccallContext)_localctx).args.add(((FunccallContext)_localctx).progo);
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(152);
			match(RPA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(erableParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u009f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3\3"+
		"\3\5\3\65\n\3\3\4\3\4\3\5\3\5\5\5;\n\5\3\6\3\6\5\6?\n\6\3\7\3\7\5\7C\n"+
		"\7\3\b\3\b\3\t\3\t\3\t\7\tJ\n\t\f\t\16\tM\13\t\3\n\3\n\3\n\7\nR\n\n\f"+
		"\n\16\nU\13\n\3\13\3\13\3\13\7\13Z\n\13\f\13\16\13]\13\13\3\f\3\f\3\f"+
		"\7\fb\n\f\f\f\16\fe\13\f\3\r\3\r\5\ri\n\r\3\r\3\r\5\rm\n\r\3\r\5\rp\n"+
		"\r\3\16\3\16\3\17\3\17\5\17v\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\177\n\20\3\21\3\21\3\21\3\21\3\22\6\22\u0086\n\22\r\22\16\22\u0087"+
		"\3\22\3\22\3\22\5\22\u008d\n\22\6\22\u008f\n\22\r\22\16\22\u0090\3\23"+
		"\3\23\3\23\7\23\u0096\n\23\f\23\16\23\u0099\13\23\3\23\3\23\3\24\3\24"+
		"\3\24\5\u0087\u0090\u0097\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&\2\5\3\2\6\7\3\2\b\t\3\2\25\27\2\u009f\2-\3\2\2\2\4\64\3\2\2\2\6"+
		"\66\3\2\2\2\b:\3\2\2\2\n>\3\2\2\2\fB\3\2\2\2\16D\3\2\2\2\20F\3\2\2\2\22"+
		"N\3\2\2\2\24V\3\2\2\2\26^\3\2\2\2\30o\3\2\2\2\32q\3\2\2\2\34u\3\2\2\2"+
		"\36~\3\2\2\2 \u0080\3\2\2\2\"\u0085\3\2\2\2$\u0092\3\2\2\2&\u009c\3\2"+
		"\2\2()\5\4\3\2)*\7\f\2\2*,\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2"+
		"\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\2\2\3\61\3\3\2\2\2\62\65\5\16\b\2\63"+
		"\65\5\"\22\2\64\62\3\2\2\2\64\63\3\2\2\2\65\5\3\2\2\2\66\67\5\b\5\2\67"+
		"\7\3\2\2\28;\5\f\7\29;\5\n\6\2:8\3\2\2\2:9\3\2\2\2;\t\3\2\2\2<?\5\32\16"+
		"\2=?\5\30\r\2><\3\2\2\2>=\3\2\2\2?\13\3\2\2\2@C\5$\23\2AC\5&\24\2B@\3"+
		"\2\2\2BA\3\2\2\2C\r\3\2\2\2DE\5\20\t\2E\17\3\2\2\2FK\5\22\n\2GH\t\2\2"+
		"\2HJ\5\22\n\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\21\3\2\2\2MK\3"+
		"\2\2\2NS\5\24\13\2OP\t\3\2\2PR\5\24\13\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2"+
		"ST\3\2\2\2T\23\3\2\2\2US\3\2\2\2V[\5\26\f\2WX\7\13\2\2XZ\5\26\f\2YW\3"+
		"\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\25\3\2\2\2][\3\2\2\2^c\5\b\5\2"+
		"_`\7\r\2\2`b\5\f\7\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\27\3\2\2"+
		"\2ec\3\2\2\2fh\7\17\2\2gi\5\4\3\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jp\7\20"+
		"\2\2km\t\2\2\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2np\5\34\17\2of\3\2\2\2ol\3"+
		"\2\2\2p\31\3\2\2\2qr\7\33\2\2r\33\3\2\2\2sv\5\36\20\2tv\5 \21\2us\3\2"+
		"\2\2ut\3\2\2\2v\35\3\2\2\2wx\7\3\2\2x\177\7\24\2\2yz\7\4\2\2z\177\7\22"+
		"\2\2{|\7\5\2\2|\177\7\23\2\2}\177\7\21\2\2~w\3\2\2\2~y\3\2\2\2~{\3\2\2"+
		"\2~}\3\2\2\2\177\37\3\2\2\2\u0080\u0081\7\21\2\2\u0081\u0082\7\r\2\2\u0082"+
		"\u0083\7\21\2\2\u0083!\3\2\2\2\u0084\u0086\t\4\2\2\u0085\u0084\3\2\2\2"+
		"\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008e"+
		"\3\2\2\2\u0089\u008c\7\32\2\2\u008a\u008b\7\13\2\2\u008b\u008d\5\4\3\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u0089"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"#\3\2\2\2\u0092\u0093\7\32\2\2\u0093\u0097\7\17\2\2\u0094\u0096\5\4\3"+
		"\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0098\3\2\2\2\u0097\u0095"+
		"\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\20\2\2"+
		"\u009b%\3\2\2\2\u009c\u009d\7\32\2\2\u009d\'\3\2\2\2\24-\64:>BKS[chlo"+
		"u~\u0087\u008c\u0090\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}