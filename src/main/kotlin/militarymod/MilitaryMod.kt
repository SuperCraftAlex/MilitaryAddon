package militarymod

import com.mojang.logging.LogUtils
import militarymod.blocks.ModBlocks
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod("military")
class MilitaryMod {
    init {

        ModBlocks.REGISTRY.register(MOD_BUS)
        MinecraftForge.EVENT_BUS.register(this)
    }

    companion object {
        val modId = "military"
        private val LOGGER = LogUtils.getLogger()
    }
}
