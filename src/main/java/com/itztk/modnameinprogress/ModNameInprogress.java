package com.itztk.modnameinprogress;

import com.itztk.modnameinprogress.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModNameInprogress implements ModInitializer {
	public static final String MOD_ID = "modnameinprogress";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Mod Name In Progress, in progress");
		ModItems.initalize();

	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
