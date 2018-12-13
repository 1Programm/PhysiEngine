package com.github.helperclasses.math;

public class Vector2 {
	public float x;
	public float y;

	// --------------------------------------------------------------------------------------------
	// Constructors
	// --------------------------------------------------------------------------------------------
	public Vector2() {
		x = y = 0;
	}

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2(Vector2 v) {
		if(v == null) v = new Vector2();
		
		this.x = v.x;
		this.y = v.y;
	}

	public Vector2(Vector2 v1, Vector2 v2) {
		if(v1 == null) v1 = new Vector2();
		if(v2 == null) v2 = new Vector2();
		
		this.x = v2.x - v1.x;
		this.y = v2.y - v1.y;
	}

	// --------------------------------------------------------------------------------------------
	// Usage Methods
	// --------------------------------------------------------------------------------------------

	public float getLength() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public void normalize() {
		float l = this.getLength();
		if(l == 0) l = 1;
		this.x /= l;
		this.y /= l;
	}

	public void rotate(float rotation) {
		double rx = (this.x * Math.cos(rotation)) - (this.y * Math.sin(rotation));
		double ry = (this.x * Math.sin(rotation)) + (this.y * Math.cos(rotation));
		x = (float) rx;
		y = (float) ry;
	}

	public void rotateAround(float rotation, Vector2 point) {
		if(point == null) return;
		
		this.x -= point.x;
		this.y -= point.y;

		rotate(rotation);

		this.x += point.x;
		this.y += point.y;
	}	
	
	public void print(String name) {
		System.out.println(name + ": " + toString());
	}
	
	public float[] toArray() {
		return new float[] {x, y};
	}
	
	// --------------------------------------------------------------------------------------------
	// Super Methods
	// --------------------------------------------------------------------------------------------

	@Override
	public Vector2 clone() {
		return new Vector2(this.x, this.y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Vector2)) return false;
		
		Vector2 vec = (Vector2)obj;
		
		return (this.x == vec.x && this.y == vec.y);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	// --------------------------------------------------------------------------------------------
	// Operating Methods
	// --------------------------------------------------------------------------------------------

	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector2 v) {
		this.x = v.x;
		this.y = v.y;
	}
	
	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}

	public void add(Vector2 v) {
		if(v == null) return;
		
		add(v.x, v.y);
	}

	public void sub(float x, float y) {
		this.x -= x;
		this.y -= y;
	}

	public void sub(Vector2 v) {
		if(v == null) return;
		
		sub(v.x, v.y);
	}

	public void div(float x, float y) {
		this.x /= x;
		this.y /= y;
	}
	
	public void div(float d) {
		div(d, d);
	}

	public void div(Vector2 v) {
		if(v == null) return;
		
		div(v.x, v.y);
	}

	public void mul(float x, float y) {
		this.x *= x;
		this.y *= y;
	}
	
	public void mul(float m) {
		mul(m, m);
	}
	
	public void mul(Vector2 v) {
		if(v == null) return;
		
		mul(v.x, v.y);
	}

	public void scale(float scale) {
		mul(scale, scale);
	}

	// --------------------------------------------------------------------------------------------
	// Static Methods
	// --------------------------------------------------------------------------------------------
	
	public static Vector2 Add(Vector2 v1, Vector2 v2) {
		if(v1 == null || v2 == null) return null;
		
		return new Vector2(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static Vector2 Sub(Vector2 v1, Vector2 v2) {
		if(v1 == null || v2 == null) return null;
		
		return new Vector2(v2.x - v1.x, v2.y - v1.y);
	}

	public static Vector2 Div(Vector2 v1, Vector2 v2) {
		return new Vector2(v2.x / v1.x, v2.y / v1.y);
	}

	public static Vector2 Mul(Vector2 v1, Vector2 v2) {
		if(v1 == null) return v2.clone();
		if(v2 == null) return v1.clone();
		
		return new Vector2(v2.x * v1.x, v2.y * v1.y);
	}

	public static Vector2 Scale(Vector2 v, float scale) {
		return new Vector2(v.x * scale, v.y * scale);
	}

	public static float Distance(Vector2 v1, Vector2 v2) {
		if(v1 == null || v2 == null) return 0;
		
		float dx = v2.x - v1.x;
		float dy = v2.y - v1.y;

		return (float)Math.sqrt(dx * dx + dy * dy);
	}

	public static Vector2 Normalized(Vector2 v) {
		if(v == null) return null;
		
		float l = v.getLength();
		return new Vector2(v.x / l, v.y / l);
	}

	public static float Dot(Vector2 v1, Vector2 v2) {
		if(v1 == null || v2 == null) return 0;
		
		return v1.x * v2.x + v1.y * v2.y;
	}

	public static float GetAngle(Vector2 v1, Vector2 v2) {
		if(v1 == null || v2 == null) return 0;
		
		return (float) Math.acos(Dot(v1, v2) / (v1.getLength() * v2.getLength()));
	}
	
	
	/*
	 * Reflection:
	 * 
	 * o-----------> x
	 * |  
	 * |   \    |
	 * |    \   |  <- this is the reflected Vector
	 * |     \  |
	 * |      o |
	 * |   <----|  <- this is the normal
	 * |      o |
	 * |     /  |  <- this is the toBeReflected Vector
	 * |    /   |
	 * |   /    |  
	 * |
	 * V
	 * y
	 * 
	 */
	public static Vector2 getReflection(Vector2 normal, Vector2 toBeReflected) {
		Vector2 ret = new Vector2(normal);
		
		float dot = Vector2.Dot(toBeReflected, normal) * 2;
		
		ret.mul(dot);
		ret.sub(toBeReflected);
		
		return ret;
	}
}