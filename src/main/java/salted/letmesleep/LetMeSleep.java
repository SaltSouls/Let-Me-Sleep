package salted.letmesleep;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import salted.letmesleep.common.config.Config;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LetMeSleep.MODID)
public class LetMeSleep {
    public static final String MODID = "letmesleep";
    public static final Logger LOGGER = LogManager.getLogger();

    public LetMeSleep() {
        ModLoadingContext ctx = ModLoadingContext.get();
        ctx.registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);
    }

    public static ResourceLocation resLoc(String path) {
        return new ResourceLocation(MODID, path);
    }
}
