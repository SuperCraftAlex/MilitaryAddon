package de.m_marvin.core.util;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3d;

public class MathUtility {

	public static int clamp(int v, int min, int max) {
		if (v < min) return min;
		if (v > max) return max;
		return v;
	}
	
	public static float clamp(float v, float min, float max) {
		if (v < min) return min;
		if (v > max) return max;
		return v;
	}
	
	public static double clamp(double v, double min, double max) {
		if (v < min) return min;
		if (v > max) return max;
		return v;
	}
	
	public static float clampToDegree(float angle) {
		return angle % 360;
	}
	
	public static BlockPos getMinCorner(BlockPos pos1, BlockPos pos2) {
		return new BlockPos(
				Math.min(pos1.getX(), pos2.getX()),
				Math.min(pos1.getY(), pos2.getY()),
				Math.min(pos1.getZ(), pos2.getZ())
			);
	}
	
	public static BlockPos getMaxCorner(BlockPos pos1, BlockPos pos2) {
		return new BlockPos(
				Math.max(pos1.getX(), pos2.getX()),
				Math.max(pos1.getY(), pos2.getY()),
				Math.max(pos1.getZ(), pos2.getZ())
			);
	}

	public static Vector3d getMinCorner(Vector3d pos1, Vector3d pos2) {
		return new Vector3d(
				Math.min(pos1.x, pos2.x),
				Math.min(pos1.y, pos2.y),
				Math.min(pos1.z, pos2.z)
			);
	}
	
	public static Vector3d getMaxCorner(Vector3d pos1, Vector3d pos2) {
		return new Vector3d(
				Math.max(pos1.x, pos2.x),
				Math.max(pos1.y, pos2.y),
				Math.max(pos1.z, pos2.z)
			);
	}
	
	public static BlockPos getMiddleBlock(BlockPos pos1, BlockPos pos2) {
		int middleX = Math.min(pos1.getX(), pos2.getX()) + (Math.max(pos1.getX(), pos2.getX()) - Math.min(pos1.getX(), pos2.getX())) / 2;
		int middleY = Math.min(pos1.getY(), pos2.getY()) + (Math.max(pos1.getY(), pos2.getY()) - Math.min(pos1.getY(), pos2.getY())) / 2;
		int middleZ = Math.min(pos1.getZ(), pos2.getZ()) + (Math.max(pos1.getZ(), pos2.getZ()) - Math.min(pos1.getZ(), pos2.getZ())) / 2;
		return new BlockPos(middleX, middleY, middleZ);
	}

	public static Vector3d getMiddle(BlockPos pos1, BlockPos pos2) {
		double middleX = Math.min(pos1.getX(), pos2.getX()) + (Math.max(pos1.getX(), pos2.getX()) - Math.min(pos1.getX(), pos2.getX()) + 1) / 2.0;
		double middleY = Math.min(pos1.getY(), pos2.getY()) + (Math.max(pos1.getY(), pos2.getY()) - Math.min(pos1.getY(), pos2.getY()) + 1) / 2.0;
		double middleZ = Math.min(pos1.getZ(), pos2.getZ()) + (Math.max(pos1.getZ(), pos2.getZ()) - Math.min(pos1.getZ(), pos2.getZ()) + 1) / 2.0;
		return new Vector3d(middleX, middleY, middleZ);
	}

	public static Vector3d getMiddle(Vector3d pos1, Vector3d pos2) {
		double middleX = Math.min(pos1.x, pos2.x) + (Math.max(pos1.x, pos2.x) - Math.min(pos1.x, pos2.x) + 1) / 2.0;
		double middleY = Math.min(pos1.y, pos2.y) + (Math.max(pos1.y, pos2.y) - Math.min(pos1.y, pos2.y) + 1) / 2.0;
		double middleZ = Math.min(pos1.z, pos2.z) + (Math.max(pos1.z, pos2.z) - Math.min(pos1.z, pos2.z) + 1) / 2.0;
		return new Vector3d(middleX, middleY, middleZ);
	}
	
	public static double directionAngleDegrees(Direction direction) {
		switch (direction) {
		case NORTH: return 0;
		case SOUTH: return 180;
		case EAST: return -90;
		case WEST: return 90;
		case UP: return 90;
		case DOWN: return -90;
		default: return 0;
		}
	}

	public static boolean isInChunk(ChunkPos chunk, BlockPos block) {
		return 	chunk.getMinBlockX() <= block.getX() && chunk.getMaxBlockX() >= block.getX() &&
				chunk.getMinBlockZ() <= block.getZ() && chunk.getMaxBlockZ() >= block.getZ();
	}
	
