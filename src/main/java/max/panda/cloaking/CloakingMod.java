package max.panda.cloaking;

import max.panda.cloaking.enchantment.ModEnchantments;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloakingMod implements ModInitializer {

	public static final String MOD_ID = "cloaking";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Commencing CloakingMod");
		ModEnchantments.registerModEnchantments();
	}

}