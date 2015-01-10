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
package com.admincmd.core.plugin;

import com.admincmd.api.plugin.ACPlugin;
import com.admincmd.api.plugin.ServerSoftware;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> IACPlugin.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class IACPlugin implements ACPlugin {

    private final ACPlugin plugin;
    private static ACPlugin INSTANCE;
    private final ServerSoftware software;

    public IACPlugin(ACPlugin plugin, ServerSoftware software) {
        INSTANCE = this;
        this.plugin = plugin;
        this.software = software;
    }

    @Override
    public void onPluginEnable() {
        plugin.onPluginEnable();
    }

    @Override
    public void onPluginDisable() {
        plugin.onPluginDisable();
    }

    public ServerSoftware getServerSoftware() {
        return this.software;
    }

    public static ACPlugin getInstance() {
        return INSTANCE;
    }
}
