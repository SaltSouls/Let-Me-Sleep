package salted.letmesleep.common.events;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.CanContinueSleepingEvent;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;
import salted.letmesleep.LetMeSleep;
import salted.letmesleep.common.Config;

import java.util.List;

@EventBusSubscriber(modid = LetMeSleep.MODID, bus = EventBusSubscriber.Bus.GAME)
public class SleepEvents {

    @SubscribeEvent
    public static void onPlayerSleep(CanPlayerSleepEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        /* replacing the vanilla sleep check with my own.
         * while I don't like this, it seems like the best method. */
        if (level.isClientSide()) return;
        if (level.isDay()) event.setProblem(event.getVanillaProblem());
        else if (Config.MOB_CHECK.get()) {

            if (Config.BETTER_CHECKING.get()) {
                if (noMonstersNear(level, player)) event.setProblem(null);
                else event.setProblem(event.getVanillaProblem());
            }
            else event.setProblem(event.getVanillaProblem());
        }
        else event.setProblem(null);
    }

    @SubscribeEvent
    public static void canContinueSleeping(CanContinueSleepingEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();

        if (!entity.isSleeping()) return;
        boolean canSleep = event.mayContinueSleeping();

        if (level.isClientSide()) return;
        if (!(entity instanceof Player player)) {
            event.setContinueSleeping(canSleep);
            return;
        }
        else if (!Config.MOB_CHECK.get() || !Config.BETTER_CHECKING.get() || !canSleep) return;
        long time = level.getGameTime();

        if (time % 10 != 0) return;
        if (noMonstersNear(level, player)) return;

        event.setContinueSleeping(false);
        player.displayClientMessage(Component.translatable(LetMeSleep.MODID + ".sleep.not_safe"), true);
    }

    private static boolean noMonstersNear(Level level, Player player) {
        int h = Config.HORIZONTAL_RANGE.getAsInt();
        int v = Config.VERTICAL_RANGE.getAsInt();
        Vec3 vec3 = Vec3.atBottomCenterOf(player.getOnPos());
        AABB bounds = new AABB(vec3.x() - h, vec3.y() - v, vec3.z() - h, vec3.x() + h, vec3.y() + v, vec3.z() + h);

        List<Monster> list = level.getEntitiesOfClass(Monster.class, bounds, monster -> monster.getTarget() == player);
        return list.isEmpty();
    }

}
