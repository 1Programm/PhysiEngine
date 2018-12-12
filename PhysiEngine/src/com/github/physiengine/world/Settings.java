package com.github.physiengine.world;

import com.github.helperclasses.math.Vector2;

public class Settings {

	public static Vector2 GRAVITY = new Vector2(0, -0.8f);

	public static float airFriction = 0.2f; 
	
	public static float unitSize = 10;
	
	public static float LEFT;
	public static float RIGHT;
	public static float BOTTOM;
	public static float TOP;
	
	public static float getUnitsWidth() {
		return RIGHT - LEFT;
	}
	
	public static float getUnitsHeight() {
		return TOP - BOTTOM;
	}
	
}
