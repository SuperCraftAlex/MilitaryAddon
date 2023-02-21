package militarymod.entities

import militarymod.MilitaryMod
import net.minecraft.world.entity.EntityType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries


object ModEntities {
    val REGISTRY: DeferredRegister<EntityType<*>>? = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MilitaryMod.ID)
}