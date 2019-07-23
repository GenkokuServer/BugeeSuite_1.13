package com.minecraftdimensions.bungeesuite.configs;

import com.minecraftdimensions.bungeesuite.configlibrary.Config;
import net.md_5.bungee.api.ProxyServer;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TeleportConfig {
    private static String configpath = File.separator + "plugins" + File.separator + "BungeeSuite" + File.separator + "teleport.yml";
    public static Config teleportConfig = new Config(configpath);
    public static int expireTime = teleportConfig.getInt("TeleportRequestExpireTime",
            10);
    public static int teleportTime = teleportConfig.getInt("TeleportWait", 5);
    public static List<List<String>> allowServerGroup = new ArrayList<>();

    public static void reload() {
        teleportConfig = new Config(configpath);
        expireTime = teleportConfig.getInt("TeleportRequestExpireTime", 10);
        teleportTime = teleportConfig.getInt("TeleportWait", 5);
        List<String> defList = Collections.singletonList(StringUtils.join(ProxyServer.getInstance().getServers().keySet(), ", "));
        teleportConfig.getListString("TeleportServerGroup", defList).forEach(e -> allowServerGroup.add(Arrays.asList(e.split(", "))));
    }
}
