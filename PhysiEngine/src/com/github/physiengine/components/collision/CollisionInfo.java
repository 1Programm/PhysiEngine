package com.github.physiengine.components.collision;

public class CollisionInfo {

	public float penetrateX, penetrateY, collisionAngel;
	
	public CollisionInfo(float pX, float pY, float cA) {
		penetrateX = pX;
		penetrateY = pY;
		collisionAngel = cA;
	}
}
