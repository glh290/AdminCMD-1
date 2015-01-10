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
package com.admincmd.core.world;

import com.admincmd.api.plugin.ServerSoftware;
import com.admincmd.api.world.Location;
import com.admincmd.api.world.World;
import com.admincmd.core.AdminCMD;

/**
 * <strong>Project:</strong> core <br>
 * <strong>File:</strong> ACWorld.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class ACWorld implements World {

    private final String name;

    public ACWorld(String name) {
        this.name = name;
    }

    @Override
    public Location getSpawnLocation() {
        Location loc = null;

        if (AdminCMD.getACPlugin().getServerSoftware() == ServerSoftware.BUKKIT) {
            org.bukkit.World world = org.bukkit.Bukkit.getServer().getWorld(name);
            loc = new Location(world.getSpawnLocation().getBlockX(), world.getSpawnLocation().getBlockY(), world.getSpawnLocation().getBlockZ(), world.getSpawnLocation().getYaw(), world.getSpawnLocation().getPitch(), this);
        } else if (AdminCMD.getACPlugin().getServerSoftware() == ServerSoftware.SPONGE) {
        }

        return loc;
    }

    @Override
    public void setSpawnLocation() {
    }

    @Override
    public String getName() {
        return this.name;
    }

}
