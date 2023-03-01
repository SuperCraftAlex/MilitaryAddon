package militarymod

import net.minecraft.resources.ResourceLocation

fun mil(path: String) = ResourceLocation(MilitaryMod.modId, path)
fun mc(path: String) = ResourceLocation("minecraft", path)
fun forge(path: String) = ResourceLocation("forge", path)
