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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 *
 * @author Qiufeng54321
 */
public class MultiplePrintStream extends PrintStream {
    PrintStream[] streams;

    public MultiplePrintStream(PrintStream[] streams, OutputStream out) {
	super(out);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, OutputStream out, boolean autoFlush) {
	super(out, autoFlush);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
	super(out, autoFlush, encoding);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, OutputStream out, boolean autoFlush, Charset charset) {
	super(out, autoFlush, charset);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, String fileName) throws FileNotFoundException {
	super(fileName);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
	super(fileName, csn);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, String fileName, Charset charset) throws IOException {
	super(fileName, charset);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, File file) throws FileNotFoundException {
	super(file);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
	super(file, csn);
	this.streams = streams;
    }

    public MultiplePrintStream(PrintStream[] streams, File file, Charset charset) throws IOException {
	super(file, charset);
	this.streams = streams;
    }

    @Override
    public void println(String x) {
	super.println(x);
	for(var ps : this.streams){
	    ps.println(x);
	}
    }
    
}
