package com.tristanandrew.emeralditems.init;

import com.tristanandrew.emeralditems.Main;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups
{
    public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(Main.MODID,
            () -> new ItemStack(ModItems.emerald_sword));

    public static class ModItemGroup extends ItemGroup
    {
        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }

    }
}

