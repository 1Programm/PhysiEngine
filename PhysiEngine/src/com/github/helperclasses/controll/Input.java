package com.github.helperclasses.controll;

import java.util.ArrayList;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.math.MathHelp;
import com.github.helperclasses.math.Vector2;
import com.github.helperclasses.strings.StringUtils;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

public class Input implements KeyListener, MouseListener{

	private static ArrayList<Integer> keys = new ArrayList<>();
	
	private static boolean mouse1, mouse2, mouse3;
	private static Vector2 mousePosition = new Vector2(0.1f, 0.1f);
	
	// --------------------------------------------------------------------------------------------
	// Interface methods
	// --------------------------------------------------------------------------------------------
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		Debug.Log(Input.class, "Pressed: " + key);
		
		if((InputEvent.AUTOREPEAT_MASK & e.getModifiers()) == 0) {
			if(!keys.contains(key)) {
				keys.add(key);
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		Debug.Log(Input.class, "Released: " + key);
		
		if((InputEvent.AUTOREPEAT_MASK & e.getModifiers()) == 0) {
			if(keys.contains(key)) {
				keys.remove(keys.indexOf(key));
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//TODO Maybe call listeners which will listen for an click event 
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePosition.set(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Debug.Log(Input.class, "MouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Debug.Log(Input.class, "MouseExited");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePosition.set(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int code = e.getButton();
		
		Debug.Log(Input.class, "MousePressed: " + code);
		
		if(code == MouseEvent.BUTTON1) {
			mouse1 = true;
		}else if(code == MouseEvent.BUTTON2) {
			mouse2 = true;
		}else if(code == MouseEvent.BUTTON3) {
			mouse3 = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int code = e.getButton();
		
		Debug.Log(Input.class, "MouseReleased: " + code);
		
		if(code == MouseEvent.BUTTON1) {
			mouse1 = false;
		}else if(code == MouseEvent.BUTTON2) {
			mouse2 = false;
		}else if(code == MouseEvent.BUTTON3) {
			mouse3 = false;
		}
	}

	@Override
	public void mouseWheelMoved(MouseEvent e) {
		//TODO Don't know if we need it
	}
	
	
	// --------------------------------------------------------------------------------------------
	// Getters
	// --------------------------------------------------------------------------------------------
	
	public static boolean isKeyPressed(String key) {
		int keyCode = StringUtils.KeyCharToKeyCode(key);
		
		return keys.contains(keyCode);
	}
	
	public static boolean mouse1Pressed() {
		return mouse1;
	}
	
	public static boolean mouse2Pressed() {
		return mouse2;
	}
	
	public static boolean mouse3Pressed() {
		return mouse3;
	}
	
	public static Vector2 getMousePos() {
		return mousePosition;
	}
	
	public static float getMouseScreenX() {
		return mousePosition.x;
	}
	
	public static float getMouseScreenY() {
		return mousePosition.y;
	}

	public static float getMouseGameX() {
		return MathHelp.getGamePosX(mousePosition.x);
	}
	
	public static float getMouseGameY() {
		return MathHelp.getGamePosY(mousePosition.y);
	}
	
}
