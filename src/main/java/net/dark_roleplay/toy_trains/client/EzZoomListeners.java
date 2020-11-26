package net.dark_roleplay.toy_trains.client;

import net.dark_roleplay.toy_trains.EzZoom;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EzZoom.MODID, value = Dist.CLIENT)
public class EzZoomListeners {

	private static boolean zoomed = false;

	@SubscribeEvent
	public static void keyListeners(InputEvent.KeyInputEvent event){
		if(EzZoomClient.ZOOM.isKeyDown() && !zoomed){
			if(!zoomed){
				zoomed = true;
				EzZoomClient.startZoom();
			}
		}else if(!EzZoomClient.ZOOM.isKeyDown() && zoomed){
			zoomed = false;
			EzZoomClient.stopZoom();
		}
	}


	@SubscribeEvent
	public static void updateFOV(FOVUpdateEvent event){
		if(EzZoomClient.shouldZoom())
			event.setNewfov(0);
	}
}
