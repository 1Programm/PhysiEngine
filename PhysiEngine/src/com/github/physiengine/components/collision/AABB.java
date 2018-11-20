package com.github.physiengine.components.collision;

import com.github.physiengine.math.Vector2;

public class AABB extends Collider{
	
	public Vector2 position;
	public Vector2 size;
	
	public AABB(Vector2 pos, Vector2 size) {
		this.position = pos;
		this.size = size;
	}

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
