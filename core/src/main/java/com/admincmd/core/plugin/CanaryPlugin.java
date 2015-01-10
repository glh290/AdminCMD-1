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
import net.canarymod.plugin.Plugin;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> CanaryPlugin.java
 * 
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class CanaryPlugin extends Plugin implements ACPlugin {

    private IACPlugin acp;
    
    @Override
    public boolean enable() {
        acp = new IACPlugin(this, ServerSoftware.CANARY);
        acp.onPluginEnable();
        return true;
    }

    @Override
    public void disable() {
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
