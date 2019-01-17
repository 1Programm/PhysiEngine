package com.github.helperclasses.math;

import org.lwjgl.util.vector.Vector3f;

public class Transform {
	
	public static Transform ZERO() { return new Transform(new Vector3f(), new Vector3f(), new Vector3f()); }

	private Vector3f position;
	private Vector3f scale;
	private Vector3f rotation;
	
	public Transform() {
		this.position = new Vector3f();
		this.scale = new Vector3f(1, 1, 1);
		this.rotation = new Vector3f();
	}
	
	public Transform(Vector3f position, Vector3f scale, Vector3f rotation) {
		this.position = position;
		this.scale = scale;
		this.rotation = rotation;
	}
	
	public void set(Vector3f position, Vector3f scale, Vector3f rotation) {
		this.position = position;
		this.scale = scale;
		this.rotation = rotation;
	}
	
	public void set(float x, float y, float z, float s1, float s2, float s3, float r1, float r2, float r3) {
		this.position.set(x, y, z);
		this.scale.set(s1, s2, s3);
		this.rotation.set(r1, r2, r3);
	}
	
	public void addTransform(Transform transform) {
		addPosition(transform.getPosition());
		addScale(transform.getScale());
		addRotation(transform.getRotation());
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public void addPosition(Vector3f v) {
		this.position.x += v.x;
		this.position.y += v.y;
		this.position.z += v.z;
	}
	
	public void addPosition(float x, float y, float z) {
		this.position.x += x;
		this.position.y += y;
		this.position.z += z;
	}

	public Vector3f getScale() {
		return scale;
	}
	
	public void addScale(Vector3f v) {
		this.scale.x += v.x;
		this.scale.y += v.y;
		this.scale.z += v.z;
	}
	
	public void addScale(float x, float y, float z) {
		this.scale.x += x;
		this.scale.y += y;
		this.scale.z += z;
	}

	public Vector3f getRotation() {
		return rotation;
	}
	
	public void addRotation(Vector3f v) {
		this.rotation.x += v.x;
		this.rotation.y += v.y;
		this.rotation.z += v.z;
	}
	
	public void addRotation(float x, float y, float z) {
		this.rotation.x += x;
		this.rotation.y += y;
		this.rotation.z += z;
	}
}
