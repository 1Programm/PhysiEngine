package com.github.physiengine.object.components.controllers;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.components.Component;

public class Mover extends Component{
	
	private Transform transformations;
	
	public Mover() {
		transformations = Transform.ZERO();
	}

	public void addTransformation(Transform vel) {
		transformations.addTransform(vel);
	}
	
	public void addVelocity(Vector3f posVel) {
		transformations.addPosition(posVel);
	}
	
	public void addRotationVel(Vector3f rotVel) {
		transformations.addRotation(rotVel);
	}
	
	public void addScaleVel(Vector3f scaleVel) {
		transformations.addScale(scaleVel);
	}
	
	public Transform getTransformations() {
		Transform t = Transform.ZERO();
		t.set(transformations);
		
		transformations.set(0, 0, 0, 0, 0, 0, 0, 0, 0);
		return t;
	}
	
	@Override
	public void init() {}

	@Override
	public void update() {}

	@Override
	public void receiveMessage(Component sender, String msg) {}

}
