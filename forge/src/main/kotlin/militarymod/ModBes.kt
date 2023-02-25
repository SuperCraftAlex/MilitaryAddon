package militarymod

import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ModBes {
    val REGISTRY: DeferredRegister<BlockEntityType<*>>? = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MilitaryMod.MODID)
}