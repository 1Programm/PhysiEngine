package com.github.helperclasses.strings;

import java.util.ArrayList;
import java.util.HashMap;

import com.jogamp.newt.event.KeyEvent;

public class StringUtils {
	private static HashMap<String, Short> keyboardKeys = new HashMap<>();
	
	static {
		
		keyboardKeys.put("F1", KeyEvent.VK_F1);
		keyboardKeys.put("F2", KeyEvent.VK_F2);
		keyboardKeys.put("F3", KeyEvent.VK_F3);
		keyboardKeys.put("F4", KeyEvent.VK_F4);
		keyboardKeys.put("F5", KeyEvent.VK_F5);
		keyboardKeys.put("F6", KeyEvent.VK_F6);
		keyboardKeys.put("F7", KeyEvent.VK_F7);
		keyboardKeys.put("F8", KeyEvent.VK_F8);
		keyboardKeys.put("F9", KeyEvent.VK_F9);
		keyboardKeys.put("F10", KeyEvent.VK_F10);
		keyboardKeys.put("F11", KeyEvent.VK_F11);
		keyboardKeys.put("F12", KeyEvent.VK_F12);
		
		keyboardKeys.put("1", KeyEvent.VK_1);
		keyboardKeys.put("2", KeyEvent.VK_2);
		keyboardKeys.put("3", KeyEvent.VK_3);
		keyboardKeys.put("4", KeyEvent.VK_4);
		keyboardKeys.put("5", KeyEvent.VK_5);
		keyboardKeys.put("6", KeyEvent.VK_6);
		keyboardKeys.put("7", KeyEvent.VK_7);
		keyboardKeys.put("8", KeyEvent.VK_8);
		keyboardKeys.put("9", KeyEvent.VK_9);
		keyboardKeys.put("0", KeyEvent.VK_0);
		
		keyboardKeys.put("A", KeyEvent.VK_A);
		keyboardKeys.put("B", KeyEvent.VK_B);
		keyboardKeys.put("C", KeyEvent.VK_C);
		keyboardKeys.put("D", KeyEvent.VK_D);
		keyboardKeys.put("E", KeyEvent.VK_E);
		keyboardKeys.put("F", KeyEvent.VK_F);
		keyboardKeys.put("G", KeyEvent.VK_G);
		keyboardKeys.put("H", KeyEvent.VK_H);
		keyboardKeys.put("I", KeyEvent.VK_I);
		keyboardKeys.put("J", KeyEvent.VK_J);
		keyboardKeys.put("K", KeyEvent.VK_K);
		keyboardKeys.put("L", KeyEvent.VK_L);
		keyboardKeys.put("M", KeyEvent.VK_M);
		keyboardKeys.put("N", KeyEvent.VK_N);
		keyboardKeys.put("O", KeyEvent.VK_O);
		keyboardKeys.put("P", KeyEvent.VK_P);
		keyboardKeys.put("Q", KeyEvent.VK_Q);
		keyboardKeys.put("R", KeyEvent.VK_R);
		keyboardKeys.put("S", KeyEvent.VK_S);
		keyboardKeys.put("T", KeyEvent.VK_T);
		keyboardKeys.put("U", KeyEvent.VK_U);
		keyboardKeys.put("V", KeyEvent.VK_V);
		keyboardKeys.put("W", KeyEvent.VK_W);
		keyboardKeys.put("X", KeyEvent.VK_X);
		keyboardKeys.put("Y", KeyEvent.VK_Y);
		keyboardKeys.put("Z", KeyEvent.VK_Z);
		
		keyboardKeys.put("+", KeyEvent.VK_PLUS);
		keyboardKeys.put("-", KeyEvent.VK_MINUS);

		keyboardKeys.put("ESCAPE", KeyEvent.VK_ESCAPE);
		keyboardKeys.put("SPACE", KeyEvent.VK_SPACE);
		keyboardKeys.put("TAB", KeyEvent.VK_TAB);
		keyboardKeys.put("ENTER", KeyEvent.VK_ENTER);
		keyboardKeys.put("SHIFT", KeyEvent.VK_SHIFT);
		keyboardKeys.put("CONTROL", KeyEvent.VK_CONTROL);
		
		keyboardKeys.put("UP", KeyEvent.VK_UP);
		keyboardKeys.put("DOWN", KeyEvent.VK_DOWN);
		keyboardKeys.put("LEFT", KeyEvent.VK_LEFT);
		keyboardKeys.put("RIGHT", KeyEvent.VK_RIGHT);
	};
	
	public static int KeyCharToKeyCode(String keyChar) {
		for(String key : keyboardKeys.keySet()) {
			if(key.equalsIgnoreCase(keyChar)) {
				return keyboardKeys.get(key);
			}
		}
		return -1;
	}
	
	/*
	 * String[] a = {"a", "b", "c"};
	 * 
	 * append(a, "")  -> abc
	 * append(a, " ") -> a b c
	 * append(a, "d") -> adbdc
	 */
	public static String Append(Object[] array, String between) {
		String ret = "";
		
		for(int i=0;i<array.length;i++) {
			if(i != 0) ret += between;
			ret += array[i];
		}
		
		return ret;
	}
	
	
	public static String ArrayToString(Object[] data) {
		String ret = "(";
		
		for(int i=0;i<data.length;i++) {
			if(i != 0) ret += ", ";
			ret += data[i].toString();
		}
		
		return ret + ")";
	}
	
	public static String ArrayListToString(ArrayList<Object> data) {
		String ret = "(";
		
		for(int i=0;i<data.size();i++) {
			if(i != 0) ret += ", ";
			ret += data.get(i).toString();
		}
		
		return ret + ")";
	}
}
