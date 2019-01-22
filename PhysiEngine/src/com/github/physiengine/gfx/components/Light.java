package com.github.physiengine.gfx.components;

import org.lwjgl.util.vector.Vector3f;

public class Light {

	private Vector3f parentPosition;
	
	private Vector3f color;
	
	private Vector3f attenuation;
	
	public Light(Vector3f color) {
		this.color = color;
		this.attenuation = new Vector3f(1, 0, 0);
	}
	
	public Light(Vector3f color, Vector3f attenuation) {
		this.color = color;
		this.attenuation = attenuation;
	}
	
	public Vector3f getAttenuation() {
		return attenuation;
	}

	public Vector3f getParentPosition() {
		return parentPosition;
	}

	public void setParentPosition(Vector3f parentPosition) {
		this.parentPosition = parentPosition;
	}

	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}
}
