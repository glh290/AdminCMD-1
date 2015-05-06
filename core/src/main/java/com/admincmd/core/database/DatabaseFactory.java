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
package com.admincmd.core.database;

import com.admincmd.api.database.Database;
import com.admincmd.core.AdminCMD;
import com.admincmd.core.Config;
import com.admincmd.core.util.loggers.ACLogger;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.gjt.mm.mysql.Driver;
import org.sqlite.JDBC;

public class DatabaseFactory {
    
    private static Database db = null;
    
    public static void init() {
        try {
            DriverManager.registerDriver(new JDBC());
            DriverManager.registerDriver(new Driver());
        } catch (SQLException ex) {
            ACLogger.debug("Could not register the drivers!", ex);
            ex.printStackTrace();
        }
        
        if (Config.MYSQL_USE.getBoolean()) {
            db = new MySQL(Config.MYSQL_IP.getString(), Config.MYSQL_USER.getString(), Config.MYSQL_PASSWORD.getString(), Config.MYSQL_DATABASE.getString(), Config.MYSQL_PORT.getInteger());
        } else {
            db = new SQLite(new File(AdminCMD.getACPlugin().getDataFolder(), "Database.db"));
        }
        
        if (db.testConnection()) {
            ACLogger.info("The connection was successful!");
        } else {
            ACLogger.severe("Could not connect to the Database!");
        }
        
    }
    
    public static Database getDatabase() {
        return db;
    }
    
}
