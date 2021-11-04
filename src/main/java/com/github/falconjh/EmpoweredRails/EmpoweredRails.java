package com.github.falconjh.EmpoweredRails;

import com.github.falconjh.EmpoweredRails.config.EmpoweredRailsConfig;

import com.github.falconjh.EmpoweredRails.config.GsonUtil;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.Map;

public class EmpoweredRails implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("EmpoweredRails");
	public static EmpoweredRailsConfig config;
	@Override
	public void onInitialize() {
		Path configpath = net.fabricmc.loader.api.FabricLoader.getInstance().getConfigDir().resolve("EmpoweredRails.json");
		EmpoweredRailsConfig defaults = new EmpoweredRailsConfig();

		 config = GsonUtil.getcreateConfigFile(configpath,defaults, EmpoweredRailsConfig.class);
		if(config == null)
		{
			config = defaults;
		}
	}
}
