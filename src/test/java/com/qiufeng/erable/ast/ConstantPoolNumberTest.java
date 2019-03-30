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
public class ConstantPoolNumberTest {
    
    public ConstantPoolNumberTest() {
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
     * Test of serialise method, of class ConstantPoolNumber.
     */
    @Test
    public void testSerialise() {
	System.out.println("----------Testing ConstantPoolNumber#serialise");
	ConstantPoolNumber instance = new ConstantPoolNumber(123456789d);
	var expResult = new byte[]{1, 65, -99, 111, 52, 84, 0, 0, 0};
	byte[] result = instance.serialise();
	System.out.println("exp:'"+Arrays.toString(expResult)+"',res="+Arrays.toString(result));
	assertArrayEquals(expResult, result);
    }

    /**
     * Test of generateHeader method, of class ConstantPoolNumber.
     */
    @Test
    public void testGenerateHeader() {
	System.out.println("----------Testing ConstantPoolNumber#generateHeader");
	var instance = new ConstantPoolNumber(123456789d);
	var expResult = new byte[]{1};
	byte[] result = instance.generateHeader();
	System.out.println("exp:'"+Arrays.toString(expResult)+"',res="+Arrays.toString(result));
	assertArrayEquals(expResult, result);
    }
    
}
