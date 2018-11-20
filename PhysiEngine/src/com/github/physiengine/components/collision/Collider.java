package com.github.physiengine.components.collision;

import java.util.ArrayList;

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
	
	protected abstract CollisionInfo collideWith(AABB aabb);

	protected abstract CollisionInfo collideWith(Circle cicle);
	

	@Override
	public void update() {}
	
}
