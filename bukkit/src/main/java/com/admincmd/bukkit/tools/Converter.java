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
package com.admincmd.bukkit.tools;

import com.admincmd.api.entity.GameMode;
import com.admincmd.api.entity.Player;
import com.admincmd.api.world.Location;
import com.admincmd.api.world.World;
import com.admincmd.bukkit.entity.IPlayer;
import com.admincmd.bukkit.world.IWorld;
import org.bukkit.Bukkit;

public class Converter {

    public static Player transformPlayer(org.bukkit.entity.Player p) {
        Player ret = new IPlayer(p.getUniqueId(), p.getName());        
        return ret; 
    }
    
    public static Location transformLocation(org.bukkit.Location loc) {
        Location ret = new Location(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), loc.getYaw(), loc.getPitch(), transformWorld(loc.getWorld()));
        return ret;
    }
    
    public static org.bukkit.Location transformLocation(Location loc) {
        org.bukkit.Location ret = new org.bukkit.Location(transformWorld(loc.getWorld()), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        return ret;
    }
    
    public static World transformWorld(org.bukkit.World world) {
        World ret = new IWorld();
        return ret;
    }
    
    public static org.bukkit.World transformWorld(World world) {
        org.bukkit.World ret = Bukkit.getWorld(world.getName());
        return ret;
    }
    
    public static GameMode transformGameMode(org.bukkit.GameMode mode) {
        GameMode ret = GameMode.valueOf(mode.toString());
        return ret;
    }

    public static org.bukkit.GameMode transformGameMode(GameMode mode) {
        org.bukkit.GameMode ret = org.bukkit.GameMode.valueOf(mode.toString());
        return ret;
    }

}
