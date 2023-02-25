package api.militarymod.extensions.level_vs2

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import org.valkyrienskies.core.api.ships.ServerShip

import org.valkyrienskies.mod.common.getShipManagingPos
import org.valkyrienskies.mod.common.getShipObjectManagingPos

fun ServerLevel.getShipManagingPos(pos : BlockPos) : ServerShip? =
    this.getShipManagingPos(pos)

fun ServerLevel.getShipObjectManagingPos(pos : BlockPos) : ServerShip? =
    this.getShipObjectManagingPos(pos)