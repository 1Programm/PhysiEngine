package com.github.physiengine.components.collision;

import com.github.helperclasses.math.Vector2;

public class Circle extends Collider{

	public Vector2 position;
	
	public float radius;
	
	@Override
	protected CollisionInfo collideWith(AABB other) {
		return null;
	}

	@Override
	protected CollisionInfo collideWith(Circle other) {
		Vector2 distV = new Vector2(position, other.position);
		float dist = distV.getLength();
		
		float intersect = (radius + other.radius) - dist;
		
		if(intersect >= 0) {
			
			CollisionInfo info = new CollisionInfo();
			
			distV.normalize();
			distV.mul(new Vector2(intersect, intersect));
			
			info.penetrateX = distV.x;
			info.penetrateY = distV.y;
		}
		
		
		return null;
	}

	@Override
	protected void onPositionChanged() {
		this.position = parent.getTransform().getPos();
	}

	@Override
	protected void onSizeChanged() {
		this.radius = parent.getTransform().getScale().getLength();
	}

	@Override
	protected void onRotationChanged() {
		//TODO 
	}

}
