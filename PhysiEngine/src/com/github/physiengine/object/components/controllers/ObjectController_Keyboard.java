package com.github.physiengine.object.components.controllers;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.helperclasses.strings.StringUtils;

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
	public Transform getTransformation(Vector3f speeds) {
		Transform transform = Transform.ZERO();
		
		if(mode == MODE_LINEAR_MOVEMENT) {
			if(is(forwards)) {
				transform.getPosition().z += speeds.x;
			}
			if(is(backwards)) {
				transform.getPosition().z -= speeds.x;
			}
			if(is(left)) {
				transform.getPosition().x += speeds.x;
			}
			if(is(right)) {
				transform.getPosition().x -= speeds.x;
			}
		}else if(mode == MODE_TURNED_MOVEMENT) {
			float runspeed = 0;
			
			if(is(forwards)) {
				runspeed -= speeds.x;
			}
			if(is(backwards)) {
				runspeed += speeds.x;
			}
			if(is(left)) {
				//transform.getPosition().x -= speed;abc
				transform.getRotation().y += speeds.z;
			}
			if(is(right)) {
				//transform.getPosition().x += speed;
				transform.getRotation().y -= speeds.z;
			}
			

			float dx = (float) (runspeed * Math.sin(Math.toRadians(parent.getTransform().getRotation().y)));
			float dz = (float) (runspeed * Math.cos(Math.toRadians(parent.getTransform().getRotation().y)));
			
			transform.getPosition().x = dx;
			transform.getPosition().z = dz;
			
		}
		
		return transform;
	}
	
	private boolean is(String name) {
		return Keyboard.isKeyDown(StringUtils.keyCharToKeyCode(name));
	}

}
