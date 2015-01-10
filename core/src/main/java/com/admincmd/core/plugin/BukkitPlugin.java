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
import com.admincmd.core.AdminCMD;
import com.admincmd.core.Config;
import com.admincmd.plugin.util.database.DatabaseFactory;
import java.sql.SQLException;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> BukkitPlugin.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class BukkitPlugin extends JavaPlugin implements ACPlugin {

    @Override
    public void onEnable() {
        onPluginEnable();
    }

    @Override
    public void onDisable() {
        onPluginDisable();
    }

    @Override
    public void onPluginEnable() {
        AdminCMD.registerACPlugin(this);
        Config.load();
        DatabaseFactory.init();
    }

    @Override
    public void onPluginDisable() {
        try {
            DatabaseFactory.getDatabase().closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ServerSoftware getServerSoftware() {
        return ServerSoftware.BUKKIT;
    }
}
