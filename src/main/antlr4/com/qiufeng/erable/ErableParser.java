// Generated from Erable.g4 by ANTLR 4.7.1

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
		BIN=35, OCT=36, HEX=37, HEXD=38, ESC=39, UNICODE=40, WS=41, ADDEQ=42, 
		SUBEQ=43, MULEQ=44, DIVEQ=45, MODEQ=46;
	public static final int
		RULE_prog = 0, RULE_exprs = 1, RULE_decls = 2, RULE_condexprs = 3, RULE_field_and_types = 4, 
		RULE_types = 5, RULE_field = 6, RULE_var = 7, RULE_kvs = 8, RULE_ops = 9, 
		RULE_string = 10, RULE_anymatch = 11, RULE_array = 12, RULE_num = 13, 
		RULE_funccall = 14, RULE_args = 15, RULE_codeblock = 16, RULE_funcdecl = 17, 
		RULE_ifcond = 18, RULE_whilecond = 19, RULE_name = 20;
	public static final String[] ruleNames = {
		"prog", "exprs", "decls", "condexprs", "field_and_types", "types", "field", 
		"var", "kvs", "ops", "string", "anymatch", "array", "num", "funccall", 
		"args", "codeblock", "funcdecl", "ifcond", "whilecond", "name"
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
		"HEXD", "ESC", "UNICODE", "WS", "ADDEQ", "SUBEQ", "MULEQ", "DIVEQ", "MODEQ"
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
		public List<OpsContext> ops() {
			return getRuleContexts(OpsContext.class);
		}
		public OpsContext ops(int i) {
			return getRuleContext(OpsContext.class,i);
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << UNARYOPS) | (1L << ADD) | (1L << SUB) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << NAME) | (1L << INT))) != 0)) {
				{
				{
				setState(42);
				ops(0);
				setState(43);
				match(SPLIT);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOF) {
				{
				setState(50);
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

	public static class ExprsContext extends ParserRuleContext {
		public Object obj;
		public int id;
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
		enterRule(_localctx, 2, RULE_exprs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
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
		public Object obj;
		public int id;
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
		enterRule(_localctx, 4, RULE_decls);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				((DeclsContext)_localctx).fd = funcdecl();
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
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
		public Object obj;
		public int id;
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
		enterRule(_localctx, 6, RULE_condexprs);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				((CondexprsContext)_localctx).ic = ifcond();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
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
		public Object obj;
		public int id;
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
		enterRule(_localctx, 8, RULE_field_and_types);
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				((Field_and_typesContext)_localctx).val = field();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case ALPA:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
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
		public Object obj;
		public int id;
		public ArrayContext arr;
		public StringContext str;
		public NumContext ato;
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
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
		enterRule(_localctx, 10, RULE_types);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPA:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				((TypesContext)_localctx).arr = array();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				((TypesContext)_localctx).str = string();
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				((TypesContext)_localctx).ato = num();
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
		public Object obj;
		public int id;
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
		enterRule(_localctx, 12, RULE_field);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				((FieldContext)_localctx).fc = funccall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
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
		public Object obj;
		public int id;
		public Token VAR_ID;
		public List<Token> modifiers = new ArrayList<Token>();
		public KvsContext kvs;
		public List<KvsContext> declarations = new ArrayList<KvsContext>();
		public KvsContext kvs() {
			return getRuleContext(KvsContext.class,0);
		}
		public List<TerminalNode> VAR_ID() { return getTokens(ErableParser.VAR_ID); }
		public TerminalNode VAR_ID(int i) {
			return getToken(ErableParser.VAR_ID, i);
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
		enterRule(_localctx, 14, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				((VarContext)_localctx).VAR_ID = match(VAR_ID);
				((VarContext)_localctx).modifiers.add(((VarContext)_localctx).VAR_ID);
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR_ID );
			setState(81);
			((VarContext)_localctx).kvs = kvs();
			((VarContext)_localctx).declarations.add(((VarContext)_localctx).kvs);
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

	public static class KvsContext extends ParserRuleContext {
		public Token key;
		public OpsContext val;
		public List<TerminalNode> NAME() { return getTokens(ErableParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ErableParser.NAME, i);
		}
		public List<TerminalNode> EQU() { return getTokens(ErableParser.EQU); }
		public TerminalNode EQU(int i) {
			return getToken(ErableParser.EQU, i);
		}
		public List<OpsContext> ops() {
			return getRuleContexts(OpsContext.class);
		}
		public OpsContext ops(int i) {
			return getRuleContext(OpsContext.class,i);
		}
		public KvsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kvs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterKvs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitKvs(this);
		}
	}

	public final KvsContext kvs() throws RecognitionException {
		KvsContext _localctx = new KvsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_kvs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(83);
					((KvsContext)_localctx).key = match(NAME);
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(84);
						match(EQU);
						setState(85);
						((KvsContext)_localctx).val = ops(0);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(90); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class OpsContext extends ParserRuleContext {
		public Object obj;
		public int id;
		public String type;
		public OpsContext l;
		public Token operation;
		public OpsContext r;
		public OpsContext p;
		public OpsContext pdo;
		public List<OpsContext> ops() {
			return getRuleContexts(OpsContext.class);
		}
		public OpsContext ops(int i) {
			return getRuleContext(OpsContext.class,i);
		}
		public TerminalNode UNARYOPS() { return getToken(ErableParser.UNARYOPS, 0); }
		public TerminalNode ADD() { return getToken(ErableParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ErableParser.SUB, 0); }
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
		public Field_and_typesContext field_and_types() {
			return getRuleContext(Field_and_typesContext.class,0);
		}
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public CondexprsContext condexprs() {
			return getRuleContext(CondexprsContext.class,0);
		}
		public CodeblockContext codeblock() {
			return getRuleContext(CodeblockContext.class,0);
		}
		public TerminalNode POW() { return getToken(ErableParser.POW, 0); }
		public TerminalNode EQU() { return getToken(ErableParser.EQU, 0); }
		public TerminalNode ADDEQ() { return getToken(ErableParser.ADDEQ, 0); }
		public TerminalNode SUBEQ() { return getToken(ErableParser.SUBEQ, 0); }
		public TerminalNode MULEQ() { return getToken(ErableParser.MULEQ, 0); }
		public TerminalNode DIVEQ() { return getToken(ErableParser.DIVEQ, 0); }
		public TerminalNode MODEQ() { return getToken(ErableParser.MODEQ, 0); }
		public TerminalNode MOD() { return getToken(ErableParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(ErableParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(ErableParser.MUL, 0); }
		public TerminalNode BINOPS() { return getToken(ErableParser.BINOPS, 0); }
		public TerminalNode ALPA() { return getToken(ErableParser.ALPA, 0); }
		public TerminalNode ARPA() { return getToken(ErableParser.ARPA, 0); }
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_ops, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNARYOPS:
			case ADD:
			case SUB:
				{
				setState(93);
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
				setState(94);
				((OpsContext)_localctx).r = ops(6);
				((OpsContext)_localctx).type = "unary";
				}
				break;
			case LPA:
				{
				setState(97);
				match(LPA);
				setState(98);
				((OpsContext)_localctx).p = ops(0);
				setState(99);
				match(RPA);
				((OpsContext)_localctx).type = "bracket";
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case ALPA:
			case NAME:
			case INT:
				{
				setState(102);
				field_and_types();
				((OpsContext)_localctx).type = "instance";
				}
				break;
			case VAR_ID:
			case FUNC:
				{
				setState(105);
				decls();
				((OpsContext)_localctx).type = "decls";
				}
				break;
			case WHILE:
			case IF:
				{
				setState(108);
				condexprs();
				((OpsContext)_localctx).type = "conds";
				}
				break;
			case LCB:
				{
				setState(111);
				codeblock();
				((OpsContext)_localctx).type = "block";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(116);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(117);
						match(POW);
						setState(118);
						((OpsContext)_localctx).r = ops(9);
						((OpsContext)_localctx).type = "pow";
						}
						break;
					case 2:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(121);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(122);
						((OpsContext)_localctx).operation = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQU) | (1L << ADDEQ) | (1L << SUBEQ) | (1L << MULEQ) | (1L << DIVEQ) | (1L << MODEQ))) != 0)) ) {
							((OpsContext)_localctx).operation = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(123);
						((OpsContext)_localctx).r = ops(9);
						((OpsContext)_localctx).type = "change";
						}
						break;
					case 3:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(126);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(127);
						((OpsContext)_localctx).operation = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BINOPS) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((OpsContext)_localctx).operation = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(128);
						((OpsContext)_localctx).r = ops(8);
						((OpsContext)_localctx).type = "binop";
						}
						break;
					case 4:
						{
						_localctx = new OpsContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_ops);
						setState(131);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(132);
						match(ALPA);
						setState(133);
						((OpsContext)_localctx).pdo = ops(0);
						setState(134);
						match(ARPA);
						((OpsContext)_localctx).type = "element";
						}
						break;
					}
					} 
				}
				setState(141);
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

	public static class StringContext extends ParserRuleContext {
		public Object obj;
		public int id;
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
		enterRule(_localctx, 20, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__0);
			setState(143);
			((StringContext)_localctx).str = anymatch();
			setState(144);
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
		public Object obj;
		public int id;
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
		enterRule(_localctx, 22, RULE_anymatch);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(148);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(146);
						match(ESC);
						}
						break;
					case 2:
						{
						setState(147);
						matchWildcard();
						}
						break;
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public Object obj;
		public int id;
		public OpsContext ops;
		public List<OpsContext> elements = new ArrayList<OpsContext>();
		public TerminalNode ALPA() { return getToken(ErableParser.ALPA, 0); }
		public TerminalNode ARPA() { return getToken(ErableParser.ARPA, 0); }
		public List<OpsContext> ops() {
			return getRuleContexts(OpsContext.class);
		}
		public OpsContext ops(int i) {
			return getRuleContext(OpsContext.class,i);
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
		enterRule(_localctx, 24, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(ALPA);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << UNARYOPS) | (1L << ADD) | (1L << SUB) | (1L << LPA) | (1L << LCB) | (1L << ALPA) | (1L << VAR_ID) | (1L << FUNC) | (1L << WHILE) | (1L << IF) | (1L << NAME) | (1L << INT))) != 0)) {
				{
				{
				setState(154);
				((ArrayContext)_localctx).ops = ops(0);
				((ArrayContext)_localctx).elements.add(((ArrayContext)_localctx).ops);
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
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

	public static class NumContext extends ParserRuleContext {
		public Object obj;
		public int id;
		public TerminalNode HEX() { return getToken(ErableParser.HEX, 0); }
		public TerminalNode BIN() { return getToken(ErableParser.BIN, 0); }
		public TerminalNode OCT() { return getToken(ErableParser.OCT, 0); }
		public List<TerminalNode> INT() { return getTokens(ErableParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ErableParser.INT, i);
		}
		public TerminalNode DOT() { return getToken(ErableParser.DOT, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ErableListener ) ((ErableListener)listener).exitNum(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_num);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(T__1);
				setState(163);
				match(HEX);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(T__2);
				setState(165);
				match(BIN);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(T__3);
				setState(167);
				match(OCT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(INT);
				setState(171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(169);
					match(DOT);
					setState(170);
					match(INT);
					}
					break;
				}
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

	public static class FunccallContext extends ParserRuleContext {
		public Object obj;
		public int id;
		public NameContext funcname;
		public OpsContext ops;
		public List<OpsContext> arguments = new ArrayList<OpsContext>();
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<OpsContext> ops() {
			return getRuleContexts(OpsContext.class);
		}
		public OpsContext ops(int i) {
			return getRuleContext(OpsContext.class,i);
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
		enterRule(_localctx, 28, RULE_funccall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			((FunccallContext)_localctx).funcname = name();
			setState(176);
			match(LPA);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(177);
					((FunccallContext)_localctx).ops = ops(0);
					((FunccallContext)_localctx).arguments.add(((FunccallContext)_localctx).ops);
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(183);
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
		public ArrayList<FPADCode> arguments;
		public Token NAME;
		public List<Token> argss = new ArrayList<Token>();
		public TerminalNode COLON() { return getToken(ErableParser.COLON, 0); }
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
		public List<TerminalNode> NAME() { return getTokens(ErableParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ErableParser.NAME, i);
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
		enterRule(_localctx, 30, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(COLON);
			setState(186);
			match(LPA);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(187);
				((ArgsContext)_localctx).NAME = match(NAME);
				((ArgsContext)_localctx).argss.add(((ArgsContext)_localctx).NAME);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
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
		public Object obj;
		public int id;
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
		enterRule(_localctx, 32, RULE_codeblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(LCB);
			setState(196);
			((CodeblockContext)_localctx).block = prog();
			setState(197);
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
		public Object obj;
		public int id;
		public Token funcname;
		public ArgsContext arguments;
		public CodeblockContext block;
		public TerminalNode FUNC() { return getToken(ErableParser.FUNC, 0); }
		public TerminalNode NAME() { return getToken(ErableParser.NAME, 0); }
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
		enterRule(_localctx, 34, RULE_funcdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(FUNC);
			setState(200);
			((FuncdeclContext)_localctx).funcname = match(NAME);
			setState(201);
			((FuncdeclContext)_localctx).arguments = args();
			setState(202);
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
		public Object obj;
		public int id;
		public OpsContext cond;
		public OpsContext ido;
		public OpsContext edo;
		public TerminalNode IF() { return getToken(ErableParser.IF, 0); }
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
		public List<OpsContext> ops() {
			return getRuleContexts(OpsContext.class);
		}
		public OpsContext ops(int i) {
			return getRuleContext(OpsContext.class,i);
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
		enterRule(_localctx, 36, RULE_ifcond);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(IF);
			setState(205);
			match(LPA);
			setState(206);
			((IfcondContext)_localctx).cond = ops(0);
			setState(207);
			match(RPA);
			setState(208);
			((IfcondContext)_localctx).ido = ops(0);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(209);
					match(ELSE);
					setState(210);
					((IfcondContext)_localctx).edo = ops(0);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		public Object obj;
		public int id;
		public OpsContext cond;
		public OpsContext pdo;
		public TerminalNode WHILE() { return getToken(ErableParser.WHILE, 0); }
		public TerminalNode LPA() { return getToken(ErableParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(ErableParser.RPA, 0); }
		public List<OpsContext> ops() {
			return getRuleContexts(OpsContext.class);
		}
		public OpsContext ops(int i) {
			return getRuleContext(OpsContext.class,i);
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
		enterRule(_localctx, 38, RULE_whilecond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(WHILE);
			setState(217);
			match(LPA);
			setState(218);
			((WhilecondContext)_localctx).cond = ops(0);
			setState(219);
			match(RPA);
			setState(220);
			((WhilecondContext)_localctx).pdo = ops(0);
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
		public Object obj;
		public int id;
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
		enterRule(_localctx, 40, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
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
		case 9:
			return ops_sempred((OpsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ops_sempred(OpsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u00e3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\7\2\60\n\2\f\2\16"+
		"\2\63\13\2\3\2\5\2\66\n\2\3\3\3\3\3\4\3\4\5\4<\n\4\3\5\3\5\5\5@\n\5\3"+
		"\6\3\6\5\6D\n\6\3\7\3\7\3\7\5\7I\n\7\3\b\3\b\5\bM\n\b\3\t\6\tP\n\t\r\t"+
		"\16\tQ\3\t\3\t\3\n\3\n\3\n\5\nY\n\n\6\n[\n\n\r\n\16\n\\\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13u\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u008c\n\13\f\13\16\13\u008f\13\13\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u0097"+
		"\n\r\f\r\16\r\u009a\13\r\3\16\3\16\7\16\u009e\n\16\f\16\16\16\u00a1\13"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ae"+
		"\n\17\5\17\u00b0\n\17\3\20\3\20\3\20\7\20\u00b5\n\20\f\20\16\20\u00b8"+
		"\13\20\3\20\3\20\3\21\3\21\3\21\7\21\u00bf\n\21\f\21\16\21\u00c2\13\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\7\24\u00d6\n\24\f\24\16\24\u00d9\13\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\4\u0098\u00b6\3\24\27\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*\2\5\4\2\b\b\17\20\4\2\7\7,\60\4\2\t"+
		"\t\17\23\2\u00eb\2\61\3\2\2\2\4\67\3\2\2\2\6;\3\2\2\2\b?\3\2\2\2\nC\3"+
		"\2\2\2\fH\3\2\2\2\16L\3\2\2\2\20O\3\2\2\2\22Z\3\2\2\2\24t\3\2\2\2\26\u0090"+
		"\3\2\2\2\30\u0098\3\2\2\2\32\u009b\3\2\2\2\34\u00af\3\2\2\2\36\u00b1\3"+
		"\2\2\2 \u00bb\3\2\2\2\"\u00c5\3\2\2\2$\u00c9\3\2\2\2&\u00ce\3\2\2\2(\u00da"+
		"\3\2\2\2*\u00e0\3\2\2\2,-\5\24\13\2-.\7\f\2\2.\60\3\2\2\2/,\3\2\2\2\60"+
		"\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\64\66"+
		"\7\2\2\3\65\64\3\2\2\2\65\66\3\2\2\2\66\3\3\2\2\2\678\5\n\6\28\5\3\2\2"+
		"\29<\5$\23\2:<\5\20\t\2;9\3\2\2\2;:\3\2\2\2<\7\3\2\2\2=@\5&\24\2>@\5("+
		"\25\2?=\3\2\2\2?>\3\2\2\2@\t\3\2\2\2AD\5\16\b\2BD\5\f\7\2CA\3\2\2\2CB"+
		"\3\2\2\2D\13\3\2\2\2EI\5\32\16\2FI\5\26\f\2GI\5\34\17\2HE\3\2\2\2HF\3"+
		"\2\2\2HG\3\2\2\2I\r\3\2\2\2JM\5\36\20\2KM\5*\26\2LJ\3\2\2\2LK\3\2\2\2"+
		"M\17\3\2\2\2NP\7\33\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2RS\3\2"+
		"\2\2ST\5\22\n\2T\21\3\2\2\2UX\7#\2\2VW\7\7\2\2WY\5\24\13\2XV\3\2\2\2X"+
		"Y\3\2\2\2Y[\3\2\2\2ZU\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\23\3\2"+
		"\2\2^_\b\13\1\2_`\t\2\2\2`a\5\24\13\bab\b\13\1\2bu\3\2\2\2cd\7\25\2\2"+
		"de\5\24\13\2ef\7\26\2\2fg\b\13\1\2gu\3\2\2\2hi\5\n\6\2ij\b\13\1\2ju\3"+
		"\2\2\2kl\5\6\4\2lm\b\13\1\2mu\3\2\2\2no\5\b\5\2op\b\13\1\2pu\3\2\2\2q"+
		"r\5\"\22\2rs\b\13\1\2su\3\2\2\2t^\3\2\2\2tc\3\2\2\2th\3\2\2\2tk\3\2\2"+
		"\2tn\3\2\2\2tq\3\2\2\2u\u008d\3\2\2\2vw\f\13\2\2wx\7\n\2\2xy\5\24\13\13"+
		"yz\b\13\1\2z\u008c\3\2\2\2{|\f\n\2\2|}\t\3\2\2}~\5\24\13\13~\177\b\13"+
		"\1\2\177\u008c\3\2\2\2\u0080\u0081\f\t\2\2\u0081\u0082\t\4\2\2\u0082\u0083"+
		"\5\24\13\n\u0083\u0084\b\13\1\2\u0084\u008c\3\2\2\2\u0085\u0086\f\f\2"+
		"\2\u0086\u0087\7\31\2\2\u0087\u0088\5\24\13\2\u0088\u0089\7\32\2\2\u0089"+
		"\u008a\b\13\1\2\u008a\u008c\3\2\2\2\u008bv\3\2\2\2\u008b{\3\2\2\2\u008b"+
		"\u0080\3\2\2\2\u008b\u0085\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\25\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091"+
		"\7\3\2\2\u0091\u0092\5\30\r\2\u0092\u0093\7\3\2\2\u0093\27\3\2\2\2\u0094"+
		"\u0097\7)\2\2\u0095\u0097\13\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2"+
		"\2\2\u0097\u009a\3\2\2\2\u0098\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\31\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009f\7\31\2\2\u009c\u009e\5\24"+
		"\13\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\32"+
		"\2\2\u00a3\33\3\2\2\2\u00a4\u00a5\7\4\2\2\u00a5\u00b0\7\'\2\2\u00a6\u00a7"+
		"\7\5\2\2\u00a7\u00b0\7%\2\2\u00a8\u00a9\7\6\2\2\u00a9\u00b0\7&\2\2\u00aa"+
		"\u00ad\7$\2\2\u00ab\u00ac\7\r\2\2\u00ac\u00ae\7$\2\2\u00ad\u00ab\3\2\2"+
		"\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00a4\3\2\2\2\u00af\u00a6"+
		"\3\2\2\2\u00af\u00a8\3\2\2\2\u00af\u00aa\3\2\2\2\u00b0\35\3\2\2\2\u00b1"+
		"\u00b2\5*\26\2\u00b2\u00b6\7\25\2\2\u00b3\u00b5\5\24\13\2\u00b4\u00b3"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\26\2\2\u00ba\37\3\2\2"+
		"\2\u00bb\u00bc\7\13\2\2\u00bc\u00c0\7\25\2\2\u00bd\u00bf\7#\2\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7\26\2\2\u00c4"+
		"!\3\2\2\2\u00c5\u00c6\7\27\2\2\u00c6\u00c7\5\2\2\2\u00c7\u00c8\7\30\2"+
		"\2\u00c8#\3\2\2\2\u00c9\u00ca\7\34\2\2\u00ca\u00cb\7#\2\2\u00cb\u00cc"+
		"\5 \21\2\u00cc\u00cd\5\"\22\2\u00cd%\3\2\2\2\u00ce\u00cf\7\36\2\2\u00cf"+
		"\u00d0\7\25\2\2\u00d0\u00d1\5\24\13\2\u00d1\u00d2\7\26\2\2\u00d2\u00d7"+
		"\5\24\13\2\u00d3\u00d4\7 \2\2\u00d4\u00d6\5\24\13\2\u00d5\u00d3\3\2\2"+
		"\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\'"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7\35\2\2\u00db\u00dc\7\25\2\2"+
		"\u00dc\u00dd\5\24\13\2\u00dd\u00de\7\26\2\2\u00de\u00df\5\24\13\2\u00df"+
		")\3\2\2\2\u00e0\u00e1\7#\2\2\u00e1+\3\2\2\2\27\61\65;?CHLQX\\t\u008b\u008d"+
		"\u0096\u0098\u009f\u00ad\u00af\u00b6\u00c0\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}