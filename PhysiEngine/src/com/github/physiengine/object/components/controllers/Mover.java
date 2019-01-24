package com.github.physiengine.object.components.controllers;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.components.Component;

public class Mover extends Component{
	
	private Transform velocities;
	
	public Mover() {
		velocities = Transform.ZERO();
	}

	public void addVelocity(Transform vel) {
		velocities.addTransform(vel);
	}
	
	public void addPosition(Vector3f pos) {
		velocities.addPosition(pos);
	}
	
	public void addRotation(Vector3f rot) {
		velocities.addRotation(rot);
	}
	
	public void addScale(Vector3f scale) {
		velocities.addScale(scale);
	}
	
	public Transform getVelocity() {
		Transform t = Transform.ZERO();
		t.set(velocities);
		
		velocities.set(0, 0, 0, 0, 0, 0, 0, 0, 0);
		return t;
	}
	
	@Override
	public void init() {}

	@Override
	public void update() {}

	@Override
	public void receiveMessage(Component sender, String msg) {}

}
