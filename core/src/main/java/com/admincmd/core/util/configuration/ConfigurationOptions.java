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
package com.admincmd.core.util.configuration;

public class ConfigurationOptions {

	private char pathSeparator = '.';
	private int indent = 2;
	private boolean copyDefaults = false;
	private String header = null;
	private boolean copyHeader = true;
	private final Configuration config;

	protected ConfigurationOptions(Configuration config) {
		this.config = config;
	}

	public Configuration configuration() {
		return this.config;
	}

	public char pathSeparator() {
		return this.pathSeparator;
	}

	public ConfigurationOptions pathSeparator(char value) {
		this.pathSeparator = value;
		return this;
	}

	public boolean copyDefaults() {
		return this.copyDefaults;
	}

	public ConfigurationOptions copyDefaults(boolean value) {
		this.copyDefaults = value;
		return this;
	}

	public boolean copyHeader() {
		return copyHeader;
	}

	public ConfigurationOptions copyHeader(final boolean value) {
		copyHeader = value;
		return this;
	}

	public String header() {
		return header;
	}

	public ConfigurationOptions header(final String value) {
		this.header = value;
		return this;
	}

	public int indent() {
		return indent;
	}

	public ConfigurationOptions indent(final int value) {
		if (indent < 2 || value > 9) {
			throw new IllegalArgumentException("Indent must be between 1 and 10 characters");
		}
		this.indent = value;
		return this;
	}

}
