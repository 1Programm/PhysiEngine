package com.github.physiengine.object.components.controllers;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.components.Component;

public class ObjectController_Simple extends ObjectController{

	private Vector3f posVel;
	private Vector3f rotVel;
	private Vector3f scaleVel;
	
	public ObjectController_Simple() {
		super(new Vector3f(1, 1, 1));
		
		this.posVel = new Vector3f();
		this.rotVel = new Vector3f();
		this.scaleVel = new Vector3f();
	}
	
	public ObjectController_Simple setPositionVel(Vector3f posVel) {
		this.posVel = posVel;
		
		return this;
	}
	
	public ObjectController_Simple setRotationVel(Vector3f rotVel) {
		this.rotVel = rotVel;
		
		return this;
	}
	
	public ObjectController_Simple setScaleVel(Vector3f scaleVel) {
		this.scaleVel = scaleVel;
		
		return this;
	}

	@Override
	public Transform getTransformation(float posSpeed, float rotSpeed, float scaleSpeed) {
		return new Transform()
				.set(
						posVel.x * posSpeed, posVel.y * posSpeed, posVel.z * posSpeed,
						rotVel.x * rotSpeed, rotVel.y * rotSpeed, rotVel.z * rotSpeed,
						scaleVel.x * scaleSpeed, scaleVel.y * scaleSpeed, scaleVel.z * scaleSpeed);
	}

	@Override
	public void init() {}

	@Override
	public void receiveMessage(Component sender, String msg) {}

}
