package com.github.physiengine.object.components.controllers;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.world.Time;

public abstract class ObjectController extends Component{

	private Vector3f speeds;
	
	public ObjectController(Vector3f speeds) {
		this.speeds = speeds;
	}
	
	public abstract Transform getTransformation(Vector3f speeds);

	@Override
	public void update() {
		Transform transform = getTransformation(new Vector3f(speeds.x * Time.getDelta(), speeds.y * Time.getDelta(), speeds.z * Time.getDelta()));
		
		parent.getTransform().addTransform(transform);
	}

}
