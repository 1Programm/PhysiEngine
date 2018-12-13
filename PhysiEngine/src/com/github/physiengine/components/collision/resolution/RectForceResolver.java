package com.github.physiengine.components.collision.resolution;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.collision.detection.CollisionInfo;

public class RectForceResolver extends Resolver{

	private float force;
	
	public RectForceResolver(float force) {
		this.force = force;
	}
	
	@Override
	protected void resolveCollision(CollisionInfo info) {
		Vector2 vel = new Vector2();
		
		if(info.penetrateX != 0) {
			if(info.penetrateX > 0) {
				vel.set(-force, 0);
			}else {
				vel.set(force, 0);
			}
		}else {
			if(info.penetrateY > 0) {
				vel.set(0, -force);
			}else {
				vel.set(0, force);
			}
		}
		
		parent.getTransform().move(vel);
	}

}
