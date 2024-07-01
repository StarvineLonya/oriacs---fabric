package starvinelonya.oriacs.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import starvinelonya.oriacs.Oriacs;

public class ModItems {

    public static final Item UMBRELLA = registerItem("umbrella",new Item(new FabricItemSettings().maxCount(1)));


    public static final Item DIVING_HELMET = registerItem("diving_helmet",
            new ArmorItem(ModArmorMaterials.DIVING, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item LANDWALKING_HELMET = registerItem("landwalking_helmet",
            new ArmorItem(ModArmorMaterials.LANDWALKING, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item CHAINMEMBRANE_HELMET = registerItem("chainmembrane_helmet",
            new ArmorItem(ModArmorMaterials.CHAINMEMBRANE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item CHAINMEMBRANE_CHESTPLATE = registerItem("chainmembrane_chestplate",
            new ArmorItem(ModArmorMaterials.CHAINMEMBRANE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item CHAINMEMBRANE_LEGGINGS = registerItem("chainmembrane_leggings",
            new ArmorItem(ModArmorMaterials.CHAINMEMBRANE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item CHAINMEMBRANE_BOOTS = registerItem("chainmembrane_boots",
            new ArmorItem(ModArmorMaterials.CHAINMEMBRANE, ArmorItem.Type.BOOTS, new FabricItemSettings()));



    private static void addItemToolGroup(FabricItemGroupEntries entries){
        entries.add(UMBRELLA);
    }

    private static void addItemCombatGroup(FabricItemGroupEntries entries){
        entries.add(DIVING_HELMET);
        entries.add(LANDWALKING_HELMET);
        entries.add(CHAINMEMBRANE_HELMET);
        entries.add(CHAINMEMBRANE_CHESTPLATE);
        entries.add(CHAINMEMBRANE_LEGGINGS);
        entries.add(CHAINMEMBRANE_BOOTS);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Oriacs.MOD_ID, name),item);
    }
    public static void registerModItems(){
        Oriacs.LOGGER.info("Registering mod items for" + Oriacs.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemToolGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemCombatGroup);

    }
}

