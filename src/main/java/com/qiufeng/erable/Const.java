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
package com.qiufeng.erable;

/**
 * 
 * @author Qiufeng54321
 */
public class Const {
    public static byte    MAJOR=0;
    public static byte    MINOR=1;
    public static byte ID_LENGTH=1;
    public static byte CID_LENGTH=1;
    public static byte[]   MAGIC={(byte)0xe4,(byte)0xab};
    public static byte[]  HEADER={MAGIC[0],MAGIC[1],MAJOR,MINOR,(byte)((ID_LENGTH<<4)|CID_LENGTH)};
    public static void setIdLen(int len){
	Const.ID_LENGTH=(byte)len;
	refreshLen();
    }
    public static void setCidLen(int len){
	Const.CID_LENGTH=(byte)len;
	refreshLen();
    }
    public static void refreshLen(){
	HEADER[4]=(byte)((ID_LENGTH<<4)|CID_LENGTH);
    }
}
