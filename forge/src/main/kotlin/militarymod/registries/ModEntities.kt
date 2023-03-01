package militarymod.registries

import militarymod.MilitaryMod
import net.minecraft.world.entity.EntityType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries


object ModEntities {
    val REGISTRY: DeferredRegister<EntityType<*>>? = DeferredRegister.create(ForgeRegistries.ENTITIES,
        MilitaryMod.modId
    )
}