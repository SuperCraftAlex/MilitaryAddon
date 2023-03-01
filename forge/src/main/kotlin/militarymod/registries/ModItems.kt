package militarymod.registries

import militarymod.MilitaryMod
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ModItems {
    val REGISTRY: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MilitaryMod.modId)

    fun register() {
        ModBlocks.registerItems(REGISTRY)
    }
}