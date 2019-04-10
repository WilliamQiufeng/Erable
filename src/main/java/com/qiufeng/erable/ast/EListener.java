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
import com.qiufeng.erable.compiler.ErableCompiler;
import com.qiufeng.erable.ErableParser;
import com.qiufeng.erable.OpCode;
import com.qiufeng.erable.VarModifiers;
import com.qiufeng.erable.exception.BaseException;
import com.qiufeng.erable.exception.RedefinitionException;
import com.qiufeng.erable.exception.UnknownException;
import java.util.ArrayList;
import java.util.HashSet;
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
    public HashSet<String> importedModules;
    
    
    /**
     * Constant Pool
     */
    public ConstantPool pool;

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
    public EListener(ErableParser p,EListener current){
	this.importedModules = current.importedModules;
	this.parser=p;
	this.root=current.current;
	this.current=this.root;
	this.pool=current.pool;
    }
    public EListener(ErableParser p){
	this.importedModules = new HashSet<>();
	this.parser=p;
	this.root=new Scope(null);
	this.current=this.root;
	this.pool=new ConstantPool(this.root);
	this.root.addCode(pool);
	pool.addElement(new ConstantPoolNumber(0d));
	pool.addElement(new ConstantPoolNumber(1d));
	var TTemp=new TempCode(pool.findElementId(1d),current);
	var True=new VarCode("true",(short)0,TTemp.id,current);
	this.current.addCode(TTemp);
	this.current.addCode(True);
	var FTemp=new TempCode(pool.findElementId(0d),current);
	var False=new VarCode("false",(short)0,FTemp.id,current);
	this.current.addCode(FTemp);
	this.current.addCode(False);
    }

    @Override
    public void exitElsecond(ErableParser.ElsecondContext ctx) {
	super.exitElsecond(ctx);
	this.current.getParent().addCode(this.current);
	this.current=this.current.getParent();
    }

    @Override
    public void enterElsecond(ErableParser.ElsecondContext ctx) {
	super.enterElsecond(ctx);
	this.current=new ElseCode(this.current);
    }
    @Override
    public void visitErrorNode(ErrorNode node) {
	super.visitErrorNode(node);
	var what=node.getSymbol().getText();
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
	this.current.getParent().addCode(current);
	current=current.getParent();
    }

    @Override
    public void exitSops(ErableParser.SopsContext ctx) {
	super.exitSops(ctx);
	this.current.addCode(new MachineCode(OpCode.END,current.getParent().id,this.current));
    }

    @Override
    public void enterSops(ErableParser.SopsContext ctx) {
	super.enterSops(ctx);
	this.current.addCode(new MachineCode(OpCode.BREAKIF,this.current.codes.get(this.current.codes.size()-1).id,this.current));
	
    }

    @Override
    public void enterWhilecond(ErableParser.WhilecondContext ctx) {
	super.enterWhilecond(ctx);
	current=new WhileCode(current);
    }

    @Override
    public void exitIfcond(ErableParser.IfcondContext ctx) {
	super.exitIfcond(ctx);
	//Quit Scope1 to Scope0
	current.getParent().addCode(this.current);
	current=current.getParent();
    }

    @Override
    public void enterIfcond(ErableParser.IfcondContext ctx) {
	super.enterIfcond(ctx);
	//Enter Scope1 from Scope0
	current=new IfCode(current);
	
    }

    @Override
    public void exitFuncdecl(ErableParser.FuncdeclContext ctx) {
	super.exitFuncdecl(ctx);
	var funcname=ctx.funcname.getText();
	var funcid=this.current.findFunction(funcname, ctx.arguments.arguments.size());
	if(funcid!=-1){
	    new RedefinitionException("Redefinition of function '"+funcname+"' with same argument length of "+ctx.arguments.arguments.size(),funcname,ctx.funcname.getLine(),ctx.funcname.getCharPositionInLine()).throwException();
	}
	//QUIT FUNCDECL
	ctx.id=this.current.id;
	this.current.getParent().addCode(this.current);
	this.current=this.current.getParent();
    }

    @Override
    public void enterFuncdecl(ErableParser.FuncdeclContext ctx) {
	super.enterFuncdecl(ctx);
	var funcname=ctx.funcname.getText();
	//Enter FUNCDECL
	this.current=new FuncDeclCode(funcname,null,this.current);
	
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
    public void exitSblock(ErableParser.SblockContext ctx) {
	super.exitSblock(ctx);
    }

    @Override
    public void enterSblock(ErableParser.SblockContext ctx) {
	super.enterSblock(ctx);
	this.current.addCode(new MachineCode(OpCode.BREAKIF,this.current.codes.get(this.current.codes.size()-1).id,this.current));
    }

    @Override
    public void exitArgs(ErableParser.ArgsContext ctx) {
	super.exitArgs(ctx);
	for(var t : ctx.argss){
	    ctx.arguments.add(new FPADCode(t.getText(),current));
	}
	if(!(current instanceof Scope))
	    ((FuncDeclCode)current).args=ctx.arguments;
    }

    @Override
    public void enterArgs(ErableParser.ArgsContext ctx) {
	super.enterArgs(ctx);
	ctx.arguments=new ArrayList<>();
    }

    /*@Override
    public void exitFunccall(ErableParser.FunccallContext ctx) {
	super.exitFunccall(ctx);
	
    }

    @Override
    public void enterFunccall(ErableParser.FunccallContext ctx) {
	super.enterFunccall(ctx);
    }*/


    @Override
    public void exitArray(ErableParser.ArrayContext ctx) {
	super.exitArray(ctx);
	ctx.arr=new ArrayList<Integer>();
	for(var ele : ctx.elements.ops()){
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
    public void exitString(ErableParser.StringContext ctx) {
	super.exitString(ctx);
	var text=ctx.ANYMATCH().getText();
	text=text.substring(1, text.length()-1);
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
    public void exitPair(ErableParser.PairContext ctx) {
	super.exitPair(ctx);
	boolean isFuncDecl=true;
	int key=0,value=0;
	ConstantPoolString ks=null;
	if(ctx.funcdecl()!=null){
	    ks=new ConstantPoolString(ctx.funcdecl().funcname.getText());
	    value=ctx.funcdecl().id;
	}else if(ctx.native_funcdecl()!=null){
	    ks=new ConstantPoolString(ctx.native_funcdecl().funcname.getText());
	    value=ctx.native_funcdecl().id;
	}else{
	    isFuncDecl=false;
	}
	if(isFuncDecl){
	    this.pool.addElement(ks);
	    var tmp=new TempCode(ks.id,this.current);
	    this.current.addCode(tmp);
	    key=tmp.id;
	    current.addCode(new MachineCode(OpCode.KEY,/*current.codes.get(current.codes.size()-1)*/key,current));
	    current.addCode(new MachineCode(OpCode.VALUE,/*current.codes.get(current.codes.size()-1)*/value,current));
	}
	current.addCode(new MachineCode(OpCode.END_PAIR,-1,this.current));
    }

    @Override
    public void enterPair(ErableParser.PairContext ctx) {
	super.enterPair(ctx);
	current.addCode(new MachineCode(OpCode.START_PAIR,-1,this.current));
    }

    @Override
    public void exitPairs(ErableParser.PairsContext ctx) {
	super.exitPairs(ctx);
    }

    @Override
    public void enterPairs(ErableParser.PairsContext ctx) {
	super.enterPairs(ctx);
    }

    @Override
    public void exitParent_expression(ErableParser.Parent_expressionContext ctx) {
	super.exitParent_expression(ctx);
	if(this.current.getMeaningfulParent()==null)
	    new UnknownException(BaseException.ErrorType.COMPILATION,"Already at the root scope",ctx.getText(),ctx.getStart().getLine(),ctx.getStart().getCharPositionInLine(),5).throwException();
	ctx.id=this.current.getMeaningfulParent().id;
    }

    @Override
    public void exitObject(ErableParser.ObjectContext ctx) {
	super.exitObject(ctx);
	current.getParent().addCode(current);
	ctx.id=current.id;
	current=this.current.getParent();
    }

    @Override
    public void enterObject(ErableParser.ObjectContext ctx) {
	super.enterObject(ctx);
	current=new ObjectCode(current);
    }

    @Override
    public void exitThis_expression(ErableParser.This_expressionContext ctx) {
	super.exitThis_expression(ctx);
	ctx.id=this.current.id;
    }

    @Override
    public void exitOops(ErableParser.OopsContext ctx) {
	super.exitOops(ctx);
	var cur=(ObjectCode)current;
	OpCode type=(cur.isKey?OpCode.KEY:OpCode.VALUE);
	((ObjectCode)current).isKey=!((ObjectCode)current).isKey;
	current.addCode(new MachineCode(type,/*current.codes.get(current.codes.size()-1)*/ctx.ops().id,current));
	ctx.id=ctx.ops().id;
    }

    @Override
    public void enterOops(ErableParser.OopsContext ctx) {
	super.enterOops(ctx);
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
	    case "funccall":
		var name=ctx.funcname.getText();
		var nameid=ctx.funcname.id;
		var args=new ArrayList<Integer>();
		for(var arg : ctx.arguments.ops()){
		    args.add(arg.id);
		}
		var call=new FuncCallCode(name,args,nameid,current);
		current.addCode(call);
		ctx.id=call.id;
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
	    case "modacc":
		ctx.id=ctx.modacc().id;
	    case "exprs":
	    case "dynload":
		break;
	    default:
		new UnknownException(BaseException.ErrorType.COMPILATION,"Unknown Operation type("+ctx.type+")",ctx.getText(),ctx.start.getLine(),ctx.start.getCharPositionInLine(),4).throwException();
		
	}
    }

    @Override
    public void exitLoad_native(ErableParser.Load_nativeContext ctx) {
	super.exitLoad_native(ctx);
	var lc=new LoadCode(ctx.lib.id,this.current);
	this.current.addCode(lc);
    }

    @Override
    public void enterLoad_native(ErableParser.Load_nativeContext ctx) {
	super.enterLoad_native(ctx);
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
    public void exitImp_module(ErableParser.Imp_moduleContext ctx) {
	super.exitImp_module(ctx);
	var compiler=new ErableCompiler();
	var mod=(String)ctx.mod.obj;
	if(!mod.endsWith(".erable")){
	    mod+=".erable";
	}
	if(!this.importedModules.contains(mod)){
	    compiler.compile(mod, this);
	    this.importedModules.add(mod);
	}
    }

    @Override
    public void enterImp_module(ErableParser.Imp_moduleContext ctx) {
	super.enterImp_module(ctx);
    }

    @Override
    public void exitCatch_expr(ErableParser.Catch_exprContext ctx) {
	super.exitCatch_expr(ctx);
	this.current.addCode(new MachineCode(OpCode.CATCH_END,-1,this.current));
	this.current.addCode(new MachineCode(OpCode.FINALLY,this.current.id,this.current));
    }

    @Override
    public void enterCatch_expr(ErableParser.Catch_exprContext ctx) {
	super.enterCatch_expr(ctx);
	this.current.addCode(new MachineCode(OpCode.TRY_END,-1,this.current));
	var fpad=new FPADCode(ctx.cn.getText(),this.current);
	((TryCatchCode)this.current).mCatch=fpad;
	this.current.addCode(new MachineCode(OpCode.CATCH_ID,fpad.id,this.current));
	this.current.addCode(new MachineCode(OpCode.CATCH_START,-1,this.current));
    }

    @Override
    public void exitTry_expr(ErableParser.Try_exprContext ctx) {
	super.exitTry_expr(ctx);
	this.current.getParent().addCode(this.current);
	this.current=this.current.getParent();
    }

    @Override
    public void enterTry_expr(ErableParser.Try_exprContext ctx) {
	super.enterTry_expr(ctx);
	this.current=new TryCatchCode(this.current);
	this.current.addCode(new MachineCode(OpCode.TRY_START,-1,this.current));
    }


    @Override
    public void exitNative_funcdecl(ErableParser.Native_funcdeclContext ctx) {
	super.exitNative_funcdecl(ctx);
	var funcname=ctx.funcname.getText();
	var funcid=this.current.findFunction(funcname, ctx.arguments.arguments.size());
	var nativeCall=ctx.method.id;
	if(funcid!=-1){
	    new RedefinitionException("Redefinition of function '"+funcname+"' with same argument length of "+ctx.arguments.arguments.size(),funcname,ctx.funcname.getLine(),ctx.funcname.getCharPositionInLine()).throwException();
	}
	var nfdc=new NativeFuncDeclCode(funcname,nativeCall,ctx.arguments.arguments,this.current);
	ctx.id=nfdc.id;
	this.current.addCode(nfdc);
	
    }

    @Override
    public void enterNative_funcdecl(ErableParser.Native_funcdeclContext ctx) {
	super.enterNative_funcdecl(ctx);
	
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
	    var exists=this.current.variableExistsInCurrentScope(key);
	    if(exists){
		new RedefinitionException("Redefinition of variable with the same name '"+key+"'.",key,kv.key.getLine(),kv.key.getCharPositionInLine()).throwException();
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
	    ctx.id=-1;
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
	else if(ctx.str!=null)
	    ctx.id=ctx.str.id;
	else if(ctx.thi!=null)
	    ctx.id=ctx.thi.id;
	else if(ctx.par!=null)
	    ctx.id=ctx.par.id;
	else
	    ctx.id=ctx.objv.id;
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
	if(ctx.ic!=null){
	    ctx.id=ctx.ic.id;
	}else if(ctx.wc!=null){
	    ctx.id=ctx.wc.id;
	}else if(ctx.te!=null){
	    ctx.id=ctx.te.id;
	}
    }

    @Override
    public void enterCondexprs(ErableParser.CondexprsContext ctx) {
	super.enterCondexprs(ctx);
    }

    @Override
    public void exitDecls(ErableParser.DeclsContext ctx) {
	super.exitDecls(ctx);
	if(ctx.fd!=null){
	    ctx.id=ctx.fd.id;
	}else{
	    ctx.id=ctx.v.id;
	}
    }

    @Override
    public void exitDynload(ErableParser.DynloadContext ctx) {
	super.exitDynload(ctx);
	var dlc=new DynLoadCode(ctx.mod.getText(),(String)ctx.dyn.obj,ctx.dyn.id,(String)ctx.table.obj,ctx.table.id,this.current);
	dlc.loadProps();
	this.current.addCode(dlc);
    }

    @Override
    public void enterDynload(ErableParser.DynloadContext ctx) {
	super.enterDynload(ctx);
	
    }

    @Override
    public void exitModacc(ErableParser.ModaccContext ctx) {
	super.exitModacc(ctx);
	var mac=new ModuleAccessCode(this.current.findModule(ctx.mod.getText()),ctx.tar.getText(),this.current);
	ctx.id=mac.id;
	this.current.addCode(mac);
    }

    @Override
    public void enterModacc(ErableParser.ModaccContext ctx) {
	super.enterModacc(ctx);
    }

    @Override
    public void enterDecls(ErableParser.DeclsContext ctx) {
	super.enterDecls(ctx);
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
