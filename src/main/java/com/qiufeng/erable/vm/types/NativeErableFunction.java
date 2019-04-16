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

package com.qiufeng.erable.vm.types;

import com.qiufeng.erable.stdlib.Reflector;
import com.qiufeng.erable.vm.ErableDescriptor;
import com.qiufeng.erable.vm.OpCodeIns;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 2019年4月15日
 * @author Qiufeng54321
 */
public class NativeErableFunction extends ErableFunction{
    String[] nativeCall;
    public NativeErableFunction(String calls, ErableDescriptor descriptor, int retid, int id) {
	super(new ArrayList<OpCodeIns>(), descriptor, retid, id);
	this.nativeCall=calls.split("#");
    }

    @Override
    public Object apply(Arguments arguments) {
	try {
	    Class<?> cls=Class.forName(nativeCall[0]);
	    Object obj=null;
	    for(int i=1;i<nativeCall.length-1;i++){
		Field field;
		String fname=nativeCall[i];
		field=cls.getField(fname);
		obj=field.get(obj);
		cls=obj.getClass();
	    }
	    Method method=cls.getMethod(nativeCall[nativeCall.length-1], Reflector.getArgsClasses(arguments.args.toArray()));
	    return method.invoke(obj, arguments.args.toArray());
	}
	catch (Exception ex) {
	    Logger.getLogger(NativeErableFunction.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }

    @Override
    public String toString() {
	String str=super.toString();
	return str.substring(0, str.length()-1) + ", native call=" + Arrays.toString(nativeCall) + '}';
    }

}
