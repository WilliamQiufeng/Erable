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

import com.qiufeng.erable.vm.ErableDescriptor;

/**
 * @since 2019年4月16日
 * @author Qiufeng54321
 */
public class ErableVariable extends ErableInstance<ErableInstance<?>> {
    public ErableVariable(ErableInstance<?> value, int id, ErableDescriptor descriptor) {
	super(value, id, descriptor);
    }

    public ErableVariable(Integer value, int id, ErableDescriptor descriptor) {
	super(descriptor.buffer.get(value), id, descriptor);
    }
    
    
    public int getRef(){
	return value.id;
    }

    @Override
    public String toString() {
	return "ErableVariable{id=" + id + ", value=" + this.value + ", refid=" + getRef() + '}';
    }
    
}
