package com.github.physiengine.object;

import com.github.physiengine.math.Vector2;

public class Transform {

	private Vector2 pos, scale;

	private float rotation;

	public Transform() { init(0, 0, 1, 1, 0); }
	public Transform(float x, float y) { init(x, y, 1, 1, 0); }
	public Transform(float x, float y, float r) { init(x, y, 1, 1, r); }
	public Transform(float x, float y, float w, float h) { init(x, y, w, h, 0); }
	public Transform(float x, float y, float w, float h, float r) { init(x, y, w, h, r); }
	
	public void init(float x, float y, float w, float h, float r) {
		this.pos = new Vector2(x, y);
		this.scale = new Vector2(w, h);
		this.rotation = r; 
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public void setPos(float x, float y) {
		pos.x = x;
		pos.y = y;
	}

	public Vector2 getScale() {
		return scale;
	}

	public void setScale(Vector2 scale) {
		this.scale = scale;
	}
	
	public void move(float x, float y) {
		
		pos.add(x,y);
		
	}
	
	public void move(Vector2 vec) {
		
		pos.add(vec);
		
	}

}
