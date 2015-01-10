/**
 * This file is part of AdminCMD-Rebirth
 * 
 * Copyright (C) 2014 Antoine Aflalo
 * <p/>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.admincmd.core.util.exceptions;

/**
 * @author jkmalan (aka John Malandrakis)
 *
 */
public class InvalidConfigurationException extends Exception {

	private static final long serialVersionUID = -7133072603461950340L;

	/**
	 * Creates an exception with String input
	 * 
	 * @param message The message
	 */
	public InvalidConfigurationException(String message) {
		super(message);
	}

	/**
	 * Creates an exception with Exception input
	 * 
	 * @param e The exception
	 */
	public InvalidConfigurationException(Throwable e) {
		super(e);
	}

	/**
	 * @param message The message
	 * @param e The exception
	 */
	public InvalidConfigurationException(String message, Throwable e) {
		super(message, e);
	}

}
