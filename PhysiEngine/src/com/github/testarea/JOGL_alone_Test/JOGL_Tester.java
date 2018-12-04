package com.github.testarea.JOGL_alone_Test;

import com.github.physiengine.engine.FPSAnimator;
import com.github.physiengine.engine.UpdateMethod;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.event.WindowUpdateEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

public class JOGL_Tester {
	public static int WIDTH = 600, HEIGHT = WIDTH / 12 * 9;
	
	public static int units = 10;

	public static GLProfile profile;	
	public static GLWindow window;
	
	public JOGL_Tester() {
		GLProfile.initSingleton();
		
		profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window = GLWindow.create(caps);
		window.setSize(WIDTH, HEIGHT);
		window.setResizable(false);
		window.addGLEventListener(new MyEventListener());
		window.setTitle("JOGL - Test");
		window.requestFocus();
		window.addWindowListener(new WindowListener() {
			@Override
			public void windowResized(WindowEvent arg0) {}
			@Override
			public void windowRepaint(WindowUpdateEvent arg0) {}
			@Override
			public void windowMoved(WindowEvent arg0) {}
			@Override
			public void windowLostFocus(WindowEvent arg0) {}
			@Override
			public void windowGainedFocus(WindowEvent arg0) {}
			@Override
			public void windowDestroyed(WindowEvent arg0) {
				System.exit(0);
			}
			@Override
			public void windowDestroyNotify(WindowEvent arg0) {}
		});
		
		window.setVisible(true);
		
		// Our FPSAnimator ! ;D not from OpenGL
		FPSAnimator anim = new FPSAnimator(60);
		anim.setUpdateMethod(update);
		anim.start();
	}
	
	private UpdateMethod update = () -> {
		window.display();
	};
	
	public static int getWindowWidth() {
		return window.getWidth();
	}
	
	public static int getWindowHeight() {
		return window.getHeight();
	}

	
	
	
	public static void main(String[] args) {
		new JOGL_Tester();
	}
	
}
