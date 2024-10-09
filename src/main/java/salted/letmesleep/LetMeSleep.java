package salted.letmesleep;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import salted.letmesleep.common.Config;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LetMeSleep.MODID)
public class LetMeSleep {
    public static final String MODID = "letmesleep";
    public static final Logger LOGGER = LogManager.getLogger();

    public LetMeSleep(ModContainer container) {
        container.registerConfig(net.neoforged.fml.config.ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    }

    public static ResourceLocation resLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
