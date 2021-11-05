package com.tristanandrew.emeralditems;

import com.tristanandrew.emeralditems.init.ModItemGroups;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import java.util.function.Supplier;

@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new SwordItem(ModItemTier.EMERALDTOOLS, 0, -2.4f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName("emerald_sword"));
        event.getRegistry().register(new AxeItem(ModItemTier.EMERALDTOOLS, 2, -3.0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName("emerald_axe"));
        event.getRegistry().register(new HoeItem(ModItemTier.EMERALDTOOLS, 0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName("emerald_hoe"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.EMERALDTOOLS, -2, -2.8F, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName("emerald_pickaxe"));
        event.getRegistry().register(new ShovelItem(ModItemTier.EMERALDTOOLS, -1.5F, -3F, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName("emerald_shovel"));
    }

    // Implements IItemTier interface
    public enum ModItemTier implements IItemTier
    {
        EMERALDTOOLS(4, 1562, 15.0f, 7, 250, () -> {
                return Ingredient.fromItems(Items.EMERALD);
        });
        private final int HARVESTLEVEL;
        private final int MAXUSES;
        private final float EFFICIENCY;
        private final float ATTACKDAMAGE;
        private final int ENCHANTABILITY;
        private final LazyValue<Ingredient> REPAIRMATERIAL;

        ModItemTier(int harvestLevel, int maxUses, float efficiency,
                            float attackDamage, int enchantability,
                            Supplier<Ingredient> repairMaterial){
            HARVESTLEVEL = harvestLevel;
            MAXUSES = maxUses;
            EFFICIENCY = efficiency;
            ATTACKDAMAGE = attackDamage;
            ENCHANTABILITY= enchantability;
            REPAIRMATERIAL = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getHarvestLevel() {
            return HARVESTLEVEL;
        }
        @Override
        public int getMaxUses() {
            return MAXUSES;
        }
        @Override
        public float getEfficiency() {
            return EFFICIENCY;
        }
        @Override
        public float getAttackDamage() {
            return ATTACKDAMAGE;
        }
        @Override
        public int getEnchantability() {
            return ENCHANTABILITY;
        }
        @Override
        public Ingredient getRepairMaterial() {
            return REPAIRMATERIAL.getValue();
        }
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(Main.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }
}
