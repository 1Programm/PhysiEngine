package com.github.physiengine.object.components.controllers;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.helperclasses.strings.StringUtils;
import com.github.physiengine.object.components.Component;

public class ObjectController_Keyboard extends ObjectController{

	public static final int MODE_LINEAR_MOVEMENT = 0;
	public static final int MODE_TURNED_MOVEMENT = 1;
	
	private int mode;
	
	private String forwards;
	private String backwards;
	private String left;
	private String right;
	
	public ObjectController_Keyboard(Vector3f speeds, int mode) {
		super(speeds);
		
		this.mode = mode;
		
		this.forwards = "W";
		this.backwards = "S";
		this.left = "A";
		this.right = "D";
	}
	
	public ObjectController_Keyboard(Vector3f speeds, String[] keys, int mode) {
		super(speeds);
		
		this.mode = mode;
		
		this.forwards = keys[0];
		this.backwards = keys[1];
		this.left = keys[2];
		this.right = keys[3];
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public Transform getTransformation(float posSpeed, float rotSpeed, float scaleSpeed) {
		Transform transform = Transform.ZERO();
		
		if(mode == MODE_LINEAR_MOVEMENT) {
			if(is(forwards)) {
				transform.getPosition().z += posSpeed;
			}
			if(is(backwards)) {
				transform.getPosition().z -= posSpeed;
			}
			if(is(left)) {
				transform.getPosition().x += posSpeed;
			}
			if(is(right)) {
				transform.getPosition().x -= posSpeed;
			}
		}else if(mode == MODE_TURNED_MOVEMENT) {
			float runspeed = 0;
			
			if(is(forwards)) {
				runspeed += posSpeed;
			}
			if(is(backwards)) {
				runspeed -= posSpeed;
			}
			if(is(left)) {
				transform.getRotation().y += rotSpeed;
			}
			if(is(right)) {
				transform.getRotation().y -= rotSpeed;
			}
			
			float dx = (float) (runspeed * Math.sin(Math.toRadians(parent.getRotationY())));
			float dz = (float) (runspeed * Math.cos(Math.toRadians(parent.getRotationY())));
			
			transform.getPosition().x = dx;
			transform.getPosition().z = dz;
			
		}
		
		return transform;
	}
	
	private boolean is(String name) {
		return Keyboard.isKeyDown(StringUtils.keyCharToKeyCode(name));
	}
	
	@Override
	public void receiveMessage(Component sender, String msg) {}

}
