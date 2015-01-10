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

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> IACPlugin.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class IACPlugin implements ACPlugin {

    private final ACPlugin plugin;
    private static ACPlugin INSTANCE;
    private final ServerSoftware software;

    public IACPlugin(ACPlugin plugin, ServerSoftware software) {
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
}
