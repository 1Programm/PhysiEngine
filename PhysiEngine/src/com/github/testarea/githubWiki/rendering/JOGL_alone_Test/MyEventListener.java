package com.github.testarea.githubWiki.rendering.JOGL_alone_Test;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class MyEventListener implements GLEventListener{
	
	public static GL2 gl;

	private float p1 = 0.75f, p2 = -0.75f, p3 = 0.75f, p4 = -0.75f;
	private float s1 = 0.05f,  s2 = -0.05f , s3 = 0.05f , s4 = -0.05f;
	
	private float min = -4, max = 5;
	
	@Override
	public void display(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		
		//Fill Background with Clear color, which was set in the init method
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		//Set Color for future Drawings
		Graphics.setColor(0, 0.5f, 0.5f, 0.3f);
		
		//Draw first Rect (x = 0, y = 0) -> Rect would be centered in the middle
		Graphics.drawRect(p1, 0, 1, 1);
		
		Graphics.drawRect(p2, 0, 1, 1);

		Graphics.drawRect(0, p3, 1, 1);

		Graphics.drawRect(0, p4, 1, 1);
		
		
		p1 += s1;
		if(p1 > max || p1 < min) {
			s1 *= -1;
		}
		
		p2 += s2;
		if(p2 > max || p2 < min) {
			s2 *= -1;
		}
		
		p3 += s3;
		if(p3 > max || p3 < min) {
			s3 *= -1;
		}
		
		p4 += s4;
		if(p4 > max || p4 < min) {
			s4 *= -1;
		}
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
	}
	
	//Init is called once for initialization
	@Override 
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();

		//Set Background Color (0,0,0 = black, 1 = 100% alpha)
		gl.glClearColor(0, 0, 0, 1);
		
		//Enable to render 2D Textures
		gl.glEnable(GL2.GL_TEXTURE_2D);
		
		//Enable Blending (Use of alpha values)
		gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	}

	//Setting up the mapping for units, so that the units Value is used instead of pixels
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		float unitsTall = JOGL_Tester.getWindowHeight() / (JOGL_Tester.getWindowWidth() / JOGL_Tester.units);
		
		gl.glOrtho(-JOGL_Tester.units/2, JOGL_Tester.units/2, -unitsTall/2, unitsTall/2, -1, 1);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

}
