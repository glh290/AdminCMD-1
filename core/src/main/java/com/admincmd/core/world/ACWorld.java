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

import com.admincmd.api.world.Location;
import com.admincmd.api.world.World;
import com.admincmd.core.util.reflection.Reflector;

/**
 * <strong>Project:</strong> core <br>
 * <strong>File:</strong> ACWorld.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class ACWorld implements World {

    public World w;

    public ACWorld() {
        try {
            Class<?> clazz = Reflector.getSoftwareClass(".world.IWorld");

            Object o = clazz.newInstance();
            w = (World) o;
        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "World{" + w.getClass().getPackage().getName() + "." + w.getClass().getSimpleName() + "}";
    }

    @Override
    public Location getSpawnLocation() {
        return w.getSpawnLocation();
    }

    @Override
    public void setSpawnLocation() {
        w.setSpawnLocation();
    }

    @Override
    public String getName() {
        return w.getName();
    }

}
