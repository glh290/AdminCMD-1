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
package com.admincmd.bukkit.commands;

import com.admincmd.api.commands.BaseCommand;
import com.admincmd.api.commands.CommandArgs;
import com.admincmd.api.commands.CommandHandler;
import com.admincmd.api.commands.CommandResult;
import com.admincmd.bukkit.BukkitPlugin;
import com.admincmd.bukkit.Messager;
import com.admincmd.bukkit.commands.tools.HelpPage;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

@CommandHandler
public class ServerCommands {

    private final HelpPage reload = new HelpPage("reload");

    public ServerCommands() {
        reload.addPage("", "Reloads the whole server.");
        reload.addPage("<plugin>", "Reloads a single plugin.");
        reload.prepare();
    }

    @BaseCommand(command = "reload", sender = BaseCommand.Sender.CONSOLE)
    public CommandResult executeConsole(CommandSender sender, CommandArgs args) {
        if (reload.sendHelp(sender, args)) {
            return CommandResult.SUCCESS;
        }
        if (args.isEmpty()) {
            BukkitPlugin.getInstance().getServer().reload();
            return Messager.sendMessage(sender, "The server has been reloaded.", Messager.MessageType.INFO);
        } else {
            if (args.getLength() == 1) {
                Plugin pl = BukkitPlugin.getInstance().getServer().getPluginManager().getPlugin(args.getString(0));
                if (pl == null) {
                    return Messager.sendMessage(sender, "There is no plugin by that name.", Messager.MessageType.ERROR);
                }
                BukkitPlugin.getInstance().getServer().getPluginManager().disablePlugin(pl);
                BukkitPlugin.getInstance().getServer().getPluginManager().enablePlugin(pl);
                return Messager.sendMessage(sender, "The plugin has been reloaded.", Messager.MessageType.INFO);
            } else {
                return CommandResult.ERROR;
            }
        }
    }
    
    @BaseCommand(command = "reload", sender = BaseCommand.Sender.PLAYER, permission = "admincmd.server.reload")
    public CommandResult executePlayer(CommandSender sender, CommandArgs args) {
        return executeConsole(sender, args);
    }

}
