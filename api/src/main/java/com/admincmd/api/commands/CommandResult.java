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
 * <strong>File:</strong> CommandResult.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public enum CommandResult {

    SUCCESS(null),
    NO_PERMISSION("§4[ERROR] §7You don't have permission to do that! §c(%perm%)"),
    NO_PERMISSION_OTHER("§4[ERROR] §7You don't have permission to do that! §c(%perm%.other)"),
    ERROR("§c[ERROR] §7Wrong usage! Please use §6/%cmd% help §7 to see the correct usage!"),
    ONLY_PLAYER("§c[ERROR] §7This command is only for players!"),
    NOT_ONLINE("§c[ERROR] §7That player is not online."),
    NOT_A_NUMBER("§c[ERROR] §7This is not a number!");

    private final String msg;

    CommandResult(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }
}
