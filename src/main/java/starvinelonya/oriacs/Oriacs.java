package starvinelonya.oriacs;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starvinelonya.oriacs.item.ModItems;

public class Oriacs implements ModInitializer {
	public static final String MOD_ID = "oriacs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize(){
		ModItems.registerModItems();

	}
}