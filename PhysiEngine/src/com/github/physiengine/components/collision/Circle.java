package com.github.physiengine.components.collision;

import com.github.helperclasses.math.Vector2;

public class Circle extends Collider{
	
	@Override
	protected CollisionInfo collideWith(AABB other) {
		return null;
	}

	@Override
	protected CollisionInfo collideWith(Circle other) {
		Vector2 distV = new Vector2(getPosition(), other.getPosition());
		float dist = distV.getLength();
		
		float intersect = (getRadius() + other.getRadius()) - dist;
		
		if(intersect >= 0) {
			
			CollisionInfo info = new CollisionInfo();
			
			distV.normalize();
			distV.mul(new Vector2(intersect, intersect));
			
			info.penetrateX = distV.x;
			info.penetrateY = distV.y;
		}
		
		
		return null;
	}

	private float getRadius() {
		return getWidth() > getHeight() ? getWidth() : getHeight();
	}

}
