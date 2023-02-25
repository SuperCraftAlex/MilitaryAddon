package militarymod.tabs

import militarymod.MilitaryMod
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Blocks

object MilitaryTabs {

    private val tk = MilitaryMod.MODID+"."

    val TAB = object : CreativeModeTab(tk+"tab") {
        override fun makeIcon(): ItemStack {
            return ItemStack(Blocks.IRON_BLOCK)
        }
    }

}