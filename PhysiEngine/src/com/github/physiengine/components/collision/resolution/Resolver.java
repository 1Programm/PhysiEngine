package com.github.physiengine.components.collision.resolution;

import com.github.physiengine.components.Component;
import com.github.physiengine.components.ComponentTyp;
import com.github.physiengine.components.collision.detection.Collider;
import com.github.physiengine.components.collision.detection.CollisionInfo;

public abstract class Resolver extends Component {
	
	public Resolver() {
		typ = ComponentTyp.ControllingComponent;
	}
	
	@Override
	public void update() {
		Collider collider = parent.getComponent(Collider.class);
		
		if(collider != null) {
			if(collider.getCollision() != null) {
				resolveCollision(collider.getCollision());
			}
		}
	}
	
	protected abstract void resolveCollision(CollisionInfo info);

}
