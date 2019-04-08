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

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Qiufeng54321
 */
public class ConstantPoolTest {
    ConstantPool instance;
    public ConstantPoolTest() {
        ConstantPoolElement acpe = new ConstantPoolString("a");
	ConstantPoolElement bcpe = new ConstantPoolString("b");
	ConstantPoolElement ccpe = new ConstantPoolString("c");
	ConstantPoolElement dcpe = new ConstantPoolString("c");
	ConstantPoolElement ecpe = new ConstantPoolString("d");
	ConstantPoolElement fcpe = new ConstantPoolNumber(123456.789012d);
	ConstantPoolElement gcpe = new ConstantPoolNumber(345678.901234d);
	ConstantPoolElement hcpe = new ConstantPoolNumber(567890.123456d);
	instance = new ConstantPool();
	instance.addElement(acpe);
	instance.addElement(bcpe);
	instance.addElement(ccpe);
	instance.addElement(dcpe);
	instance.addElement(ecpe);
	instance.addElement(fcpe);
	instance.addElement(gcpe);
	instance.addElement(hcpe);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addElement method, of class ConstantPool.
     */
    @Test
    public void testAddElement() {
	System.out.println("Testing ConstantPool#addElement");
	
	for(ConstantPoolElement ele : instance.elements){
	    System.out.println(ele.toString());
	}
    }

    /**
     * Test of findElement method, of class ConstantPool.
     */
    @Test
    public void testFindElement() {
        System.out.println("-----------Testing ConstantPool#findElement");
        int id = 1;
        String expResult = "b";
        ConstantPoolElement result = instance.findElement(id);
        System.out.println("--Find result:"+result);
        assertEquals(expResult, result.obj);
    }

    /**
     * Test of findElementId method, of class ConstantPool.
     */
    @Test
    public void testFindElementId() {
        System.out.println("-----------Testing ConstantPool#findElementId");
        double obj = 123456.789012d;
        int expResult = 4;
        int result = instance.findElementId(obj);
        System.out.println("--Finded ID:"+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of generate method, of class ConstantPool.
     */
    @Test
    public void testGenerate() {
	System.out.println("----------Testing ConstantPool#generate");
	byte[] expResult = {0, 0, 0, 0, 7, 2, 0, 0, 0, 1, 97, 2, 0, 0, 0, 1, 98, 2, 0, 0, 0, 1, 99, 2, 0, 0, 0, 1, 100, 1, 64, -2, 36, 12, -97, -53, 12, 2, 1, 65, 21, 25, 59, -102, -35, 21, -16, 1, 65, 33, 84, -92, 63, 53, -97, -11};
	byte[] result = instance.generate();
	System.out.println("Generated Constant Pool:"+new String(result));
	System.out.println("--As bytes:"+Arrays.toString(result));
	assertArrayEquals(expResult, result);
    }
    
}
