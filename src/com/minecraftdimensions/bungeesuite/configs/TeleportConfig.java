package com.minecraftdimensions.bungeesuite.configs;

import java.io.File;

import com.minecraftdimensions.bungeesuite.configlibrary.Config;

public class TeleportConfig {
	private static String configpath = File.separator+"plugins"+File.separator+"BungeeSuite"+File.separator+"teleport.yml";
	public static Config teleportConfig = new Config(configpath);
	public static int expireTime = teleportConfig.getInt("TeleportRequestExpireTime",
			10);
	public static int teleportTime = teleportConfig.getInt("TeleportWait", 5);
}
