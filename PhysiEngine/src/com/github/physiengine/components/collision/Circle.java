package com.github.physiengine.components.collision;

import com.github.physiengine.math.Vector2;

public class Circle extends Collider{

	public Vector2 position;
	
	public float radius;
	
	@Override
	protected CollisionInfo collideWith(AABB aabb) {
 
		return null;
	}

	@Override
	protected CollisionInfo collideWith(Circle circle) {
		Vector2 distV = new Vector2(position, circle.position);
		float dist = distV.getLength();
		
		float intersect = (radius + circle.radius) - dist;
		
		if(intersect >= 0) {
			
			CollisionInfo info = new CollisionInfo();
			
			distV.normalize();
			distV.mul(new Vector2(intersect, intersect));
			
			info.penetrateX = distV.x;
			info.penetrateY = distV.y;
		}
		
		
		return null;
	}

}
