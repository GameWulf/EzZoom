package net.dark_roleplay.toy_trains.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EzZoomConfig {

	public static ForgeConfigSpec CLIENT_SPECS;

	public static ForgeConfigSpec.BooleanValue ADVANCED_ZOOM;

	public static ForgeConfigSpec.DoubleValue SIMPLE_ZOOM_STRENGTH, SIMPLE_ZOOM_MOUSE_SENS;
	public static ForgeConfigSpec.DoubleValue ADV_ZOOM_STRENGTH_MIN, ADV_ZOOM_STRENGTH_MAX;
	public static ForgeConfigSpec.DoubleValue ADV_ZOOM_MOUSE_SENS_MIN, ADV_ZOOM_MOUSE_SENS_MAX;
	public static ForgeConfigSpec.IntValue ADV_ZOOM_STEPS;

	static {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		ADVANCED_ZOOM = builder
				.comment("Enable \"advanced\" zoom, which requires you to push a button, and use the scroll wheel to zoom in/out")
				.define("EnableAdvancedZoom", false);

		builder.comment("Simple zoom settings (used if advanced zoom is disabled").push("SimpleZoom");
		SIMPLE_ZOOM_STRENGTH = builder
				.comment("Set to 1.0 for maximal zoom, or 0.0 for no zoom at all")
				.defineInRange("ZoomStrength", 1.0F, 0.0F, 1.0F);
		SIMPLE_ZOOM_MOUSE_SENS = builder
				.comment("Set by how much % your mouse sensitivy will be decreased during zooming")
				.defineInRange("ZoomMouseSensitivity", 0.25F, 0.0F, 1.0F);
		builder.pop();

		builder.comment("Advanced zoom settings (used if advanced zoom is enabled").push("AdvancedZoom");
		ADV_ZOOM_STRENGTH_MIN = builder
				.comment("Minimal zoom")
				.defineInRange("ZoomStrengthMin", 0.25F, 0.0F, 1.0F);
		ADV_ZOOM_STRENGTH_MAX = builder
				.comment("Maximal zoom")
				.defineInRange("ZoomStrengthMax", 1F, 0.0F, 1.0F);
		ADV_ZOOM_MOUSE_SENS_MIN = builder
				.comment("Minimal Mouse sensitivity lowering")
				.defineInRange("ZoomMouseSensitivityMin", 0.02F, 0.0F, 1.0F);
		ADV_ZOOM_MOUSE_SENS_MAX = builder
				.comment("Maximal mouse sensitivity lowering")
				.defineInRange("ZoomMouseSensitivityMax", 0.25F, 0.0F, 1.0F);
		ADV_ZOOM_STEPS = builder
				.comment("The amount of zooming steps you'll have")
				.defineInRange("ZoomSteps", 4, 2, 100);
		builder.pop();

		CLIENT_SPECS = builder.build();
	}

	@SubscribeEvent
	public static void configChange(ModConfig.Reloading event){
		System.out.println("ALERT");
	}
}
