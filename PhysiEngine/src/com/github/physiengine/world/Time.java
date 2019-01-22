package com.github.physiengine.world;

import org.lwjgl.Sys;

public class Time {

	private static long LAST;
	private static float delta;
	
	private static float sinTime;
	
	public static void init() {
		LAST = Sys.getTime();
	}
	
	public static void updateDelta() {
		long curTime = getCurrentTime();
		delta = (curTime - LAST) / 1000f;
		LAST = curTime;
		
		sinTime += (delta / 10.0);
		
		if(sinTime >= Math.PI * 2) {
			sinTime = 0;
		}
	}
	
	public static float getDelta() {
		return delta;
	}
	
	public static float getSinTime() {
		return (float)(Math.sin(sinTime) * 0.5 + 0.5);
	}
	
	public static float getSinTime(float offset, float scale) {
		return (float)(Math.sin((sinTime + offset) * scale) * 0.5 + 0.5);
	}
	
	private static long getCurrentTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
}
