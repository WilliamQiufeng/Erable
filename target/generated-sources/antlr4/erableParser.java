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
		T__0=1, T__1=2, T__2=3, ADD=4, SUB=5, MUL=6, DIV=7, POW=8, EQU=9, COLON=10, 
		SPLIT=11, DOT=12, COMMA=13, LPA=14, RPA=15, LCB=16, RCB=17, VAR_ID=18, 
		FUNC=19, NAME=20, STRING=21, INT=22, BIN=23, OCT=24, HEX=25, UNICODE=26, 
		WS=27;
	public static final int
		RULE_prog = 0, RULE_progo = 1, RULE_exprs = 2, RULE_field_and_types = 3, 
		RULE_types = 4, RULE_field = 5, RULE_ops = 6, RULE_minus_plus = 7, RULE_mul_div = 8, 
		RULE_change = 9, RULE_dot = 10, RULE_atom = 11, RULE_string = 12, RULE_unsigned_num = 13, 
		RULE_unsigned_int = 14, RULE_unsigned_float = 15, RULE_var = 16, RULE_var_kv = 17, 
		RULE_var_pair = 18, RULE_var_ids = 19, RULE_funccall = 20, RULE_args = 21, 
		RULE_codeblock = 22, RULE_funcdecl = 23, RULE_name = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "progo", "exprs", "field_and_types", "types", "field", "ops", 
			"minus_plus", "mul_div", "change", "dot", "atom", "string", "unsigned_num", 
			"unsigned_int", "unsigned_float", "var", "var_kv", "var_pair", "var_ids", 
			"funccall", "args", "codeblock", "funcdecl", "name"
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
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << LPA) | (1L << LCB) | (1L << VAR_ID) | (1L << FUNC) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				{
				setState(50);
				progo();
				setState(51);
				match(SPLIT);
				}
				}
				setState(57);
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

	public static class ProgoContext extends ParserRuleContext {
		public FuncdeclContext funcdecl() {
			return getRuleContext(FuncdeclContext.class,0);
		}
		public OpsContext ops() {
			return getRuleContext(OpsContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CodeblockContext codeblock() {
			return getRuleContext(CodeblockContext.class,0);
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
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				funcdecl();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case LPA:
			case NAME:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				ops();
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				var();
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				codeblock();
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
			setState(64);
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
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				field();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case LPA:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
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
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
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
				setState(71);
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
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				funccall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
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
			setState(78);
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
			setState(80);
			mul_div();
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(81);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(82);
					mul_div();
					}
					} 
				}
				setState(87);
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
			setState(88);
			change();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(89);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(90);
				change();
				}
				}
				setState(95);
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
			setState(96);
			dot();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQU) {
				{
				{
				setState(97);
				match(EQU);
				setState(98);
				dot();
				}
				}
				setState(103);
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
			setState(104);
			field_and_types();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(105);
				match(DOT);
				setState(106);
				field();
				}
				}
				setState(111);
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
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(LPA);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << LPA) | (1L << LCB) | (1L << VAR_ID) | (1L << FUNC) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
					{
					setState(113);
					progo();
					}
				}

				setState(116);
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
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(117);
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

				setState(120);
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
			setState(123);
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
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				unsigned_int();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
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
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(T__0);
				setState(130);
				match(HEX);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(T__1);
				setState(132);
				match(BIN);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(T__2);
				setState(134);
				match(OCT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
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
			setState(138);
			match(INT);
			setState(139);
			match(DOT);
			setState(140);
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
		public Var_idsContext modifiers;
		public Var_kvContext decls;
		public Var_idsContext var_ids() {
			return getRuleContext(Var_idsContext.class,0);
		}
		public Var_kvContext var_kv() {
			return getRuleContext(Var_kvContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((VarContext)_localctx).modifiers = var_ids();
			setState(143);
			((VarContext)_localctx).decls = var_kv();
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

	public static class Var_kvContext extends ParserRuleContext {
		public List<Var_pairContext> var_pair() {
			return getRuleContexts(Var_pairContext.class);
		}
		public Var_pairContext var_pair(int i) {
			return getRuleContext(Var_pairContext.class,i);
		}
		public Var_kvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_kv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterVar_kv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitVar_kv(this);
		}
	}

	public final Var_kvContext var_kv() throws RecognitionException {
		Var_kvContext _localctx = new Var_kvContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_var_kv);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(145);
					var_pair();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(148); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Var_pairContext extends ParserRuleContext {
		public Token key;
		public ProgoContext val;
		public TerminalNode NAME() { return getToken(erableParser.NAME, 0); }
		public TerminalNode EQU() { return getToken(erableParser.EQU, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
		public Var_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterVar_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitVar_pair(this);
		}
	}

	public final Var_pairContext var_pair() throws RecognitionException {
		Var_pairContext _localctx = new Var_pairContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_var_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			((Var_pairContext)_localctx).key = match(NAME);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQU) {
				{
				setState(151);
				match(EQU);
				setState(152);
				((Var_pairContext)_localctx).val = progo();
				}
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

	public static class Var_idsContext extends ParserRuleContext {
		public List<TerminalNode> VAR_ID() { return getTokens(erableParser.VAR_ID); }
		public TerminalNode VAR_ID(int i) {
			return getToken(erableParser.VAR_ID, i);
		}
		public Var_idsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterVar_ids(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitVar_ids(this);
		}
	}

	public final Var_idsContext var_ids() throws RecognitionException {
		Var_idsContext _localctx = new Var_idsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_var_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				match(VAR_ID);
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR_ID );
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
		public List<ProgoContext> arguments = new ArrayList<ProgoContext>();
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
		enterRule(_localctx, 40, RULE_funccall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(NAME);
			setState(161);
			match(LPA);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(162);
					((FunccallContext)_localctx).progo = progo();
					((FunccallContext)_localctx).arguments.add(((FunccallContext)_localctx).progo);
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(168);
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

	public static class ArgsContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(erableParser.COLON, 0); }
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public List<TerminalNode> NAME() { return getTokens(erableParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(erableParser.NAME, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(COLON);
			setState(171);
			match(LPA);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(172);
				match(NAME);
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
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

	public static class CodeblockContext extends ParserRuleContext {
		public TerminalNode LCB() { return getToken(erableParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(erableParser.RCB, 0); }
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public CodeblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterCodeblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitCodeblock(this);
		}
	}

	public final CodeblockContext codeblock() throws RecognitionException {
		CodeblockContext _localctx = new CodeblockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_codeblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(LCB);
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(181);
				prog();
				}
				break;
			}
			setState(184);
			match(RCB);
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

	public static class FuncdeclContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(erableParser.FUNC, 0); }
		public TerminalNode NAME() { return getToken(erableParser.NAME, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public CodeblockContext codeblock() {
			return getRuleContext(CodeblockContext.class,0);
		}
		public FuncdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterFuncdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitFuncdecl(this);
		}
	}

	public final FuncdeclContext funcdecl() throws RecognitionException {
		FuncdeclContext _localctx = new FuncdeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_funcdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(FUNC);
			setState(187);
			match(NAME);
			setState(188);
			args();
			setState(189);
			codeblock();
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
		enterRule(_localctx, 48, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00c4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\3\3\3\3\3\3\3\5\3A\n"+
		"\3\3\4\3\4\3\5\3\5\5\5G\n\5\3\6\3\6\5\6K\n\6\3\7\3\7\5\7O\n\7\3\b\3\b"+
		"\3\t\3\t\3\t\7\tV\n\t\f\t\16\tY\13\t\3\n\3\n\3\n\7\n^\n\n\f\n\16\na\13"+
		"\n\3\13\3\13\3\13\7\13f\n\13\f\13\16\13i\13\13\3\f\3\f\3\f\7\fn\n\f\f"+
		"\f\16\fq\13\f\3\r\3\r\5\ru\n\r\3\r\3\r\5\ry\n\r\3\r\5\r|\n\r\3\16\3\16"+
		"\3\17\3\17\5\17\u0082\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u008b"+
		"\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\6\23\u0095\n\23\r\23\16"+
		"\23\u0096\3\24\3\24\3\24\5\24\u009c\n\24\3\25\6\25\u009f\n\25\r\25\16"+
		"\25\u00a0\3\26\3\26\3\26\7\26\u00a6\n\26\f\26\16\26\u00a9\13\26\3\26\3"+
		"\26\3\27\3\27\3\27\7\27\u00b0\n\27\f\27\16\27\u00b3\13\27\3\27\3\27\3"+
		"\30\3\30\5\30\u00b9\n\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\u00a7\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\2\4\3\2\6\7\3\2\b\t\2\u00c2\29\3\2\2\2\4@\3\2\2\2\6B\3\2\2\2\bF\3"+
		"\2\2\2\nJ\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20R\3\2\2\2\22Z\3\2\2\2\24b\3"+
		"\2\2\2\26j\3\2\2\2\30{\3\2\2\2\32}\3\2\2\2\34\u0081\3\2\2\2\36\u008a\3"+
		"\2\2\2 \u008c\3\2\2\2\"\u0090\3\2\2\2$\u0094\3\2\2\2&\u0098\3\2\2\2(\u009e"+
		"\3\2\2\2*\u00a2\3\2\2\2,\u00ac\3\2\2\2.\u00b6\3\2\2\2\60\u00bc\3\2\2\2"+
		"\62\u00c1\3\2\2\2\64\65\5\4\3\2\65\66\7\r\2\2\668\3\2\2\2\67\64\3\2\2"+
		"\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\3\3\2\2\2;9\3\2\2\2<A\5\60\31\2=A"+
		"\5\16\b\2>A\5\"\22\2?A\5.\30\2@<\3\2\2\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2"+
		"A\5\3\2\2\2BC\5\b\5\2C\7\3\2\2\2DG\5\f\7\2EG\5\n\6\2FD\3\2\2\2FE\3\2\2"+
		"\2G\t\3\2\2\2HK\5\32\16\2IK\5\30\r\2JH\3\2\2\2JI\3\2\2\2K\13\3\2\2\2L"+
		"O\5*\26\2MO\5\62\32\2NL\3\2\2\2NM\3\2\2\2O\r\3\2\2\2PQ\5\20\t\2Q\17\3"+
		"\2\2\2RW\5\22\n\2ST\t\2\2\2TV\5\22\n\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2W"+
		"X\3\2\2\2X\21\3\2\2\2YW\3\2\2\2Z_\5\24\13\2[\\\t\3\2\2\\^\5\24\13\2]["+
		"\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\23\3\2\2\2a_\3\2\2\2bg\5\26\f"+
		"\2cd\7\13\2\2df\5\26\f\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\25\3"+
		"\2\2\2ig\3\2\2\2jo\5\b\5\2kl\7\16\2\2ln\5\f\7\2mk\3\2\2\2nq\3\2\2\2om"+
		"\3\2\2\2op\3\2\2\2p\27\3\2\2\2qo\3\2\2\2rt\7\20\2\2su\5\4\3\2ts\3\2\2"+
		"\2tu\3\2\2\2uv\3\2\2\2v|\7\21\2\2wy\t\2\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2"+
		"\2\2z|\5\34\17\2{r\3\2\2\2{x\3\2\2\2|\31\3\2\2\2}~\7\27\2\2~\33\3\2\2"+
		"\2\177\u0082\5\36\20\2\u0080\u0082\5 \21\2\u0081\177\3\2\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\35\3\2\2\2\u0083\u0084\7\3\2\2\u0084\u008b\7\33\2\2\u0085"+
		"\u0086\7\4\2\2\u0086\u008b\7\31\2\2\u0087\u0088\7\5\2\2\u0088\u008b\7"+
		"\32\2\2\u0089\u008b\7\30\2\2\u008a\u0083\3\2\2\2\u008a\u0085\3\2\2\2\u008a"+
		"\u0087\3\2\2\2\u008a\u0089\3\2\2\2\u008b\37\3\2\2\2\u008c\u008d\7\30\2"+
		"\2\u008d\u008e\7\16\2\2\u008e\u008f\7\30\2\2\u008f!\3\2\2\2\u0090\u0091"+
		"\5(\25\2\u0091\u0092\5$\23\2\u0092#\3\2\2\2\u0093\u0095\5&\24\2\u0094"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097%\3\2\2\2\u0098\u009b\7\26\2\2\u0099\u009a\7\13\2\2\u009a\u009c"+
		"\5\4\3\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\'\3\2\2\2\u009d"+
		"\u009f\7\24\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1)\3\2\2\2\u00a2\u00a3\7\26\2\2\u00a3\u00a7"+
		"\7\20\2\2\u00a4\u00a6\5\4\3\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2"+
		"\u00a7\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00aa\u00ab\7\21\2\2\u00ab+\3\2\2\2\u00ac\u00ad\7\f\2\2\u00ad"+
		"\u00b1\7\20\2\2\u00ae\u00b0\7\26\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3"+
		"\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b5\7\21\2\2\u00b5-\3\2\2\2\u00b6\u00b8\7\22\2"+
		"\2\u00b7\u00b9\5\2\2\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00bb\7\23\2\2\u00bb/\3\2\2\2\u00bc\u00bd\7\25\2\2\u00bd"+
		"\u00be\7\26\2\2\u00be\u00bf\5,\27\2\u00bf\u00c0\5.\30\2\u00c0\61\3\2\2"+
		"\2\u00c1\u00c2\7\26\2\2\u00c2\63\3\2\2\2\269@FJNW_gotx{\u0081\u008a\u0096"+
		"\u009b\u00a0\u00a7\u00b1\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}