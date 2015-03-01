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
package com.admincmd.bukkit.entity;

import com.admincmd.api.entity.GameMode;
import com.admincmd.api.entity.Player;
import com.admincmd.api.world.Location;
import com.admincmd.bukkit.tools.Converter;
import org.bukkit.Bukkit;

import java.util.UUID;

public class IPlayer extends Player {
    
    private final org.bukkit.entity.Player bPlayer;
    
    public IPlayer(UUID uuid, String name) {
        super(uuid, name);
        bPlayer = Bukkit.getPlayer(uuid);
    }

    @Override
    public boolean getAllowFlight() {
        return bPlayer.getAllowFlight();
    }

    @Override
    public String getDisplayName() {
        return bPlayer.getDisplayName();
    }

    @Override
    public GameMode getGameMode() {
        return Converter.transformGameMode(bPlayer.getGameMode());
    }

    @Override
    public void setAllowFlight(boolean allow) {
        bPlayer.setAllowFlight(allow);
    }
    
    @Override
    public void setDisplayName(String name) {
        bPlayer.setDisplayName(name);
    }

    @Override
    public void setGameMode(GameMode mode) {
        bPlayer.setGameMode(Converter.transformGameMode(mode));
    }

    @Override
    public void sendMessage(String msg) {
        bPlayer.sendMessage(msg);
    }
    
    @Override
    public Location getLocation() {
        return Converter.transformLocation(bPlayer.getLocation());
    }

    @Override
    public void damage(double amount) {
        bPlayer.damage(amount);
    }

    @Override
    public double getHealth() {
        return bPlayer.getHealth();
    }

    @Override
    public void setHealth(double health) {
        bPlayer.setHealth(health);
    }

    @Override
    public double getMaxHealth() {
        return bPlayer.getMaxHealth();
    }

    @Override
    public void setMaxHealth(double health) {
        bPlayer.setMaxHealth(health);
    }

    @Override
    public void teleport(Location newLoc) {
        bPlayer.teleport(Converter.transformLocation(newLoc));
    }

    @Override
    public int getHunger() {
        return bPlayer.getFoodLevel();
    }

    @Override
    public void setHunger(int hunger) {
        bPlayer.setFoodLevel(hunger);
    }

    @Override
    public float getSaturation() {
        return bPlayer.getSaturation();
    }

    @Override
    public void setSaturation(float saturation) {
        bPlayer.setSaturation(saturation);
    }
}
