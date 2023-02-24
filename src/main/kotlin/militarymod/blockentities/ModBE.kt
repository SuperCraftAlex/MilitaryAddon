package militarymod.blockentities

import militarymod.MilitaryMod
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModBE {
    val REGISTRY: DeferredRegister<BlockEntityType<*>>? = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MilitaryMod.modId)
}