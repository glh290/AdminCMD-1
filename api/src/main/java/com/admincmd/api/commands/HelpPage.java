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

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>Project:</strong> api <br>
 * <strong>File:</strong> HelpPage.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class HelpPage {
    
    public HelpPage(String command) {
        this.command = command;
    }
    
    private final List<CommandHelp> helpPages = new ArrayList<>();
    private final List<String> HELP_TEXT = new ArrayList<>();
    private final String command;
    
    public void addPage(String argument, String description) {
        helpPages.add(new CommandHelp(command + argument, description));
    }
    
    public void prepare() {
        if (helpPages == null || helpPages.isEmpty()) return;
        HELP_TEXT.add("§a------------------------§1Help§a-------------------------");
        for (CommandHelp ch : helpPages) {
            HELP_TEXT.add("§6/" + ch.getText());
        }
        HELP_TEXT.add("§a-----------------------------------------------------");
    }
    
    public boolean sendHelp(CommandSender s, CommandArgs args) {
        if (args.getLength() == 1 && (args.getString(0).equalsIgnoreCase("?") || args.getString(0).equalsIgnoreCase("help")) && !HELP_TEXT.isEmpty()) {
            for (String string : HELP_TEXT) {
                s.sendMessage(string);
            }
            return true;
        }
        return false;
    }
    
    private class CommandHelp {
        
        private final String FULL_TEXT;
        
        public CommandHelp(String cmd, String description) {
            this.FULL_TEXT = "§6" + cmd + "§7" + " - " + description;
        }
        
        public String getText() {
            return FULL_TEXT;
        }
        
    }
    
}
