/*
 * Copyright 2015 Joey Peter.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.admincmd.core;

import com.admincmd.api.ACPlugin;
import com.admincmd.api.player.Player;
import com.admincmd.core.player.IPlayer;
import java.util.UUID;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> BukkitPlugin.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class BukkitPlugin extends JavaPlugin implements IACPlugin {

    private ACPlugin acp;

    @Override
    public void onEnable() {
        acp = new ACPlugin(this, ServerSoftware.BUKKIT);
        acp.onPluginEnable();
    }

    @Override
    public void onDisable() {
        acp.onPluginDisable();
    }

    @Override
    public void onPluginEnable() {
        //enabling code here
    }

    @Override
    public void onPluginDisable() {
        //disabling code here
    }

    @Override
    public Player getPlayer(UUID uuid) {
        org.bukkit.entity.Player player = getServer().getPlayer(uuid);
        return new IPlayer(player.getName(), player.getUniqueId());
    }

}
