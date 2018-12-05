package com.github.testarea.githubWiki.rendering.JOGL_alone_Test;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics {


	private static float r = 1;
	private static float g = 1;
	private static float b = 1;
	private static float a = 1;
	
	private static float rotation = 0;
	
	public static void drawImage(ImageResource image, float x, float y, float width, float height) {
		GL2 gl = MyEventListener.gl;
		
		Texture tex = image.getTexture();
		
		if(tex != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
		
		gl.glTranslatef(x, y, 0);
		gl.glRotatef(-rotation, 0, 0, 1);
		
		
		gl.glColor4f(r, g, b, a);
		gl.glBegin(GL2.GL_QUADS);
		
			gl.glTexCoord2f(0, 1);
			gl.glVertex2f(- width/2, - height/2);
			
			gl.glTexCoord2f(1, 1);
			gl.glVertex2f(+ width/2, - height/2);

			gl.glTexCoord2f(1, 0);
			gl.glVertex2f(+ width/2, + height/2);

			gl.glTexCoord2f(0, 0);
			gl.glVertex2f(- width/2, + height/2);
			
		gl.glEnd();
		gl.glFlush();

		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
		
		gl.glRotatef(rotation, 0, 0, 1);
		gl.glTranslatef(-x, -y, 0);
	}
	
	public static void drawRect(float x, float y, float width, float height) {
		GL2 gl = MyEventListener.gl;
		
		gl.glTranslatef(x, y, 0);
		gl.glRotatef(-rotation, 0, 0, 1);
		
		
		gl.glColor4f(r, g, b, a);
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex2f(- width/2, - height/2);
		gl.glVertex2f(+ width/2, - height/2);
		gl.glVertex2f(+ width/2, + height/2);
		gl.glVertex2f(- width/2, + height/2);
		
		gl.glEnd();
		gl.glFlush();

		
		gl.glRotatef(rotation, 0, 0, 1);
		gl.glTranslatef(-x, -y, 0);
	}
	
	public static void setColor(float r, float g, float b, float a) {
		Graphics.r = r;
		Graphics.g = g;
		Graphics.b = b;
		Graphics.a = a;
	}
	
	public static void setRotation(float r) {
		Graphics.rotation = r;
	}
	
}
