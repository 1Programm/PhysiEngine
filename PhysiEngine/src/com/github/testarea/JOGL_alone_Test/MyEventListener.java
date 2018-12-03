package com.github.testarea.JOGL_alone_Test;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class MyEventListener implements GLEventListener{
	
	public static GL2 gl;

	@Override
	public void display(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		gl = drawable.getGL().getGL2();
	}

}
