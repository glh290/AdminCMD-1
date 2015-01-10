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
package com.admincmd.core.util.loggers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ACLogger {

    private static final Logger logger = Logger.getLogger("AdminCMD");
    private static final String PREFIX = "[AdminCMD]";

    /**
     * Logs information to console
     * 
     * @param message The message to log
     */
    public static void info(final String message) {
        logger.log(Level.INFO, PREFIX + message);
    }

    /**
     * Logs warnings to console
     * 
     * @param message The warning to log
     */
    public static void warn(final String message) {
        logger.log(Level.WARNING, PREFIX + message);
    }

    /**
     * Logs errors to console
     * 
     * @param message The error to log
     */
    public static void severe(final String message) {
        logger.log(Level.SEVERE, PREFIX + message);
    }

    /**
     * Logs errors and exceptions to console
     * 
     * @param message The error to log
     * @param ex The exception to log
     */
    public static void severe(final String message, final Throwable ex) {
        logger.log(Level.SEVERE, PREFIX + message, ex);
    }

    /**
     * Logs debug messages to console
     * 
     * (Eventually, this can be written to file)
     * 
     * @param message The debug message to log
     */
    public static void debug(final String message) {
        logger.log(Level.INFO, PREFIX + message);
    }

    /**
     * Logs debug messages and exceptions to console
     * 
     * (Eventually, this can be written to file)
     * 
     * @param message The debug message to log
     * @param ex The exception to log
     */
    public static void debug(final String message, final Throwable ex) {
        logger.log(Level.INFO, PREFIX + message, ex);
    }

}
