package com.github.physiengine.gfx.components;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.object.GameObject;

public class Light extends GameObject{

	private Vector3f color;
	private Vector3f attenuation;
	
	public Light(Vector3f position) {
		super(position);
		
		this.color = new Vector3f(1, 1, 1);
		this.attenuation = new Vector3f(1, 0, 0);
	}
	
	public Light(Vector3f position, Vector3f color) {
		super(position);
		
		this.color = color;
		this.attenuation = new Vector3f(1, 0, 0);
	}
	
	public Light(Vector3f position, Vector3f color, Vector3f attenuation) {
		super(position);
		
		this.color = color;
		this.attenuation = attenuation;
	}
	
	public Vector3f getAttenuation() {
		return attenuation;
	}
	
	public Light setAttenuation(Vector3f attenuation) {
		this.attenuation = attenuation;
		
		return this;
	}

	public Vector3f getColor() {
		return color;
	}

	public Light setColor(Vector3f color) {
		this.color = color;
		
		return this;
	}
}
