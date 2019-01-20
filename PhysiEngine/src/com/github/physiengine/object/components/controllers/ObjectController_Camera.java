package com.github.physiengine.object.components.controllers;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.math.Transform;
import com.github.helperclasses.strings.StringUtils;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.object.components.gfx.CameraComponent;

public class ObjectController_Camera extends ObjectController{

	private Camera cam;
	
	public ObjectController_Camera(Vector3f speeds) {
		super(speeds);
	}
	
	@Override
	public void init() {
		CameraComponent camComponent = parent.getComponent(CameraComponent.class);
		if(camComponent != null) {
			cam = camComponent.getCamera();
		}
	}

	@Override
	public Transform getTransformation(Vector3f speeds) {
		Transform transform = Transform.ZERO();
		
		if(cam != null) {
			float runspeed = 0;
			
			if(Keyboard.isKeyDown(StringUtils.keyCharToKeyCode("W"))) {
				runspeed += speeds.x;
			}
			if(Keyboard.isKeyDown(StringUtils.keyCharToKeyCode("S"))) {
				runspeed -= speeds.x;
			}
			
			float dx = (float) (runspeed * Math.cos(Math.toRadians(cam.getRotation().y - 90)));
			float dz = (float) (runspeed * Math.sin(Math.toRadians(cam.getRotation().y - 90)));
			
			transform.getPosition().x = dx;
			transform.getPosition().z = dz;
		}else {
			Debug.LogWarning(getClass(), "Could not find a CameraComponent attached to this GameObject (" + parent.getClass().getSimpleName() + ") ...");
		}

		return transform;
	}
	
	@Override
	public void receiveMessage(Component sender, String msg) {
		if(sender instanceof CameraComponent) {
			cam = ((CameraComponent) sender).getCamera();
		}
	}

}
