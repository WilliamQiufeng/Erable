// Generated from Erable.g4 by ANTLR 4.7.1

  import java.util.*;
  //import com.qiufeng.erable.*;
  //import com.qiufeng.erable.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ErableParser}.
 */
public interface ErableListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ErableParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ErableParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ErableParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#progo}.
	 * @param ctx the parse tree
	 */
	void enterProgo(ErableParser.ProgoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#progo}.
	 * @param ctx the parse tree
	 */
	void exitProgo(ErableParser.ProgoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(ErableParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(ErableParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(ErableParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(ErableParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#condexprs}.
	 * @param ctx the parse tree
	 */
	void enterCondexprs(ErableParser.CondexprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#condexprs}.
	 * @param ctx the parse tree
	 */
	void exitCondexprs(ErableParser.CondexprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#field_and_types}.
	 * @param ctx the parse tree
	 */
	void enterField_and_types(ErableParser.Field_and_typesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#field_and_types}.
	 * @param ctx the parse tree
	 */
	void exitField_and_types(ErableParser.Field_and_typesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(ErableParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(ErableParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(ErableParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(ErableParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(ErableParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(ErableParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#var_kv}.
	 * @param ctx the parse tree
	 */
	void enterVar_kv(ErableParser.Var_kvContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#var_kv}.
	 * @param ctx the parse tree
	 */
	void exitVar_kv(ErableParser.Var_kvContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#var_pair}.
	 * @param ctx the parse tree
	 */
	void enterVar_pair(ErableParser.Var_pairContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#var_pair}.
	 * @param ctx the parse tree
	 */
	void exitVar_pair(ErableParser.Var_pairContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#ops}.
	 * @param ctx the parse tree
	 */
	void enterOps(ErableParser.OpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#ops}.
	 * @param ctx the parse tree
	 */
	void exitOps(ErableParser.OpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ErableParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ErableParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ErableParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ErableParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#anymatch}.
	 * @param ctx the parse tree
	 */
	void enterAnymatch(ErableParser.AnymatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#anymatch}.
	 * @param ctx the parse tree
	 */
	void exitAnymatch(ErableParser.AnymatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(ErableParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(ErableParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#unsigned_num}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_num(ErableParser.Unsigned_numContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#unsigned_num}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_num(ErableParser.Unsigned_numContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_int(ErableParser.Unsigned_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_int(ErableParser.Unsigned_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#unsigned_float}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_float(ErableParser.Unsigned_floatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#unsigned_float}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_float(ErableParser.Unsigned_floatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#var_ids}.
	 * @param ctx the parse tree
	 */
	void enterVar_ids(ErableParser.Var_idsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#var_ids}.
	 * @param ctx the parse tree
	 */
	void exitVar_ids(ErableParser.Var_idsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#funccall}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(ErableParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#funccall}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(ErableParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(ErableParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(ErableParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#codeblock}.
	 * @param ctx the parse tree
	 */
	void enterCodeblock(ErableParser.CodeblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#codeblock}.
	 * @param ctx the parse tree
	 */
	void exitCodeblock(ErableParser.CodeblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#funcdecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncdecl(ErableParser.FuncdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#funcdecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncdecl(ErableParser.FuncdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#ifcond}.
	 * @param ctx the parse tree
	 */
	void enterIfcond(ErableParser.IfcondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#ifcond}.
	 * @param ctx the parse tree
	 */
	void exitIfcond(ErableParser.IfcondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#whilecond}.
	 * @param ctx the parse tree
	 */
	void enterWhilecond(ErableParser.WhilecondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#whilecond}.
	 * @param ctx the parse tree
	 */
	void exitWhilecond(ErableParser.WhilecondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ErableParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(ErableParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ErableParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(ErableParser.NameContext ctx);
}