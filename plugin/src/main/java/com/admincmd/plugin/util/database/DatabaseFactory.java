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
package com.admincmd.plugin.util.database;

import com.admincmd.api.database.Database;
import com.admincmd.core.AdminCMD;
import com.admincmd.core.Config;
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
            ex.printStackTrace();
        }

        //TODO: Config implementation
        boolean mysql = Config.SQL_USEMYSQL.getBoolean();

        db = mysql ? new MySQL(Config.SQL_MYSQL_IP.getString(), Config.SQL_MYSQL_USER.getString(), Config.SQL_MYSQL_PASSWORD.getString(), Config.SQL_MYSQL_DB.getString(), Config.SQL_MYSQL_PORT.getInteger()) : new SQLite(new File(AdminCMD.getACPlugin().getDataFolder(), "Database.db"));
    }

    public static Database getDatabase() {
        return db;
    }

}
