// Generated from erable.g4 by ANTLR 4.7.2

  import java.util.*;
  import com.qiufeng.erable.*;
  import com.qiufeng.erable.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link erableParser}.
 */
public interface erableListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link erableParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(erableParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(erableParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#progo}.
	 * @param ctx the parse tree
	 */
	void enterProgo(erableParser.ProgoContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#progo}.
	 * @param ctx the parse tree
	 */
	void exitProgo(erableParser.ProgoContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(erableParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(erableParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(erableParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(erableParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#condexprs}.
	 * @param ctx the parse tree
	 */
	void enterCondexprs(erableParser.CondexprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#condexprs}.
	 * @param ctx the parse tree
	 */
	void exitCondexprs(erableParser.CondexprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#field_and_types}.
	 * @param ctx the parse tree
	 */
	void enterField_and_types(erableParser.Field_and_typesContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#field_and_types}.
	 * @param ctx the parse tree
	 */
	void exitField_and_types(erableParser.Field_and_typesContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(erableParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(erableParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(erableParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(erableParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#ops}.
	 * @param ctx the parse tree
	 */
	void enterOps(erableParser.OpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#ops}.
	 * @param ctx the parse tree
	 */
	void exitOps(erableParser.OpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(erableParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(erableParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#var_kv}.
	 * @param ctx the parse tree
	 */
	void enterVar_kv(erableParser.Var_kvContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#var_kv}.
	 * @param ctx the parse tree
	 */
	void exitVar_kv(erableParser.Var_kvContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#var_pair}.
	 * @param ctx the parse tree
	 */
	void enterVar_pair(erableParser.Var_pairContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#var_pair}.
	 * @param ctx the parse tree
	 */
	void exitVar_pair(erableParser.Var_pairContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterBinary_op(erableParser.Binary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitBinary_op(erableParser.Binary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(erableParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(erableParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#pos_neg_num}.
	 * @param ctx the parse tree
	 */
	void enterPos_neg_num(erableParser.Pos_neg_numContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#pos_neg_num}.
	 * @param ctx the parse tree
	 */
	void exitPos_neg_num(erableParser.Pos_neg_numContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(erableParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(erableParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#anymatch}.
	 * @param ctx the parse tree
	 */
	void enterAnymatch(erableParser.AnymatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#anymatch}.
	 * @param ctx the parse tree
	 */
	void exitAnymatch(erableParser.AnymatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(erableParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(erableParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#unsigned_num}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_num(erableParser.Unsigned_numContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#unsigned_num}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_num(erableParser.Unsigned_numContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_int(erableParser.Unsigned_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_int(erableParser.Unsigned_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#unsigned_float}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_float(erableParser.Unsigned_floatContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#unsigned_float}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_float(erableParser.Unsigned_floatContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void enterUnary_op(erableParser.Unary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void exitUnary_op(erableParser.Unary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#var_ids}.
	 * @param ctx the parse tree
	 */
	void enterVar_ids(erableParser.Var_idsContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#var_ids}.
	 * @param ctx the parse tree
	 */
	void exitVar_ids(erableParser.Var_idsContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#funccall}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(erableParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#funccall}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(erableParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(erableParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(erableParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#codeblock}.
	 * @param ctx the parse tree
	 */
	void enterCodeblock(erableParser.CodeblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#codeblock}.
	 * @param ctx the parse tree
	 */
	void exitCodeblock(erableParser.CodeblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#funcdecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncdecl(erableParser.FuncdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#funcdecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncdecl(erableParser.FuncdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#ifcond}.
	 * @param ctx the parse tree
	 */
	void enterIfcond(erableParser.IfcondContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#ifcond}.
	 * @param ctx the parse tree
	 */
	void exitIfcond(erableParser.IfcondContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#whilecond}.
	 * @param ctx the parse tree
	 */
	void enterWhilecond(erableParser.WhilecondContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#whilecond}.
	 * @param ctx the parse tree
	 */
	void exitWhilecond(erableParser.WhilecondContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(erableParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(erableParser.NameContext ctx);
}