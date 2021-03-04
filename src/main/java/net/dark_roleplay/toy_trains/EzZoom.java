package net.dark_roleplay.toy_trains;

import net.dark_roleplay.toy_trains.client.EzZoomClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EzZoom.MODID)
public class EzZoom {

	public static final String MODID = "ezzoom";
	public static final Logger LOG = LogManager.getLogger(MODID);

	public EzZoom() {
		DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> EzZoomClient::modConstructorInit);
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(
				() -> "1.0",
				(version, isRemote) -> true
		));
	}
}
