package salted.letmesleep.common.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import salted.letmesleep.common.config.IConfig;

import java.util.List;
import java.util.function.Predicate;

@Mixin(ServerPlayer.class)
public abstract class CanSleepCheckServerPlayerMixin {

    @WrapOperation(method = "startSleepInBed", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;isCreative()Z"))
    public boolean monsterCheck(ServerPlayer player, Operation<Boolean> original) {
        return original.call(player) || !IConfig.getMobCheck();
    }

    @WrapOperation(method = "startSleepInBed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"))
    public List betterCheck(Level level, Class<Monster> clazz, AABB aabb, Predicate<Monster> predicate, Operation<List<Monster>> original) {
        ServerPlayer player = (ServerPlayer) (Object) this;
        int h = IConfig.getHorizontalRange();
        int v = IConfig.getVerticalRange();
        Vec3 vec3 = Vec3.atBottomCenterOf(player.getOnPos());
        AABB bounds = new AABB(vec3.x() - h, vec3.y() - v, vec3.z() - h, vec3.x() + h, vec3.y() + v, vec3.z() + h);

        if (IConfig.getBetterChecking()) return original.call(level, clazz, bounds, predicate.and(monster -> monster.getTarget() == player));
        return original.call(level, clazz, aabb, predicate);
    }

}
