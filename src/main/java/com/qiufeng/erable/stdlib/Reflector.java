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
package com.qiufeng.erable.stdlib;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author Qiufeng54321
 */
public class Reflector {
    public static Object newInstance(String className,Object[] args) throws Exception{
	var clazz=Class.forName(className);
	Class<?>[] classes=new Class<?>[args.length];
	for(int i=0;i<args.length;i++){
	    classes[i]=args[i].getClass();
	}
	Constructor constructor=clazz.getConstructor(classes);
	return constructor.newInstance(args);
    }
    public static Object call(Object obj,String methodName,Object[] args)throws Exception{
	var clazz=obj.getClass();
	Class<?>[] classes=new Class<?>[args.length];
	for(int i=0;i<args.length;i++){
	    classes[i]=args[i].getClass();
	}
	Method constructor=clazz.getMethod(methodName,classes);
	return constructor.invoke(obj, args);
    }
    public static Object callStatic(String className,String methodName,Object[] args)throws Exception{
	var clazz=Class.forName(className);
	Class<?>[] classes=new Class<?>[args.length];
	for(int i=0;i<args.length;i++){
	    classes[i]=args[i].getClass();
	}
	Method constructor=clazz.getMethod(methodName,classes);
	return constructor.invoke(null, args);
    }
    public static Object get(Object obj,String field)throws Exception{
	var clazz=obj.getClass();
	Field f=clazz.getField(field);
	f.setAccessible(true);
	return f.get(obj);
    }
    public static Object getStatic(String className,String field)throws Exception{
	var clazz=Class.forName(className);
	Field f=clazz.getField(field);
	f.setAccessible(true);
	return f.get(null);
    }
}
