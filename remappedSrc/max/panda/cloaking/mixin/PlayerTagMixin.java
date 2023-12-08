package max.panda.cloaking.mixin;

import max.panda.cloaking.enchantment.ModEnchantments;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= EntityRenderer.class, priority = 2000)
public abstract class PlayerTagMixin<T extends Entity> {

    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    private void doNotRender(T entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        if (entity instanceof PlayerEntity) {
            if (CloakingOn(entity)) {
                ci.cancel();
            }
        }
    }

    @Unique
    private boolean CloakingOn(Entity entity) {
        ItemStack itemStack = ((PlayerEntity) entity).getEquippedStack(EquipmentSlot.HEAD);
        if (itemStack.isEmpty()) {
            return false;
        }
        return EnchantmentHelper.getLevel(ModEnchantments.CLOAKING, itemStack) != 0;
    }
}
