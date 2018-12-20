package com.github.physiengine.gfx.light;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Light {

	private Vector2f position;
	private Vector3f color;
	private float strength;
	
	public Light(Vector2f position, Vector3f color, float strength) {
		this.position = position;
		this.color = color;
		this.strength = strength;
	}

	public Vector2f getPosition() {
		return position;
	}

	public Vector3f getColor() {
		return color;
	}

	public float getStrength() {
		return strength;
	}
}
