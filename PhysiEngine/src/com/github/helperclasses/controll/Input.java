package com.github.helperclasses.controll;

import java.util.ArrayList;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.strings.StringUtils;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class Input implements KeyListener{

	private static ArrayList<Integer> keys = new ArrayList<>();
	
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
	
	
	
	public static boolean isKeyPressed(String key) {
		int keyCode = StringUtils.KeyCharToKeyCode(key);
		
		return keys.contains(keyCode);
	}
	
	
}
