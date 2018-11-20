package com.github.physiengine.components.collision;

import com.github.physiengine.math.Vector2;

public class Circle extends Collider{

	public Vector2 position;
	
	public float radius;
	
	@Override
	protected CollisionInfo collideWith(AABB aabb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CollisionInfo collideWith(Circle cicle) {
		// TODO Auto-generated method stub
		return null;
	}

}
