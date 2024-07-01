package starvinelonya.oriacs.recipe;
/**
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import com.google.gson.JsonObject;

import java.util.List;

public class LandwalkingRepair implements Recipe<CraftingInventory> {
    public static class Type implements RecipeType<CraftingRecipe>{}

    private final Ingredient inputA;
    private final Ingredient inputB;
    private final ItemStack result;
    private final Identifier id;

    public LandwalkingRepair(Identifier id, ItemStack result, Ingredient inputA, Ingredient inputB) {
        this.id = id;
        this.inputA = inputA;
        this.inputB = inputB;
        this.result = result;
    }

    public Ingredient getInputA() {
        return this.inputA;
    }

    public Ingredient getInputB() {
        return this.inputB;
    }

    public ItemStack getOutput() {
        return this.result;
    }
    class LandwalkingRepairJsonFormat {
        JsonObject inputA;
        JsonObject inputB;
        String outputItem;
        int outputAmount;
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        return false;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory, DynamicRegistryManager registryManager) {
        return this.getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }


    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return null;
    }

    @Override
    public Identifier getId() {
        return null;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return LandwalkingRepairSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

    public static class LandwalkingRepairSerializer implements RecipeSerializer<LandwalkingRepair>{
        private LandwalkingRepairSerializer(){

        }

        public static final LandwalkingRepairSerializer INSTANCE = new LandwalkingRepairSerializer();
        public static final Identifier ID = new Identifier("oriacs:landwalking_repair");
        @Override
        public LandwalkingRepair read(Identifier id, JsonObject json) {
            LandwalkingRepairJsonFormat recipeJson = new Gson().fromJson(json, LandwalkingRepairJsonFormat.class);
            if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.outputItem == null) {
                throw new JsonSyntaxException("A required attribute is missing!");
            }
            if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

            Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
            Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
            Item outputItem = Registries.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                    .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
            ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);

            return new LandwalkingRepair(id, output, inputA, inputB);

        }

        @Override
        public LandwalkingRepair read(Identifier id, PacketByteBuf buf) {
            Ingredient inputA = Ingredient.fromPacket(buf);
            Ingredient inputB = Ingredient.fromPacket(buf);
            ItemStack output = buf.readItemStack();
            return new LandwalkingRepair(id, output, inputA, inputB);        }

        @Override
        public void write(PacketByteBuf buf, LandwalkingRepair recipe) {
            recipe.getInputA().write(buf);
            recipe.getInputB().write(buf);
            buf.writeItemStack(recipe.getOutput());
        }
    }
}
 **/