	public static Vector3d[] lineInfinityIntersection(Vector3d lineA1, Vector3d lineA2, Vector3d lineB1, Vector3d lineB2) {
		Vector3d p43 = new Vector3d(lineB2.x - lineB1.x, lineB2.y - lineB1.y, lineB2.z - lineB1.z);
		Vector3d p21 = new Vector3d(lineA2.x - lineA1.x, lineA2.y - lineA1.y, lineA2.z - lineA1.z);
		Vector3d p13 = new Vector3d(lineA1.x - lineB1.x, lineA1.y - lineB1.y, lineA1.z - lineB1.z);
		double d1343 = p13.x * p43.x + p13.y * p43.y + p13.z * p43.z;
		double d4321 = p43.x * p21.x + p43.y * p21.y + p43.z * p21.z;
		double d4343 = p43.x * p43.x + p43.y * p43.y + p43.z * p43.z;
		double d2121 = p21.x * p21.x + p21.y * p21.y + p21.z * p21.z;
		double denom = d2121 * d4343 - d4321 * d4321;
		double d1321 = p13.x * p21.x + p13.y * p21.y + p13.z * p21.z;
		double numer = d1343 * d4321 - d1321 * d4343;
		
		double mua = numer / denom;
		double mub = (d1343 + d4321 * mua) / d4343;
		
		Vec3 cl1 = new Vec3(lineA1.x+mua*p21.x, lineA1.y+mua*p21.y, lineA1.z+mua*p21.z);
		Vec3 cl2 = new Vec3(lineB1.x+mub*p43.x, lineB1.y+mub*p43.y, lineB1.z+mub*p43.z);
		
		return new Vector3d[] {new Vector3d(
				cl1.x,
				cl1.y,
				cl1.z
		), new Vector3d(
				cl1.x,
				cl1.y,
				cl1.z
		)};
	}
	
	public static boolean isOnLine(Vector3d point, Vector3d line1, Vector3d line2, double t) {
		return line1.sub(point).length() + line2.sub(point).length() <= line1.sub(line2).length() + t;
	}
	
	public static Optional<Vector3d> getHitPoint(Vector3d lineA1, Vector3d lineA2, Vector3d lineB1, Vector3d lineB2, double tolerance) {
		Vector3d[] shortesLine = lineInfinityIntersection(lineA1, lineA2, lineB1, lineB2);
		if (isOnLine(shortesLine[0], lineA1, lineA2, 0.1F) && isOnLine(shortesLine[1], lineB1, lineB2, 0.1F)) {
			if (shortesLine[0].sub(shortesLine[1]).length() <= tolerance) return Optional.of(shortesLine[0]);
		}
		return Optional.empty();
	}
	
	public static boolean doLinesCross(Vector3d lineA1, Vector3d lineA2, Vector3d lineB1, Vector3d lineB2, double tolerance) {
		Vector3d[] shortesLine = lineInfinityIntersection(lineA1, lineA2, lineB1, lineB2);
		if (isOnLine(shortesLine[0], lineA1, lineA2, 0.1F) && isOnLine(shortesLine[1], lineB1, lineB2, 0.1F)) {
			return shortesLine[0].sub(shortesLine[1]).length() <= tolerance;
		}
		return false;
	}
	
	public static BlockHitResult getPlayerPOVHitResult(Level pLevel, Player pPlayer, ClipContext.Fluid pFluidMode, double reachDistance) {
		float f = pPlayer.getXRot();
		float f1 = pPlayer.getYRot();
		Vec3 vec3 = pPlayer.getEyePosition();
		float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
		float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
		float f6 = f3 * f4;
		float f7 = f2 * f4;
		double d0 = reachDistance;
		Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
		return pLevel.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, pFluidMode, pPlayer));
	}
	
	private static final Predicate<Entity> ENTITY_PREDICATE_CLICKEABLE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
	
	public static UseOnContext raycastBlockClick(Level level, Player player, InteractionHand hand, double reachDistance) {
		ItemStack stack = player.getItemInHand(hand);
		HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY, reachDistance);
		
		if (hitresult.getType() == HitResult.Type.MISS) {
			return null;
		} else {
			Vec3 vec3 = player.getViewVector(1.0F);
			List<Entity> list = level.getEntities(player,  player.getBoundingBox().expandTowards(vec3.scale(reachDistance)).inflate(1.0), ENTITY_PREDICATE_CLICKEABLE);
			if (!list.isEmpty()) {
				Vec3 eyePos = player.getEyePosition();
				
				for (Entity entity : list) {
					AABB aabb = entity.getBoundingBox().inflate((double) entity.getPickRadius());
					if (aabb.contains(eyePos)) {
						return null;
					}
				}
			}
			if (hitresult.getType() == HitResult.Type.BLOCK) {
				return new UseOnContext(level, player, hand, stack, (BlockHitResult) hitresult);
			}
		}
		return null;
	}
	
}
