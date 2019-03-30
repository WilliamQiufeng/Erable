// Generated from Erable.g4 by ANTLR 4.7.1

  import java.util.*;
  //import com.qiufeng.erable.*;
  //import com.qiufeng.erable.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ErableParser extends Parser {
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
	public static final int
		RULE_prog = 0, RULE_progo = 1, RULE_exprs = 2, RULE_decls = 3, RULE_condexprs = 4, 
		RULE_field_and_types = 5, RULE_types = 6, RULE_field = 7, RULE_var = 8, 
		RULE_var_kv = 9, RULE_var_pair = 10, RULE_ops = 11, RULE_atom = 12, RULE_string = 13, 
		RULE_anymatch = 14, RULE_array = 15, RULE_unsigned_num = 16, RULE_unsigned_int = 17, 
		RULE_unsigned_float = 18, RULE_var_ids = 19, RULE_funccall = 20, RULE_args = 21, 
		RULE_codeblock = 22, RULE_funcdecl = 23, RULE_ifcond = 24, RULE_whilecond = 25, 
		RULE_name = 26;
	public static final String[] ruleNames = {
		"prog", "progo", "exprs", "decls", "condexprs", "field_and_types", "types", 
		"field", "var", "var_kv", "var_pair", "ops", "atom", "string", "anymatch", 
		"array", "unsigned_num", "unsigned_int", "unsigned_float", "var_ids", 
		"funccall", "args", "codeblock", "funcdecl", "ifcond", "whilecond", "name"
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

	@Override
	public String getGrammarFileName() { return "Erable.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    

	public ErableParser(TokenStream input) {
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
		public List<TerminalNode> SPLIT() { return getTokens(ErableParser.SPLIT); }
		public TerminalNode SPLIT(int i) {
			return getToken(ErableParser.SPLIT, i);
		}
		public TerminalNode EOF() { return getToken(ErableParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << UNARYOPS) | (1L << ADD) | (1L << SUB) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << NAME) | (1L << INT))) != 0)) {
				{
				{
				setState(54);
				progo();
				setState(55);
				match(SPLIT);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOF) {
				{
				setState(62);
				match(EOF);
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterProgo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitProgo(this);
		}
	}

	public final ProgoContext progo() throws RecognitionException {
		ProgoContext _localctx = new ProgoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_progo);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_ID:
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				decls();
				}
				break;
			case WHILE:
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				condexprs();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case UNARYOPS:
			case ADD:
			case SUB:
			case LPA:
			case ALPA:
			case NAME:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				ops(0);
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitExprs(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exprs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((ExprsContext)_localctx).fat = field_and_types();
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitDecls(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decls);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				((DeclsContext)_localctx).fd = funcdecl();
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				((DeclsContext)_localctx).v = var();
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
		public IfcondContext ic;
		public WhilecondContext wc;
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterCondexprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitCondexprs(this);
		}
	}

	public final CondexprsContext condexprs() throws RecognitionException {
		CondexprsContext _localctx = new CondexprsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condexprs);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				((CondexprsContext)_localctx).ic = ifcond();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				((CondexprsContext)_localctx).wc = whilecond();
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterField_and_types(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitField_and_types(this);
		}
	}

	public final Field_and_typesContext field_and_types() throws RecognitionException {
		Field_and_typesContext _localctx = new Field_and_typesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_field_and_types);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((Field_and_typesContext)_localctx).val = field();
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
				setState(82);
				((Field_and_typesContext)_localctx).tps = types();
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitTypes(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_types);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				((TypesContext)_localctx).arr = array();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				((TypesContext)_localctx).str = string();
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case LPA:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				((TypesContext)_localctx).ato = atom();
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field);
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				((FieldContext)_localctx).fc = funccall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				((FieldContext)_localctx).val = name();
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			((VarContext)_localctx).modifiers = var_ids();
			setState(95);
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterVar_kv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitVar_kv(this);
		}
	}

	public final Var_kvContext var_kv() throws RecognitionException {
		Var_kvContext _localctx = new Var_kvContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var_kv);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(97);
					var_pair();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100); 
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
		public TerminalNode EQU() { return getToken(ErableParser.EQU, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
		public Var_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterVar_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitVar_pair(this);
		}
	}

	public final Var_pairContext var_pair() throws RecognitionException {
		Var_pairContext _localctx = new Var_pairContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((Var_pairContext)_localctx).key = name();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQU) {
				{
				setState(103);
				match(EQU);
				setState(104);
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

	public static class OpsContext extends ParserRuleContext {
		public OpsContext l;
		public Token operation;
		public OpsContext r;
		public FieldContext f;
		public ProgoContext pdo;
		public List<OpsContext> ops() {
			return getRuleContexts(OpsContext.class);
		}
		public OpsContext ops(int i) {
			return getRuleContext(OpsContext.class,i);
		}
		public TerminalNode UNARYOPS() { return getToken(ErableParser.UNARYOPS, 0); }
		public TerminalNode ADD() { return getToken(ErableParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ErableParser.SUB, 0); }
		public Field_and_typesContext field_and_types() {
			return getRuleContext(Field_and_typesContext.class,0);
		}
		public TerminalNode POW() { return getToken(ErableParser.POW, 0); }
		public TerminalNode EQU() { return getToken(ErableParser.EQU, 0); }
		public TerminalNode MOD() { return getToken(ErableParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(ErableParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(ErableParser.MUL, 0); }
		public TerminalNode BINOPS() { return getToken(ErableParser.BINOPS, 0); }
		public TerminalNode DOT() { return getToken(ErableParser.DOT, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public TerminalNode ALPA() { return getToken(ErableParser.ALPA, 0); }
		public TerminalNode ARPA() { return getToken(ErableParser.ARPA, 0); }
		public ProgoContext progo() {
			return getRuleContext(ProgoContext.class,0);
		}
		public OpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitOps(this);
		}
	}

	public final OpsContext ops() throws RecognitionException {
		return ops(0);
	}

	private OpsContext ops(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OpsContext _localctx = new OpsContext(_ctx, _parentState);
		OpsContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_ops, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNARYOPS:
			case ADD:
			case SUB:
				{
				setState(108);
				((OpsContext)_localctx).operation = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNARYOPS) | (1L << ADD) | (1L << SUB))) != 0)) ) {
					((OpsContext)_localctx).operation = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(109);
				((OpsContext)_localctx).r = ops(2);
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
				{
				setState(110);
				field_and_types();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(145);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(113);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(114);
						match(POW);
						setState(115);
						((OpsContext)_localctx).r = ops(10);
						}
						break;
					case 2:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(116);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(117);
						match(EQU);
						setState(118);
						((OpsContext)_localctx).r = ops(10);
						}
						break;
					case 3:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(119);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(120);
						match(MOD);
						setState(121);
						((OpsContext)_localctx).r = ops(9);
						}
						break;
					case 4:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(122);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(123);
						match(DIV);
						setState(124);
						((OpsContext)_localctx).r = ops(8);
						}
						break;
					case 5:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(125);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(126);
						match(MUL);
						setState(127);
						((OpsContext)_localctx).r = ops(7);
						}
						break;
					case 6:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(128);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(129);
						match(SUB);
						setState(130);
						((OpsContext)_localctx).r = ops(6);
						}
						break;
					case 7:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(131);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(132);
						match(ADD);
						setState(133);
						((OpsContext)_localctx).r = ops(5);
						}
						break;
					case 8:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(134);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(135);
						((OpsContext)_localctx).operation = match(BINOPS);
						setState(136);
						((OpsContext)_localctx).r = ops(4);
						}
						break;
					case 9:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(137);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(138);
						match(DOT);
						setState(139);
						((OpsContext)_localctx).f = field();
						}
						break;
					case 10:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(140);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(141);
						match(ALPA);
						setState(142);
						((OpsContext)_localctx).pdo = progo();
						setState(143);
						match(ARPA);
						}
						break;
					}
					} 
				}
				setState(149);
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
		public ProgoContext p;
		public Unsigned_numContext num;
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(LPA);
				setState(151);
				((AtomContext)_localctx).p = progo();
				setState(152);
				match(RPA);
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				((AtomContext)_localctx).num = unsigned_num();
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__0);
			setState(158);
			((StringContext)_localctx).str = anymatch();
			setState(159);
			match(T__0);
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
		public List<TerminalNode> ESC() { return getTokens(ErableParser.ESC); }
		public TerminalNode ESC(int i) {
			return getToken(ErableParser.ESC, i);
		}
		public AnymatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anymatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterAnymatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitAnymatch(this);
		}
	}

	public final AnymatchContext anymatch() throws RecognitionException {
		AnymatchContext _localctx = new AnymatchContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_anymatch);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(163);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(161);
						match(ESC);
						}
						break;
					case 2:
						{
						setState(162);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(167);
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
		public ProgoContext progo;
		public List<ProgoContext> elements = new ArrayList<ProgoContext>();
		public TerminalNode ALPA() { return getToken(ErableParser.ALPA, 0); }
		public TerminalNode ARPA() { return getToken(ErableParser.ARPA, 0); }
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(ALPA);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << UNARYOPS) | (1L << ADD) | (1L << SUB) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << NAME) | (1L << INT))) != 0)) {
				{
				{
				setState(169);
				((ArrayContext)_localctx).progo = progo();
				((ArrayContext)_localctx).elements.add(((ArrayContext)_localctx).progo);
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterUnsigned_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitUnsigned_num(this);
		}
	}

	public final Unsigned_numContext unsigned_num() throws RecognitionException {
		Unsigned_numContext _localctx = new Unsigned_numContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unsigned_num);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				unsigned_int();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
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
		public TerminalNode HEX() { return getToken(ErableParser.HEX, 0); }
		public TerminalNode BIN() { return getToken(ErableParser.BIN, 0); }
		public TerminalNode OCT() { return getToken(ErableParser.OCT, 0); }
		public TerminalNode INT() { return getToken(ErableParser.INT, 0); }
		public Unsigned_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterUnsigned_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitUnsigned_int(this);
		}
	}

	public final Unsigned_intContext unsigned_int() throws RecognitionException {
		Unsigned_intContext _localctx = new Unsigned_intContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unsigned_int);
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(T__1);
				setState(182);
				match(HEX);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(T__2);
				setState(184);
				match(BIN);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				match(T__3);
				setState(186);
				match(OCT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
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
		public List<TerminalNode> INT() { return getTokens(ErableParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ErableParser.INT, i);
		}
		public TerminalNode DOT() { return getToken(ErableParser.DOT, 0); }
		public Unsigned_floatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_float; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterUnsigned_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitUnsigned_float(this);
		}
	}

	public final Unsigned_floatContext unsigned_float() throws RecognitionException {
		Unsigned_floatContext _localctx = new Unsigned_floatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unsigned_float);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(INT);
			setState(191);
			match(DOT);
			setState(192);
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
		public List<TerminalNode> VAR_ID() { return getTokens(ErableParser.VAR_ID); }
		public TerminalNode VAR_ID(int i) {
			return getToken(ErableParser.VAR_ID, i);
		}
		public Var_idsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterVar_ids(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitVar_ids(this);
		}
	}

	public final Var_idsContext var_ids() throws RecognitionException {
		Var_idsContext _localctx = new Var_idsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_var_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				match(VAR_ID);
				}
				}
				setState(197); 
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
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitFunccall(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funccall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			((FunccallContext)_localctx).funcname = name();
			setState(200);
			match(LPA);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(201);
					((FunccallContext)_localctx).progo = progo();
					((FunccallContext)_localctx).arguments.add(((FunccallContext)_localctx).progo);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(207);
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
		public NameContext name;
		public List<NameContext> argss = new ArrayList<NameContext>();
		public TerminalNode COLON() { return getToken(ErableParser.COLON, 0); }
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(COLON);
			setState(210);
			match(LPA);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(211);
				((ArgsContext)_localctx).name = name();
				((ArgsContext)_localctx).argss.add(((ArgsContext)_localctx).name);
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
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
		public TerminalNode LCB() { return getToken(ErableParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(ErableParser.RCB, 0); }
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public CodeblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterCodeblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitCodeblock(this);
		}
	}

	public final CodeblockContext codeblock() throws RecognitionException {
		CodeblockContext _localctx = new CodeblockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_codeblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(LCB);
			setState(220);
			((CodeblockContext)_localctx).block = prog();
			setState(221);
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
		public CodeblockContext block;
		public TerminalNode FUNC() { return getToken(ErableParser.FUNC, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterFuncdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitFuncdecl(this);
		}
	}

	public final FuncdeclContext funcdecl() throws RecognitionException {
		FuncdeclContext _localctx = new FuncdeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_funcdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(FUNC);
			setState(224);
			((FuncdeclContext)_localctx).funcname = name();
			setState(225);
			((FuncdeclContext)_localctx).arguments = args();
			setState(226);
			((FuncdeclContext)_localctx).block = codeblock();
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
		public ProgoContext cond;
		public ProgoContext ido;
		public ProgoContext edo;
		public TerminalNode IF() { return getToken(ErableParser.IF, 0); }
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
		public List<ProgoContext> progo() {
			return getRuleContexts(ProgoContext.class);
		}
		public ProgoContext progo(int i) {
			return getRuleContext(ProgoContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(ErableParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(ErableParser.ELSE, i);
		}
		public IfcondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifcond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterIfcond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitIfcond(this);
		}
	}

	public final IfcondContext ifcond() throws RecognitionException {
		IfcondContext _localctx = new IfcondContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ifcond);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(IF);
			setState(229);
			match(LPA);
			setState(230);
			((IfcondContext)_localctx).cond = progo();
			setState(231);
			match(RPA);
			setState(232);
			((IfcondContext)_localctx).ido = progo();
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					match(ELSE);
					setState(234);
					((IfcondContext)_localctx).edo = progo();
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		public ProgoContext cond;
		public ProgoContext pdo;
		public TerminalNode WHILE() { return getToken(ErableParser.WHILE, 0); }
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
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
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterWhilecond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitWhilecond(this);
		}
	}

	public final WhilecondContext whilecond() throws RecognitionException {
		WhilecondContext _localctx = new WhilecondContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_whilecond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(WHILE);
			setState(241);
			match(LPA);
			setState(242);
			((WhilecondContext)_localctx).cond = progo();
			setState(243);
			match(RPA);
			setState(244);
			((WhilecondContext)_localctx).pdo = progo();
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
		public TerminalNode NAME() { return getToken(ErableParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return ops_sempred((OpsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ops_sempred(OpsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00fb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\2"+
		"\5\2B\n\2\3\3\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\3\5\3\5\5\5N\n\5\3\6\3\6\5"+
		"\6R\n\6\3\7\3\7\5\7V\n\7\3\b\3\b\3\b\5\b[\n\b\3\t\3\t\5\t_\n\t\3\n\3\n"+
		"\3\n\3\13\6\13e\n\13\r\13\16\13f\3\f\3\f\3\f\5\fl\n\f\3\r\3\r\3\r\3\r"+
		"\5\rr\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7"+
		"\r\u0094\n\r\f\r\16\r\u0097\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u009e\n"+
		"\16\3\17\3\17\3\17\3\17\3\20\3\20\7\20\u00a6\n\20\f\20\16\20\u00a9\13"+
		"\20\3\21\3\21\7\21\u00ad\n\21\f\21\16\21\u00b0\13\21\3\21\3\21\3\22\3"+
		"\22\5\22\u00b6\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00bf\n\23"+
		"\3\24\3\24\3\24\3\24\3\25\6\25\u00c6\n\25\r\25\16\25\u00c7\3\26\3\26\3"+
		"\26\7\26\u00cd\n\26\f\26\16\26\u00d0\13\26\3\26\3\26\3\27\3\27\3\27\7"+
		"\27\u00d7\n\27\f\27\16\27\u00da\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u00ee"+
		"\n\32\f\32\16\32\u00f1\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\4\u00a7\u00ce\3\30\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\66\2\3\4\2\b\b\17\20\2\u0103\2=\3\2\2\2\4G\3\2\2\2\6I\3"+
		"\2\2\2\bM\3\2\2\2\nQ\3\2\2\2\fU\3\2\2\2\16Z\3\2\2\2\20^\3\2\2\2\22`\3"+
		"\2\2\2\24d\3\2\2\2\26h\3\2\2\2\30q\3\2\2\2\32\u009d\3\2\2\2\34\u009f\3"+
		"\2\2\2\36\u00a7\3\2\2\2 \u00aa\3\2\2\2\"\u00b5\3\2\2\2$\u00be\3\2\2\2"+
		"&\u00c0\3\2\2\2(\u00c5\3\2\2\2*\u00c9\3\2\2\2,\u00d3\3\2\2\2.\u00dd\3"+
		"\2\2\2\60\u00e1\3\2\2\2\62\u00e6\3\2\2\2\64\u00f2\3\2\2\2\66\u00f8\3\2"+
		"\2\289\5\4\3\29:\7\f\2\2:<\3\2\2\2;8\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2"+
		"\2\2>A\3\2\2\2?=\3\2\2\2@B\7\2\2\3A@\3\2\2\2AB\3\2\2\2B\3\3\2\2\2CH\5"+
		"\b\5\2DH\5\n\6\2EH\5\30\r\2FH\5.\30\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF"+
		"\3\2\2\2H\5\3\2\2\2IJ\5\f\7\2J\7\3\2\2\2KN\5\60\31\2LN\5\22\n\2MK\3\2"+
		"\2\2ML\3\2\2\2N\t\3\2\2\2OR\5\62\32\2PR\5\64\33\2QO\3\2\2\2QP\3\2\2\2"+
		"R\13\3\2\2\2SV\5\20\t\2TV\5\16\b\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2W[\5"+
		" \21\2X[\5\34\17\2Y[\5\32\16\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\17\3\2\2"+
		"\2\\_\5*\26\2]_\5\66\34\2^\\\3\2\2\2^]\3\2\2\2_\21\3\2\2\2`a\5(\25\2a"+
		"b\5\24\13\2b\23\3\2\2\2ce\5\26\f\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2"+
		"\2\2g\25\3\2\2\2hk\5\66\34\2ij\7\7\2\2jl\5\4\3\2ki\3\2\2\2kl\3\2\2\2l"+
		"\27\3\2\2\2mn\b\r\1\2no\t\2\2\2or\5\30\r\4pr\5\f\7\2qm\3\2\2\2qp\3\2\2"+
		"\2r\u0095\3\2\2\2st\f\f\2\2tu\7\n\2\2u\u0094\5\30\r\fvw\f\13\2\2wx\7\7"+
		"\2\2x\u0094\5\30\r\fyz\f\n\2\2z{\7\23\2\2{\u0094\5\30\r\13|}\f\t\2\2}"+
		"~\7\22\2\2~\u0094\5\30\r\n\177\u0080\f\b\2\2\u0080\u0081\7\21\2\2\u0081"+
		"\u0094\5\30\r\t\u0082\u0083\f\7\2\2\u0083\u0084\7\20\2\2\u0084\u0094\5"+
		"\30\r\b\u0085\u0086\f\6\2\2\u0086\u0087\7\17\2\2\u0087\u0094\5\30\r\7"+
		"\u0088\u0089\f\5\2\2\u0089\u008a\7\t\2\2\u008a\u0094\5\30\r\6\u008b\u008c"+
		"\f\16\2\2\u008c\u008d\7\r\2\2\u008d\u0094\5\20\t\2\u008e\u008f\f\r\2\2"+
		"\u008f\u0090\7\31\2\2\u0090\u0091\5\4\3\2\u0091\u0092\7\32\2\2\u0092\u0094"+
		"\3\2\2\2\u0093s\3\2\2\2\u0093v\3\2\2\2\u0093y\3\2\2\2\u0093|\3\2\2\2\u0093"+
		"\177\3\2\2\2\u0093\u0082\3\2\2\2\u0093\u0085\3\2\2\2\u0093\u0088\3\2\2"+
		"\2\u0093\u008b\3\2\2\2\u0093\u008e\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\31\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u0099\7\25\2\2\u0099\u009a\5\4\3\2\u009a\u009b\7\26\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009e\5\"\22\2\u009d\u0098\3\2\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\33\3\2\2\2\u009f\u00a0\7\3\2\2\u00a0\u00a1\5\36\20\2\u00a1\u00a2\7\3"+
		"\2\2\u00a2\35\3\2\2\2\u00a3\u00a6\7)\2\2\u00a4\u00a6\13\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\37\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ae\7\31\2"+
		"\2\u00ab\u00ad\5\4\3\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b2\7\32\2\2\u00b2!\3\2\2\2\u00b3\u00b6\5$\23\2\u00b4\u00b6\5&\24\2"+
		"\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6#\3\2\2\2\u00b7\u00b8\7"+
		"\4\2\2\u00b8\u00bf\7\'\2\2\u00b9\u00ba\7\5\2\2\u00ba\u00bf\7%\2\2\u00bb"+
		"\u00bc\7\6\2\2\u00bc\u00bf\7&\2\2\u00bd\u00bf\7$\2\2\u00be\u00b7\3\2\2"+
		"\2\u00be\u00b9\3\2\2\2\u00be\u00bb\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf%"+
		"\3\2\2\2\u00c0\u00c1\7$\2\2\u00c1\u00c2\7\r\2\2\u00c2\u00c3\7$\2\2\u00c3"+
		"\'\3\2\2\2\u00c4\u00c6\7\33\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2"+
		"\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8)\3\2\2\2\u00c9\u00ca"+
		"\5\66\34\2\u00ca\u00ce\7\25\2\2\u00cb\u00cd\5\4\3\2\u00cc\u00cb\3\2\2"+
		"\2\u00cd\u00d0\3\2\2\2\u00ce\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\26\2\2\u00d2+\3\2\2\2\u00d3"+
		"\u00d4\7\13\2\2\u00d4\u00d8\7\25\2\2\u00d5\u00d7\5\66\34\2\u00d6\u00d5"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7\26\2\2\u00dc-\3\2\2\2"+
		"\u00dd\u00de\7\27\2\2\u00de\u00df\5\2\2\2\u00df\u00e0\7\30\2\2\u00e0/"+
		"\3\2\2\2\u00e1\u00e2\7\34\2\2\u00e2\u00e3\5\66\34\2\u00e3\u00e4\5,\27"+
		"\2\u00e4\u00e5\5.\30\2\u00e5\61\3\2\2\2\u00e6\u00e7\7\36\2\2\u00e7\u00e8"+
		"\7\25\2\2\u00e8\u00e9\5\4\3\2\u00e9\u00ea\7\26\2\2\u00ea\u00ef\5\4\3\2"+
		"\u00eb\u00ec\7 \2\2\u00ec\u00ee\5\4\3\2\u00ed\u00eb\3\2\2\2\u00ee\u00f1"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\63\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\7\35\2\2\u00f3\u00f4\7\25\2\2\u00f4\u00f5\5"+
		"\4\3\2\u00f5\u00f6\7\26\2\2\u00f6\u00f7\5\4\3\2\u00f7\65\3\2\2\2\u00f8"+
		"\u00f9\7#\2\2\u00f9\67\3\2\2\2\31=AGMQUZ^fkq\u0093\u0095\u009d\u00a5\u00a7"+
		"\u00ae\u00b5\u00be\u00c7\u00ce\u00d8\u00ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}