package com.github.physiengine.gfx.components;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.object.GameObject;

public class Camera {
	
	public static final int THIRD_PERSON = 0;
	public static final int THIRD_PERSON_LOCKED = 1;
	public static final int FIRST_PERSON = 2;
	

	private Vector3f position;
	private Vector3f rotation;
	
	private GameObject toFollow;
	
	private float distanceFromObject;
	private float angleAroundObject;
	private float eyeHeight = 6;
	
	private boolean controllable;
	
	public Camera(GameObject toFollow) {
		this.toFollow = toFollow;
		this.position = new Vector3f();
		this.rotation = new Vector3f();
		
		setViewMode(THIRD_PERSON);
	}
	
	public void update() {
		if(controllable) {
			calculateZoom();
			calculatePitch();
			calculateAngleAroundPlayer();
		}
		
		float horDist = calculateHorizontalDist();
		float vertDist = calculateVerticalDist();
		
		calculateCamPos(horDist, vertDist);
		
		this.rotation.y = 180 - (toFollow.getTransform().getRotation().y + angleAroundObject);
	}
	
	private float calculateHorizontalDist() {
		return (float) (distanceFromObject * Math.cos(Math.toRadians(rotation.x)));
	}
	
	private float calculateVerticalDist() {
		return (float) (distanceFromObject * Math.sin(Math.toRadians(rotation.x)));
	}
	
	private void calculateCamPos(float horDist, float vertDist) {
		float angle = toFollow.getTransform().getRotation().y + angleAroundObject;
		float offsetX = (float) (horDist * Math.sin(Math.toRadians(angle)));
		float offsetZ = (float) (horDist * Math.cos(Math.toRadians(angle)));
		
		position.x = toFollow.getTransform().getPosition().x - offsetX;
		position.y = toFollow.getTransform().getPosition().y + vertDist + eyeHeight;
		position.z = toFollow.getTransform().getPosition().z - offsetZ;
	}
	
	private void calculateZoom() {
		float zoomLevel = Mouse.getDWheel() * 0.1f;
		distanceFromObject -= zoomLevel;
	}
	
	private void calculatePitch() {
		if(Mouse.isButtonDown(1)) {
			float pitchChange = Mouse.getDY() * 0.1f;
			rotation.x -= pitchChange;
		}
	}
	
	private void calculateAngleAroundPlayer() {
		if(Mouse.isButtonDown(0)) {
			float angleChange = Mouse.getDX() * 0.3f;
			angleAroundObject -= angleChange;
		}
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public Vector3f getRotation() {
		return rotation;
	}
	
	public void setViewMode(int MODE) {
		switch(MODE) {
		case THIRD_PERSON:
			this.distanceFromObject = 50;
			this.angleAroundObject = 0;
			this.update();
			this.controllable = true;
			break;
		case THIRD_PERSON_LOCKED:
			this.distanceFromObject = 40;
			this.angleAroundObject = 0;
			this.rotation.x = 25;
			this.update();
			this.controllable = false;
			break;
		case FIRST_PERSON:
			this.distanceFromObject = -1;
			this.angleAroundObject = 0;
			this.rotation.x = 4.6f;
			this.update();
			this.controllable = false;
			break;
		}
	}
	
}
