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
package com.admincmd.core.entity;

import com.admincmd.api.entity.Player;
import com.admincmd.api.world.Location;
import com.admincmd.core.util.reflection.Reflector;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * <strong>Project:</strong> core <br>
 * <strong>File:</strong> ACPlayer.java
 * 
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class ACPlayer extends Player {
    
    private Player p;
    
    public ACPlayer(UUID uuid, String name) {
        super(uuid, name);
        try {
            Class<?> clazz = Reflector.getSoftwareClass(".entity.IPlayer");          
            Object o = clazz.getConstructor(UUID.class, String.class).newInstance(uuid, name);
            p = (Player) o;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String msg) {
        p.sendMessage(msg);
    }

    @Override
    public Location getLocation() {
        return p.getLocation();
    }

    @Override
    public void teleport(Location newLoc) {
        p.teleport(newLoc);
    }

}
