package com.github.physiengine.components.model;

import com.github.helperclasses.math.Vector2;

public class Model_Rectangle extends Model {
	
	public Model_Rectangle(Vector2 pos, Vector2 size) {
		vertecies = new Vector2[4];
		
		float sx = size.x/2;
		float sy = size.y/2;
		
		vertecies[0] = new Vector2(pos.x - sx, pos.y - sy); // Top - Left Vertex
		vertecies[1] = new Vector2(pos.x + sx, pos.y - sy); // Top - Rigth Vertex
		vertecies[2] = new Vector2(pos.x - sx, pos.y + sy); // Btm - Left Vertex
		vertecies[3] = new Vector2(pos.x + sx, pos.y + sy); // Btm - Right Vertex
	}
	
	@Override
	public void update() {}
	
}
