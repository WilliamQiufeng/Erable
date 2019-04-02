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
import com.qiufeng.erable.OpCode;
import com.qiufeng.erable.VarModifiers;
import com.qiufeng.erable.exception.BaseException;
import com.qiufeng.erable.exception.UndefinedException;
import com.qiufeng.erable.exception.UnknownException;
import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Qiufeng54321
 */
public class EListener extends ErableBaseListener {
    public ErableParser parser;
    public Code root;
    public Code current;
    
    /**
     * Constant Pool
     */
    public ConstantPool pool = new ConstantPool();

    public ErableParser getParser() {
	return parser;
    }

    public void setParser(ErableParser parser) {
	this.parser = parser;
    }

    public Code getRoot() {
	return root;
    }

    public void setRoot(Scope root) {
	this.root = root;
    }

    public Code getCurrent() {
	return current;
    }

    public void setCurrent(Scope current) {
	this.current = current;
    }

    public ConstantPool getPool() {
	return pool;
    }

    public void setPool(ConstantPool pool) {
	this.pool = pool;
    }
    public int findVar(int tempid){
	var cid=this.current.findCid(tempid);
	var nameobj=this.pool.findElement(cid);
	var name=(String)nameobj.obj;
	var variable=this.current.findVar(name);
	if(variable==-1){
	    new UndefinedException(name,-1,-1).throwException();
	}
	return variable;
    }
    public EListener(ErableParser p){
	this.parser=p;
	this.root=new Scope(null);
	this.current=this.root;
    }
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
	var id=this.current.findVar(ctx.getText());
	ctx.id=id;
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
	//QUIT FUNCDECL
	this.current.getParent().addCode(this.current);
	this.current=this.current.getParent();
    }

    @Override
    public void enterFuncdecl(ErableParser.FuncdeclContext ctx) {
	super.enterFuncdecl(ctx);
	//Enter FUNCDECL
	this.current=new FuncDeclCode(ctx.funcname.getText(),null,this.current);
	//Enter CODEBLOCK ('''block=codeblock''' in Erable.g4),will invoke #enterCodeblock and #exitCodeblock after.
    }

    @Override
    public void exitCodeblock(ErableParser.CodeblockContext ctx) {
	super.exitCodeblock(ctx);
	//Quit the scope and add the scope
	this.current.getParent().addCode(this.current);
	this.current=this.current.getParent();
    }

    @Override
    public void enterCodeblock(ErableParser.CodeblockContext ctx) {
	super.enterCodeblock(ctx);
	this.current=new Scope(this.current);
    }

    @Override
    public void exitArgs(ErableParser.ArgsContext ctx) {
	super.exitArgs(ctx);
	
	for(var t : ctx.argss){
	    ctx.arguments.add(new FPADCode(t.getText(),current));
	}
	((FuncDeclCode)current).args=ctx.arguments;
    }

    @Override
    public void enterArgs(ErableParser.ArgsContext ctx) {
	super.enterArgs(ctx);
	ctx.arguments=new ArrayList<>();
    }

    @Override
    public void exitFunccall(ErableParser.FunccallContext ctx) {
	super.exitFunccall(ctx);
	var name=ctx.funcname.getText();
	var nameid=ctx.funcname.id;
	var args=new ArrayList<Integer>();
	for(var ele : ctx.arguments){
	    args.add(ele.id);
	}
	var call=new FuncCallCode(name,args,nameid,current);
	current.addCode(call);
	ctx.id=call.id;
    }

    @Override
    public void enterFunccall(ErableParser.FunccallContext ctx) {
	super.enterFunccall(ctx);
    }


    @Override
    public void exitArray(ErableParser.ArrayContext ctx) {
	super.exitArray(ctx);
	ctx.arr=new ArrayList<Integer>();
	for(var ele : ctx.elements){
	    ctx.arr.add(ele.id);
	}
	var array=new ArrayCode(ctx.arr,current);
	current.addCode(array);
	ctx.id=array.id;
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
	var text=ctx.anymatch().getText();
	var string=new ConstantPoolString(text);
	ctx.obj=text;
	var id=this.pool.addElement(string);
	var temp=new TempCode(id,current);
	current.addCode(temp);
	ctx.id=temp.id;
    }

    @Override
    public void enterString(ErableParser.StringContext ctx) {
	super.enterString(ctx);
    }

    @Override
    public void exitNum(ErableParser.NumContext ctx) {
	super.exitNum(ctx);
	var number=Double.parseDouble(ctx.getText());
	ctx.obj=number;
	var id=this.pool.addElement(new ConstantPoolNumber(number));
	var temp=new TempCode(id,current);
	current.addCode(temp);
	ctx.id=temp.id;
    }

    @Override
    public void enterNum(ErableParser.NumContext ctx) {
	super.enterNum(ctx);
    }


    @Override
    public void exitOps(ErableParser.OpsContext ctx) {
	super.exitOps(ctx);
	switch(ctx.type){
	    case "element":
		var element=new ElementCode(ctx.l.id,ctx.pdo.id,current);
		current.addCode(element);
		ctx.id=element.id;
		break;
	    case "pow":
	    case "change":
	    case "binop":
		var binop=new BinaryOpCode(ctx.l.id,ctx.r.id,OpCode.findOp(ctx.operation.getText()),current);
		current.addCode(binop);
		ctx.id=binop.id;
		break;
	    case "unary":
		var unaryop=new UnaryOpCode(ctx.r.id,OpCode.findOp(ctx.operation.getText()),current);
		current.addCode(unaryop);
		ctx.id=unaryop.id;
		break;
	    case "bracket":
		ctx.id=ctx.p.id;
		break;
	    case "instance":
		ctx.id=ctx.field_and_types().id;
		break;
	    case "decls":
		ctx.id=ctx.decls().id;
		break;
	    case "conds":
		ctx.id=ctx.condexprs().id;
		break;
	    case "block":
		ctx.id=ctx.codeblock().id;
		break;
	    default:
		new UnknownException(BaseException.ErrorType.COMPILATION,"Unknown Operation type("+ctx.type+")",ctx.getText(),ctx.start.getLine(),ctx.start.getCharPositionInLine(),4).throwException();
		
	}
    }

    @Override
    public void enterOps(ErableParser.OpsContext ctx) {
	super.enterOps(ctx);
    }

    @Override
    public void exitKvs(ErableParser.KvsContext ctx) {
	super.exitKvs(ctx);
    }

    @Override
    public void enterKvs(ErableParser.KvsContext ctx) {
	super.enterKvs(ctx);
    }


    @Override
    public void exitVar(ErableParser.VarContext ctx) {
	super.exitVar(ctx);
	for(var kv : ctx.declarations){
	    var key=kv.key.getText();
	    var val=-1;
	    if(kv.val!=null){
		val=kv.val.id;
	    }
	    var variable=new VarCode(key,ctx.mod,val,current);
	    current.addCode(variable);
	    ctx.id=variable.id;
	}
	
    }

    @Override
    public void enterVar(ErableParser.VarContext ctx) {
	super.enterVar(ctx);
	short modifiers=0;
	for(var token : ctx.modifiers){
	    modifiers=VarModifiers.add(modifiers, VarModifiers.valueOf(token.getText().toUpperCase()).mod);
	}
	ctx.mod=modifiers;
    }

    @Override
    public void exitField(ErableParser.FieldContext ctx) {
	super.exitField(ctx);
	ctx.id=-1;
	if(ctx.val!=null)
	    ctx.id=ctx.val.id;
	else
	    ctx.id=ctx.funccall().id;
    }

    @Override
    public void enterField(ErableParser.FieldContext ctx) {
	super.enterField(ctx);
    }

    @Override
    public void exitTypes(ErableParser.TypesContext ctx) {
	super.exitTypes(ctx);
	ctx.id=-1;
	if(ctx.arr!=null)
	    ctx.id=ctx.arr.id;
	else if(ctx.ato!=null)
	    ctx.id=ctx.ato.id;
	else
	    ctx.id=ctx.str.id;
    }

    @Override
    public void enterTypes(ErableParser.TypesContext ctx) {
	super.enterTypes(ctx);
    }

    @Override
    public void exitField_and_types(ErableParser.Field_and_typesContext ctx) {
	super.exitField_and_types(ctx);
	ctx.id=-1;
	if(ctx.val!=null)
	    ctx.id=ctx.val.id;
	else
	    ctx.id=ctx.tps.id;
	
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
    public void exitProg(ErableParser.ProgContext ctx) {
	super.exitProg(ctx);
    }

    @Override
    public void enterProg(ErableParser.ProgContext ctx) {
	super.enterProg(ctx);
    }
    
}
