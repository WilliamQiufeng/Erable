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
package com.qiufeng.erable.vm;

import com.qiufeng.erable.Const;
import com.qiufeng.erable.OpCode;
import com.qiufeng.erable.ast.ConstantPool;
import com.qiufeng.erable.ast.ConstantPoolInteger;
import com.qiufeng.erable.ast.ConstantPoolNumber;
import com.qiufeng.erable.ast.ConstantPoolString;
import com.qiufeng.erable.exception.ValidateErr;
import com.qiufeng.erable.util.BitUtils;
import com.qiufeng.erable.util.StringUtils;
import com.qiufeng.erable.vm.types.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @since 2019年4月9日
 * @author Qiufeng54321
 */
public class ErableDescriptor {

    InputStream input;
    OpCodeIns skip;
    public List<OpCodeIns> codes;
    public HashMap<Integer, ErableInstance> buffer;
    ConstantPool pool;
    int major, minor;
    int idlen, cidlen;
    byte[] magic;
    ErableDescriptor parent;
    public static int	STATE_PASS=0,
			STATE_EXIT=1,
			STATE_FAIL=2;

    public ErableDescriptor(InputStream in, ErableDescriptor parent) {
	this.input = in;
	this.buffer = new HashMap<>();
	this.pool = new ConstantPool(null);
	this.parent=parent;
	this.codes=new ArrayList<>();
	if(parent!=null){
	    this.buffer=parent.buffer;
	    this.pool=parent.pool;
	    this.major=parent.major;
	    this.minor=parent.minor;
	    this.magic=parent.magic;
	    this.idlen=parent.idlen;
	    this.cidlen=parent.cidlen;
	    this.codes=parent.codes;
	}
    }

    public ErableDescriptor(InputStream in) {
	this(in, null);
    }
    

    public void doAll() throws IOException {
	this.readHeader();
	this.executeAll(new OpCodeIns(OpCode.EXIT, new ArrayList<>()));
    }

