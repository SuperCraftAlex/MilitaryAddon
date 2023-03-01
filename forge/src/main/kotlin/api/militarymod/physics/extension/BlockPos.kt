package api.militarymod.physics.extension

import de.m_marvin.univec.impl.Vec3d
import de.m_marvin.univec.impl.Vec3i
import net.minecraft.core.BlockPos

fun BlockPos.conv() : Vec3i {
    return Vec3i(x,y,z)
}

fun BlockPos.convD() : Vec3d {
    return Vec3d(x.toDouble(),y.toDouble(),z.toDouble())
}