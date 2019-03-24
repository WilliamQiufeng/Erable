// Generated from erable.g4 by ANTLR 4.7.2

  import java.util.*;
  import com.qiufeng.erable.*;
  import com.qiufeng.erable.ast.*;

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
		T__0=1, T__1=2, T__2=3, POW=4, ULS=5, URS=6, SWITCH=7, LTE=8, GTE=9, LS=10, 
		RS=11, AND=12, OR=13, XOR=14, ADDEQ=15, SUBEQ=16, MULEQ=17, DIVEQ=18, 
		MODEQ=19, EQ=20, NEQ=21, EQU=22, LT=23, GT=24, COLON=25, SPLIT=26, DOT=27, 
		COMMA=28, ADD=29, SUB=30, MUL=31, DIV=32, MOD=33, BAND=34, BOR=35, BXOR=36, 
		BNOT=37, LPA=38, RPA=39, LCB=40, RCB=41, ALPA=42, ARPA=43, VAR_ID=44, 
		FUNC=45, WHILE=46, IF=47, ELIF=48, ELSE=49, RETURN=50, BREAK=51, NAME=52, 
		STRING=53, INT=54, BIN=55, OCT=56, HEX=57, UNICODE=58, WS=59;
	public static final int
		RULE_prog = 0, RULE_progo = 1, RULE_exprs = 2, RULE_decls = 3, RULE_condexprs = 4, 
		RULE_field_and_types = 5, RULE_types = 6, RULE_field = 7, RULE_ops = 8, 
		RULE_binary_op = 9, RULE_atom = 10, RULE_pos_neg_num = 11, RULE_string = 12, 
		RULE_array = 13, RULE_unsigned_num = 14, RULE_unsigned_int = 15, RULE_unsigned_float = 16, 
		RULE_unary_op = 17, RULE_var = 18, RULE_var_kv = 19, RULE_var_pair = 20, 
		RULE_var_ids = 21, RULE_funccall = 22, RULE_args = 23, RULE_codeblock = 24, 
		RULE_funcdecl = 25, RULE_ifcond = 26, RULE_whilecond = 27, RULE_name = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "progo", "exprs", "decls", "condexprs", "field_and_types", "types", 
			"field", "ops", "binary_op", "atom", "pos_neg_num", "string", "array", 
			"unsigned_num", "unsigned_int", "unsigned_float", "unary_op", "var", 
			"var_kv", "var_pair", "var_ids", "funccall", "args", "codeblock", "funcdecl", 
			"ifcond", "whilecond", "name"
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

	@Override
	public String getGrammarFileName() { return "erable.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  Scope root=new Scope(null,Scope.Type.CODEBLOCK);
	  Scope current=root;

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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				{
				setState(58);
				progo();
				setState(59);
				match(SPLIT);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			    root.printTree();
			  
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
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_ID:
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				decls();
				}
				break;
			case WHILE:
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
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
			case ALPA:
			case RETURN:
			case NAME:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				ops();
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
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
			setState(74);
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
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				funcdecl();
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
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
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				ifcond();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
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
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				field();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case LPA:
			case ALPA:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
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
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
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
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				array();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
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
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
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
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				funccall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
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
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case ADD:
			case SUB:
			case LPA:
			case ALPA:
			case NAME:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				binary_op(0);
				}
				break;
			case BNOT:
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
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
		public Token operation;
		public Field_and_typesContext field_and_types() {
			return getRuleContext(Field_and_typesContext.class,0);
		}
		public List<Binary_opContext> binary_op() {
			return getRuleContexts(Binary_opContext.class);
		}
		public Binary_opContext binary_op(int i) {
			return getRuleContext(Binary_opContext.class,i);
		}
		public TerminalNode EQU() { return getToken(erableParser.EQU, 0); }
		public TerminalNode POW() { return getToken(erableParser.POW, 0); }
		public TerminalNode MOD() { return getToken(erableParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(erableParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(erableParser.MUL, 0); }
		public TerminalNode SUB() { return getToken(erableParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(erableParser.ADD, 0); }
		public TerminalNode AND() { return getToken(erableParser.AND, 0); }
		public TerminalNode OR() { return getToken(erableParser.OR, 0); }
		public TerminalNode XOR() { return getToken(erableParser.XOR, 0); }
		public TerminalNode BAND() { return getToken(erableParser.BAND, 0); }
		public TerminalNode BOR() { return getToken(erableParser.BOR, 0); }
		public TerminalNode BXOR() { return getToken(erableParser.BXOR, 0); }
		public TerminalNode ADDEQ() { return getToken(erableParser.ADDEQ, 0); }
		public TerminalNode SUBEQ() { return getToken(erableParser.SUBEQ, 0); }
		public TerminalNode MULEQ() { return getToken(erableParser.MULEQ, 0); }
		public TerminalNode DIVEQ() { return getToken(erableParser.DIVEQ, 0); }
		public TerminalNode MODEQ() { return getToken(erableParser.MODEQ, 0); }
		public TerminalNode NEQ() { return getToken(erableParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(erableParser.EQ, 0); }
		public TerminalNode SWITCH() { return getToken(erableParser.SWITCH, 0); }
		public TerminalNode ULS() { return getToken(erableParser.ULS, 0); }
		public TerminalNode URS() { return getToken(erableParser.URS, 0); }
		public TerminalNode LTE() { return getToken(erableParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(erableParser.GTE, 0); }
		public TerminalNode LS() { return getToken(erableParser.LS, 0); }
		public TerminalNode RS() { return getToken(erableParser.RS, 0); }
		public TerminalNode LT() { return getToken(erableParser.LT, 0); }
		public TerminalNode GT() { return getToken(erableParser.GT, 0); }
		public TerminalNode DOT() { return getToken(erableParser.DOT, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode ALPA() { return getToken(erableParser.ALPA, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
		public TerminalNode ARPA() { return getToken(erableParser.ARPA, 0); }
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
		return binary_op(0);
	}

	private Binary_opContext binary_op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Binary_opContext _localctx = new Binary_opContext(_ctx, _parentState);
		Binary_opContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_binary_op, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(102);
			field_and_types();
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(136);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(104);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(105);
						match(EQU);
						setState(106);
						binary_op(10);
						}
						break;
					case 2:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(107);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(108);
						match(POW);
						setState(109);
						binary_op(8);
						}
						break;
					case 3:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(110);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(111);
						match(MOD);
						setState(112);
						binary_op(8);
						}
						break;
					case 4:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(113);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(114);
						match(DIV);
						setState(115);
						binary_op(7);
						}
						break;
					case 5:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(116);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(117);
						match(MUL);
						setState(118);
						binary_op(6);
						}
						break;
					case 6:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(119);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(120);
						match(SUB);
						setState(121);
						binary_op(5);
						}
						break;
					case 7:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(122);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(123);
						match(ADD);
						setState(124);
						binary_op(4);
						}
						break;
					case 8:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(125);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(126);
						((Binary_opContext)_localctx).operation = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ULS) | (1L << URS) | (1L << SWITCH) | (1L << LTE) | (1L << GTE) | (1L << LS) | (1L << RS) | (1L << AND) | (1L << OR) | (1L << XOR) | (1L << ADDEQ) | (1L << SUBEQ) | (1L << MULEQ) | (1L << DIVEQ) | (1L << MODEQ) | (1L << EQ) | (1L << NEQ) | (1L << LT) | (1L << GT) | (1L << BAND) | (1L << BOR) | (1L << BXOR))) != 0)) ) {
							((Binary_opContext)_localctx).operation = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(127);
						binary_op(3);
						}
						break;
					case 9:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(128);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(129);
						match(DOT);
						setState(130);
						field();
						}
						break;
					case 10:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(131);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(132);
						match(ALPA);
						setState(133);
						progo();
						setState(134);
						match(ARPA);
						}
						break;
					}
					} 
				}
				setState(140);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public int retid;
		public Pos_neg_numContext num;
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
		public Pos_neg_numContext pos_neg_num() {
			return getRuleContext(Pos_neg_numContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_atom);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(LPA);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
					{
					setState(142);
					progo();
					}
				}

				setState(145);
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
				setState(146);
				((AtomContext)_localctx).num = pos_neg_num();

				     int idr=-1;
				     String text=(((AtomContext)_localctx).num!=null?_input.getText(((AtomContext)_localctx).num.start,((AtomContext)_localctx).num.stop):null);
				     double number=Double.parseDouble(text);
				     idr=current.addObject(number);
				     ((AtomContext)_localctx).retid = idr;
				     System.out.println("------ID for number'"+number+"' is:"+idr+"------");
				  
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

	public static class Pos_neg_numContext extends ParserRuleContext {
		public Unsigned_numContext unsigned_num() {
			return getRuleContext(Unsigned_numContext.class,0);
		}
		public TerminalNode ADD() { return getToken(erableParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(erableParser.SUB, 0); }
		public Pos_neg_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos_neg_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterPos_neg_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitPos_neg_num(this);
		}
	}

	public final Pos_neg_numContext pos_neg_num() throws RecognitionException {
		Pos_neg_numContext _localctx = new Pos_neg_numContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pos_neg_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(151);
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

			setState(154);
			unsigned_num();
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
			setState(156);
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

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode ALPA() { return getToken(erableParser.ALPA, 0); }
		public TerminalNode ARPA() { return getToken(erableParser.ARPA, 0); }
		public List<ProgoContext> progo() {
			return getRuleContexts(ProgoContext.class);
		}
		public ProgoContext progo(int i) {
			return getRuleContext(ProgoContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(ALPA);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				{
				setState(159);
				progo();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			match(ARPA);
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
		enterRule(_localctx, 28, RULE_unsigned_num);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				unsigned_int();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
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
		enterRule(_localctx, 30, RULE_unsigned_int);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(T__0);
				setState(172);
				match(HEX);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(T__1);
				setState(174);
				match(BIN);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(T__2);
				setState(176);
				match(OCT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
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
		enterRule(_localctx, 32, RULE_unsigned_float);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(INT);
			setState(181);
			match(DOT);
			setState(182);
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
		public Token operation;
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
		enterRule(_localctx, 34, RULE_unary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((Unary_opContext)_localctx).operation = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==BNOT || _la==RETURN) ) {
				((Unary_opContext)_localctx).operation = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(185);
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
		enterRule(_localctx, 36, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			((VarContext)_localctx).modifiers = var_ids();
			setState(188);
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
		enterRule(_localctx, 38, RULE_var_kv);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(190);
					var_pair();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(193); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public NameContext key;
		public ProgoContext val;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
		enterRule(_localctx, 40, RULE_var_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			((Var_pairContext)_localctx).key = name();
			current=current.createChild(Scope.Type.VARIABLE);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQU) {
				{
				setState(197);
				match(EQU);
				setState(198);
				((Var_pairContext)_localctx).val = progo();
				}
			}


			    current.getParent().declareVariable(((Var_pairContext)_localctx).key.retid,current);
			    current=current.getParent();
			    System.out.println("------variable declared:"+(((Var_pairContext)_localctx).key!=null?_input.getText(((Var_pairContext)_localctx).key.start,((Var_pairContext)_localctx).key.stop):null));
			  
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
		enterRule(_localctx, 42, RULE_var_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(203);
				match(VAR_ID);
				}
				}
				setState(206); 
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
		public NameContext funcname;
		public ProgoContext progo;
		public List<ProgoContext> arguments = new ArrayList<ProgoContext>();
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
		enterRule(_localctx, 44, RULE_funccall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			((FunccallContext)_localctx).funcname = name();
			setState(209);
			match(LPA);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(210);
					((FunccallContext)_localctx).progo = progo();
					((FunccallContext)_localctx).arguments.add(((FunccallContext)_localctx).progo);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(216);
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
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
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
		enterRule(_localctx, 46, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(COLON);
			setState(219);
			match(LPA);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(220);
				name();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
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
		enterRule(_localctx, 48, RULE_codeblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(LCB);
			setState(229);
			((CodeblockContext)_localctx).block = prog();
			setState(230);
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
		public NameContext funcname;
		public ArgsContext arguments;
		public ProgoContext block;
		public TerminalNode FUNC() { return getToken(erableParser.FUNC, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_funcdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(FUNC);
			setState(233);
			((FuncdeclContext)_localctx).funcname = name();
			setState(234);
			((FuncdeclContext)_localctx).arguments = args();
			current=current.createChild(Scope.Type.FUNCTION);
			setState(236);
			((FuncdeclContext)_localctx).block = progo();

			    current.getParent().declareFunction(((FuncdeclContext)_localctx).funcname.retid,current);
			    current=current.getParent();
			    System.out.println("------function declared:"+(((FuncdeclContext)_localctx).funcname!=null?_input.getText(((FuncdeclContext)_localctx).funcname.start,((FuncdeclContext)_localctx).funcname.stop):null));
			  
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
		enterRule(_localctx, 52, RULE_ifcond);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(IF);
			setState(240);
			match(LPA);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(241);
				progo();
				}
			}

			setState(244);
			match(RPA);
			setState(245);
			progo();
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(246);
					match(ELIF);
					setState(247);
					match(LPA);
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
						{
						setState(248);
						progo();
						}
					}

					setState(251);
					match(RPA);
					setState(252);
					progo();
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(258);
				match(ELSE);
				setState(259);
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
		enterRule(_localctx, 54, RULE_whilecond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(WHILE);
			setState(263);
			match(LPA);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << BNOT) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << NAME) | (1L << STRING) | (1L << INT))) != 0)) {
				{
				setState(264);
				progo();
				}
			}

			setState(267);
			match(RPA);
			setState(268);
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
		public int retid;
		public Token NAME;
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
		enterRule(_localctx, 56, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			((NameContext)_localctx).NAME = match(NAME);

			     int idr=-1;
			     idr=current.addObject((((NameContext)_localctx).NAME!=null?((NameContext)_localctx).NAME.getText():null));
			     ((NameContext)_localctx).retid = idr;
			     System.out.println("------ID for name'"+(((NameContext)_localctx).NAME!=null?((NameContext)_localctx).NAME.getText():null)+"' is:"+idr+"------");
			  
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return binary_op_sempred((Binary_opContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean binary_op_sempred(Binary_opContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 11);
		case 9:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\7\2@\n"+
		"\2\f\2\16\2C\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3K\n\3\3\4\3\4\3\5\3\5\5\5"+
		"Q\n\5\3\6\3\6\5\6U\n\6\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\5\b^\n\b\3\t\3\t\5"+
		"\tb\n\t\3\n\3\n\5\nf\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008b"+
		"\n\13\f\13\16\13\u008e\13\13\3\f\3\f\5\f\u0092\n\f\3\f\3\f\3\f\3\f\5\f"+
		"\u0098\n\f\3\r\5\r\u009b\n\r\3\r\3\r\3\16\3\16\3\17\3\17\7\17\u00a3\n"+
		"\17\f\17\16\17\u00a6\13\17\3\17\3\17\3\20\3\20\5\20\u00ac\n\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b5\n\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\6\25\u00c2\n\25\r\25\16\25\u00c3\3\26\3"+
		"\26\3\26\3\26\5\26\u00ca\n\26\3\26\3\26\3\27\6\27\u00cf\n\27\r\27\16\27"+
		"\u00d0\3\30\3\30\3\30\7\30\u00d6\n\30\f\30\16\30\u00d9\13\30\3\30\3\30"+
		"\3\31\3\31\3\31\7\31\u00e0\n\31\f\31\16\31\u00e3\13\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\5\34"+
		"\u00f5\n\34\3\34\3\34\3\34\3\34\3\34\5\34\u00fc\n\34\3\34\3\34\7\34\u0100"+
		"\n\34\f\34\16\34\u0103\13\34\3\34\3\34\5\34\u0107\n\34\3\35\3\35\3\35"+
		"\5\35\u010c\n\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\u00d7\3\24\37\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\5\5\2\7"+
		"\27\31\32$&\3\2\37 \4\2\'\'\64\64\2\u011d\2A\3\2\2\2\4J\3\2\2\2\6L\3\2"+
		"\2\2\bP\3\2\2\2\nT\3\2\2\2\fX\3\2\2\2\16]\3\2\2\2\20a\3\2\2\2\22e\3\2"+
		"\2\2\24g\3\2\2\2\26\u0097\3\2\2\2\30\u009a\3\2\2\2\32\u009e\3\2\2\2\34"+
		"\u00a0\3\2\2\2\36\u00ab\3\2\2\2 \u00b4\3\2\2\2\"\u00b6\3\2\2\2$\u00ba"+
		"\3\2\2\2&\u00bd\3\2\2\2(\u00c1\3\2\2\2*\u00c5\3\2\2\2,\u00ce\3\2\2\2."+
		"\u00d2\3\2\2\2\60\u00dc\3\2\2\2\62\u00e6\3\2\2\2\64\u00ea\3\2\2\2\66\u00f1"+
		"\3\2\2\28\u0108\3\2\2\2:\u0110\3\2\2\2<=\5\4\3\2=>\7\34\2\2>@\3\2\2\2"+
		"?<\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\b\2\1\2"+
		"E\3\3\2\2\2FK\5\b\5\2GK\5\n\6\2HK\5\22\n\2IK\5\62\32\2JF\3\2\2\2JG\3\2"+
		"\2\2JH\3\2\2\2JI\3\2\2\2K\5\3\2\2\2LM\5\f\7\2M\7\3\2\2\2NQ\5\64\33\2O"+
		"Q\5&\24\2PN\3\2\2\2PO\3\2\2\2Q\t\3\2\2\2RU\5\66\34\2SU\58\35\2TR\3\2\2"+
		"\2TS\3\2\2\2U\13\3\2\2\2VY\5\20\t\2WY\5\16\b\2XV\3\2\2\2XW\3\2\2\2Y\r"+
		"\3\2\2\2Z^\5\34\17\2[^\5\32\16\2\\^\5\26\f\2]Z\3\2\2\2][\3\2\2\2]\\\3"+
		"\2\2\2^\17\3\2\2\2_b\5.\30\2`b\5:\36\2a_\3\2\2\2a`\3\2\2\2b\21\3\2\2\2"+
		"cf\5\24\13\2df\5$\23\2ec\3\2\2\2ed\3\2\2\2f\23\3\2\2\2gh\b\13\1\2hi\5"+
		"\f\7\2i\u008c\3\2\2\2jk\f\13\2\2kl\7\30\2\2l\u008b\5\24\13\fmn\f\n\2\2"+
		"no\7\6\2\2o\u008b\5\24\13\npq\f\t\2\2qr\7#\2\2r\u008b\5\24\13\nst\f\b"+
		"\2\2tu\7\"\2\2u\u008b\5\24\13\tvw\f\7\2\2wx\7!\2\2x\u008b\5\24\13\byz"+
		"\f\6\2\2z{\7 \2\2{\u008b\5\24\13\7|}\f\5\2\2}~\7\37\2\2~\u008b\5\24\13"+
		"\6\177\u0080\f\4\2\2\u0080\u0081\t\2\2\2\u0081\u008b\5\24\13\5\u0082\u0083"+
		"\f\r\2\2\u0083\u0084\7\35\2\2\u0084\u008b\5\20\t\2\u0085\u0086\f\f\2\2"+
		"\u0086\u0087\7,\2\2\u0087\u0088\5\4\3\2\u0088\u0089\7-\2\2\u0089\u008b"+
		"\3\2\2\2\u008aj\3\2\2\2\u008am\3\2\2\2\u008ap\3\2\2\2\u008as\3\2\2\2\u008a"+
		"v\3\2\2\2\u008ay\3\2\2\2\u008a|\3\2\2\2\u008a\177\3\2\2\2\u008a\u0082"+
		"\3\2\2\2\u008a\u0085\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\25\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0091\7(\2\2"+
		"\u0090\u0092\5\4\3\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0098\7)\2\2\u0094\u0095\5\30\r\2\u0095\u0096\b\f\1\2\u0096"+
		"\u0098\3\2\2\2\u0097\u008f\3\2\2\2\u0097\u0094\3\2\2\2\u0098\27\3\2\2"+
		"\2\u0099\u009b\t\3\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009d\5\36\20\2\u009d\31\3\2\2\2\u009e\u009f\7\67\2\2\u009f"+
		"\33\3\2\2\2\u00a0\u00a4\7,\2\2\u00a1\u00a3\5\4\3\2\u00a2\u00a1\3\2\2\2"+
		"\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7-\2\2\u00a8\35\3\2\2\2\u00a9"+
		"\u00ac\5 \21\2\u00aa\u00ac\5\"\22\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3"+
		"\2\2\2\u00ac\37\3\2\2\2\u00ad\u00ae\7\3\2\2\u00ae\u00b5\7;\2\2\u00af\u00b0"+
		"\7\4\2\2\u00b0\u00b5\79\2\2\u00b1\u00b2\7\5\2\2\u00b2\u00b5\7:\2\2\u00b3"+
		"\u00b5\78\2\2\u00b4\u00ad\3\2\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b1\3\2"+
		"\2\2\u00b4\u00b3\3\2\2\2\u00b5!\3\2\2\2\u00b6\u00b7\78\2\2\u00b7\u00b8"+
		"\7\35\2\2\u00b8\u00b9\78\2\2\u00b9#\3\2\2\2\u00ba\u00bb\t\4\2\2\u00bb"+
		"\u00bc\5\4\3\2\u00bc%\3\2\2\2\u00bd\u00be\5,\27\2\u00be\u00bf\5(\25\2"+
		"\u00bf\'\3\2\2\2\u00c0\u00c2\5*\26\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3"+
		"\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4)\3\2\2\2\u00c5\u00c6"+
		"\5:\36\2\u00c6\u00c9\b\26\1\2\u00c7\u00c8\7\30\2\2\u00c8\u00ca\5\4\3\2"+
		"\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc"+
		"\b\26\1\2\u00cc+\3\2\2\2\u00cd\u00cf\7.\2\2\u00ce\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1-\3\2\2\2"+
		"\u00d2\u00d3\5:\36\2\u00d3\u00d7\7(\2\2\u00d4\u00d6\5\4\3\2\u00d5\u00d4"+
		"\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7)\2\2\u00db/\3\2\2\2\u00dc"+
		"\u00dd\7\33\2\2\u00dd\u00e1\7(\2\2\u00de\u00e0\5:\36\2\u00df\u00de\3\2"+
		"\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7)\2\2\u00e5\61\3\2\2\2"+
		"\u00e6\u00e7\7*\2\2\u00e7\u00e8\5\2\2\2\u00e8\u00e9\7+\2\2\u00e9\63\3"+
		"\2\2\2\u00ea\u00eb\7/\2\2\u00eb\u00ec\5:\36\2\u00ec\u00ed\5\60\31\2\u00ed"+
		"\u00ee\b\33\1\2\u00ee\u00ef\5\4\3\2\u00ef\u00f0\b\33\1\2\u00f0\65\3\2"+
		"\2\2\u00f1\u00f2\7\61\2\2\u00f2\u00f4\7(\2\2\u00f3\u00f5\5\4\3\2\u00f4"+
		"\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7)"+
		"\2\2\u00f7\u0101\5\4\3\2\u00f8\u00f9\7\62\2\2\u00f9\u00fb\7(\2\2\u00fa"+
		"\u00fc\5\4\3\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00fe\7)\2\2\u00fe\u0100\5\4\3\2\u00ff\u00f8\3\2\2\2\u0100"+
		"\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0106\3\2"+
		"\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7\63\2\2\u0105\u0107\5\4\3\2\u0106"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\67\3\2\2\2\u0108\u0109\7\60\2"+
		"\2\u0109\u010b\7(\2\2\u010a\u010c\5\4\3\2\u010b\u010a\3\2\2\2\u010b\u010c"+
		"\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7)\2\2\u010e\u010f\5\4\3\2\u010f"+
		"9\3\2\2\2\u0110\u0111\7\66\2\2\u0111\u0112\b\36\1\2\u0112;\3\2\2\2\34"+
		"AJPTX]ae\u008a\u008c\u0091\u0097\u009a\u00a4\u00ab\u00b4\u00c3\u00c9\u00d0"+
		"\u00d7\u00e1\u00f4\u00fb\u0101\u0106\u010b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}