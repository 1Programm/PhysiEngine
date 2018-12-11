package com.github.physiengine.gfx;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class WindowUpdates implements GLEventListener{

	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		gl = drawable.getGL().getGL2();

		//Set Background Color (0,0,0 = black, 1 = 100% alpha)
		gl.glClearColor(0, 0, 0, 1);
		
		//Enable to render 2D Textures
		gl.glEnable(GL2.GL_TEXTURE_2D);
		
		//Enable Blending (Use of alpha values)
		gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}

}
