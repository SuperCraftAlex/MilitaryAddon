package militarymod.blocks

import militarymod.MilitaryMod
import militarymod.blocks.engine.JetEngine
import militarymod.blocks.engine.JetEngineAirDuct
import militarymod.tabs.MilitaryTabs
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModBlocks {
    val REGISTRY: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MilitaryMod.modId)


    // val EXAMPLE_BLOCK by REGISTRY.registerObject("example_block") {
    //     Block(BlockBehaviour.Properties.of(Material.BAMBOO).lightLevel { 15 }.strength(3.0f))
    // }

    fun registerItems(items: DeferredRegister<Item>) {
        REGISTRY.entries.forEach {
            items.register(it.id.path) { BlockItem(it.get(), Item.Properties().tab(MilitaryTabs.TEST_TAB)) }
        }
    }
}