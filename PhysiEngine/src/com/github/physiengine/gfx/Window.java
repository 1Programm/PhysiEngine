package com.github.physiengine.gfx;

import com.github.helperclasses.controll.Input;
import com.github.helperclasses.math.Vector2;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.UpdateMethod;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

public class Window {
	
	public static GLProfile profile;

	public static Window Create(GameStats stats, UpdateMethod renderMethod) {
		Window w = new Window();

		if(profile == null) {
			profile = GLProfile.get(GLProfile.GL2);
		}

		GLCapabilities caps = new GLCapabilities(profile);
		
		String name = stats.getVariable(GameStats.WINDOW_NAME, String.class);
		Integer width = (int)stats.getVariable(GameStats.WINDOW_SIZE, Vector2.class).x;
		Integer height = (int)stats.getVariable(GameStats.WINDOW_SIZE, Vector2.class).y;
		
		if(name == null || width == null || height == null) return null;
		
		w.window = GLWindow.create(caps);
		w.window.setSize(width, height);
		w.window.setResizable(false);    // <-- should this be a variable in GameStats ?
		w.window.addGLEventListener(new WindowUpdates(w));
		w.window.setTitle(name);
		w.window.requestFocus();
		w.window.addWindowListener(new WindowListener());
		
		Input in = new Input();
		w.window.addKeyListener(in);
		w.window.addMouseListener(in);
		
		w.window.setVisible(true);
		
		w.renderMethod = renderMethod;
		
		return w;
	}
	
	private GLWindow window;
	private UpdateMethod renderMethod;
	
	public GLWindow getWindow() {
		return window;
	}
	
	public UpdateMethod getRenderMethod() {
		return renderMethod;
	}
	
	public int getWidth() {
		return window.getWidth();
	}
	
	public int getHeight() {
		return window.getHeight();
	}
	
}
