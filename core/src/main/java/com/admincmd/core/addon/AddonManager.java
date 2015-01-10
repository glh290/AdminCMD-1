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
package com.admincmd.core.addon;

import com.admincmd.api.addon.Addon;
import com.admincmd.core.AdminCMD;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * <strong>Project:</strong> core <br>
 * <strong>File:</strong> AddonManager.java
 *
 * @author <a href="http://jpeter.redthirddivision.com">TheJeterLP</a>
 */
public class AddonManager {

    private static Map<String, Addon> addons;

    public static void init() {
        addons = new HashMap<>();
        File addonFolder = new File(AdminCMD.getACPlugin().getDataFolder(), "addons");
        addonFolder.mkdirs();

        for (File jarFile : addonFolder.listFiles()) {
            if (!jarFile.getName().endsWith(".jar") || !jarFile.isFile()) continue;
        }
    }

}
