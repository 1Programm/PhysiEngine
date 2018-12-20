package com.github.helperclasses.controll;

import org.lwjgl.input.Keyboard;

import com.github.helperclasses.strings.StringUtils;

public class Input {

	public static boolean isKeyPressed(String key) {
		int keyCode = StringUtils.keyCharToKeyCode(key);
		return Keyboard.isKeyDown(keyCode);
	}
	
}
