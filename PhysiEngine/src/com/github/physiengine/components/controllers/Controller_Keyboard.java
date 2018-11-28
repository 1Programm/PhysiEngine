package com.github.physiengine.components.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.github.physiengine.math.Vector2;

public class Controller_Keyboard extends Controller implements KeyListener {

	private int keyUp, keyLeft, keyDown, keyRight;
	private boolean up, left, down, right;
	private float speed;

	public Controller_Keyboard(float speed) {
		this.keyUp = KeyEvent.VK_UP;
		this.keyLeft = KeyEvent.VK_LEFT;
		this.keyDown = KeyEvent.VK_DOWN;
		this.keyRight = KeyEvent.VK_RIGHT;
		
		this.speed = speed;
	}
	
	public Controller_Keyboard(String controll, float speed) {
		String[] splittedKeys = controll.split(",");
		
		if(splittedKeys.length != 4) {
			//Throw Exception
			return;
		}
		
		this.keyUp = StringUtils.KeyCharToKeyCode(splittedKeys[0]);
		this.keyLeft = StringUtils.KeyCharToKeyCode(splittedKeys[1]);
		this.keyDown = StringUtils.KeyCharToKeyCode(splittedKeys[2]);
		this.keyRight = StringUtils.KeyCharToKeyCode(splittedKeys[3]);
	}

	@Override
	public Vector2 updatePos() {
		Vector2 newVec = new Vector2();
		
		if(up) newVec.y += speed;
		
		if(left) newVec.x -= speed;
		
		if(down) newVec.y -= speed;
		
		if(right) newVec.x += speed;
		
		return newVec;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == keyUp) {
			up = true;
		}
		
		else if(code == keyLeft) {
			left = true;
		}
		
		else if(code == keyDown) {
			down = true;
		}
		
		else if(code == keyRight) {
			right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == keyUp) {
			up = false;
		}
		
		else if(code == keyLeft) {
			left = false;
		}
		
		else if(code == keyDown) {
			down = false;
		}
		
		else if(code == keyRight) {
			right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
