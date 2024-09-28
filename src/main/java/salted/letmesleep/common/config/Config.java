package salted.letmesleep.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import salted.letmesleep.LetMeSleep;

public class Config implements IConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;

    static {
        Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = specPair.getLeft();
        COMMON_SPEC = specPair.getRight();
    }

    public static class CommonConfig {
        public final ForgeConfigSpec.BooleanValue MOB_CHECK;
        public final ForgeConfigSpec.BooleanValue BETTER_CHECKING;
        public final ForgeConfigSpec.IntValue VERTICAL_RANGE;
        public final ForgeConfigSpec.IntValue HORIZONTAL_RANGE;

        public CommonConfig(ForgeConfigSpec.Builder builder) {
            String modid = LetMeSleep.MODID;
            String CATEGORY_GENERAL = "general";
            builder.comment("General Settings").translation(modid + ".config." + "CATEGORY_GENERAL").push(CATEGORY_GENERAL);
            MOB_CHECK = builder
                    .comment("Should nearby monsters prevent sleep?")
                    .translation(modid + ".config." + "MOB_CHECK")
                    .define("monsterCheck", true);

            BETTER_CHECKING = builder
                    .comment("Should only monsters tracking the player prevent sleep? [Requires monsterCheck]")
                    .translation(modid + ".config." + "BETTER_CHECKING")
                    .define("betterChecking", true);
                    
            HORIZONTAL_RANGE = builder
                    .comment("Horizontal radius to check for monsters. [Requires betterChecking]")
                    .translation(modid + ".config." + "HORIZONTAL_RANGE")
                    .defineInRange("horizontalRange", () -> 32, 0, 256);

            VERTICAL_RANGE = builder
                    .comment("Vertical radius to check for monsters. [Requires betterChecking]")
                    .translation(modid + ".config." + "VERTICAL_RANGE")
                    .defineInRange("verticalRange", () -> 16, 0, 64);
            builder.pop();
        }
    }

}