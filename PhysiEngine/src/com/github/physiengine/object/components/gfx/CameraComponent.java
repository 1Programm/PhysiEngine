package com.github.physiengine.object.components.gfx;

import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.object.components.controllers.ObjectController_Camera;

public class CameraComponent extends Component{
	
	private float distanceFromObject;
	
	private Camera cam;
	
	
	public CameraComponent(float distanceFromObject) {
		this.distanceFromObject = distanceFromObject;
	}
	
	@Override
	public void init() {
		this.cam = new Camera(parent);
		cam.setViewMode(Camera.FIRST_PERSON);
		cam.setEyeHeight(3);
		cam.setDist(distanceFromObject);
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
