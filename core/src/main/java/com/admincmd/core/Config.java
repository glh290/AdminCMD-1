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

import com.admincmd.core.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <strong>Project:</strong> core <br>
 * <strong>File:</strong> Config.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public enum Config {

    SQL_USEMYSQL("SQL.UseMySQL", false, "Should we use MySQL or SQLite?"),
    SQL_MYSQL_DB("SQL.MySQL.Database", "minecraft", "The name of the database"),
    SQL_MYSQL_USER("SQl.MySQL.User", "root", "The user of the database"),
    SQL_MYSQL_PASSWORD("SQL.MySQL.Password", "password", "The password of the user"),
    SQL_MYSQL_IP("SQL.MySQL.IP", "127.0.0.1", "The IP where the MySQL server is"),
    SQL_MYSQL_PORT("SQL.MySQL.Port", 3306, "The port of the MySQL server");

    private final Object value;
    private final String path;
    private final String description;
    private static YamlConfiguration cfg;
    private static final File f = new File(AdminCMD.getACPlugin().getDataFolder(), "config.yml");

    private Config(String path, Object val, String description) {
        this.path = path;
        this.value = val;
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public Object getDefaultValue() {
        return value;
    }

    public int getInteger() {
        return cfg.getInt(path);
    }

    public boolean getBoolean() {
        return cfg.getBoolean(path);
    }

    public double getDouble() {
        return cfg.getDouble(path);
    }

    public String getString() {
        return cfg.getString(path);
    }

    public List<String> getStringList() {
        return cfg.getStringList(path);
    }

    public static void load() {
        f.mkdirs();
        reload(false);
        String header = "";
        for (Config c : values()) {
            header += c.getPath() + ": " + c.getDescription() + System.lineSeparator();
            if (!cfg.contains(c.getPath())) {
                c.set(c.getDefaultValue(), false);
            }
        }
        cfg.options().header(header);
        try {
            cfg.save(f);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void set(Object value, boolean save) {
        cfg.set(path, value);
        if (save) {
            try {
                cfg.save(f);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            reload(false);
        }
    }

    public static void reload(boolean complete) {
        if (!complete) {
            cfg = YamlConfiguration.loadConfiguration(f);
            return;
        }
        load();
    }

}
