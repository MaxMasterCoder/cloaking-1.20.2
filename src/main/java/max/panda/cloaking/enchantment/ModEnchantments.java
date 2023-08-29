package max.panda.cloaking.enchantment;

import max.panda.cloaking.CloakingMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModEnchantments {

    public static Enchantment CLOAKING = register("cloaking",
            new CloakingEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.ARMOR_HEAD, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(CloakingMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for "+CloakingMod.MOD_ID);
    }
}
