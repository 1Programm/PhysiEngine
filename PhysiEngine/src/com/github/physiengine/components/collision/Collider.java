package com.github.physiengine.components.collision;

import java.util.ArrayList;

import com.github.physiengine.components.Changes;
import com.github.physiengine.components.Component;

public abstract class Collider extends Component{

	private enum Layers {
		BaseLayer,
		
	}
	
	private ArrayList<Layers> myLayer;

	public Collider() {
		super("collider");
		myLayer = new ArrayList<>();
		myLayer.add(Layers.BaseLayer);
	}
	
	public CollisionInfo resolveCollision(Collider other) {
		if(other instanceof AABB) {
			return collideWith((AABB)other);
		}else if(other instanceof Circle) {
			return collideWith((Circle)other);
		}
		
		
		return null;
	}
	
	protected abstract CollisionInfo collideWith(AABB other);

	protected abstract CollisionInfo collideWith(Circle other);
	

	protected abstract void onPositionChanged();
	protected abstract void onSizeChanged();
	protected abstract void onRotationChanged();
	
	@Override
	public void update(Changes c) {}
	
}
