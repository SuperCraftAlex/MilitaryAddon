package api.militarymod.extensions.vs2

import api.militarymod.extensions.vecpos.conv
import de.m_marvin.univec.impl.Vec3d
import org.valkyrienskies.core.impl.pipelines.SegmentUtils

fun SegmentUtils.getVelocity(poseVel: org.valkyrienskies.physics_api.PoseVel, segmentDisplacement: org.valkyrienskies.physics_api.SegmentDisplacement, dest: Vec3d): Vec3d {
    return SegmentUtils.getVelocity(poseVel, segmentDisplacement, dest.conv()).conv()
}