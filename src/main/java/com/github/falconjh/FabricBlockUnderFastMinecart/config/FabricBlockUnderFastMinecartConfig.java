package com.github.falconjh.FabricBlockUnderFastMinecart.config;

import com.google.gson.reflect.TypeToken;

import java.util.*;

public class FabricBlockUnderFastMinecartConfig {

	public Map<String, Double> blocks = new HashMap<String, Double>();
	public FabricBlockUnderFastMinecartConfig() {
		blocks.put("minecraft:gold_block", 16.0);
		blocks.put("minecraft:iron_block", 30.0);
		blocks.put("minecraft:diamond_block", 30.0);
		blocks.put("minecraft:soul_sand", 6.0);
		blocks.put("minecraft:emerald_block", 30.0);
		blocks.put("minecraft:redstone_block", 30.0);
	}
	public FabricBlockUnderFastMinecartConfig(HashMap<String, Double> inblocks)
	{
		blocks = inblocks;
	}

}
