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
import net.canarymod.plugin.Plugin;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> CanaryPlugin.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class CanaryPlugin extends Plugin implements ACPlugin {

    private IACPlugin acp;

    @Override
    public boolean enable() {
        acp = new IACPlugin(this, ServerSoftware.CANARY);
        acp.onPluginEnable();
        return true;
    }

    @Override
    public void disable() {
        acp.onPluginDisable();
    }

    @Override
    public void onPluginEnable() {
        //enabling code here
    }

    @Override
    public void onPluginDisable() {
        //disabling code here
    }
}
