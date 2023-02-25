package api.militarymod.physics.extension

import de.m_marvin.core.physics.PhysicUtility
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.Level
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.ships.Ship

fun Level.getShipManagingPos(pos : BlockPos) : Ship? {
    return PhysicUtility.getContraptionOfBlock(this, pos)
}

fun ServerLevel.getShipManagingPos(pos : BlockPos) : ServerShip? {
    val s = PhysicUtility.getContraptionOfBlock(level, pos) ?: return null
    return s as ServerShip
}