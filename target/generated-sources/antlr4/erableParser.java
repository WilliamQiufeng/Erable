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
		T__0=1, T__1=2, T__2=3, T__3=4, EQU=5, BINOPS=6, COLON=7, SPLIT=8, COMMA=9, 
		LPA=10, RPA=11, LCB=12, RCB=13, ALPA=14, ARPA=15, VAR_ID=16, FUNC=17, 
		WHILE=18, IF=19, ELIF=20, ELSE=21, RETURN=22, BREAK=23, NAME=24, INT=25, 
		BIN=26, OCT=27, HEX=28, ESC=29, UNICODE=30, WS=31, POW=32, DOT=33, ADD=34, 
		SUB=35, BNOT=36;
	public static final int
		RULE_prog = 0, RULE_progo = 1, RULE_exprs = 2, RULE_decls = 3, RULE_condexprs = 4, 
		RULE_field_and_types = 5, RULE_types = 6, RULE_field = 7, RULE_ops = 8, 
		RULE_var = 9, RULE_var_kv = 10, RULE_var_pair = 11, RULE_binary_op = 12, 
		RULE_atom = 13, RULE_pos_neg_num = 14, RULE_string = 15, RULE_anymatch = 16, 
		RULE_array = 17, RULE_unsigned_num = 18, RULE_unsigned_int = 19, RULE_unsigned_float = 20, 
		RULE_unary_op = 21, RULE_var_ids = 22, RULE_funccall = 23, RULE_args = 24, 
		RULE_codeblock = 25, RULE_funcdecl = 26, RULE_ifcond = 27, RULE_whilecond = 28, 
		RULE_name = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "progo", "exprs", "decls", "condexprs", "field_and_types", "types", 
			"field", "ops", "var", "var_kv", "var_pair", "binary_op", "atom", "pos_neg_num", 
			"string", "anymatch", "array", "unsigned_num", "unsigned_int", "unsigned_float", 
			"unary_op", "var_ids", "funccall", "args", "codeblock", "funcdecl", "ifcond", 
			"whilecond", "name"
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
			"HEX", "ESC", "UNICODE", "WS", "POW", "DOT", "ADD", "SUB", "BNOT"
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
		public int retid;
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << BREAK) | (1L << NAME) | (1L << INT) | (1L << ADD) | (1L << SUB) | (1L << BNOT))) != 0)) {
				{
				{
				setState(60);
				progo();
				setState(61);
				match(SPLIT);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			    root.printTree();
			    ((ProgContext)_localctx).retid = -1;
			  
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
		public int retid;
		public DeclsContext decls;
		public CondexprsContext condexprs;
		public OpsContext ops;
		public CodeblockContext codeblock;
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
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_ID:
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				((ProgoContext)_localctx).decls = decls();

				    ((ProgoContext)_localctx).retid = ((ProgoContext)_localctx).decls.retid;
				  
				}
				break;
			case WHILE:
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				((ProgoContext)_localctx).condexprs = condexprs();

				    ((ProgoContext)_localctx).retid = ((ProgoContext)_localctx).condexprs.retid;
				  
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case LPA:
			case ALPA:
			case RETURN:
			case BREAK:
			case NAME:
			case INT:
			case ADD:
			case SUB:
			case BNOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				((ProgoContext)_localctx).ops = ops();

				    ((ProgoContext)_localctx).retid = ((ProgoContext)_localctx).ops.retid;
				  
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				((ProgoContext)_localctx).codeblock = codeblock();

				    ((ProgoContext)_localctx).retid = ((ProgoContext)_localctx).codeblock.retid;
				  
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
		public int retid;
		public Field_and_typesContext fat;
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
			setState(84);
			((ExprsContext)_localctx).fat = field_and_types();

			      ((ExprsContext)_localctx).retid = ((ExprsContext)_localctx).fat.retid;
			    
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
		public int retid;
		public FuncdeclContext fd;
		public VarContext v;
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
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				((DeclsContext)_localctx).fd = funcdecl();

				      ((DeclsContext)_localctx).retid = ((DeclsContext)_localctx).fd.retid;
				    
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				((DeclsContext)_localctx).v = var();

				      ((DeclsContext)_localctx).retid = ((DeclsContext)_localctx).v.retid;
				    
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
		public int retid;
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
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				ifcond();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
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
		public int retid;
		public FieldContext val;
		public TypesContext tps;
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
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((Field_and_typesContext)_localctx).val = field();

				    ((Field_and_typesContext)_localctx).retid = ((Field_and_typesContext)_localctx).val.retid;
				  
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case LPA:
			case ALPA:
			case INT:
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((Field_and_typesContext)_localctx).tps = types();

				    ((Field_and_typesContext)_localctx).retid = ((Field_and_typesContext)_localctx).tps.retid;
				  
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
		public int retid;
		public ArrayContext arr;
		public StringContext str;
		public AtomContext ato;
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
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				((TypesContext)_localctx).arr = array();

				    ((TypesContext)_localctx).retid = ((TypesContext)_localctx).arr.retid;
				  
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				((TypesContext)_localctx).str = string();

				    ((TypesContext)_localctx).retid = ((TypesContext)_localctx).str.retid;
				  
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case LPA:
			case INT:
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				((TypesContext)_localctx).ato = atom();

				    ((TypesContext)_localctx).retid = ((TypesContext)_localctx).ato.retid;
				  
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
		public int retid;
		public FunccallContext fc;
		public NameContext val;
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
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				((FieldContext)_localctx).fc = funccall();

				    ((FieldContext)_localctx).retid = ((FieldContext)_localctx).fc.retid;
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((FieldContext)_localctx).val = name();

				    ((FieldContext)_localctx).retid = ((FieldContext)_localctx).val.retid;
				  
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
		public int retid;
		public Binary_opContext bo;
		public Unary_opContext uo;
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
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case LPA:
			case ALPA:
			case NAME:
			case INT:
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				((OpsContext)_localctx).bo = binary_op(0);

				      ((OpsContext)_localctx).retid = ((OpsContext)_localctx).bo.retid;
				    
				}
				break;
			case RETURN:
			case BREAK:
			case BNOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				((OpsContext)_localctx).uo = unary_op();

				      ((OpsContext)_localctx).retid = ((OpsContext)_localctx).uo.retid;
				    
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

	public static class VarContext extends ParserRuleContext {
		public int retid;
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
		enterRule(_localctx, 18, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			((VarContext)_localctx).modifiers = var_ids();
			setState(135);
			((VarContext)_localctx).declarations = var_kv();

			      ((VarContext)_localctx).retid = -1;
			    
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
		enterRule(_localctx, 20, RULE_var_kv);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(138);
					var_pair();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(141); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 22, RULE_var_pair);
		boolean hasVal=true;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((Var_pairContext)_localctx).key = name();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQU) {
				{
				setState(144);
				match(EQU);
				setState(145);
				((Var_pairContext)_localctx).val = progo();
				hasVal=true;
				}
			}

			if(!hasVal)((Var_pairContext)_localctx).val.retid=-1;

			    current.declareVariable(((Var_pairContext)_localctx).key.retid,((Var_pairContext)_localctx).val.retid);
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

	public static class Binary_opContext extends ParserRuleContext {
		public int retid;
		public Binary_opContext l;
		public Field_and_typesContext value;
		public Binary_opContext r;
		public Token operation;
		public FieldContext f;
		public ProgoContext pdo;
		public Field_and_typesContext field_and_types() {
			return getRuleContext(Field_and_typesContext.class,0);
		}
		public TerminalNode POW() { return getToken(erableParser.POW, 0); }
		public List<Binary_opContext> binary_op() {
			return getRuleContexts(Binary_opContext.class);
		}
		public Binary_opContext binary_op(int i) {
			return getRuleContext(Binary_opContext.class,i);
		}
		public TerminalNode BINOPS() { return getToken(erableParser.BINOPS, 0); }
		public TerminalNode EQU() { return getToken(erableParser.EQU, 0); }
		public TerminalNode DOT() { return getToken(erableParser.DOT, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode ALPA() { return getToken(erableParser.ALPA, 0); }
		public TerminalNode ARPA() { return getToken(erableParser.ARPA, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
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
		return binary_op(0);
	}

	private Binary_opContext binary_op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Binary_opContext _localctx = new Binary_opContext(_ctx, _parentState);
		Binary_opContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_binary_op, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(154);
			((Binary_opContext)_localctx).value = field_and_types();

			      ((Binary_opContext)_localctx).retid = ((Binary_opContext)_localctx).value.retid;
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(157);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(158);
						match(POW);
						setState(159);
						((Binary_opContext)_localctx).r = binary_op(3);

						                BinaryOpCode boc=new BinaryOpCode((((Binary_opContext)_localctx).operation!=null?((Binary_opContext)_localctx).operation.getText():null),((Binary_opContext)_localctx).l.retid,((Binary_opContext)_localctx).r.retid);
						                current.addCode(boc);
						                ((Binary_opContext)_localctx).retid = boc.id;
						              
						}
						break;
					case 2:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(162);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(163);
						((Binary_opContext)_localctx).operation = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQU || _la==BINOPS) ) {
							((Binary_opContext)_localctx).operation = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						((Binary_opContext)_localctx).r = binary_op(3);

						                BinaryOpCode boc=new BinaryOpCode((((Binary_opContext)_localctx).operation!=null?((Binary_opContext)_localctx).operation.getText():null),((Binary_opContext)_localctx).l.retid,((Binary_opContext)_localctx).r.retid);
						                current.addCode(boc);
						                ((Binary_opContext)_localctx).retid = boc.id;
						              
						}
						break;
					case 3:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(167);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(168);
						match(DOT);
						setState(169);
						((Binary_opContext)_localctx).f = field();

						                DotCode dc=new DotCode(((Binary_opContext)_localctx).l.retid,((Binary_opContext)_localctx).f.retid);
						                ((Binary_opContext)_localctx).retid = dc.id;
						                current.addCode(dc);
						              
						}
						break;
					case 4:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(172);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(173);
						match(ALPA);
						setState(174);
						((Binary_opContext)_localctx).pdo = progo();
						setState(175);
						match(ARPA);

						                ArrayElementCode aec=new ArrayElementCode(((Binary_opContext)_localctx).l.retid,((Binary_opContext)_localctx).pdo.retid);
						                ((Binary_opContext)_localctx).retid = aec.id;
						                current.addCode(aec);
						              
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 26, RULE_atom);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(LPA);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << BREAK) | (1L << NAME) | (1L << INT) | (1L << ADD) | (1L << SUB) | (1L << BNOT))) != 0)) {
					{
					setState(184);
					progo();
					}
				}

				setState(187);
				match(RPA);
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case INT:
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
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
		enterRule(_localctx, 28, RULE_pos_neg_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(193);
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

			setState(196);
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
		public int retid;
		public AnymatchContext str;
		public AnymatchContext anymatch() {
			return getRuleContext(AnymatchContext.class,0);
		}
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
			setState(198);
			match(T__0);
			setState(199);
			((StringContext)_localctx).str = anymatch();
			setState(200);
			match(T__0);

			      int idr=-1;
			      idr=current.addObject((((StringContext)_localctx).str!=null?_input.getText(((StringContext)_localctx).str.start,((StringContext)_localctx).str.stop):null));
			      ((StringContext)_localctx).retid = current.temp(idr);
			      System.out.println("------ID for name'"+(((StringContext)_localctx).str!=null?_input.getText(((StringContext)_localctx).str.start,((StringContext)_localctx).str.stop):null)+"' is:"+idr+"------");
			    
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

	public static class AnymatchContext extends ParserRuleContext {
		public List<TerminalNode> ESC() { return getTokens(erableParser.ESC); }
		public TerminalNode ESC(int i) {
			return getToken(erableParser.ESC, i);
		}
		public AnymatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anymatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).enterAnymatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof erableListener ) ((erableListener)listener).exitAnymatch(this);
		}
	}

	public final AnymatchContext anymatch() throws RecognitionException {
		AnymatchContext _localctx = new AnymatchContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_anymatch);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(205);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						setState(203);
						match(ESC);
						}
						break;
					case 2:
						{
						setState(204);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class ArrayContext extends ParserRuleContext {
		public int retid;
		public ProgoContext progo;
		public List<ProgoContext> elements = new ArrayList<ProgoContext>();
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
		enterRule(_localctx, 34, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(ALPA);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << BREAK) | (1L << NAME) | (1L << INT) | (1L << ADD) | (1L << SUB) | (1L << BNOT))) != 0)) {
				{
				{
				setState(211);
				((ArrayContext)_localctx).progo = progo();
				((ArrayContext)_localctx).elements.add(((ArrayContext)_localctx).progo);
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
			match(ARPA);

			      int[] retids={};
			      for(ProgoContext tk : ((ArrayContext)_localctx).elements){
			        retids=ArrayUtils.push(retids,tk.retid);
			      }
			      ArrayCode ac=new ArrayCode(retids);
			      current.addCode(ac);
			      ((ArrayContext)_localctx).retid = ac.id;
			    
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
		enterRule(_localctx, 36, RULE_unsigned_num);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				unsigned_int();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
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
		enterRule(_localctx, 38, RULE_unsigned_int);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(T__1);
				setState(225);
				match(HEX);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(T__2);
				setState(227);
				match(BIN);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				match(T__3);
				setState(229);
				match(OCT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
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
		enterRule(_localctx, 40, RULE_unsigned_float);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(INT);
			setState(234);
			match(DOT);
			setState(235);
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
		public int retid;
		public Token operation;
		public ProgoContext pdo;
		public TerminalNode BNOT() { return getToken(erableParser.BNOT, 0); }
		public TerminalNode RETURN() { return getToken(erableParser.RETURN, 0); }
		public TerminalNode BREAK() { return getToken(erableParser.BREAK, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
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
		enterRule(_localctx, 42, RULE_unary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			((Unary_opContext)_localctx).operation = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << BREAK) | (1L << BNOT))) != 0)) ) {
				((Unary_opContext)_localctx).operation = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(238);
				((Unary_opContext)_localctx).pdo = progo();
				}
				break;
			}

			      UnaryOpCode uoc=new UnaryOpCode((((Unary_opContext)_localctx).operation!=null?((Unary_opContext)_localctx).operation.getText():null),((Unary_opContext)_localctx).pdo.retid);
			      current.addCode(uoc);
			      ((Unary_opContext)_localctx).retid = uoc.id;
			    
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
		enterRule(_localctx, 44, RULE_var_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(243);
				match(VAR_ID);
				}
				}
				setState(246); 
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
		public int retid;
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
		enterRule(_localctx, 46, RULE_funccall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			((FunccallContext)_localctx).funcname = name();
			setState(249);
			match(LPA);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(250);
					((FunccallContext)_localctx).progo = progo();
					((FunccallContext)_localctx).arguments.add(((FunccallContext)_localctx).progo);
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(256);
			match(RPA);

			    int[] retids={};
			    for(ProgoContext tk : ((FunccallContext)_localctx).arguments){
			      retids=ArrayUtils.push(retids,tk.retid);
			    }
			    FuncCallCode fc=new FuncCallCode(((FunccallContext)_localctx).funcname.retid,retids);
			    current.addCode(fc);
			    ((FunccallContext)_localctx).retid = fc.id;
			  
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
		public int[] argids;
		public NameContext name;
		public List<NameContext> argss = new ArrayList<NameContext>();
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
		enterRule(_localctx, 48, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(COLON);
			setState(260);
			match(LPA);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(261);
				((ArgsContext)_localctx).name = name();
				((ArgsContext)_localctx).argss.add(((ArgsContext)_localctx).name);
				}
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(267);
			match(RPA);

			      int[] retids={};
			      for(NameContext tk : ((ArgsContext)_localctx).argss){
			        retids=ArrayUtils.push(retids,tk.retid);
			      }
			      ((ArgsContext)_localctx).argids = retids;
			    
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
		public int retid;
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
		enterRule(_localctx, 50, RULE_codeblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(LCB);
			current=current.createChild(Scope.Type.CODEBLOCK);
			setState(272);
			((CodeblockContext)_localctx).block = prog();
			setState(273);
			match(RCB);

			    BlockCode bc=new BlockCode(current);
			    ((CodeblockContext)_localctx).retid = bc.id;
			    current.getParent().addCode(bc);
			    current=current.getParent();
			  
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
		public int retid;
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
		enterRule(_localctx, 52, RULE_funcdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(FUNC);
			setState(277);
			((FuncdeclContext)_localctx).funcname = name();
			setState(278);
			((FuncdeclContext)_localctx).arguments = args();
			current=current.createChild(Scope.Type.FUNCTION);
			setState(280);
			((FuncdeclContext)_localctx).block = progo();

			    ((FuncdeclContext)_localctx).retid = current.getParent().declareFunction(
			      ((FuncdeclContext)_localctx).funcname.retid,
			      ((FuncdeclContext)_localctx).arguments.argids,
			      current);
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
		enterRule(_localctx, 54, RULE_ifcond);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(IF);
			setState(284);
			match(LPA);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << BREAK) | (1L << NAME) | (1L << INT) | (1L << ADD) | (1L << SUB) | (1L << BNOT))) != 0)) {
				{
				setState(285);
				progo();
				}
			}

			setState(288);
			match(RPA);
			setState(289);
			progo();
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(290);
					match(ELIF);
					setState(291);
					match(LPA);
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << BREAK) | (1L << NAME) | (1L << INT) | (1L << ADD) | (1L << SUB) | (1L << BNOT))) != 0)) {
						{
						setState(292);
						progo();
						}
					}

					setState(295);
					match(RPA);
					setState(296);
					progo();
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(302);
				match(ELSE);
				setState(303);
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
		enterRule(_localctx, 56, RULE_whilecond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(WHILE);
			setState(307);
			match(LPA);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << BREAK) | (1L << NAME) | (1L << INT) | (1L << ADD) | (1L << SUB) | (1L << BNOT))) != 0)) {
				{
				setState(308);
				progo();
				}
			}

			setState(311);
			match(RPA);
			setState(312);
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
		enterRule(_localctx, 58, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			((NameContext)_localctx).NAME = match(NAME);

			     int idr=-1;
			     idr=current.addObject((((NameContext)_localctx).NAME!=null?((NameContext)_localctx).NAME.getText():null));
			     ((NameContext)_localctx).retid = current.temp(idr);
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
		case 12:
			return binary_op_sempred((Binary_opContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean binary_op_sempred(Binary_opContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u0140\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\7\2B\n\2\f\2\16\2E\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3U\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5`\n\5\3\6"+
		"\3\6\5\6d\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7l\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\bw\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\177\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0087\n\n\3\13\3\13\3\13\3\13\3\f\6\f\u008e\n\f\r\f\16"+
		"\f\u008f\3\r\3\r\3\r\3\r\3\r\5\r\u0097\n\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00b5\n\16\f\16\16\16\u00b8"+
		"\13\16\3\17\3\17\5\17\u00bc\n\17\3\17\3\17\3\17\3\17\5\17\u00c2\n\17\3"+
		"\20\5\20\u00c5\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\7\22"+
		"\u00d0\n\22\f\22\16\22\u00d3\13\22\3\23\3\23\7\23\u00d7\n\23\f\23\16\23"+
		"\u00da\13\23\3\23\3\23\3\23\3\24\3\24\5\24\u00e1\n\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u00ea\n\25\3\26\3\26\3\26\3\26\3\27\3\27\5\27"+
		"\u00f2\n\27\3\27\3\27\3\30\6\30\u00f7\n\30\r\30\16\30\u00f8\3\31\3\31"+
		"\3\31\7\31\u00fe\n\31\f\31\16\31\u0101\13\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\7\32\u0109\n\32\f\32\16\32\u010c\13\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\5\35\u0121\n\35\3\35\3\35\3\35\3\35\3\35\5\35\u0128\n\35\3\35\3\35\7"+
		"\35\u012c\n\35\f\35\16\35\u012f\13\35\3\35\3\35\5\35\u0133\n\35\3\36\3"+
		"\36\3\36\5\36\u0138\n\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\4\u00d1\u00ff"+
		"\3\32 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		"\2\5\3\2\7\b\3\2$%\4\2\30\31&&\2\u0145\2C\3\2\2\2\4T\3\2\2\2\6V\3\2\2"+
		"\2\b_\3\2\2\2\nc\3\2\2\2\fk\3\2\2\2\16v\3\2\2\2\20~\3\2\2\2\22\u0086\3"+
		"\2\2\2\24\u0088\3\2\2\2\26\u008d\3\2\2\2\30\u0091\3\2\2\2\32\u009b\3\2"+
		"\2\2\34\u00c1\3\2\2\2\36\u00c4\3\2\2\2 \u00c8\3\2\2\2\"\u00d1\3\2\2\2"+
		"$\u00d4\3\2\2\2&\u00e0\3\2\2\2(\u00e9\3\2\2\2*\u00eb\3\2\2\2,\u00ef\3"+
		"\2\2\2.\u00f6\3\2\2\2\60\u00fa\3\2\2\2\62\u0105\3\2\2\2\64\u0110\3\2\2"+
		"\2\66\u0116\3\2\2\28\u011d\3\2\2\2:\u0134\3\2\2\2<\u013c\3\2\2\2>?\5\4"+
		"\3\2?@\7\n\2\2@B\3\2\2\2A>\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2"+
		"\2\2EC\3\2\2\2FG\b\2\1\2G\3\3\2\2\2HI\5\b\5\2IJ\b\3\1\2JU\3\2\2\2KL\5"+
		"\n\6\2LM\b\3\1\2MU\3\2\2\2NO\5\22\n\2OP\b\3\1\2PU\3\2\2\2QR\5\64\33\2"+
		"RS\b\3\1\2SU\3\2\2\2TH\3\2\2\2TK\3\2\2\2TN\3\2\2\2TQ\3\2\2\2U\5\3\2\2"+
		"\2VW\5\f\7\2WX\b\4\1\2X\7\3\2\2\2YZ\5\66\34\2Z[\b\5\1\2[`\3\2\2\2\\]\5"+
		"\24\13\2]^\b\5\1\2^`\3\2\2\2_Y\3\2\2\2_\\\3\2\2\2`\t\3\2\2\2ad\58\35\2"+
		"bd\5:\36\2ca\3\2\2\2cb\3\2\2\2d\13\3\2\2\2ef\5\20\t\2fg\b\7\1\2gl\3\2"+
		"\2\2hi\5\16\b\2ij\b\7\1\2jl\3\2\2\2ke\3\2\2\2kh\3\2\2\2l\r\3\2\2\2mn\5"+
		"$\23\2no\b\b\1\2ow\3\2\2\2pq\5 \21\2qr\b\b\1\2rw\3\2\2\2st\5\34\17\2t"+
		"u\b\b\1\2uw\3\2\2\2vm\3\2\2\2vp\3\2\2\2vs\3\2\2\2w\17\3\2\2\2xy\5\60\31"+
		"\2yz\b\t\1\2z\177\3\2\2\2{|\5<\37\2|}\b\t\1\2}\177\3\2\2\2~x\3\2\2\2~"+
		"{\3\2\2\2\177\21\3\2\2\2\u0080\u0081\5\32\16\2\u0081\u0082\b\n\1\2\u0082"+
		"\u0087\3\2\2\2\u0083\u0084\5,\27\2\u0084\u0085\b\n\1\2\u0085\u0087\3\2"+
		"\2\2\u0086\u0080\3\2\2\2\u0086\u0083\3\2\2\2\u0087\23\3\2\2\2\u0088\u0089"+
		"\5.\30\2\u0089\u008a\5\26\f\2\u008a\u008b\b\13\1\2\u008b\25\3\2\2\2\u008c"+
		"\u008e\5\30\r\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\27\3\2\2\2\u0091\u0096\5<\37\2\u0092"+
		"\u0093\7\7\2\2\u0093\u0094\5\4\3\2\u0094\u0095\b\r\1\2\u0095\u0097\3\2"+
		"\2\2\u0096\u0092\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0099\b\r\1\2\u0099\u009a\b\r\1\2\u009a\31\3\2\2\2\u009b\u009c\b\16\1"+
		"\2\u009c\u009d\5\f\7\2\u009d\u009e\b\16\1\2\u009e\u00b6\3\2\2\2\u009f"+
		"\u00a0\f\5\2\2\u00a0\u00a1\7\"\2\2\u00a1\u00a2\5\32\16\5\u00a2\u00a3\b"+
		"\16\1\2\u00a3\u00b5\3\2\2\2\u00a4\u00a5\f\4\2\2\u00a5\u00a6\t\2\2\2\u00a6"+
		"\u00a7\5\32\16\5\u00a7\u00a8\b\16\1\2\u00a8\u00b5\3\2\2\2\u00a9\u00aa"+
		"\f\7\2\2\u00aa\u00ab\7#\2\2\u00ab\u00ac\5\20\t\2\u00ac\u00ad\b\16\1\2"+
		"\u00ad\u00b5\3\2\2\2\u00ae\u00af\f\6\2\2\u00af\u00b0\7\20\2\2\u00b0\u00b1"+
		"\5\4\3\2\u00b1\u00b2\7\21\2\2\u00b2\u00b3\b\16\1\2\u00b3\u00b5\3\2\2\2"+
		"\u00b4\u009f\3\2\2\2\u00b4\u00a4\3\2\2\2\u00b4\u00a9\3\2\2\2\u00b4\u00ae"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\33\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\7\f\2\2\u00ba\u00bc\5\4\3"+
		"\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c2"+
		"\7\r\2\2\u00be\u00bf\5\36\20\2\u00bf\u00c0\b\17\1\2\u00c0\u00c2\3\2\2"+
		"\2\u00c1\u00b9\3\2\2\2\u00c1\u00be\3\2\2\2\u00c2\35\3\2\2\2\u00c3\u00c5"+
		"\t\3\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c7\5&\24\2\u00c7\37\3\2\2\2\u00c8\u00c9\7\3\2\2\u00c9\u00ca\5\"\22"+
		"\2\u00ca\u00cb\7\3\2\2\u00cb\u00cc\b\21\1\2\u00cc!\3\2\2\2\u00cd\u00d0"+
		"\7\37\2\2\u00ce\u00d0\13\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2"+
		"\u00d0\u00d3\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2#\3"+
		"\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d8\7\20\2\2\u00d5\u00d7\5\4\3\2\u00d6"+
		"\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7\21\2\2\u00dc"+
		"\u00dd\b\23\1\2\u00dd%\3\2\2\2\u00de\u00e1\5(\25\2\u00df\u00e1\5*\26\2"+
		"\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\'\3\2\2\2\u00e2\u00e3\7"+
		"\4\2\2\u00e3\u00ea\7\36\2\2\u00e4\u00e5\7\5\2\2\u00e5\u00ea\7\34\2\2\u00e6"+
		"\u00e7\7\6\2\2\u00e7\u00ea\7\35\2\2\u00e8\u00ea\7\33\2\2\u00e9\u00e2\3"+
		"\2\2\2\u00e9\u00e4\3\2\2\2\u00e9\u00e6\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea"+
		")\3\2\2\2\u00eb\u00ec\7\33\2\2\u00ec\u00ed\7#\2\2\u00ed\u00ee\7\33\2\2"+
		"\u00ee+\3\2\2\2\u00ef\u00f1\t\4\2\2\u00f0\u00f2\5\4\3\2\u00f1\u00f0\3"+
		"\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\b\27\1\2\u00f4"+
		"-\3\2\2\2\u00f5\u00f7\7\22\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2"+
		"\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9/\3\2\2\2\u00fa\u00fb\5"+
		"<\37\2\u00fb\u00ff\7\f\2\2\u00fc\u00fe\5\4\3\2\u00fd\u00fc\3\2\2\2\u00fe"+
		"\u0101\3\2\2\2\u00ff\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0102\3\2"+
		"\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\7\r\2\2\u0103\u0104\b\31\1\2\u0104"+
		"\61\3\2\2\2\u0105\u0106\7\t\2\2\u0106\u010a\7\f\2\2\u0107\u0109\5<\37"+
		"\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b"+
		"\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\7\r\2\2\u010e"+
		"\u010f\b\32\1\2\u010f\63\3\2\2\2\u0110\u0111\7\16\2\2\u0111\u0112\b\33"+
		"\1\2\u0112\u0113\5\2\2\2\u0113\u0114\7\17\2\2\u0114\u0115\b\33\1\2\u0115"+
		"\65\3\2\2\2\u0116\u0117\7\23\2\2\u0117\u0118\5<\37\2\u0118\u0119\5\62"+
		"\32\2\u0119\u011a\b\34\1\2\u011a\u011b\5\4\3\2\u011b\u011c\b\34\1\2\u011c"+
		"\67\3\2\2\2\u011d\u011e\7\25\2\2\u011e\u0120\7\f\2\2\u011f\u0121\5\4\3"+
		"\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123"+
		"\7\r\2\2\u0123\u012d\5\4\3\2\u0124\u0125\7\26\2\2\u0125\u0127\7\f\2\2"+
		"\u0126\u0128\5\4\3\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129\u012a\7\r\2\2\u012a\u012c\5\4\3\2\u012b\u0124\3\2\2\2\u012c"+
		"\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0132\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7\27\2\2\u0131\u0133\5\4\3\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u01339\3\2\2\2\u0134\u0135\7\24\2\2"+
		"\u0135\u0137\7\f\2\2\u0136\u0138\5\4\3\2\u0137\u0136\3\2\2\2\u0137\u0138"+
		"\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\7\r\2\2\u013a\u013b\5\4\3\2\u013b"+
		";\3\2\2\2\u013c\u013d\7\32\2\2\u013d\u013e\b\37\1\2\u013e=\3\2\2\2\37"+
		"CT_ckv~\u0086\u008f\u0096\u00b4\u00b6\u00bb\u00c1\u00c4\u00cf\u00d1\u00d8"+
		"\u00e0\u00e9\u00f1\u00f8\u00ff\u010a\u0120\u0127\u012d\u0132\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}