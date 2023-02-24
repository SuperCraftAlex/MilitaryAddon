package militarymod.tabs;

import militarymod.MilitaryMod;
import militarymod.blocks.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MilitaryTabs {

    public static CreativeModeTab TEST_TAB = new CreativeModeTab("test_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.INSTANCE.getTEST_JET_ENGINE().get().asItem());
        }

        @Override
        public Component getDisplayName() {
            return new TranslatableComponent("itemGroup." + String.format("%s.%s", MilitaryMod.modId, "test_tab"));
        }
    };

}
