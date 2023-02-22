package militarymod

import com.mojang.logging.LogUtils
import militarymod.blocks.ModBlocks
import militarymod.entities.ModEntities
import militarymod.items.ModItems
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod("military")
class MilitaryMod {
    init {

        ModEntities.REGISTRY?.register(MOD_BUS)
        ModItems.REGISTRY.register(MOD_BUS)
        ModBlocks.REGISTRY.register(MOD_BUS)
        MinecraftForge.EVENT_BUS.register(this)
    }

    companion object {
        val modId = "military"
        private val LOGGER = LogUtils.getLogger()
    }
}
