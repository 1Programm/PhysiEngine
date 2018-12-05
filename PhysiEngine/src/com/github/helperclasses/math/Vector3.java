package com.github.helperclasses.math;

public class Vector3 {
	
	public float x;
	public float y;
	public float z;

	// --------------------------------------------------------------------------------------------
	// Constructors
	// --------------------------------------------------------------------------------------------
	public Vector3() {
		x = y = z = 0;
	}

	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3(Vector3 v) {
		if(v == null) v = new Vector3();
		
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}

	public Vector3(Vector3 v1, Vector3 v2) {
		if(v1 == null) v1 = new Vector3();
		if(v2 == null) v2 = new Vector3();
		
		this.x = v2.x - v1.x;
		this.y = v2.y - v1.y;
		this.z = v2.z - v1.z;
	}

	// --------------------------------------------------------------------------------------------
	// Usage Methods
	// --------------------------------------------------------------------------------------------

	public float getLength() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	public void normalize() {
		float l = this.getLength();
		this.x /= l;
		this.y /= l;
		this.z /= l;
	}

	public void rotate(Vector3 rotation) {
		//TODO
	}

	public void rotateAround(Vector3 rotation, Vector3 point) {
		if(point == null) return;
		if(rotation == null) return;
		
		this.x -= point.x;
		this.y -= point.y;
		this.z -= point.z;

		rotate(rotation);

		this.x += point.x;
		this.y += point.y;
		this.z += point.z;
	}	
	
	public void print(String name) {
		System.out.println(name + ": " + toString());
	}
	
	// --------------------------------------------------------------------------------------------
	// Super Methods
	// --------------------------------------------------------------------------------------------

	@Override
	protected Vector3 clone() {
		return new Vector3(this.x, this.y, this.z);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Vector3)) return false;
		
		Vector3 vec = (Vector3)obj;
		
		return (this.x == vec.x && this.y == vec.y && this.z == vec.z);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

	// --------------------------------------------------------------------------------------------
	// Operating Methods
	// --------------------------------------------------------------------------------------------

	public void add(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}

	public void add(Vector3 v) {
		if(v == null) return;
		
		add(v.x, v.y, v.z);
	}

	public void sub(float x, float y, float z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
	}

	public void sub(Vector3 v) {
		if(v == null) return;
		
		sub(v.x, v.y, v.z);
	}

	public void div(float x, float y, float z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
	}
	
	public void div(float d) {
		div(d, d, d);
	}

	public void div(Vector3 v) {
		if(v == null) return;
		
		div(v.x, v.y, v.z);
	}

	public void mul(float x, float y, float z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
	}
	
	public void mul(float m) {
		mul(m, m, m);
	}
	
	public void mul(Vector3 v) {
		if(v == null) return;
		
		mul(v.x, v.y, v.z);
	}

	public void scale(float scale) {
		mul(scale, scale, scale);
	}

	// --------------------------------------------------------------------------------------------
	// Static Methods
	// --------------------------------------------------------------------------------------------
	
	public static Vector3 Add(Vector3 v1, Vector3 v2) {
		if(v1 == null || v2 == null) return null;
		
		return new Vector3(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
	}
	
	public static Vector3 Sub(Vector3 v1, Vector3 v2) {
		if(v1 == null || v2 == null) return null;
		
		return new Vector3(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
	}

	public static Vector3 Div(Vector3 v1, Vector3 v2) {
		return new Vector3(v1.x / v2.x, v1.y / v2.y, v1.z / v2.z);
	}

	public static Vector3 Mul(Vector3 v1, Vector3 v2) {
		return new Vector3(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z);
	}

	public static Vector3 Scale(Vector3 v, float scale) {
		return new Vector3(v.x * scale, v.y * scale, v.z * scale);
	}

	public static float Distance(Vector3 v1, Vector3 v2) {
		if(v1 == null || v2 == null) return 0;
		
		float dx = v2.x - v1.x;
		float dy = v2.y - v1.y;
		float dz = v2.z - v1.z;

		return (float)Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	public static Vector3 Normalized(Vector3 v) {
		if(v == null) return null;
		
		float l = v.getLength();
		return new Vector3(v.x / l, v.y / l, v.z / l);
	}

	public static float Dot(Vector3 v1, Vector3 v2) {
		if(v1 == null || v2 == null) return 0;
		
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}

	public static float GetAngle(Vector3 v1, Vector3 v2) {
		if(v1 == null || v2 == null) return 0;
		
		return (float) Math.acos(Dot(v1, v2) / (v1.getLength() * v2.getLength()));
	}
}