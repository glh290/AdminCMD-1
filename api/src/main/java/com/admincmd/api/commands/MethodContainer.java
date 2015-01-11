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

import com.admincmd.api.commands.BaseCommand.Sender;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;

/**
 * <strong>Project:</strong> api <br>
 * <strong>File:</strong> MethodContainer.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class MethodContainer {

    private final HashMap<Sender, Method> methods;

    public MethodContainer(HashMap<Sender, Method> map) {
        methods = map;
    }

    public Method getMethod(Sender s) {
        return methods.get(s);
    }

    public Collection<Method> getMethods() {
        return methods.values();
    }

    public HashMap<Sender, Method> getMethodMap() {
        return methods;
    }
    
}
