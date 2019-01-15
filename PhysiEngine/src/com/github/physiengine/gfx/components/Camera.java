package com.github.physiengine.gfx.components;

import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private Vector3f position;
	private Vector3f rotation;
	
	public Camera(Vector3f position, Vector3f rotation) {
		this.position = position;
		this.rotation = rotation;
	}

	public Vector3f getPosition() {
		return position;
	}

	public Vector3f getRotation() {
		return rotation;
	}
	
	
}
