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
	private float eyeHeight = 0;
	
	private float zoomSpeed;
	
	private boolean controllable;
	
	public Camera(GameObject toFollow) {
		this.toFollow = toFollow;
		this.position = new Vector3f();
		this.rotation = new Vector3f();
		
		this.zoomSpeed = 0.1f;
		
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
		
		this.rotation.y = 180 - (toFollow.getRotationY() + angleAroundObject);
	}
	
	private float calculateHorizontalDist() {
		return (float) (distanceFromObject * Math.cos(Math.toRadians(rotation.x)));
	}
	
	private float calculateVerticalDist() {
		return (float) (distanceFromObject * Math.sin(Math.toRadians(rotation.x)));
	}
	
	private void calculateCamPos(float horDist, float vertDist) {
		float angle = toFollow.getRotationY() + angleAroundObject;
		float offsetX = (float) (horDist * Math.sin(Math.toRadians(angle)));
		float offsetZ = (float) (horDist * Math.cos(Math.toRadians(angle)));
		
		position.x = toFollow.getPositionX() - offsetX;
		position.y = toFollow.getPositionY() + vertDist + eyeHeight;
		position.z = toFollow.getPositionZ() - offsetZ;
	}
	
	private void calculateZoom() {
		float zoomLevel = Mouse.getDWheel() * zoomSpeed;
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
	
	public void setZoomSpeed(float zoomSpeed) {
		this.zoomSpeed = zoomSpeed;
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public Vector3f getRotation() {
		return rotation;
	}
	
	public void setEyeHeight(float height) {
		this.eyeHeight = height;
	}
	
	public void setDist(float distanceFromObject) {
		this.distanceFromObject = distanceFromObject;
	}
	
	public void rotateY(float rotY) {
		angleAroundObject += rotY;
	}
	
	public void setViewMode(int MODE) {
		switch(MODE) {
		case THIRD_PERSON:
			this.distanceFromObject = 15;
			this.angleAroundObject = 0;
			this.rotation.x = 30;
			this.update();
			this.controllable = true;
			break;
		case THIRD_PERSON_LOCKED:
			this.distanceFromObject = 20;
			this.angleAroundObject = 0;
			this.rotation.x = 35;
			this.update();
			this.controllable = false;
			break;
		case FIRST_PERSON:
			this.distanceFromObject = 0;
			this.angleAroundObject = 0;
			this.rotation.x = 0;
			this.update();
			this.controllable = true;
			break;
		}
	}
	
	public void setView(float distFromObj, float yRot, float xRot, boolean controllable) {
		this.distanceFromObject = distFromObj;
		this.angleAroundObject = yRot;
		this.rotation.x = xRot;
		
		if(controllable == false) {
			this.update();
			this.controllable = controllable;
		}else {
			this.controllable = controllable;
			this.update();
		}
	}
	
}
