package com.github.physiengine.components.controllers;

import com.github.helperclasses.controll.Input;
import com.github.helperclasses.math.Vector2;

public class Controller_Keyboard extends Controller {

	private String keyUp, keyLeft, keyDown, keyRight;
	private float speed;

	public Controller_Keyboard(float speed) {
		super();
		
		this.keyUp = "W";
		this.keyLeft = "A";
		this.keyDown = "S";
		this.keyRight = "D";
		
		this.speed = speed;
	}
	
	public Controller_Keyboard(String controll, float speed) {
		super();
		
		String[] splittedKeys = controll.split(",");
		
		if(splittedKeys.length != 4) {
			try {
				throw new Exception("Not valid Keys - do 'W,A,S,D' or 'Enter,Up,Tab,Escape' ...");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		this.keyUp = splittedKeys[0];
		this.keyLeft = splittedKeys[1];
		this.keyDown = splittedKeys[2];
		this.keyRight = splittedKeys[3];
		
		this.speed = speed;
	}

	@Override
	public Vector2 updatePos() {
		Vector2 newVec = new Vector2();
		
		if(Input.isKeyPressed(keyUp)) newVec.y += speed;
		
		if(Input.isKeyPressed(keyLeft)) newVec.x -= speed;
		
		if(Input.isKeyPressed(keyDown)) newVec.y -= speed;
		
		if(Input.isKeyPressed(keyRight)) newVec.x += speed;
		
		return newVec;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
