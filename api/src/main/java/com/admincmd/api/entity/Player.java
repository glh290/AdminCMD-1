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
package com.admincmd.api.entity;

import com.admincmd.api.commands.CommandSender;
import java.util.UUID;

public abstract class Player implements Entity, CommandSender, LivingEntity, HumanEntity {

    private final UUID uuid;
    private final String name;

    public Player(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }
    
    public abstract boolean getAllowFlight();
    
    public abstract String getDisplayName();
    
    public abstract GameMode getGameMode();
    
    public abstract void setAllowFlight(boolean allow);
    
    public abstract void setDisplayName(String name);
    
    public abstract void setGameMode(GameMode mode);
 
}
