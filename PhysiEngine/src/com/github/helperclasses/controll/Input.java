package com.github.helperclasses.controll;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.github.helperclasses.strings.StringUtils;

public class Input extends KeyAdapter{

	private static ArrayList<Integer> keys = new ArrayList<>();
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(!keys.contains(key)) {
			keys.add(key);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(keys.contains(key)) {
			keys.remove(keys.indexOf(key));
		}
	}
	
	public static boolean isKeyPressed(String key) {
		int keyCode = StringUtils.KeyCharToKeyCode(key);
		
		return keys.contains(keyCode);
	}
	
	
}
