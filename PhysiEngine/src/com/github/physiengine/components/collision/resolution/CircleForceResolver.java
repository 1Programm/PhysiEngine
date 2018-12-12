package com.github.physiengine.components.collision.resolution;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.collision.detection.CollisionInfo;

public class CircleForceResolver extends Resolver{

	private float force;
	
	public CircleForceResolver(float force) {
		this.force = force;
	}
	
	@Override
	protected void resolveCollision(CollisionInfo info) {
		Vector2 dir = new Vector2(parent.getTransform().getPos(), info.otherPosition);
		
		float l = dir.getLength();
		if(l < 0.001f) l = 0.001f;
		
		dir.mul(-(force / l));
		
		parent.getTransform().move(dir);
	}

}
