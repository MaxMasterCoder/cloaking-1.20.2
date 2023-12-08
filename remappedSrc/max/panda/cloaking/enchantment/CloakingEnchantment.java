package max.panda.cloaking.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class CloakingEnchantment extends Enchantment {

    public CloakingEnchantment() {
        super(Enchantment.Rarity.VERY_RARE,
                EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[] {EquipmentSlot.HEAD});
    }
}
