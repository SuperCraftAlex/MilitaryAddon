package militarymod.ship

import api.militarymod.extensions.vecpos.conv
import com.fasterxml.jackson.annotation.JsonAutoDetect
import de.m_marvin.univec.impl.Vec3d
import de.m_marvin.univec.impl.Vec3i
import militarymod.MilitaryConfig
import net.minecraft.core.BlockPos
import net.minecraft.util.Tuple
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

    private val Engines = mutableListOf<Tuple<Vec3i, Vec3d>>()

    override fun applyForces(physShip: PhysShip) {
        physShip as PhysShipImpl

        Engines.forEach {
            val pos = it.a
            val force = it.b

            val tForce = Vec3d(physShip.transform.shipToWorld.transformDirection(force.conv(), Vec3d().conv()))
            val tPos = Vec3d(pos).add(0.5, 0.5, 0.5).sub(Vec3d().readFrom(physShip.transform.positionInShip))

            if (force.isFinite && physShip.poseVel.vel.length() < 50) {
                physShip.applyInvariantForceToPos(tForce.mul(MilitaryConfig.SERVER.JetEnginePowerMultiplyer * 10000.0).conv(), tPos.conv())
            }
        }
    }

    fun addEngine(pos: BlockPos, force: Vec3d) {
        Engines.add(Tuple(pos.conv(), force))
    }

    fun removeEngine(pos: BlockPos, force: Vec3d) {
        Engines.remove(Tuple(pos.conv(), force))
    }

    companion object {
        fun getOrCreate(ship: ServerShip): JetEngineForceInducer {
            return ship.getAttachment<JetEngineForceInducer>()
                ?: JetEngineForceInducer().also { ship.saveAttachment(it) }
        }
    }

}