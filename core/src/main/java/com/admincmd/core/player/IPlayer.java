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
package com.admincmd.core.player;

import com.admincmd.api.player.Player;
import java.util.UUID;
import org.bukkit.Location;

/**
 * <strong>Project:</strong> AdminCMD-Core <br>
 * <strong>File:</strong> IPlayer.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class IPlayer implements Player {

    public IPlayer(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    private final String name;
    private final UUID uuid;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }

    @Override
    public void teleport(Location loc) {
    }
}
