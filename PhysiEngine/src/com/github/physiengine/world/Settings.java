package com.github.physiengine.world;

import org.lwjgl.util.vector.Vector3f;

public class Settings {

	public static Vector3f GRAVITY = new Vector3f(0, -0.8f, 0);

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
