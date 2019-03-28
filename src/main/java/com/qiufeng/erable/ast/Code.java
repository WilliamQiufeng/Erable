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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Qiufeng54321
 */
public abstract class Code {
    public static int    currentId = 0;
    public        String      sign = "|";
    public        List<Code> codes = new ArrayList<>();
    public        String       tag = null;
    public        Code      parent = null;
    public        int           id = Code.currentId++;
    
    
    public Code(String tag,Code parent){
        this.tag=tag;
        this.bind(parent);
    }
    public Code(String tag){
        this(tag,null);
    }
    public abstract String write();
    public void bind(Code code){
        this.parent=code;
    }
    public Code find(String tag){
        for(Code c : codes){
            if(c.tag.equals(tag))
                return c;
        }
        return null;
    }
    public boolean addCode(Code code){
        code.parent=this;
        return codes.add(code);
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setParent(Code parent) {
        this.parent = parent;
    }

    public String getSign() {
        return sign;
    }

    public String getTag() {
        return tag;
    }

    public Code getParent() {
        return parent;
    }
    
    @Override
    public String toString() {
        String ts="";
        if(parent!=null){
            ts=parent.toString();
        }
        ts+=sign;
        ts+=tag;
        return ts;
    }
    
}
