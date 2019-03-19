package com.github.physiengine.object.components.gfx;

import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.object.components.controllers.ObjectController_Camera;

public class CameraComponent extends Component{
	
	private float distanceFromObject;
	private float eyeHeight;
	private float zoomSpeed;
	
	private Camera cam;
	
	public CameraComponent() {
		this.distanceFromObject = 10;
		this.eyeHeight = 0;
	}
	
	public CameraComponent(float distanceFromObject) {
		this.distanceFromObject = distanceFromObject;
		this.eyeHeight = 0;
	}
	
	public CameraComponent(float distanceFromObject, float eyeheight) {
		this.distanceFromObject = distanceFromObject;
		this.eyeHeight = eyeheight;
	}
	
	public CameraComponent(float distanceFromObject, float eyeheight, float zoomSpeed) {
		this.distanceFromObject = distanceFromObject;
		this.eyeHeight = eyeheight;
		this.zoomSpeed = zoomSpeed;
	}
	
	@Override
	public void init() {
		this.cam = new Camera(parent);
		cam.setViewMode(Camera.THIRD_PERSON);
		cam.setEyeHeight(eyeHeight);
		cam.setDist(distanceFromObject);
		
		if(zoomSpeed != 0) {
			cam.setZoomSpeed(zoomSpeed);
		}
		
		GamePlayer.setCamera(cam);
		
		parent.sendMessage(ObjectController_Camera.class, this, "Init Camera");
	}
	
	@Override
	public void update() {
		cam.update();
	}

	@Override
	public void receiveMessage(Component sender, String msg) {
		
	}
	
	public Camera getCamera() {
		return cam;
	}

}
