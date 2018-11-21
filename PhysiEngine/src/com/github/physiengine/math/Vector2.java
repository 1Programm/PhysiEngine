package com.github.physiengine.math;

public class Vector2 {
	public float x;
	public float y;
	
	public Vector2() {
		x = y = 0;
	}
	public Vector2(float x, float y) {
		this.x = x;
		this.y =y;		
	}
	
	public Vector2(Vector2 v) {
		this.x = v.x;
		this.y = v.y;
	}
	 
	public Vector2(Vector2 v1, Vector2 v2) {
		this.x = v2.x - v1.x;
		this.y = v2.y - v1.y;		
	}
	
	//Methoden
	
	public float getLength() {
		return (float)Math.sqrt(x*x+y*y);
	}
	
	public void normalize() {
		float l = this.getLength();
		this.x /= l;
		this.y /= l;
	}
	
	public void rotate(double n)
	{
	    double rx = (this.x * Math.cos(n)) - (this.y * Math.sin(n));
	    double ry = (this.x * Math.sin(n)) + (this.y * Math.cos(n));
	    x = (float)rx;
	    y = (float)ry;
	}
	
	
	
	//"normal"
	
	public void add(Vector2 sv) {
		this.x += sv.x;
		this.y += sv.y; 				
	}
	
	public void add1() {
		
	}
	
	public void add2() {
		
	}

	public void sub(Vector2 sv) {
		this.x -= sv.x;
		this.y -= sv.y;
	}
	
	public void div(Vector2 sv) {
		this.x /= sv.x;
		this.y /= sv.y; 				
	}
	
	public void mul(Vector2 sv) {
		this.x *= sv.x;
		this.y *= sv.y; 				
	}
	
	public void add(float x, float y) {
		
		this.x += x;
		this.y += y;
		
	}
	
	// Statics
	
	public static Vector2 Add(Vector2 sv1 , Vector2 sv2) {
		return new Vector2(sv1.x+sv2.x, sv1.y+sv2.y); 				
	}
	
	public static Vector2 Sub(Vector2 sv1 , Vector2 sv2) {
		return new Vector2(sv2.x-sv1.x, sv2.y-sv1.y); 				
	}
	
	public static Vector2 Div(Vector2 sv1 , Vector2 sv2) {
		return new Vector2(sv2.x/sv1.x, sv2.y/sv1.y); 				
	}
	
	public static Vector2 Mul(Vector2 sv1 , Vector2 sv2) {
		return new Vector2(sv2.x*sv1.x, sv2.y*sv1.y); 				
	}
	
	public static Vector2 Normalize(Vector2 v) {
		float l = v.getLength();
		return new Vector2(v.x/l,v.y/l);
	}
	
	public static float Dot(Vector2 v1 , Vector2 v2) {
		return v1.x * v2.x+ v1.y * v2.y;		
	}
	
	public static float getAngle(Vector2 v1, Vector2 v2) {
		return (float) Math.acos(Dot(v1,v2)/(v1.getLength()*v2.getLength()));
	}
}