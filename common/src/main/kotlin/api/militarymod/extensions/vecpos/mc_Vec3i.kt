package api.militarymod.extensions.vecpos

import net.minecraft.core.Vec3i

fun Vec3i.conv() : de.m_marvin.univec.impl.Vec3i {
    return de.m_marvin.univec.impl.Vec3i(x, y, z)
}

fun Vec3i.convD() : de.m_marvin.univec.impl.Vec3d {
    return de.m_marvin.univec.impl.Vec3d(x.toDouble(), y.toDouble(), z.toDouble())
}