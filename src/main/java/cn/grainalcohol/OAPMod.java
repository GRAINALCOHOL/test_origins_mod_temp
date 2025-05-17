package cn.grainalcohol;

import cn.grainalcohol.init.*;
import cn.grainalcohol.power.ActionOnEffectGainedPower;
import io.github.apace100.apoli.power.factory.PowerFactories;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OAPMod implements ModInitializer {
	public static final String MOD_ID = "oap";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path)
	{
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		OAPEntityConditionType.init();
		OAPBientityConditionType.init();
		OAPEntityActionType.init();
		OAPBientityActionType.init();
		OAPPowerType.init();
	}
}