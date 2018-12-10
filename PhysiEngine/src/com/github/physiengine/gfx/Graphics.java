package com.github.physiengine.gfx;

public class Graphics {

	private static int r, g, b, a; //Colors
	private static float rotation; //Rotation
	private static float scaleX, scaleY;    //Scale
	
	public static void drawRect(float x, float y, float width, float height) {
		
	}
	
	public static void setColor(int r, int g, int b, int a) {
		Graphics.r = r;
		Graphics.g = g;
		Graphics.b = b;
		Graphics.a = a;
	}
	
	public static void setRotation(float rotation) {
		Graphics.rotation = rotation;
	}
	
	public static void setScale(float scaleX, float scaleY) {
		Graphics.scaleX = scaleX;
		Graphics.scaleY = scaleY;
	}
	
	public static void setScaleX(float scaleX) {
		Graphics.scaleX = scaleX;
	}
	
	public static void setScaleY(float scaleY) {
		Graphics.scaleY = scaleY;
	}
	
}
