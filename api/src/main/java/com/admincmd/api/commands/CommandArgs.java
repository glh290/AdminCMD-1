/*
 * This file is part of AdminCMD
 * Copyright (C) 2015 AdminCMD Team
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
package com.admincmd.api.commands;

/**
 * <strong>Project:</strong> api <br>
 * <strong>File:</strong> CommandArgs.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class CommandArgs {

    private final String[] args;
    private final int length;

    public static CommandArgs getArgs(String[] args, int start) {
        String a = "";
        int length = 0;
        for (int i = start; i < args.length; i++) {
            a += args[i] + ";";
            length++;
        }
        return new CommandArgs(a.split(";"), length);
    }

    private CommandArgs(String[] args, int length) {
        this.args = args;
        this.length = length;
    }

    public String getString(int number) {
        return args[number];
    }

    public boolean isInteger(int number) {
        try {
            Integer.valueOf(args[number]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(int number) {
        try {
            Double.valueOf(args[number]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isEmpty() {
        return length < 1;
    }

    public int getLength() {
        return length;
    }

    public String[] getArgs() {
        return args;
    }
   
    public int getInt(int num) {
        return Integer.valueOf(args[num]);
    }
   
}
