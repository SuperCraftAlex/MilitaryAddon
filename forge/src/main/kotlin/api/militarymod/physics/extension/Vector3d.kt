package api.militarymod.physics.extension

import de.m_marvin.univec.impl.Vec3d
import org.joml.Vector3d
import org.joml.Vector3dc

fun Vector3d.conv() : Vec3d {
    return Vec3d(this)
}

fun Vector3dc.conv() : Vec3d {
    return Vec3d(this)
}