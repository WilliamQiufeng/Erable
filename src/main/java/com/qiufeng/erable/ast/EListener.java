/*
 * Copyright (C) 2019 Qiufeng54321
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.qiufeng.erable.ast;

import com.qiufeng.erable.ErableBaseListener;
import com.qiufeng.erable.ErableParser;
import com.qiufeng.erable.exception.BaseException;
import com.qiufeng.erable.exception.UnknownException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Qiufeng54321
 */
public class EListener extends ErableBaseListener {

    @Override
    public void visitErrorNode(ErrorNode node) {
	super.visitErrorNode(node);
	var what=node.getText();
	var line=node.getSymbol().getLine();
	var column=node.getSymbol().getCharPositionInLine();
	new UnknownException(BaseException.ErrorType.PARSING,"",what,line,column,1).throwException();
    }

    @Override
    public void visitTerminal(TerminalNode node) {
	super.visitTerminal(node);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
	super.exitEveryRule(ctx);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
	super.enterEveryRule(ctx);
    }

    @Override
    public void exitName(ErableParser.NameContext ctx) {
	super.exitName(ctx);
    }

    @Override
    public void enterName(ErableParser.NameContext ctx) {
	super.enterName(ctx);
    }

    @Override
    public void exitWhilecond(ErableParser.WhilecondContext ctx) {
	super.exitWhilecond(ctx);
    }

    @Override
    public void enterWhilecond(ErableParser.WhilecondContext ctx) {
	super.enterWhilecond(ctx);
    }

    @Override
    public void exitIfcond(ErableParser.IfcondContext ctx) {
	super.exitIfcond(ctx);
    }

    @Override
    public void enterIfcond(ErableParser.IfcondContext ctx) {
	super.enterIfcond(ctx);
    }

    @Override
    public void exitFuncdecl(ErableParser.FuncdeclContext ctx) {
	super.exitFuncdecl(ctx);
    }

    @Override
    public void enterFuncdecl(ErableParser.FuncdeclContext ctx) {
	super.enterFuncdecl(ctx);
    }

    @Override
    public void exitCodeblock(ErableParser.CodeblockContext ctx) {
	super.exitCodeblock(ctx);
    }

    @Override
    public void enterCodeblock(ErableParser.CodeblockContext ctx) {
	super.enterCodeblock(ctx);
    }

    @Override
    public void exitArgs(ErableParser.ArgsContext ctx) {
	super.exitArgs(ctx);
    }

    @Override
    public void enterArgs(ErableParser.ArgsContext ctx) {
	super.enterArgs(ctx);
    }

    @Override
    public void exitFunccall(ErableParser.FunccallContext ctx) {
	super.exitFunccall(ctx);
    }

    @Override
    public void enterFunccall(ErableParser.FunccallContext ctx) {
	super.enterFunccall(ctx);
    }

    @Override
    public void exitVar_ids(ErableParser.Var_idsContext ctx) {
	super.exitVar_ids(ctx);
    }

    @Override
    public void enterVar_ids(ErableParser.Var_idsContext ctx) {
	super.enterVar_ids(ctx);
    }

    @Override
    public void exitUnsigned_float(ErableParser.Unsigned_floatContext ctx) {
	super.exitUnsigned_float(ctx);
    }

    @Override
    public void enterUnsigned_float(ErableParser.Unsigned_floatContext ctx) {
	super.enterUnsigned_float(ctx);
    }

    @Override
    public void exitUnsigned_int(ErableParser.Unsigned_intContext ctx) {
	super.exitUnsigned_int(ctx);
    }

    @Override
    public void enterUnsigned_int(ErableParser.Unsigned_intContext ctx) {
	super.enterUnsigned_int(ctx);
    }

    @Override
    public void exitUnsigned_num(ErableParser.Unsigned_numContext ctx) {
	super.exitUnsigned_num(ctx);
    }

    @Override
    public void enterUnsigned_num(ErableParser.Unsigned_numContext ctx) {
	super.enterUnsigned_num(ctx);
    }

