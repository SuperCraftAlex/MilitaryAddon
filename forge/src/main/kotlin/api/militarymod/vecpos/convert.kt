package api.militarymod.vecpos

import net.minecraft.core.BlockPos
import net.minecraft.core.Vec3i
import org.joml.Vector3d
import org.joml.Vector3f
import org.joml.Vector3i

// Minecraft BlockPos
fun BlockPos.convD() : Vector3d = Vector3d(
        x.toDouble(),
        y.toDouble(),
        z.toDouble()
)

fun BlockPos.convI() : Vector3i = Vector3i(
    x,
    y,
    z
)

fun BlockPos.convF() : Vector3f = Vector3f(
    x.toFloat(),
    y.toFloat(),
    z.toFloat()
)

// Minecraft Core Vec3i
fun Vec3i.convD() : Vector3d = Vector3d(
    x.toDouble(),
    y.toDouble(),
    z.toDouble()
)

fun Vec3i.convI() : Vector3i = Vector3i(
    x,
    y,
    z
)

fun Vec3i.convF() : Vector3f = Vector3f(
    x.toFloat(),
    y.toFloat(),
    z.toFloat()
)

// JOML Vector3d
fun Vector3d.convI() : Vector3i = Vector3i(
    x.toInt(),
    y.toInt(),
    z.toInt()
)

fun Vector3d.convF() : Vector3f = Vector3f(
    x.toFloat(),
    y.toFloat(),
    z.toFloat()
)

// JOML Vector3i
fun Vector3i.convD() : Vector3d = Vector3d(
    x.toDouble(),
    y.toDouble(),
    z.toDouble()
)
fun Vector3i.convF() : Vector3f = Vector3f(
    x.toFloat(),
    y.toFloat(),
    z.toFloat()
)

// JOML Vector3f
fun Vector3f.convD() : Vector3d = Vector3d(
    x.toDouble(),
    y.toDouble(),
    z.toDouble()
)

fun Vector3f.convI() : Vector3i = Vector3i(
    x.toInt(),
    y.toInt(),
    z.toInt()
)