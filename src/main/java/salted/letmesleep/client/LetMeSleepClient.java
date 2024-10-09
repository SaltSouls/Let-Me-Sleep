package salted.letmesleep.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import salted.letmesleep.LetMeSleep;

@Mod(value = LetMeSleep.MODID, dist = Dist.CLIENT)
public class LetMeSleepClient {
    public LetMeSleepClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
