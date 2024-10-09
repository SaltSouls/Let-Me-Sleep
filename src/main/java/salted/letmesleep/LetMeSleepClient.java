package salted.letmesleep;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = LetMeSleep.MODID, dist = Dist.CLIENT)
public class LetMeSleepClient {
    public LetMeSleepClient(ModContainer container) {
        container.registerExtensionPoint(
            net.neoforged.neoforge.client.gui.IConfigScreenFactory.class,
            net.neoforged.neoforge.client.gui.ConfigurationScreen::new);
    }
}
