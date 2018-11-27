package com.github.physiengine.object;

import com.github.physiengine.math.Vector2;

public class Transform {

	private Vector2 pos, scale;

	private float rotation;

	public Transform() {
		this.pos = new Vector2(0, 0);
		this.scale = new Vector2(1, 1);
		this.rotation = 0; 
	}
	
	public Transform(float x, float y) {
		this.pos = new Vector2(x, y);
		this.scale = new Vector2(1, 1);
		this.rotation = 0;
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
