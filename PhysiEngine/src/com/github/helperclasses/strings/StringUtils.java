package com.github.helperclasses.strings;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.input.Keyboard;

public class StringUtils {
	private static HashMap<String, Integer> keyboardKeys = new HashMap<>();
	
	static {
		
		keyboardKeys.put("F1", Keyboard.KEY_F1);
		keyboardKeys.put("F2", Keyboard.KEY_F1);
		keyboardKeys.put("F3", Keyboard.KEY_F3);
		keyboardKeys.put("F4", Keyboard.KEY_F4);
		keyboardKeys.put("F5", Keyboard.KEY_F5);
		keyboardKeys.put("F6", Keyboard.KEY_F6);
		keyboardKeys.put("F7", Keyboard.KEY_F7);
		keyboardKeys.put("F8", Keyboard.KEY_F8);
		keyboardKeys.put("F9", Keyboard.KEY_F9);
		keyboardKeys.put("F10", Keyboard.KEY_F10);
		keyboardKeys.put("F11", Keyboard.KEY_F11);
		keyboardKeys.put("F12", Keyboard.KEY_F12);
		
		keyboardKeys.put("1", Keyboard.KEY_1);
		keyboardKeys.put("2", Keyboard.KEY_2);
		keyboardKeys.put("3", Keyboard.KEY_3);
		keyboardKeys.put("4", Keyboard.KEY_4);
		keyboardKeys.put("5", Keyboard.KEY_5);
		keyboardKeys.put("6", Keyboard.KEY_6);
		keyboardKeys.put("7", Keyboard.KEY_7);
		keyboardKeys.put("8", Keyboard.KEY_8);
		keyboardKeys.put("9", Keyboard.KEY_9);
		keyboardKeys.put("0", Keyboard.KEY_0);
		
		keyboardKeys.put("A", Keyboard.KEY_A);
		keyboardKeys.put("B", Keyboard.KEY_B);
		keyboardKeys.put("C", Keyboard.KEY_C);
		keyboardKeys.put("D", Keyboard.KEY_D);
		keyboardKeys.put("E", Keyboard.KEY_E);
		keyboardKeys.put("F", Keyboard.KEY_F);
		keyboardKeys.put("G", Keyboard.KEY_G);
		keyboardKeys.put("H", Keyboard.KEY_H);
		keyboardKeys.put("I", Keyboard.KEY_I);
		keyboardKeys.put("J", Keyboard.KEY_J);
		keyboardKeys.put("K", Keyboard.KEY_K);
		keyboardKeys.put("L", Keyboard.KEY_L);
		keyboardKeys.put("M", Keyboard.KEY_M);
		keyboardKeys.put("N", Keyboard.KEY_N);
		keyboardKeys.put("O", Keyboard.KEY_O);
		keyboardKeys.put("P", Keyboard.KEY_P);
		keyboardKeys.put("Q", Keyboard.KEY_Q);
		keyboardKeys.put("R", Keyboard.KEY_R);
		keyboardKeys.put("S", Keyboard.KEY_S);
		keyboardKeys.put("T", Keyboard.KEY_T);
		keyboardKeys.put("U", Keyboard.KEY_U);
		keyboardKeys.put("V", Keyboard.KEY_V);
		keyboardKeys.put("W", Keyboard.KEY_W);
		keyboardKeys.put("X", Keyboard.KEY_X);
		keyboardKeys.put("Y", Keyboard.KEY_Y);
		keyboardKeys.put("Z", Keyboard.KEY_Z);
		
		keyboardKeys.put("+", Keyboard.KEY_ADD);
		keyboardKeys.put("-", Keyboard.KEY_SUBTRACT);

		keyboardKeys.put("ESCAPE", Keyboard.KEY_ESCAPE);
		keyboardKeys.put("SPACE", Keyboard.KEY_SPACE);
		keyboardKeys.put("TAB", Keyboard.KEY_TAB);
		keyboardKeys.put("ENTER", Keyboard.KEY_RETURN);
		keyboardKeys.put("SHIFT", Keyboard.KEY_LSHIFT);
		keyboardKeys.put("CONTROL", Keyboard.KEY_LCONTROL);
		
		keyboardKeys.put("UP", Keyboard.KEY_UP);
		keyboardKeys.put("DOWN", Keyboard.KEY_DOWN);
		keyboardKeys.put("LEFT", Keyboard.KEY_LEFT);
		keyboardKeys.put("RIGHT", Keyboard.KEY_RIGHT);
	};
	
	public static int keyCharToKeyCode(String keyChar) {
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
