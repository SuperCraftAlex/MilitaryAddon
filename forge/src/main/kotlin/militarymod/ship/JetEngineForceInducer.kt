package militarymod.ship

import api.militarymod.vecpos.convD
import api.militarymod.vecpos.convI
import com.fasterxml.jackson.annotation.JsonAutoDetect
import militarymod.MilitaryConfig
import net.minecraft.core.BlockPos
import net.minecraft.util.Tuple
import org.joml.Vector3d
import org.joml.Vector3i
import org.valkyrienskies.core.api.ships.PhysShip
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.ships.getAttachment
import org.valkyrienskies.core.api.ships.saveAttachment
import org.valkyrienskies.core.impl.api.ShipForcesInducer
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE
)
class JetEngineForceInducer : ShipForcesInducer {

    private val Engines = mutableListOf<Tuple<Vector3i, Vector3d>>()

    override fun applyForces(physShip: PhysShip) {
        physShip as PhysShipImpl

        Engines.forEach {
            val pos = it.a
            val force = it.b

            val tForce = physShip.transform.shipToWorld.transformDirection(force, Vector3d())
            val tPos = pos.convD().add(0.5, 0.5, 0.5).sub(physShip.transform.positionInShip)

            if (force.isFinite && physShip.poseVel.vel.length() < 50) {
                physShip.applyInvariantForceToPos(tForce.mul(MilitaryConfig.SERVER.JetEnginePowerMultiplyer * 10000.0), tPos)
            }
        }
    }

    fun addEngine(pos: BlockPos, force: Vector3d) {
        Engines.add(Tuple(pos.convI(), force))
    }

    fun removeEngine(pos: BlockPos, force: Vector3d) {
        Engines.remove(Tuple(pos.convI(), force))
    }

    companion object {
        fun getOrCreate(ship: ServerShip): JetEngineForceInducer {
            return ship.getAttachment<JetEngineForceInducer>()
                ?: JetEngineForceInducer().also { ship.saveAttachment(it) }
        }
    }

}