package net.dark_roleplay.toy_trains.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

public class EzZoomClient {

	public static KeyBinding ZOOM = new KeyBinding("key.ezzoom.zoom", KeyConflictContext.IN_GAME, InputMappings.getInputByCode(GLFW.GLFW_KEY_Z, 0), "key.categories.misc");

	public static boolean shouldZoom = false;
	public static double initialMouseSens = 0;

	public static void modConstructorInit(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(EzZoomClient::registerKeybinds);
	}

	public static void registerKeybinds(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(ZOOM);
	}

	public static void startZoom(){
		shouldZoom = true;
		initialMouseSens = Minecraft.getInstance().gameSettings.mouseSensitivity;
		Minecraft.getInstance().gameSettings.mouseSensitivity = Math.max(0, Minecraft.getInstance().gameSettings.mouseSensitivity - 0.3);
	}

	public static void stopZoom(){
		shouldZoom = false;
		Minecraft.getInstance().gameSettings.mouseSensitivity = initialMouseSens;
	}

	public static boolean shouldZoom() {
		return shouldZoom;
	}
}
