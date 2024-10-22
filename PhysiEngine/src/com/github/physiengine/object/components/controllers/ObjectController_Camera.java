package com.github.physiengine.object.components.controllers;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.log.Log;
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
		
		if(cam == null) {
			Log.warn("Initializing Camera Controller", "Could not find a CameraComponent attached to this GameObject (" + parent.getClass().getSimpleName() + ") ...");
		}
	}

	@Override
	public Transform getTransformation(float posSpeed, float rotSpeed, float scaleSpeed) {
		Transform transform = Transform.ZERO();
		
		if(cam != null) {
			Vector2f runspeeds = new Vector2f();
			boolean pressedX = false;
			boolean pressedY = false;
			
			if(Keyboard.isKeyDown(StringUtils.keyCharToKeyCode("W"))) {
				runspeeds.x += 1;
				pressedX = true;
			}
			if(Keyboard.isKeyDown(StringUtils.keyCharToKeyCode("S"))) {
				runspeeds.x -= 1;
				pressedX = !pressedX;
			}
			if(Keyboard.isKeyDown(StringUtils.keyCharToKeyCode("A"))) {
				runspeeds.y += 1;
				pressedY = true;
			}
			if(Keyboard.isKeyDown(StringUtils.keyCharToKeyCode("D"))) {
				runspeeds.y -= 1;
				pressedY = !pressedY;
			}
			
			if(pressedX || pressedY) {
				runspeeds.normalise();
				runspeeds.x *= posSpeed;
				runspeeds.y *= posSpeed;
			}
			
			double c = Math.cos(Math.toRadians(cam.getRotation().y - 90));
			double s = Math.sin(Math.toRadians(cam.getRotation().y - 90));
			
			float dx = (float) (s * runspeeds.y + c * runspeeds.x);
			float dz = (float) (-c * runspeeds.y + s * runspeeds.x);
			
			transform.getPosition().x = dx;
			transform.getPosition().z = dz;
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
