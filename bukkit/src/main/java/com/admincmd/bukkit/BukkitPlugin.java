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
package com.admincmd.bukkit;

import com.admincmd.api.commands.CommandRegistry;
import com.admincmd.api.plugin.ACPlugin;
import com.admincmd.api.plugin.ServerSoftware;
import com.admincmd.bukkit.commands.ServerCommands;
import com.admincmd.bukkit.commands.tools.CommandManager;
import com.admincmd.bukkit.events.EventManager;
import com.admincmd.bukkit.events.PlayerJoinListener;
import com.admincmd.bukkit.player.PlayerManager;
import com.admincmd.core.AdminCMD;
import com.admincmd.core.loggers.ACLogger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> BukkitPlugin.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class BukkitPlugin extends JavaPlugin implements ACPlugin {

    private final CommandManager manager = new CommandManager(this);
    private static BukkitPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        AdminCMD.registerACPlugin(INSTANCE);
        AdminCMD.onEnable();

        PlayerManager.init();
        registerCommands();
        registerEvents();
        
        ACLogger.info("Using Bukkit version!");

    }

    @Override
    public void onDisable() {
        PlayerManager.save();

        AdminCMD.onDisable();
    }

    public static BukkitPlugin getInstance() {
        return INSTANCE;
    }
    
    private void registerCommands() {
        manager.registerClass(ServerCommands.class);
    }
    
    private void registerEvents() {
        EventManager.registerEvent(PlayerJoinListener.class);
    }

    @Override
    public ServerSoftware getServerSoftware() {
        return ServerSoftware.BUKKIT;
    }

    @Override
    public CommandRegistry getCommandRegistry() {
        return INSTANCE.manager;
    }
}
