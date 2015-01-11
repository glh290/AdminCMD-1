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
package com.admincmd.bukkit.block;

import com.admincmd.api.block.Block;
import com.admincmd.api.world.Location;
import com.admincmd.api.world.World;

/**
 * <strong>Project:</strong> bukkit <br>
 * <strong>File:</strong> IBlock.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class IBlock implements Block {

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public World getWorld() {
        return null;
    }

}
