package com.github.physiengine.gfx;

import com.github.physiengine.world.Settings;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class WindowUpdates implements GLEventListener {
	
	private Window window;
	
	public WindowUpdates(Window window) {
		this.window = window;
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		Graphics.setGL(drawable.getGL().getGL2());
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		Graphics.setGL(drawable.getGL().getGL2());
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		Graphics.setGL(gl);
		
		//Set Background Color (0,0,0 = black, 1 = 100% alpha)
		gl.glClearColor(0, 0, 0, 1);
		
		//Enable to render 2D Textures
		gl.glEnable(GL2.GL_TEXTURE_2D);
		
		//Enable Blending (Use of alpha values)
		gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		Graphics.setGL(gl);
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		float unitsTall = window.getHeight() / (window.getWidth() / Settings.unitSize);
		
		gl.glOrtho(-Settings.unitSize/2, Settings.unitSize/2, -unitsTall/2, unitsTall/2, -1, 1);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

}
