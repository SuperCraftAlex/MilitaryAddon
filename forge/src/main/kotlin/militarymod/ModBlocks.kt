package militarymod

import militarymod.blocks.engine.JetEngineBlock
import militarymod.tabs.MilitaryTabs
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModBlocks {
    val REGISTRY: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MilitaryMod.MODID)

    // Debug:
    val DEBUG_JET_ENGINE by REGISTRY.registerObject("debug_jet_engine", ::JetEngineBlock)

    // val EXAMPLE_BLOCK by REGISTRY.registerObject("example_block") {
    //     Block(BlockBehaviour.Properties.of(Material.BAMBOO).lightLevel { 15 }.strength(3.0f))
    // }

    fun registerItems(items: DeferredRegister<Item>) {
        REGISTRY.entries.forEach {
            items.register(it.id.path) { BlockItem(it.get(), Item.Properties().tab(MilitaryTabs.TAB)) }
        }
    }
}