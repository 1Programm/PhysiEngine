package com.github.physiengine.object;

public class Material {

	public float mass;
	public float bounce;
	public float friction;
	
	public Material() {}
	
	public Material(float mass, float bounce, float friction) {
		this.mass = mass;
		this.bounce = bounce;
		this.friction = friction;
	}
}
