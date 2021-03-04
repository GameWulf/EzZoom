package net.dark_roleplay.toy_trains.client;

import net.dark_roleplay.toy_trains.EzZoom;
import net.dark_roleplay.toy_trains.config.EzZoomConfig;
import net.minecraft.util.math.MathHelper;
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
		if(!EzZoomClient.shouldZoom()) return;

		if(EzZoomConfig.ADVANCED_ZOOM.get()){
			event.setNewfov((float) MathHelper.lerp(
					(EzZoomClient.currentZoomStep()+1)/EzZoomConfig.ADV_ZOOM_STEPS.get(),
					EzZoomConfig.ADV_ZOOM_STRENGTH_MAX.get(),
					EzZoomConfig.ADV_ZOOM_STRENGTH_MIN.get())
			);
		}else {
			event.setNewfov(0);
		}
	}

	@SubscribeEvent
	public static void detectScroll(InputEvent.MouseScrollEvent event){
		if(EzZoomClient.shouldZoom() && EzZoomConfig.ADVANCED_ZOOM.get()){
			if(event.getScrollDelta() > 0)
				EzZoomClient.increaseZoomStep();
			else
				EzZoomClient.decreaseZoomStep();
			event.setCanceled(true);
		}
	}
}
