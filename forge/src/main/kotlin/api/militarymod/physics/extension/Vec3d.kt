package api.militarymod.physics.extension

import de.m_marvin.univec.impl.Vec3d
import net.minecraft.core.BlockPos

fun Vec3d.blockPos() : BlockPos {
    return BlockPos(x,y,z)
}