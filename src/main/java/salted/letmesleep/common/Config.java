package salted.letmesleep.common;

import net.neoforged.neoforge.common.ModConfigSpec;
import salted.letmesleep.LetMeSleep;

public class Config {
    public static ModConfigSpec COMMON_CONFIG;

    public static ModConfigSpec.BooleanValue MOB_CHECK;
    public static ModConfigSpec.BooleanValue BETTER_CHECKING;
    public static ModConfigSpec.IntValue VERTICAL_RANGE;
    public static ModConfigSpec.IntValue HORIZONTAL_RANGE;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

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

        COMMON_CONFIG = builder.build();
    }

}