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
package com.admincmd.core;

import com.admincmd.api.plugin.ACPlugin;
import com.admincmd.api.plugin.ServerSoftware;
import com.admincmd.core.database.DatabaseFactory;
import com.admincmd.core.loggers.ACLogger;
import java.sql.SQLException;

/**
 * <strong>Project:</strong> core <br>
 * <strong>File:</strong> AdminCMD.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class AdminCMD {

    private static ACPlugin acp;

    public static void registerACPlugin(ACPlugin acp) {
        AdminCMD.acp = acp;
    }

    public static ACPlugin getACPlugin() {
        return acp;
    }

    public static void onEnable() {
        long start = System.currentTimeMillis();
        Config.load();
        DatabaseFactory.init();
        
        long timeTook = System.currentTimeMillis() - start;
        ACLogger.debug("Plugin start took " + timeTook + " miliseconds");

    }

    public static void onDisable() {
        try {
            DatabaseFactory.getDatabase().closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        System.gc();
    }

    public static ServerSoftware getServerSoftware() {
        return acp.getServerSoftware();
    }

}
