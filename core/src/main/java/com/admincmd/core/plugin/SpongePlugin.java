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
package com.admincmd.core.plugin;

import com.admincmd.plugin.ACPlugin;
import com.admincmd.plugin.ServerSoftware;
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

    private IACPlugin acp;

    @Subscribe
    public void onPreInitialization(PreInitializationEvent event) {
        acp = new IACPlugin(this, ServerSoftware.CANARY);
        acp.onPluginEnable();

    }

    @Subscribe
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Subscribe
    public void onServerStopping(ServerStoppingEvent event) {
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
}
