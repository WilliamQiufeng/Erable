// Generated from erable.g4 by ANTLR 4.7.2
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
	 * Enter a parse tree produced by {@link erableParser#minus_plus}.
	 * @param ctx the parse tree
	 */
	void enterMinus_plus(erableParser.Minus_plusContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#minus_plus}.
	 * @param ctx the parse tree
	 */
	void exitMinus_plus(erableParser.Minus_plusContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#mul_div}.
	 * @param ctx the parse tree
	 */
	void enterMul_div(erableParser.Mul_divContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#mul_div}.
	 * @param ctx the parse tree
	 */
	void exitMul_div(erableParser.Mul_divContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#change}.
	 * @param ctx the parse tree
	 */
	void enterChange(erableParser.ChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#change}.
	 * @param ctx the parse tree
	 */
	void exitChange(erableParser.ChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link erableParser#dot}.
	 * @param ctx the parse tree
	 */
	void enterDot(erableParser.DotContext ctx);
	/**
	 * Exit a parse tree produced by {@link erableParser#dot}.
	 * @param ctx the parse tree
	 */
	void exitDot(erableParser.DotContext ctx);
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