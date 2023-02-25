package de.m_marvin.core.physics.types;

import com.mojang.math.Quaternion;
import org.joml.Vector3d;

public class ContraptionPosition {
	
	public Quaternion orientation;
	public Vector3d position;
	
	public ContraptionPosition(Quaternion orientation, Vector3d position) {
		this.orientation = orientation;
		this.position = position;
	}
	
	public Quaternion getOrientation() {
		return orientation;
	}
	
	public void setOrientation(Quaternion orientation) {
		this.orientation = orientation;
	}
	
	public Vector3d getPosition() {
		return position;
	}
	
	public void setPosition(Vector3d position) {
		this.position = position;
	}
	
}
