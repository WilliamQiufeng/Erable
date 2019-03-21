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
		T__0=1, T__1=2, T__2=3, ADD=4, SUB=5, MUL=6, DIV=7, POW=8, EQ=9, NEQ=10, 
		EQU=11, ULS=12, URS=13, LTE=14, GTE=15, LS=16, RS=17, AND=18, OR=19, XOR=20, 
		LT=21, GT=22, COLON=23, SPLIT=24, DOT=25, COMMA=26, BAND=27, BOR=28, BXOR=29, 
		BNOT=30, LPA=31, RPA=32, LCB=33, RCB=34, VAR_ID=35, FUNC=36, WHILE=37, 
		IF=38, ELIF=39, ELSE=40, RETURN=41, BREAK=42, NAME=43, STRING=44, INT=45, 
		BIN=46, OCT=47, HEX=48, UNICODE=49, WS=50, RTE=51;
	public static final int
		RULE_prog = 0, RULE_progo = 1, RULE_exprs = 2, RULE_decls = 3, RULE_condexprs = 4, 
		RULE_field_and_types = 5, RULE_types = 6, RULE_field = 7, RULE_ops = 8, 
		RULE_binary_op = 9, RULE_minus_plus = 10, RULE_mul_div = 11, RULE_change = 12, 
		RULE_dot = 13, RULE_atom = 14, RULE_string = 15, RULE_unsigned_num = 16, 
		RULE_unsigned_int = 17, RULE_unsigned_float = 18, RULE_unary_op = 19, 
		RULE_var = 20, RULE_var_kv = 21, RULE_var_pair = 22, RULE_var_ids = 23, 
		RULE_funccall = 24, RULE_args = 25, RULE_codeblock = 26, RULE_funcdecl = 27, 
		RULE_ifcond = 28, RULE_whilecond = 29, RULE_name = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "progo", "exprs", "decls", "condexprs", "field_and_types", "types", 
			"field", "ops", "binary_op", "minus_plus", "mul_div", "change", "dot", 
			"atom", "string", "unsigned_num", "unsigned_int", "unsigned_float", "unary_op", 
			"var", "var_kv", "var_pair", "var_ids", "funccall", "args", "codeblock", 
			"funcdecl", "ifcond", "whilecond", "name"
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
			"UNICODE", "WS", "RTE"
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
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				{
				setState(62);
				progo();
				setState(63);
				match(SPLIT);
				}
				}
				setState(69);
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
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public CondexprsContext condexprs() {
			return getRuleContext(CondexprsContext.class,0);
		}
		public OpsContext ops() {
			return getRuleContext(OpsContext.class,0);
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
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_ID:
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				decls();
				}
				break;
			case WHILE:
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				condexprs();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case BNOT:
			case LPA:
			case RETURN:
			case NAME:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				ops();
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
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
			setState(76);
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

	public static class DeclsContext extends ParserRuleContext {
		public FuncdeclContext funcdecl() {
			return getRuleContext(FuncdeclContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitDecls(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decls);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				funcdecl();
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
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

	public static class CondexprsContext extends ParserRuleContext {
		public IfcondContext ifcond() {
			return getRuleContext(IfcondContext.class,0);
		}
		public WhilecondContext whilecond() {
			return getRuleContext(WhilecondContext.class,0);
		}
		public CondexprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condexprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterCondexprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitCondexprs(this);
		}
	}

	public final CondexprsContext condexprs() throws RecognitionException {
		CondexprsContext _localctx = new CondexprsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condexprs);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				ifcond();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				whilecond();
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
		enterRule(_localctx, 10, RULE_field_and_types);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
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
				setState(87);
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
		enterRule(_localctx, 12, RULE_types);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
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
				setState(91);
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
		enterRule(_localctx, 14, RULE_field);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				funccall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
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
		public Binary_opContext binary_op() {
			return getRuleContext(Binary_opContext.class,0);
		}
		public Unary_opContext unary_op() {
			return getRuleContext(Unary_opContext.class,0);
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
		enterRule(_localctx, 16, RULE_ops);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case LPA:
			case NAME:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				binary_op();
				}
				break;
			case BNOT:
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				unary_op();
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

	public static class Binary_opContext extends ParserRuleContext {
		public List<Minus_plusContext> minus_plus() {
			return getRuleContexts(Minus_plusContext.class);
		}
		public Minus_plusContext minus_plus(int i) {
			return getRuleContext(Minus_plusContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(erableParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(erableParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(erableParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(erableParser.OR, i);
		}
		public List<TerminalNode> XOR() { return getTokens(erableParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(erableParser.XOR, i);
		}
		public List<TerminalNode> BAND() { return getTokens(erableParser.BAND); }
		public TerminalNode BAND(int i) {
			return getToken(erableParser.BAND, i);
		}
		public List<TerminalNode> BOR() { return getTokens(erableParser.BOR); }
		public TerminalNode BOR(int i) {
			return getToken(erableParser.BOR, i);
		}
		public List<TerminalNode> BXOR() { return getTokens(erableParser.BXOR); }
		public TerminalNode BXOR(int i) {
			return getToken(erableParser.BXOR, i);
		}
		public List<TerminalNode> NEQ() { return getTokens(erableParser.NEQ); }
		public TerminalNode NEQ(int i) {
			return getToken(erableParser.NEQ, i);
		}
		public List<TerminalNode> EQ() { return getTokens(erableParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(erableParser.EQ, i);
		}
		public List<TerminalNode> LTE() { return getTokens(erableParser.LTE); }
		public TerminalNode LTE(int i) {
			return getToken(erableParser.LTE, i);
		}
		public List<TerminalNode> RTE() { return getTokens(erableParser.RTE); }
		public TerminalNode RTE(int i) {
			return getToken(erableParser.RTE, i);
		}
		public List<TerminalNode> ULS() { return getTokens(erableParser.ULS); }
		public TerminalNode ULS(int i) {
			return getToken(erableParser.ULS, i);
		}
		public List<TerminalNode> URS() { return getTokens(erableParser.URS); }
		public TerminalNode URS(int i) {
			return getToken(erableParser.URS, i);
		}
		public List<TerminalNode> LS() { return getTokens(erableParser.LS); }
		public TerminalNode LS(int i) {
			return getToken(erableParser.LS, i);
		}
		public List<TerminalNode> RS() { return getTokens(erableParser.RS); }
		public TerminalNode RS(int i) {
			return getToken(erableParser.RS, i);
		}
		public List<TerminalNode> LT() { return getTokens(erableParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(erableParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(erableParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(erableParser.GT, i);
		}
		public Binary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterBinary_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitBinary_op(this);
		}
	}

	public final Binary_opContext binary_op() throws RecognitionException {
		Binary_opContext _localctx = new Binary_opContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binary_op);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			minus_plus();
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(121);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(103);
						match(AND);
						}
						break;
					case 2:
						{
						setState(104);
						match(OR);
						}
						break;
					case 3:
						{
						setState(105);
						match(XOR);
						}
						break;
					case 4:
						{
						setState(106);
						match(BAND);
						}
						break;
					case 5:
						{
						setState(107);
						match(BOR);
						}
						break;
					case 6:
						{
						setState(108);
						match(BXOR);
						}
						break;
					case 7:
						{
						}
						break;
					case 8:
						{
						setState(110);
						match(NEQ);
						}
						break;
					case 9:
						{
						setState(111);
						match(EQ);
						}
						break;
					case 10:
						{
						setState(112);
						match(LTE);
						}
						break;
					case 11:
						{
						setState(113);
						match(RTE);
						}
						break;
					case 12:
						{
						}
						break;
					case 13:
						{
						setState(115);
						match(ULS);
						}
						break;
					case 14:
						{
						setState(116);
						match(URS);
						}
						break;
					case 15:
						{
						setState(117);
						match(LS);
						}
						break;
					case 16:
						{
						setState(118);
						match(RS);
						}
						break;
					case 17:
						{
						setState(119);
						match(LT);
						}
						break;
					case 18:
						{
						setState(120);
						match(GT);
						}
						break;
					}
					setState(123);
					minus_plus();
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 20, RULE_minus_plus);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			mul_div();
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(130);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(131);
					mul_div();
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 22, RULE_mul_div);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			change();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(138);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(139);
				change();
				}
				}
				setState(144);
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
		enterRule(_localctx, 24, RULE_change);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			dot();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQU) {
				{
				{
				setState(146);
				match(EQU);
				setState(147);
				dot();
				}
				}
				setState(152);
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
		enterRule(_localctx, 26, RULE_dot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			field_and_types();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(154);
				match(DOT);
				setState(155);
				field();
				}
				}
				setState(160);
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
		enterRule(_localctx, 28, RULE_atom);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(LPA);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
					{
					setState(162);
					progo();
					}
				}

				setState(165);
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
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD || _la==SUB) {
					{
					setState(166);
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

				setState(169);
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
		enterRule(_localctx, 30, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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
		enterRule(_localctx, 32, RULE_unsigned_num);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				unsigned_int();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
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
		enterRule(_localctx, 34, RULE_unsigned_int);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(T__0);
				setState(179);
				match(HEX);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(T__1);
				setState(181);
				match(BIN);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(T__2);
				setState(183);
				match(OCT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
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
		enterRule(_localctx, 36, RULE_unsigned_float);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(INT);
			setState(188);
			match(DOT);
			setState(189);
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

	public static class Unary_opContext extends ParserRuleContext {
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
		public TerminalNode BNOT() { return getToken(erableParser.BNOT, 0); }
		public TerminalNode RETURN() { return getToken(erableParser.RETURN, 0); }
		public Unary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterUnary_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitUnary_op(this);
		}
	}

	public final Unary_opContext unary_op() throws RecognitionException {
		Unary_opContext _localctx = new Unary_opContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_la = _input.LA(1);
			if ( !(_la==BNOT || _la==RETURN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(192);
			progo();
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
		public Var_kvContext declarations;
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
		enterRule(_localctx, 40, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			((VarContext)_localctx).modifiers = var_ids();
			setState(195);
			((VarContext)_localctx).declarations = var_kv();
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
		enterRule(_localctx, 42, RULE_var_kv);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(197);
					var_pair();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(200); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		enterRule(_localctx, 44, RULE_var_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			((Var_pairContext)_localctx).key = match(NAME);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQU) {
				{
				setState(203);
				match(EQU);
				setState(204);
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
		enterRule(_localctx, 46, RULE_var_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(207);
				match(VAR_ID);
				}
				}
				setState(210); 
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
		public Token funcname;
		public ProgoContext progo;
		public List<ProgoContext> arguments = new ArrayList<ProgoContext>();
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public TerminalNode NAME() { return getToken(erableParser.NAME, 0); }
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
		enterRule(_localctx, 48, RULE_funccall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			((FunccallContext)_localctx).funcname = match(NAME);
			setState(213);
			match(LPA);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(214);
					((FunccallContext)_localctx).progo = progo();
					((FunccallContext)_localctx).arguments.add(((FunccallContext)_localctx).progo);
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(220);
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
		enterRule(_localctx, 50, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(COLON);
			setState(223);
			match(LPA);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(224);
				match(NAME);
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
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
		public ProgContext block;
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
		enterRule(_localctx, 52, RULE_codeblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(LCB);
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(233);
				((CodeblockContext)_localctx).block = prog();
				}
				break;
			}
			setState(236);
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
		public Token funcname;
		public ArgsContext arguments;
		public ProgoContext block;
		public TerminalNode FUNC() { return getToken(erableParser.FUNC, 0); }
		public TerminalNode NAME() { return getToken(erableParser.NAME, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
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
		enterRule(_localctx, 54, RULE_funcdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(FUNC);
			setState(239);
			((FuncdeclContext)_localctx).funcname = match(NAME);
			setState(240);
			((FuncdeclContext)_localctx).arguments = args();
			setState(241);
			((FuncdeclContext)_localctx).block = progo();
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

	public static class IfcondContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(erableParser.IF, 0); }
		public List<TerminalNode> LPA() { return getTokens(erableParser.LPA); }
		public TerminalNode LPA(int i) {
			return getToken(erableParser.LPA, i);
		}
		public List<TerminalNode> RPA() { return getTokens(erableParser.RPA); }
		public TerminalNode RPA(int i) {
			return getToken(erableParser.RPA, i);
		}
		public List<ProgoContext> progo() {
			return getRuleContexts(ProgoContext.class);
		}
		public ProgoContext progo(int i) {
			return getRuleContext(ProgoContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(erableParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(erableParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(erableParser.ELSE, 0); }
		public IfcondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifcond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterIfcond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitIfcond(this);
		}
	}

	public final IfcondContext ifcond() throws RecognitionException {
		IfcondContext _localctx = new IfcondContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ifcond);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(IF);
			setState(244);
			match(LPA);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(245);
				progo();
				}
			}

			setState(248);
			match(RPA);
			setState(249);
			progo();
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(250);
					match(ELIF);
					setState(251);
					match(LPA);
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
						{
						setState(252);
						progo();
						}
					}

					setState(255);
					match(RPA);
					setState(256);
					progo();
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(262);
				match(ELSE);
				setState(263);
				progo();
				}
				break;
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

	public static class WhilecondContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(erableParser.WHILE, 0); }
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public List<ProgoContext> progo() {
			return getRuleContexts(ProgoContext.class);
		}
		public ProgoContext progo(int i) {
			return getRuleContext(ProgoContext.class,i);
		}
		public WhilecondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilecond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterWhilecond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitWhilecond(this);
		}
	}

	public final WhilecondContext whilecond() throws RecognitionException {
		WhilecondContext _localctx = new WhilecondContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_whilecond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(WHILE);
			setState(267);
			match(LPA);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(268);
				progo();
				}
			}

			setState(271);
			match(RPA);
			setState(272);
			progo();
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
		enterRule(_localctx, 60, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u0117\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\7\2D\n\2\f\2\16\2G\13\2\3\3\3\3\3\3\3\3\5\3M\n\3\3\4\3\4\3\5"+
		"\3\5\5\5S\n\5\3\6\3\6\5\6W\n\6\3\7\3\7\5\7[\n\7\3\b\3\b\5\b_\n\b\3\t\3"+
		"\t\5\tc\n\t\3\n\3\n\5\ng\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13|\n\13\3\13"+
		"\7\13\177\n\13\f\13\16\13\u0082\13\13\3\f\3\f\3\f\7\f\u0087\n\f\f\f\16"+
		"\f\u008a\13\f\3\r\3\r\3\r\7\r\u008f\n\r\f\r\16\r\u0092\13\r\3\16\3\16"+
		"\3\16\7\16\u0097\n\16\f\16\16\16\u009a\13\16\3\17\3\17\3\17\7\17\u009f"+
		"\n\17\f\17\16\17\u00a2\13\17\3\20\3\20\5\20\u00a6\n\20\3\20\3\20\5\20"+
		"\u00aa\n\20\3\20\5\20\u00ad\n\20\3\21\3\21\3\22\3\22\5\22\u00b3\n\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00bc\n\23\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\27\6\27\u00c9\n\27\r\27\16\27\u00ca\3"+
		"\30\3\30\3\30\5\30\u00d0\n\30\3\31\6\31\u00d3\n\31\r\31\16\31\u00d4\3"+
		"\32\3\32\3\32\7\32\u00da\n\32\f\32\16\32\u00dd\13\32\3\32\3\32\3\33\3"+
		"\33\3\33\7\33\u00e4\n\33\f\33\16\33\u00e7\13\33\3\33\3\33\3\34\3\34\5"+
		"\34\u00ed\n\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\5\36"+
		"\u00f9\n\36\3\36\3\36\3\36\3\36\3\36\5\36\u0100\n\36\3\36\3\36\7\36\u0104"+
		"\n\36\f\36\16\36\u0107\13\36\3\36\3\36\5\36\u010b\n\36\3\37\3\37\3\37"+
		"\5\37\u0110\n\37\3\37\3\37\3\37\3 \3 \3 \3\u00db\2!\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\5\3\2\6\7\3\2\b\t\4\2"+
		"  ++\2\u0129\2E\3\2\2\2\4L\3\2\2\2\6N\3\2\2\2\bR\3\2\2\2\nV\3\2\2\2\f"+
		"Z\3\2\2\2\16^\3\2\2\2\20b\3\2\2\2\22f\3\2\2\2\24h\3\2\2\2\26\u0083\3\2"+
		"\2\2\30\u008b\3\2\2\2\32\u0093\3\2\2\2\34\u009b\3\2\2\2\36\u00ac\3\2\2"+
		"\2 \u00ae\3\2\2\2\"\u00b2\3\2\2\2$\u00bb\3\2\2\2&\u00bd\3\2\2\2(\u00c1"+
		"\3\2\2\2*\u00c4\3\2\2\2,\u00c8\3\2\2\2.\u00cc\3\2\2\2\60\u00d2\3\2\2\2"+
		"\62\u00d6\3\2\2\2\64\u00e0\3\2\2\2\66\u00ea\3\2\2\28\u00f0\3\2\2\2:\u00f5"+
		"\3\2\2\2<\u010c\3\2\2\2>\u0114\3\2\2\2@A\5\4\3\2AB\7\32\2\2BD\3\2\2\2"+
		"C@\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\3\3\2\2\2GE\3\2\2\2HM\5\b\5"+
		"\2IM\5\n\6\2JM\5\22\n\2KM\5\66\34\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3"+
		"\2\2\2M\5\3\2\2\2NO\5\f\7\2O\7\3\2\2\2PS\58\35\2QS\5*\26\2RP\3\2\2\2R"+
		"Q\3\2\2\2S\t\3\2\2\2TW\5:\36\2UW\5<\37\2VT\3\2\2\2VU\3\2\2\2W\13\3\2\2"+
		"\2X[\5\20\t\2Y[\5\16\b\2ZX\3\2\2\2ZY\3\2\2\2[\r\3\2\2\2\\_\5 \21\2]_\5"+
		"\36\20\2^\\\3\2\2\2^]\3\2\2\2_\17\3\2\2\2`c\5\62\32\2ac\5> \2b`\3\2\2"+
		"\2ba\3\2\2\2c\21\3\2\2\2dg\5\24\13\2eg\5(\25\2fd\3\2\2\2fe\3\2\2\2g\23"+
		"\3\2\2\2h\u0080\5\26\f\2i|\7\24\2\2j|\7\25\2\2k|\7\26\2\2l|\7\35\2\2m"+
		"|\7\36\2\2n|\7\37\2\2o|\3\2\2\2p|\7\f\2\2q|\7\13\2\2r|\7\20\2\2s|\7\65"+
		"\2\2t|\3\2\2\2u|\7\16\2\2v|\7\17\2\2w|\7\22\2\2x|\7\23\2\2y|\7\27\2\2"+
		"z|\7\30\2\2{i\3\2\2\2{j\3\2\2\2{k\3\2\2\2{l\3\2\2\2{m\3\2\2\2{n\3\2\2"+
		"\2{o\3\2\2\2{p\3\2\2\2{q\3\2\2\2{r\3\2\2\2{s\3\2\2\2{t\3\2\2\2{u\3\2\2"+
		"\2{v\3\2\2\2{w\3\2\2\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2\2|}\3\2\2\2}\177\5"+
		"\26\f\2~{\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\25\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0088\5\30\r\2\u0084\u0085"+
		"\t\2\2\2\u0085\u0087\5\30\r\2\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2"+
		"\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\27\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008b\u0090\5\32\16\2\u008c\u008d\t\3\2\2\u008d\u008f\5\32\16"+
		"\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\31\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0098\5\34\17\2\u0094"+
		"\u0095\7\r\2\2\u0095\u0097\5\34\17\2\u0096\u0094\3\2\2\2\u0097\u009a\3"+
		"\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\33\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u00a0\5\f\7\2\u009c\u009d\7\33\2\2\u009d\u009f\5"+
		"\20\t\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\35\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\7!\2\2"+
		"\u00a4\u00a6\5\4\3\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00ad\7\"\2\2\u00a8\u00aa\t\2\2\2\u00a9\u00a8\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\5\"\22\2\u00ac\u00a3\3"+
		"\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\37\3\2\2\2\u00ae\u00af\7.\2\2\u00af!"+
		"\3\2\2\2\u00b0\u00b3\5$\23\2\u00b1\u00b3\5&\24\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3#\3\2\2\2\u00b4\u00b5\7\3\2\2\u00b5\u00bc\7\62\2\2"+
		"\u00b6\u00b7\7\4\2\2\u00b7\u00bc\7\60\2\2\u00b8\u00b9\7\5\2\2\u00b9\u00bc"+
		"\7\61\2\2\u00ba\u00bc\7/\2\2\u00bb\u00b4\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bb"+
		"\u00b8\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc%\3\2\2\2\u00bd\u00be\7/\2\2\u00be"+
		"\u00bf\7\33\2\2\u00bf\u00c0\7/\2\2\u00c0\'\3\2\2\2\u00c1\u00c2\t\4\2\2"+
		"\u00c2\u00c3\5\4\3\2\u00c3)\3\2\2\2\u00c4\u00c5\5\60\31\2\u00c5\u00c6"+
		"\5,\27\2\u00c6+\3\2\2\2\u00c7\u00c9\5.\30\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb-\3\2\2\2"+
		"\u00cc\u00cf\7-\2\2\u00cd\u00ce\7\r\2\2\u00ce\u00d0\5\4\3\2\u00cf\u00cd"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0/\3\2\2\2\u00d1\u00d3\7%\2\2\u00d2\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\61\3\2\2\2\u00d6\u00d7\7-\2\2\u00d7\u00db\7!\2\2\u00d8\u00da\5\4\3\2"+
		"\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00dc\3\2\2\2\u00db\u00d9"+
		"\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\"\2\2\u00df"+
		"\63\3\2\2\2\u00e0\u00e1\7\31\2\2\u00e1\u00e5\7!\2\2\u00e2\u00e4\7-\2\2"+
		"\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\7\"\2\2\u00e9"+
		"\65\3\2\2\2\u00ea\u00ec\7#\2\2\u00eb\u00ed\5\2\2\2\u00ec\u00eb\3\2\2\2"+
		"\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7$\2\2\u00ef\67\3"+
		"\2\2\2\u00f0\u00f1\7&\2\2\u00f1\u00f2\7-\2\2\u00f2\u00f3\5\64\33\2\u00f3"+
		"\u00f4\5\4\3\2\u00f49\3\2\2\2\u00f5\u00f6\7(\2\2\u00f6\u00f8\7!\2\2\u00f7"+
		"\u00f9\5\4\3\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fb\7\"\2\2\u00fb\u0105\5\4\3\2\u00fc\u00fd\7)\2\2\u00fd"+
		"\u00ff\7!\2\2\u00fe\u0100\5\4\3\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u0102\7\"\2\2\u0102\u0104\5\4\3\2\u0103"+
		"\u00fc\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u010a\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7*\2\2\u0109"+
		"\u010b\5\4\3\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b;\3\2\2\2"+
		"\u010c\u010d\7\'\2\2\u010d\u010f\7!\2\2\u010e\u0110\5\4\3\2\u010f\u010e"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\7\"\2\2\u0112"+
		"\u0113\5\4\3\2\u0113=\3\2\2\2\u0114\u0115\7-\2\2\u0115?\3\2\2\2 ELRVZ"+
		"^bf{\u0080\u0088\u0090\u0098\u00a0\u00a5\u00a9\u00ac\u00b2\u00bb\u00ca"+
		"\u00cf\u00d4\u00db\u00e5\u00ec\u00f8\u00ff\u0105\u010a\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}