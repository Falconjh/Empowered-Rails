package com.github.falconjh.FabricBlockUnderFastMinecart;

import com.github.falconjh.FabricBlockUnderFastMinecart.config.FabricBlockUnderFastMinecartConfig;

import com.github.falconjh.FabricBlockUnderFastMinecart.config.GsonUtil;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.Map;

public class FabricBlockUnderFastMinecart implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("FabricBlockUnderFastMinecart");
	public static FabricBlockUnderFastMinecartConfig config;
	@Override
	public void onInitialize() {
		Path configpath = net.fabricmc.loader.api.FabricLoader.getInstance().getConfigDir().resolve("FabricBlockUnderFastMinecart.json");
		FabricBlockUnderFastMinecartConfig defaults = new FabricBlockUnderFastMinecartConfig();

		 config = GsonUtil.getcreateConfigFile(configpath,defaults, FabricBlockUnderFastMinecartConfig.class);
		if(config == null)
		{
			config = defaults;
		}
	}
}
