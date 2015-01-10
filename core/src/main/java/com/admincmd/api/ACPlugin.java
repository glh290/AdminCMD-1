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
package com.admincmd.api;

import com.admincmd.api.player.Player;
import com.admincmd.core.IACPlugin;
import com.admincmd.core.ServerSoftware;
import java.util.UUID;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> ACPlugin.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class ACPlugin implements IACPlugin {

    private final IACPlugin plugin;
    private static ACPlugin INSTANCE;
    private final ServerSoftware software;

    public ACPlugin(IACPlugin plugin, ServerSoftware software) {
        INSTANCE = this;
        this.plugin = plugin;
        this.software = software;
    }

    @Override
    public void onPluginEnable() {
        plugin.onPluginEnable();
    }

    @Override
    public void onPluginDisable() {
        plugin.onPluginDisable();
    }

    public ServerSoftware getServerSoftware() {
        return this.software;
    }

    public static ACPlugin getInstance() {
        return INSTANCE;
    }

    @Override
    public Player getPlayer(UUID uuid) {
        return plugin.getPlayer(uuid);
    }

}
