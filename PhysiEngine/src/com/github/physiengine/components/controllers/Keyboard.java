package com.github.physiengine.components.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.github.physiengine.math.Vector2;

public class Keyboard extends Controller implements KeyListener {

	private char upKey, leftKey, downKey, rightKey;
	private boolean left, right, up, down;
	private float speed;

	public Keyboard(char upKey, char leftKey, char downKey, char rightKey, float speed) {

		this.upKey = upKey;
		this.leftKey = leftKey;
		this.downKey = downKey;
		this.rightKey = rightKey;
		this.speed = speed;

	}

	@Override
	public Vector2 updatePos() {

		Vector2 newVec = new Vector2();
		
		if(up) {
			
			
			newVec.y += speed;
			
		}
		
		if(left) {
			
			
			newVec.x -= speed;;
		}
		
		if(down) {
			
			
			newVec.y -= speed;
			
		}
		
		if(right) {
			
			newVec.x += speed;
			
		}
		
		return newVec;
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		char keyPressed = e.getKeyChar();
		
		if(keyPressed == upKey) {
			
			up = true;
			
		}
		
		else if(keyPressed == leftKey) {
			
			left = true;
			
		}
		
		else if(keyPressed == downKey) {
			
			down = true;
		}
		
		else if(keyPressed == rightKey) {
			
			right = true;
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		char keyPressed = e.getKeyChar();
		
		if(keyPressed == upKey) {
			
			up = false;
			
		}
		
		else if(keyPressed == leftKey) {
			
			left = false;
			
		}
		
		else if(keyPressed == downKey) {
			
			down = false;
		}
		
		else if(keyPressed == rightKey) {
			
			right = false;
			
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
