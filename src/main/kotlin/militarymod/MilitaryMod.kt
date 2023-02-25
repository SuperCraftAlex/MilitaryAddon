package militarymod

import com.mojang.logging.LogUtils
import militarymod.blockentities.ModBE
import militarymod.blocks.ModBlocks
import militarymod.entities.ModEntities
import militarymod.items.ModItems
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import org.valkyrienskies.core.impl.config.VSConfigClass
import thedarkcolour.kotlinforforge.forge.MOD_BUS


@Mod("military")
class MilitaryMod {
    init {
        ModBE.REGISTRY?.register(MOD_BUS)
        ModEntities.REGISTRY?.register(MOD_BUS)
        ModItems.REGISTRY.register(MOD_BUS)
        ModBlocks.REGISTRY.register(MOD_BUS)

        ModItems.REGISTRY.register(MOD_BUS)
        ModItems.register()

        ModEntities.REGISTRY?.register(MOD_BUS)

        MinecraftForge.EVENT_BUS.register(this)

        VSConfigClass.registerConfig("military", MilitaryConfig::class.java)

    }

    companion object {
        const val modId = "military"
        val LOGGER = LogUtils.getLogger()
    }
}
