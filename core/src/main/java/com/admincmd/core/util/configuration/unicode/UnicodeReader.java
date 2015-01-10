/*
 * This file is part of AdminCMD-Rebirth
 * Copyright (C) 2014 AdminCMD Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.admincmd.core.util.configuration.unicode;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;

public class UnicodeReader extends Reader {

	PushbackInputStream internalIn;
	InputStreamReader internalIn2 = null;
	String defaultEnc;

	/**
	 *
	 * @param in inputstream to be read
	 * @param defaultEnc default encoding if stream does not have BOM marker. Give NULL to use
	 *        system-level default.
	 */
	public UnicodeReader(final InputStream in, final String defaultEnc) {
		internalIn = new PushbackInputStream(in, UnicodeUtil.BOM_SIZE);
		this.defaultEnc = defaultEnc;
	}

	public String getDefaultEncoding() {
		return defaultEnc;
	}

	/**
	 * Get stream encoding or NULL if stream is uninitialized. Call init() or read() method to
	 * initialize it.
	 */
	public String getEncoding() {
		if (internalIn2 == null) {
			return null;
		}
		return internalIn2.getEncoding();
	}

	/**
	 * Read-ahead four bytes and check for BOM marks. Extra bytes are unread back to the stream,
	 * only BOM bytes are skipped.
	 */
	protected void init() throws IOException {
		if (internalIn2 != null) {
			return;
		}

		String encoding;
		final byte bom[] = new byte[UnicodeUtil.BOM_SIZE];
		int n, unread;
		n = internalIn.read(bom, 0, bom.length);

		if ((bom[0] == (byte) 0x00) && (bom[1] == (byte) 0x00) && (bom[2] == (byte) 0xFE)
		        && (bom[3] == (byte) 0xFF)) {
			encoding = "UTF-32BE";
			unread = n - 4;
		} else if ((bom[0] == (byte) 0xFF) && (bom[1] == (byte) 0xFE) && (bom[2] == (byte) 0x00)
		        && (bom[3] == (byte) 0x00)) {
			encoding = "UTF-32LE";
			unread = n - 4;
		} else if ((bom[0] == (byte) 0xEF) && (bom[1] == (byte) 0xBB) && (bom[2] == (byte) 0xBF)) {
			encoding = "UTF-8";
			unread = n - 3;
		} else if ((bom[0] == (byte) 0xFE) && (bom[1] == (byte) 0xFF)) {
			encoding = "UTF-16BE";
			unread = n - 2;
		} else if ((bom[0] == (byte) 0xFF) && (bom[1] == (byte) 0xFE)) {
			encoding = "UTF-16LE";
			unread = n - 2;
		} else {
			// Unicode BOM mark not found, unread all bytes
			encoding = defaultEnc;
			unread = n;
		}
		// System.out.println("read=" + n + ", unread=" + unread);

		if (unread > 0) {
			internalIn.unread(bom, (n - unread), unread);
		}

		// Use given encoding
		if (encoding == null) {
			internalIn2 = new InputStreamReader(internalIn);
		} else {
			internalIn2 = new InputStreamReader(internalIn, encoding);
		}
	}

	@Override
	public void close() throws IOException {
		init();
		internalIn2.close();
	}

	@Override
	public int read(final char[] cbuf, final int off, final int len) throws IOException {
		init();
		return internalIn2.read(cbuf, off, len);
	}
}
