package com.github.physiengine.gfx;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import com.github.physiengine.world.Time;

public class DisplayManager {
	
	public static int WIDTH;
	public static int HEIGHT;

	public static String NAME;
	public static int FPS;

	public static void createDisplay(String name, int fps, int width, int height) {
		DisplayManager.NAME = name;
		DisplayManager.FPS = fps;
		DisplayManager.WIDTH = width;
		DisplayManager.HEIGHT = height;
		
		ContextAttribs attribs = new ContextAttribs(3, 2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(NAME);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		
		Time.init();
	}
	
	public static void updateDisplay() {
		Display.sync(FPS);
		Display.update();
		
		Time.updateDelta();
	}
	
	public static void closeDisplay() {
		Display.destroy();
	}
	
	public static int getWidth() {
		return Display.getWidth();
	}
	
	public static int getHeight() {
		return Display.getHeight();
	}
	
}
