package salted.letmesleep.common.config;

import java.util.HashSet;
import java.util.Map;

import static salted.letmesleep.common.config.Config.COMMON;

public interface IConfig {

    static boolean getMobCheck() {
        return COMMON.MOB_CHECK.get();
    }

    static boolean getBetterChecking() {
        return COMMON.BETTER_CHECKING.get();
    }

    static int getVerticalRange() {
        return COMMON.VERTICAL_RANGE.get();
    }

    static int getHorizontalRange() {
        return COMMON.HORIZONTAL_RANGE.get();
    }
    
}