    @Override
    public void exitArray(ErableParser.ArrayContext ctx) {
	super.exitArray(ctx);
    }

    @Override
    public void enterArray(ErableParser.ArrayContext ctx) {
	super.enterArray(ctx);
    }

    @Override
    public void exitAnymatch(ErableParser.AnymatchContext ctx) {
	super.exitAnymatch(ctx);
    }

    @Override
    public void enterAnymatch(ErableParser.AnymatchContext ctx) {
	super.enterAnymatch(ctx);
    }

    @Override
    public void exitString(ErableParser.StringContext ctx) {
	super.exitString(ctx);
    }

    @Override
    public void enterString(ErableParser.StringContext ctx) {
	super.enterString(ctx);
    }

    @Override
    public void exitAtom(ErableParser.AtomContext ctx) {
	super.exitAtom(ctx);
    }

    @Override
    public void enterAtom(ErableParser.AtomContext ctx) {
	super.enterAtom(ctx);
    }

    @Override
    public void exitOps(ErableParser.OpsContext ctx) {
	super.exitOps(ctx);
    }

    @Override
    public void enterOps(ErableParser.OpsContext ctx) {
	super.enterOps(ctx);
    }

    @Override
    public void exitVar_pair(ErableParser.Var_pairContext ctx) {
	super.exitVar_pair(ctx);
    }

    @Override
    public void enterVar_pair(ErableParser.Var_pairContext ctx) {
	super.enterVar_pair(ctx);
    }

    @Override
    public void exitVar_kv(ErableParser.Var_kvContext ctx) {
	super.exitVar_kv(ctx);
    }

    @Override
    public void enterVar_kv(ErableParser.Var_kvContext ctx) {
	super.enterVar_kv(ctx);
    }

    @Override
    public void exitVar(ErableParser.VarContext ctx) {
	super.exitVar(ctx);
    }

    @Override
    public void enterVar(ErableParser.VarContext ctx) {
	super.enterVar(ctx);
    }

    @Override
    public void exitField(ErableParser.FieldContext ctx) {
	super.exitField(ctx);
    }

    @Override
    public void enterField(ErableParser.FieldContext ctx) {
	super.enterField(ctx);
    }

    @Override
    public void exitTypes(ErableParser.TypesContext ctx) {
	super.exitTypes(ctx);
    }

    @Override
    public void enterTypes(ErableParser.TypesContext ctx) {
	super.enterTypes(ctx);
    }

    @Override
    public void exitField_and_types(ErableParser.Field_and_typesContext ctx) {
	super.exitField_and_types(ctx);
    }

    @Override
    public void enterField_and_types(ErableParser.Field_and_typesContext ctx) {
	super.enterField_and_types(ctx);
    }

    @Override
    public void exitCondexprs(ErableParser.CondexprsContext ctx) {
	super.exitCondexprs(ctx);
    }

    @Override
    public void enterCondexprs(ErableParser.CondexprsContext ctx) {
	super.enterCondexprs(ctx);
    }

    @Override
    public void exitDecls(ErableParser.DeclsContext ctx) {
	super.exitDecls(ctx);
    }

    @Override
    public void enterDecls(ErableParser.DeclsContext ctx) {
	super.enterDecls(ctx);
    }

    @Override
    public void exitExprs(ErableParser.ExprsContext ctx) {
	super.exitExprs(ctx);
    }

    @Override
    public void enterExprs(ErableParser.ExprsContext ctx) {
	super.enterExprs(ctx);
    }

    @Override
    public void exitProgo(ErableParser.ProgoContext ctx) {
	super.exitProgo(ctx);
    }

    @Override
    public void enterProgo(ErableParser.ProgoContext ctx) {
	super.enterProgo(ctx);
    }

    @Override
    public void exitProg(ErableParser.ProgContext ctx) {
	super.exitProg(ctx);
    }

    @Override
    public void enterProg(ErableParser.ProgContext ctx) {
	super.enterProg(ctx);
    }
    
}
