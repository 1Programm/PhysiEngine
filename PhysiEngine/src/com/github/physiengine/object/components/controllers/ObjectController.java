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
	
	public abstract Transform getTransformation(float posSpeed, float rotSpeed, float scaleSpeed);

	@Override
	public void update() {
		Transform transform = getTransformation(speeds.x * Time.getDelta(), speeds.y * Time.getDelta(), speeds.z * Time.getDelta());
		
		parent.transform(transform);
	}

}
