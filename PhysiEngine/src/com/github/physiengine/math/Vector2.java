package com.github.physiengine.math;

public class Vector2 { // Wer das liest ist cooool :D
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

	// --------------------------------------------------------------------------------------------
	// Operating Methods
	// --------------------------------------------------------------------------------------------

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

	public void div(Vector2 v) {
		if(v == null) return;
		
		div(v.x, v.y);
	}

	public void mul(float x, float y) {
		this.x *= x;
		this.y *= y;
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
}