    public int execute(OpCodeIns oci) throws IOException {
	System.out.println(oci);
	int state=STATE_PASS;
	switch (oci.op) {
	    case CONSTANT_POOL:
		this.readConstantPool();
		break;
	    case ADD:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.add(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case SUB:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.sub(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case MUL:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.mul(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case DIV:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.div(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case MOD:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.mod(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case POW:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.pow(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case POS:
	    {
		int lid=oci.args.get(0);
		int bto=oci.args.get(1);
		ErableInstance l1=buffer.get(lid);
		ErableInstance bres=l1;
		buffer.put(bto, bres);
		break;
	    }
	    case NEG:
	    {
		int lid=oci.args.get(0);
		int bto=oci.args.get(1);
		ErableInstance l1=buffer.get(lid);
		ErableInteger  zero=new ErableInteger(0, -1);
		ErableInstance bres=zero.sub(l1, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case ELEMENT:
		break;
	    case LS:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.ls(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case RS:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.rs(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case URS:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.urs(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case LT:
		break;
	    case GT:
		break;
	    case LTE:
		break;
	    case GTE:
		break;
	    case EQ:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.eq(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case NEQ:
		break;
	    case EQU:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		l1.setValue(r2);
		break;
	    }
	    case SWITCH:
		break;
	    case BNOT:
	    {
		int lid=oci.args.get(0);
		int bto=oci.args.get(1);
		ErableInstance l1=buffer.get(lid);
		ErableInstance bres=l1.not(bto);
		buffer.put(bto, bres);
		break;
	    }
	    case BAND:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.and(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case BOR:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.or(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case BXOR:
	    {
		int lid=oci.args.get(0);
		int rid=oci.args.get(1);
		int bto=oci.args.get(2);
		ErableInstance l1=buffer.get(lid);
		ErableInstance r2=buffer.get(rid);
		ErableInstance bres=l1.xor(r2, bto);
		buffer.put(bto, bres);
		break;
	    }
	    case ADDEQ:
		break;
	    case SUBEQ:
		break;
	    case MULEQ:
		break;
	    case DIVEQ:
		break;
	    case MODEQ:
		break;
	    case PUSH_SCOPE:
		int psid = oci.args.get(0);
		ErableDescriptor child=new ErableDescriptor(input, this);
		OpCodeIns psoci=new OpCodeIns(OpCode.POP_SCOPE, new ArrayList<>(){{
		    add(psid);
		}});
		child.executeAll(psoci);
		break;
	    case POP_SCOPE:
		//Do nothing because #readAll and #executeAll includes this
		break;
	    case REF:
		int refid=oci.args.get(0);
		int refto=oci.args.get(1);
		//int refinsid=((ErableInstance)buffer.get(refid).value).id;
		//System.out.println("REFINSID="+refinsid);
		//int refinsid2=(int)(double)buffer.get(refinsid).value;
		ErableInstance refins=buffer.get(refid);
		this.buffer.put(refto, refins);
		break;
	    case GREF:
		int grefid=oci.args.get(0);
		int grefto=oci.args.get(1);
		ErableInteger grefres=new ErableInteger(grefid,grefto,this);
		this.buffer.put(grefto, grefres);
		break;
	    case RETURN:
		break;
	    case BREAK:
		break;
	    case COPY:
		int varval=oci.args.get(0);
		int varid =oci.args.get(1);
		ErableInstance copyFrom=buffer.get(varval).clone();
		copyFrom.id=varid;
		this.buffer.put(varid, copyFrom);
		break;
	    case LOADC:
		int cid=oci.args.get(0);
		int loadid=oci.args.get(1);
		this.loadc(cid, loadid);
		break;
	    case FUNCTION:
		int fretid = oci.args.get(0);
		int funcid = oci.args.get(1);
		OpCodeIns functill = new OpCodeIns(OpCode.END, new ArrayList<>() {
		    {
			add(funcid);
		    }
		});
		this.readAll(functill, (result) -> {
		    ErableFunction ef = new ErableFunction(result, this, fretid, funcid);
		    this.buffer.put(funcid, ef);
		});
		break;
	    case ARRAY:
		break;
	    case PUSH_ELEMENT:
		break;
	    case CALL_PREPARE:
		break;
	    case PUSH_ARG:
		break;
	    case CALL:
		break;
	    case IF:
		break;
	    case ELSE:
		break;
	    case WHILE:
		break;
	    case END:
		//Same as POP_SCOPE, skip
		break;
	    case BREAKIF:
		break;
	    case JUMPIF:
		break;
	    case OBJECT:
		break;
	    case START_PAIR:
		break;
	    case KEY:
		break;
	    case VALUE:
		break;
	    case END_PAIR:
		break;
	    case TRY:
		break;
	    case NATIVE_FUNCDECL:
		int nretid = oci.args.get(0);
		int nfuncid = oci.args.get(1);
		int nativeId = oci.args.get(2);
		String calls = (String)this.buffer.get(nativeId).getValue();
		NativeErableFunction nef = new NativeErableFunction(calls, this, nretid, nfuncid);
		this.buffer.put(nfuncid, nef);
		break;
	    case LOAD_LIB:
		break;
	    case DYN_LOAD:
		break;
	    case DYNCALL:
		break;
	    case EXIT:
		System.out.println("Program exit.");
		state=STATE_EXIT;
		for(ErableInstance ei : this.getDeclaredErableInstances()){
		    System.out.println(StringUtils.std(ei.id+"", 8)+" = "+ei.getValue());
		}
		break;
	    default:
		throw new AssertionError(oci.op.name());

	}
	return state;
    }

    public void executeAll(OpCodeIns until) throws IOException {
	OpCodeIns oci = null;
	while (!until.equals(oci)) {
	    oci = read();
	    execute(oci);
	}
    }

    public void executeAll(List<OpCodeIns> codes) throws IOException {
	for (OpCodeIns oci : codes) {
	    execute(oci);
	}
    }
    public void gc() {
	buffer.clear();
    }
    public void readAll(OpCodeIns until, Consumer<List<OpCodeIns>> function) throws IOException {
	List<OpCodeIns> l = new ArrayList<>();
	OpCodeIns oci = null;
	while (!until.equals(oci)) {
	    oci = read();
	    l.add(oci);
	}
	function.accept(l);
    }

    public OpCodeIns read() throws IOException {
	OpCode op = OpCode.values()[input.read()];
	List<Integer> args = new ArrayList<>();
	switch (op) {
	    case LOADC:
		int cid = this.readId(cidlen);
		int id = this.readId(idlen);
		args.add(cid);
		args.add(id);
		break;
	    default:
		for (int i = 0; i < op.argc; i++) {
		    int aid = this.readId(idlen);
		    args.add(aid);
		}
		break;
	}
	OpCodeIns oci = new OpCodeIns(op, args);
	this.codes.add(oci);
	//System.out.println(oci);
	return oci;
    }

    public void validate() {
	if (major > Const.MAJOR) {
	    new ValidateErr("Major version higher than runtime").throwException();
	}
	if (!Arrays.equals(magic, Const.MAGIC)) {
	    new ValidateErr("Magic number not right").throwException();
	}
    }

    public void readConstantPool() throws IOException {
	int len = this.readId(cidlen);
	System.out.println("Constant Pool: Length="+len);
	for (int i = 0; i < len; i++) {
	    OpCode code = OpCode.values()[this.input.read()];
	    if (null != code) switch (code) {
	    	case CP_NUM:{
		    byte[] doubb = this.input.readNBytes(8);
		    double doub = BitUtils.getDouble(doubb, 0);
		    this.pool.addElement(new ConstantPoolNumber(doub));
			break;
		    }
	    	case CP_STR:
		    int strlen = this.readId(4);
		    String str = new String(this.input.readNBytes(strlen));
		    this.pool.addElement(new ConstantPoolString(str));
		    break;
	    	case CP_INT:{
		    byte[] intb=this.input.readNBytes(4);
		    int integer=BitUtils.getInt(intb, 0);
		    this.pool.addElement(new ConstantPoolInteger(integer));
		    break;
		    }
	    	default:
		    break;
	    }
	}
	System.out.println(pool.elements);
    }

    public void readHeader() throws IOException {
	magic = input.readNBytes(2);
	major = input.read();
	minor = input.read();
	int il = input.read();
	idlen = il >> 4;
	cidlen = il & 0x01;
	Const.setIdLen(idlen);
	Const.setCidLen(cidlen);
	System.out.println(magic + ", version:" + major + "," + minor + ", idlen: " + idlen + ", cidlen: " + cidlen);
	this.validate();
    }

    public void loadc(int cid, int id) {
	//System.out.println(cid);
	//System.out.println(this.pool.elements);
	ErableInstance<?> loadInstance=this.pool.findElement(cid).getInstance();
	loadInstance.id=id;
	loadInstance.descriptor=this;
	this.buffer.put(id, loadInstance);
    }

    public int readId(int len) throws IOException {
	byte[] bs = this.input.readNBytes(len);
	int id=Const.getId(bs, 0, len);
	//System.out.println(id);
	return id;
    }
    public List<ErableInstance<?>> getDeclaredErableInstances(){
	List<ErableInstance<?>> instances=new ArrayList<>();
	for(Map.Entry<Integer, ErableInstance> me : this.buffer.entrySet()){
	    if((me.getValue() instanceof ErableVariable) || (me.getValue() instanceof ErableFunction)){
		instances.add(me.getValue());
	    }
	}
	return instances;
    }
}
