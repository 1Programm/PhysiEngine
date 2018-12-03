package com.github.physiengine.components.model;

import com.github.physiengine.components.Changes;
import com.github.physiengine.components.Component;

public class Material extends Component{

	public float mass;
	public float bounce;
	public float friction;
	
	public Material() {
		super("material");
	}
	
	public Material(float mass, float bounce, float friction) {
		super("material");
		
		this.mass = mass;
		this.bounce = bounce;
		this.friction = friction;
	}
	
	@Override
	public void update(Changes c) {}
}
