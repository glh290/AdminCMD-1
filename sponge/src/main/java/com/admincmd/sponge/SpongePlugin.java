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
package com.admincmd.sponge;

import com.admincmd.api.commands.CommandRegistry;
import com.admincmd.api.plugin.ACPlugin;
import com.admincmd.api.plugin.ServerSoftware;
import com.admincmd.core.AdminCMD;
import java.io.File;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.util.event.Subscribe;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> SpongePlugin.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
@Plugin(id = "AC", name = "AdminCMD", version = "1.0.0")
public class SpongePlugin implements ACPlugin {

    private Game game;

    @Subscribe
    public void onPreInitialization(PreInitializationEvent event) {
        AdminCMD.registerACPlugin(this);
        AdminCMD.onEnable();

    }

    @Subscribe
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Subscribe
    public void onServerStopping(ServerStoppingEvent event) {
        AdminCMD.onDisable();
    }

    @Override
    public File getDataFolder() {
        File folder = new File(".//" + File.separator + "AdminCMD");
        folder.mkdirs();
        return folder;
    }

    @Override
    public ServerSoftware getServerSoftware() {
        return ServerSoftware.SPONGE;
    }

    @Override
    public CommandRegistry getCommandRegistry() {
        return null;
    }
}
