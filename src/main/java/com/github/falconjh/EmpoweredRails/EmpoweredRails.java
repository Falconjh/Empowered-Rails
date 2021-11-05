package com.github.falconjh.EmpoweredRails;

import com.github.falconjh.EmpoweredRails.commands.EmpoweredRailCommand;
import com.github.falconjh.EmpoweredRails.config.EmpoweredRailsConfig;

import com.github.falconjh.EmpoweredRails.config.GsonUtil;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.Map;

public class EmpoweredRails implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("EmpoweredRails");
	public static EmpoweredRailsConfig config;
	public static Path configpath;
	@Override
	public void onInitialize() {
		configpath = net.fabricmc.loader.api.FabricLoader.getInstance().getConfigDir().resolve("EmpoweredRails.json");
		EmpoweredRailsConfig defaults = new EmpoweredRailsConfig();

		 config = GsonUtil.getcreateConfigFile(configpath,defaults, EmpoweredRailsConfig.class);
		if(config == null)
		{
			config = defaults;
		}
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> EmpoweredRailCommand.register(dispatcher));
	}
}
