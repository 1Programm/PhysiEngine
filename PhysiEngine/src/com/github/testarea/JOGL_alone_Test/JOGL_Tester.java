package com.github.testarea.JOGL_alone_Test;

import com.github.physiengine.engine.FPSAnimator;
import com.github.physiengine.engine.UpdateMethod;
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
		
		window.setVisible(true);
		
		// Our FPSAnimator ! ;D not from OpenGL
		FPSAnimator anim = new FPSAnimator(60, false);
		anim.setUpdateMethod(update);
		anim.start();
	}
	
	private UpdateMethod update = () -> {
		window.display();
	};

	public static void main(String[] args) {
		new JOGL_Tester();
	}
	
}
