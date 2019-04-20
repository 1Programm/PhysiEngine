package com.github.physiengine.gfx;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import com.github.physiengine.EngineSettings;
import com.github.physiengine.world.Time;

public class DisplayManager {

	private static EngineSettings settings;
	
	private static float timer;
	private static int updates;

	public static void createDisplay(EngineSettings settings) {
		DisplayManager.settings = settings;
		
		ContextAttribs attribs = 
				new ContextAttribs(3, 2)
				.withForwardCompatible(true)
				.withProfileCore(true);
		
		try {
			Display.setDisplayMode(
					new DisplayMode(settings.getWindowWidth(), settings.getWindowHeight())
			);
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(settings.getWindowTitle());
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0, 0, settings.getWindowWidth(), settings.getWindowHeight());
	}
	
	public static void updateDisplay() {
		Display.sync(settings.getGameFpsCap());
		Display.update();
		
		if(settings.isPrintFPS()) {
			timer += Time.getDelta();
			updates++;
			
			if(timer >= 1.0) {
				timer = 0;
				settings.getFpsLogger().trace("Engine", "Updates: " + updates);
				updates = 0;
			}
		}
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
