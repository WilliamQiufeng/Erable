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
		T__0=1, T__1=2, T__2=3, T__3=4, EQU=5, UNARYOPS=6, BINOPS=7, POW=8, COLON=9, 
		SPLIT=10, DOT=11, COMMA=12, ADD=13, SUB=14, BNOT=15, LPA=16, RPA=17, LCB=18, 
		RCB=19, ALPA=20, ARPA=21, VAR_ID=22, FUNC=23, WHILE=24, IF=25, ELIF=26, 
		ELSE=27, RETURN=28, BREAK=29, NAME=30, INT=31, BIN=32, OCT=33, HEX=34, 
		ESC=35, UNICODE=36, WS=37;
	public static final int
		RULE_prog = 0, RULE_progo = 1, RULE_exprs = 2, RULE_decls = 3, RULE_condexprs = 4, 
		RULE_field_and_types = 5, RULE_types = 6, RULE_field = 7, RULE_ops = 8, 
		RULE_var = 9, RULE_var_kv = 10, RULE_var_pair = 11, RULE_unary_op = 12, 
		RULE_binary_op = 13, RULE_atom = 14, RULE_string = 15, RULE_anymatch = 16, 
		RULE_array = 17, RULE_unsigned_num = 18, RULE_unsigned_int = 19, RULE_unsigned_float = 20, 
		RULE_var_ids = 21, RULE_funccall = 22, RULE_args = 23, RULE_codeblock = 24, 
		RULE_funcdecl = 25, RULE_ifcond = 26, RULE_whilecond = 27, RULE_name = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "progo", "exprs", "decls", "condexprs", "field_and_types", "types", 
			"field", "ops", "var", "var_kv", "var_pair", "unary_op", "binary_op", 
			"atom", "string", "anymatch", "array", "unsigned_num", "unsigned_int", 
			"unsigned_float", "var_ids", "funccall", "args", "codeblock", "funcdecl", 
			"ifcond", "whilecond", "name"
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << UNARYOPS) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << NAME) | (1L << INT))) != 0)) {
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

			    if(root==current){
			      root.printTree();
			      ((ProgContext)_localctx).retid = -1;
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
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_ID:
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				((ProgoContext)_localctx).decls = decls();

				    ((ProgoContext)_localctx).retid = ((ProgoContext)_localctx).decls.retid;
				  
				}
				break;
			case WHILE:
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				((ProgoContext)_localctx).condexprs = condexprs();

				    ((ProgoContext)_localctx).retid = ((ProgoContext)_localctx).condexprs.retid;
				  
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case UNARYOPS:
			case LPA:
			case ALPA:
			case NAME:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				((ProgoContext)_localctx).ops = ops();

				    ((ProgoContext)_localctx).retid = ((ProgoContext)_localctx).ops.retid;
				  
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
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
			setState(82);
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
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				((DeclsContext)_localctx).fd = funcdecl();

				      ((DeclsContext)_localctx).retid = ((DeclsContext)_localctx).fd.retid;
				    
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
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
		public IfcondContext ic;
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
				setState(93);
				((CondexprsContext)_localctx).ic = ifcond();

				      ((CondexprsContext)_localctx).retid = ((CondexprsContext)_localctx).ic.retid;
				    
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
		public Unary_opContext uo;
		public Binary_opContext bo;
		public Unary_opContext unary_op() {
			return getRuleContext(Unary_opContext.class,0);
		}
		public Binary_opContext binary_op() {
			return getRuleContext(Binary_opContext.class,0);
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
			case UNARYOPS:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				((OpsContext)_localctx).uo = unary_op();

				      ((OpsContext)_localctx).retid = ((OpsContext)_localctx).uo.retid;
				    
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case LPA:
			case ALPA:
			case NAME:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				((OpsContext)_localctx).bo = binary_op(0);

				      ((OpsContext)_localctx).retid = ((OpsContext)_localctx).bo.retid;
				    
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

	public static class Unary_opContext extends ParserRuleContext {
		public int retid;
		public Token operation;
		public ProgoContext pdo;
		public TerminalNode UNARYOPS() { return getToken(erableParser.UNARYOPS, 0); }
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
		enterRule(_localctx, 24, RULE_unary_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			((Unary_opContext)_localctx).operation = match(UNARYOPS);
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(154);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_binary_op, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(160);
			((Binary_opContext)_localctx).value = field_and_types();

			      ((Binary_opContext)_localctx).retid = ((Binary_opContext)_localctx).value.retid;
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(184);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_opContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_binary_op);
						setState(163);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(164);
						match(POW);
						setState(165);
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
						setState(168);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(169);
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
						setState(170);
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
						setState(173);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(174);
						match(DOT);
						setState(175);
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
						setState(178);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(179);
						match(ALPA);
						setState(180);
						((Binary_opContext)_localctx).pdo = progo();
						setState(181);
						match(ARPA);

						                ArrayElementCode aec=new ArrayElementCode(((Binary_opContext)_localctx).l.retid,((Binary_opContext)_localctx).pdo.retid);
						                ((Binary_opContext)_localctx).retid = aec.id;
						                current.addCode(aec);
						              
						}
						break;
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		public ProgoContext p;
		public Unsigned_numContext num;
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
		public Unsigned_numContext unsigned_num() {
			return getRuleContext(Unsigned_numContext.class,0);
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
		enterRule(_localctx, 28, RULE_atom);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(LPA);
				setState(190);
				((AtomContext)_localctx).p = progo();
				setState(191);
				match(RPA);

				      ((AtomContext)_localctx).retid = ((AtomContext)_localctx).p.retid;
				    
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				((AtomContext)_localctx).num = unsigned_num();

				     int idr=-1;
				     String text=(((AtomContext)_localctx).num!=null?_input.getText(((AtomContext)_localctx).num.start,((AtomContext)_localctx).num.stop):null);
				     double number=Double.parseDouble(text);
				     idr=current.addObject(number);
				     ((AtomContext)_localctx).retid = current.temp(idr);
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
			setState(199);
			match(T__0);
			setState(200);
			((StringContext)_localctx).str = anymatch();
			setState(201);
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
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(206);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(204);
						match(ESC);
						}
						break;
					case 2:
						{
						setState(205);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
			setState(211);
			match(ALPA);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << UNARYOPS) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << NAME) | (1L << INT))) != 0)) {
				{
				{
				setState(212);
				((ArrayContext)_localctx).progo = progo();
				((ArrayContext)_localctx).elements.add(((ArrayContext)_localctx).progo);
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
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
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				unsigned_int();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
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
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(T__1);
				setState(226);
				match(HEX);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(T__2);
				setState(228);
				match(BIN);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				match(T__3);
				setState(230);
				match(OCT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(231);
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
			setState(234);
			match(INT);
			setState(235);
			match(DOT);
			setState(236);
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
			setState(239); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(238);
				match(VAR_ID);
				}
				}
				setState(241); 
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
		enterRule(_localctx, 44, RULE_funccall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			((FunccallContext)_localctx).funcname = name();
			setState(244);
			match(LPA);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(245);
					((FunccallContext)_localctx).progo = progo();
					((FunccallContext)_localctx).arguments.add(((FunccallContext)_localctx).progo);
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(251);
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
		enterRule(_localctx, 46, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(COLON);
			setState(255);
			match(LPA);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(256);
				((ArgsContext)_localctx).name = name();
				((ArgsContext)_localctx).argss.add(((ArgsContext)_localctx).name);
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262);
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
		enterRule(_localctx, 48, RULE_codeblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(LCB);
			current=current.createChild(Scope.Type.CODEBLOCK);
			setState(267);
			((CodeblockContext)_localctx).block = prog();
			setState(268);
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
		enterRule(_localctx, 50, RULE_funcdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(FUNC);
			setState(272);
			((FuncdeclContext)_localctx).funcname = name();
			setState(273);
			((FuncdeclContext)_localctx).arguments = args();

			      current=current.createChild(Scope.Type.FUNCTION);
			      int nul=current.temp(current.findId("null"));
			      for(int ids : ((FuncdeclContext)_localctx).arguments.argids){
				current.declareVariable(ids,nul,true);
			      }
			    
			setState(275);
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
		public int retid;
		public ProgoContext cond;
		public ProgoContext ido;
		public ProgoContext edo;
		public TerminalNode IF() { return getToken(erableParser.IF, 0); }
		public TerminalNode LPA() { return getToken(erableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(erableParser.RPA, 0); }
		public List<ProgoContext> progo() {
			return getRuleContexts(ProgoContext.class);
		}
		public ProgoContext progo(int i) {
			return getRuleContext(ProgoContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(erableParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(erableParser.ELSE, i);
		}
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

		    Scope sif;
		    Scope[] elses={};
		  
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(IF);
			setState(279);
			match(LPA);
			setState(280);
			((IfcondContext)_localctx).cond = progo();
			setState(281);
			match(RPA);
			current=current.createChild(Scope.Type.IF);
			setState(283);
			((IfcondContext)_localctx).ido = progo();

			      sif=current;current=current.getParent();
			    
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(285);
					match(ELSE);
					current=current.createChild(Scope.Type.IF);
					setState(287);
					((IfcondContext)_localctx).edo = progo();

					      elses=ArrayUtils.push(elses,current);
					      current=current.getParent();
					    
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}

			      IfCode ic=new IfCode(((IfcondContext)_localctx).cond.retid,sif,elses);
			      current.addCode(ic);
			      ((IfcondContext)_localctx).retid = ic.id;
			    
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
			setState(297);
			match(WHILE);
			setState(298);
			match(LPA);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << UNARYOPS) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << NAME) | (1L << INT))) != 0)) {
				{
				setState(299);
				progo();
				}
			}

			setState(302);
			match(RPA);
			setState(303);
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
			setState(305);
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
		case 13:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0137\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\7\2@\n"+
		"\2\f\2\16\2C\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3S\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5^\n\5\3\6\3\6\3\6"+
		"\3\6\5\6d\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7l\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\bw\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\177\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0087\n\n\3\13\3\13\3\13\3\13\3\f\6\f\u008e\n\f\r\f\16"+
		"\f\u008f\3\r\3\r\3\r\3\r\3\r\5\r\u0097\n\r\3\r\3\r\3\r\3\16\3\16\5\16"+
		"\u009e\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u00bb\n\17\f\17\16\17\u00be\13\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00c8\n\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\7\22"+
		"\u00d1\n\22\f\22\16\22\u00d4\13\22\3\23\3\23\7\23\u00d8\n\23\f\23\16\23"+
		"\u00db\13\23\3\23\3\23\3\23\3\24\3\24\5\24\u00e2\n\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u00eb\n\25\3\26\3\26\3\26\3\26\3\27\6\27\u00f2"+
		"\n\27\r\27\16\27\u00f3\3\30\3\30\3\30\7\30\u00f9\n\30\f\30\16\30\u00fc"+
		"\13\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u0104\n\31\f\31\16\31\u0107"+
		"\13\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\7\34\u0125\n\34\f\34\16\34\u0128\13\34\3\34\3\34\3\35\3\35\3\35"+
		"\5\35\u012f\n\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\4\u00d2\u00fa\3\34"+
		"\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\3"+
		"\4\2\7\7\t\t\2\u0138\2A\3\2\2\2\4R\3\2\2\2\6T\3\2\2\2\b]\3\2\2\2\nc\3"+
		"\2\2\2\fk\3\2\2\2\16v\3\2\2\2\20~\3\2\2\2\22\u0086\3\2\2\2\24\u0088\3"+
		"\2\2\2\26\u008d\3\2\2\2\30\u0091\3\2\2\2\32\u009b\3\2\2\2\34\u00a1\3\2"+
		"\2\2\36\u00c7\3\2\2\2 \u00c9\3\2\2\2\"\u00d2\3\2\2\2$\u00d5\3\2\2\2&\u00e1"+
		"\3\2\2\2(\u00ea\3\2\2\2*\u00ec\3\2\2\2,\u00f1\3\2\2\2.\u00f5\3\2\2\2\60"+
		"\u0100\3\2\2\2\62\u010b\3\2\2\2\64\u0111\3\2\2\2\66\u0118\3\2\2\28\u012b"+
		"\3\2\2\2:\u0133\3\2\2\2<=\5\4\3\2=>\7\f\2\2>@\3\2\2\2?<\3\2\2\2@C\3\2"+
		"\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\b\2\1\2E\3\3\2\2\2FG\5"+
		"\b\5\2GH\b\3\1\2HS\3\2\2\2IJ\5\n\6\2JK\b\3\1\2KS\3\2\2\2LM\5\22\n\2MN"+
		"\b\3\1\2NS\3\2\2\2OP\5\62\32\2PQ\b\3\1\2QS\3\2\2\2RF\3\2\2\2RI\3\2\2\2"+
		"RL\3\2\2\2RO\3\2\2\2S\5\3\2\2\2TU\5\f\7\2UV\b\4\1\2V\7\3\2\2\2WX\5\64"+
		"\33\2XY\b\5\1\2Y^\3\2\2\2Z[\5\24\13\2[\\\b\5\1\2\\^\3\2\2\2]W\3\2\2\2"+
		"]Z\3\2\2\2^\t\3\2\2\2_`\5\66\34\2`a\b\6\1\2ad\3\2\2\2bd\58\35\2c_\3\2"+
		"\2\2cb\3\2\2\2d\13\3\2\2\2ef\5\20\t\2fg\b\7\1\2gl\3\2\2\2hi\5\16\b\2i"+
		"j\b\7\1\2jl\3\2\2\2ke\3\2\2\2kh\3\2\2\2l\r\3\2\2\2mn\5$\23\2no\b\b\1\2"+
		"ow\3\2\2\2pq\5 \21\2qr\b\b\1\2rw\3\2\2\2st\5\36\20\2tu\b\b\1\2uw\3\2\2"+
		"\2vm\3\2\2\2vp\3\2\2\2vs\3\2\2\2w\17\3\2\2\2xy\5.\30\2yz\b\t\1\2z\177"+
		"\3\2\2\2{|\5:\36\2|}\b\t\1\2}\177\3\2\2\2~x\3\2\2\2~{\3\2\2\2\177\21\3"+
		"\2\2\2\u0080\u0081\5\32\16\2\u0081\u0082\b\n\1\2\u0082\u0087\3\2\2\2\u0083"+
		"\u0084\5\34\17\2\u0084\u0085\b\n\1\2\u0085\u0087\3\2\2\2\u0086\u0080\3"+
		"\2\2\2\u0086\u0083\3\2\2\2\u0087\23\3\2\2\2\u0088\u0089\5,\27\2\u0089"+
		"\u008a\5\26\f\2\u008a\u008b\b\13\1\2\u008b\25\3\2\2\2\u008c\u008e\5\30"+
		"\r\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\27\3\2\2\2\u0091\u0096\5:\36\2\u0092\u0093\7\7\2"+
		"\2\u0093\u0094\5\4\3\2\u0094\u0095\b\r\1\2\u0095\u0097\3\2\2\2\u0096\u0092"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\b\r\1\2\u0099"+
		"\u009a\b\r\1\2\u009a\31\3\2\2\2\u009b\u009d\7\b\2\2\u009c\u009e\5\4\3"+
		"\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0"+
		"\b\16\1\2\u00a0\33\3\2\2\2\u00a1\u00a2\b\17\1\2\u00a2\u00a3\5\f\7\2\u00a3"+
		"\u00a4\b\17\1\2\u00a4\u00bc\3\2\2\2\u00a5\u00a6\f\5\2\2\u00a6\u00a7\7"+
		"\n\2\2\u00a7\u00a8\5\34\17\5\u00a8\u00a9\b\17\1\2\u00a9\u00bb\3\2\2\2"+
		"\u00aa\u00ab\f\4\2\2\u00ab\u00ac\t\2\2\2\u00ac\u00ad\5\34\17\5\u00ad\u00ae"+
		"\b\17\1\2\u00ae\u00bb\3\2\2\2\u00af\u00b0\f\7\2\2\u00b0\u00b1\7\r\2\2"+
		"\u00b1\u00b2\5\20\t\2\u00b2\u00b3\b\17\1\2\u00b3\u00bb\3\2\2\2\u00b4\u00b5"+
		"\f\6\2\2\u00b5\u00b6\7\26\2\2\u00b6\u00b7\5\4\3\2\u00b7\u00b8\7\27\2\2"+
		"\u00b8\u00b9\b\17\1\2\u00b9\u00bb\3\2\2\2\u00ba\u00a5\3\2\2\2\u00ba\u00aa"+
		"\3\2\2\2\u00ba\u00af\3\2\2\2\u00ba\u00b4\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\35\3\2\2\2\u00be\u00bc\3\2\2"+
		"\2\u00bf\u00c0\7\22\2\2\u00c0\u00c1\5\4\3\2\u00c1\u00c2\7\23\2\2\u00c2"+
		"\u00c3\b\20\1\2\u00c3\u00c8\3\2\2\2\u00c4\u00c5\5&\24\2\u00c5\u00c6\b"+
		"\20\1\2\u00c6\u00c8\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c8"+
		"\37\3\2\2\2\u00c9\u00ca\7\3\2\2\u00ca\u00cb\5\"\22\2\u00cb\u00cc\7\3\2"+
		"\2\u00cc\u00cd\b\21\1\2\u00cd!\3\2\2\2\u00ce\u00d1\7%\2\2\u00cf\u00d1"+
		"\13\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2"+
		"\u00d2\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3#\3\2\2\2\u00d4\u00d2\3"+
		"\2\2\2\u00d5\u00d9\7\26\2\2\u00d6\u00d8\5\4\3\2\u00d7\u00d6\3\2\2\2\u00d8"+
		"\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2"+
		"\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\7\27\2\2\u00dd\u00de\b\23\1\2\u00de"+
		"%\3\2\2\2\u00df\u00e2\5(\25\2\u00e0\u00e2\5*\26\2\u00e1\u00df\3\2\2\2"+
		"\u00e1\u00e0\3\2\2\2\u00e2\'\3\2\2\2\u00e3\u00e4\7\4\2\2\u00e4\u00eb\7"+
		"$\2\2\u00e5\u00e6\7\5\2\2\u00e6\u00eb\7\"\2\2\u00e7\u00e8\7\6\2\2\u00e8"+
		"\u00eb\7#\2\2\u00e9\u00eb\7!\2\2\u00ea\u00e3\3\2\2\2\u00ea\u00e5\3\2\2"+
		"\2\u00ea\u00e7\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb)\3\2\2\2\u00ec\u00ed"+
		"\7!\2\2\u00ed\u00ee\7\r\2\2\u00ee\u00ef\7!\2\2\u00ef+\3\2\2\2\u00f0\u00f2"+
		"\7\30\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2"+
		"\u00f3\u00f4\3\2\2\2\u00f4-\3\2\2\2\u00f5\u00f6\5:\36\2\u00f6\u00fa\7"+
		"\22\2\2\u00f7\u00f9\5\4\3\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fd\u00fe\7\23\2\2\u00fe\u00ff\b\30\1\2\u00ff/\3\2\2\2\u0100\u0101"+
		"\7\13\2\2\u0101\u0105\7\22\2\2\u0102\u0104\5:\36\2\u0103\u0102\3\2\2\2"+
		"\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108"+
		"\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7\23\2\2\u0109\u010a\b\31\1\2"+
		"\u010a\61\3\2\2\2\u010b\u010c\7\24\2\2\u010c\u010d\b\32\1\2\u010d\u010e"+
		"\5\2\2\2\u010e\u010f\7\25\2\2\u010f\u0110\b\32\1\2\u0110\63\3\2\2\2\u0111"+
		"\u0112\7\31\2\2\u0112\u0113\5:\36\2\u0113\u0114\5\60\31\2\u0114\u0115"+
		"\b\33\1\2\u0115\u0116\5\4\3\2\u0116\u0117\b\33\1\2\u0117\65\3\2\2\2\u0118"+
		"\u0119\7\33\2\2\u0119\u011a\7\22\2\2\u011a\u011b\5\4\3\2\u011b\u011c\7"+
		"\23\2\2\u011c\u011d\b\34\1\2\u011d\u011e\5\4\3\2\u011e\u0126\b\34\1\2"+
		"\u011f\u0120\7\35\2\2\u0120\u0121\b\34\1\2\u0121\u0122\5\4\3\2\u0122\u0123"+
		"\b\34\1\2\u0123\u0125\3\2\2\2\u0124\u011f\3\2\2\2\u0125\u0128\3\2\2\2"+
		"\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u0126"+
		"\3\2\2\2\u0129\u012a\b\34\1\2\u012a\67\3\2\2\2\u012b\u012c\7\32\2\2\u012c"+
		"\u012e\7\22\2\2\u012d\u012f\5\4\3\2\u012e\u012d\3\2\2\2\u012e\u012f\3"+
		"\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\7\23\2\2\u0131\u0132\5\4\3\2\u0132"+
		"9\3\2\2\2\u0133\u0134\7 \2\2\u0134\u0135\b\36\1\2\u0135;\3\2\2\2\32AR"+
		"]ckv~\u0086\u008f\u0096\u009d\u00ba\u00bc\u00c7\u00d0\u00d2\u00d9\u00e1"+
		"\u00ea\u00f3\u00fa\u0105\u0126\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}