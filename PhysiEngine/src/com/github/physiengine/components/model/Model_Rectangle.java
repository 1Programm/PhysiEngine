package com.github.physiengine.components.model;

import com.github.physiengine.components.Changes;
import com.github.physiengine.math.Vector2;

public class Model_Rectangle extends Model {
	
	public Model_Rectangle(Vector2 pos, Vector2 size) {
		vertecies = new Vector2[4];
		updateVertecies(pos, size);
	}
	
	private void updateVertecies(Vector2 pos, Vector2 size) {
		float sx = size.x/2;
		float sy = size.y/2;
		
		vertecies[0] = new Vector2(pos.x - sx, pos.y - sy); // Top - Left Vertex
		vertecies[1] = new Vector2(pos.x + sx, pos.y - sy); // Top - Rigth Vertex
		vertecies[2] = new Vector2(pos.x - sx, pos.y + sy); // Btm - Left Vertex
		vertecies[3] = new Vector2(pos.x + sx, pos.y + sy);
	}
	
	@Override
	public void update(Changes c) {
		 if(c.position || c.size){
		 		updateVertecies(parent.getTransform().getPos(), parent.getTransform().getScale());
		 }
	}
	
}