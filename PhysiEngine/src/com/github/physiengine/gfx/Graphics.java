package com.github.physiengine.gfx;

import java.awt.Color;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.gfx.ImageResource;
import com.github.helperclasses.math.Vector2;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Graphics {

	private static float r = 1, g = 1, b = 1, a = 1; 		//Colors
	private static float rotation = 0; 			//Rotation
	private static float scaleX = 1, scaleY = 1;    //Scale
	private static float antiscaleX = 1, anitscaleY = 1;
	
	private static GL2 gl;
	
	public static void drawRect(float x, float y, float width, float height) {
		if(gl == null) {
			Debug.LogWarning(Graphics.class, "gl - object is null");
			return;
		}
		
		gl.glTranslatef(x, y, 0);
		gl.glScalef(scaleX, scaleY, 1);
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
		gl.glScalef(antiscaleX, anitscaleY, 1);
		gl.glTranslatef(-x, -y, 0);
	}
	
	public static void drawRect(Vector2[] verts, Vector2 mid) {
		if(gl == null) {
			Debug.LogWarning(Graphics.class, "gl - object is null");
			return;
		}

		gl.glTranslatef(mid.x, mid.y, 0);
		gl.glScalef(scaleX, scaleY, 1);
		gl.glRotatef(-rotation, 0, 0, 1);
		
		
		gl.glColor4f(r, g, b, a);
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex2f(verts[0].x, verts[0].y);
		gl.glVertex2f(verts[1].x, verts[1].y);
		gl.glVertex2f(verts[2].x, verts[2].y);
		gl.glVertex2f(verts[3].x, verts[3].y);
		
		gl.glEnd();
		gl.glFlush();

		
		gl.glRotatef(rotation, 0, 0, 1);
		gl.glScalef(antiscaleX, anitscaleY, 1);
		gl.glTranslatef(-mid.x, -mid.y, 0);
	}
	
	public static void drawImage(ImageResource image, Vector2[] verts, Vector2 mid) {
		if(gl == null) {
			Debug.LogWarning(Graphics.class, "gl - object is null");
			return;
		}
		
		Texture tex = image.getTexture();
		
		if(tex != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
		

		gl.glTranslatef(mid.x, mid.y, 0);
		gl.glScalef(scaleX, scaleY, 1);
		gl.glRotatef(-rotation, 0, 0, 1);
		
		
		gl.glColor4f(r, g, b, a);
		gl.glBegin(GL2.GL_QUADS);
		
			gl.glTexCoord2f(0, 1);
			gl.glVertex2f(verts[0].x, verts[0].y);
			
			gl.glTexCoord2f(1, 1);
			gl.glVertex2f(verts[1].x, verts[1].y);
	
			gl.glTexCoord2f(1, 0);
			gl.glVertex2f(verts[2].x, verts[2].y);
	
			gl.glTexCoord2f(0, 0);
			gl.glVertex2f(verts[3].x, verts[3].y);
			
		gl.glEnd();
		gl.glFlush();
	
		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
		
		gl.glRotatef(rotation, 0, 0, 1);
		gl.glScalef(antiscaleX, anitscaleY, 1);
		gl.glTranslatef(-mid.x, -mid.y, 0);
	}
		
	public static void drawImage(ImageResource image, float x, float y, float width, float height) {
		Texture tex = image.getTexture();
		
		if(tex != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
		}
		
		gl.glTranslatef(x, y, 0);
		gl.glScalef(scaleX, scaleY, 1);
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
		gl.glScalef(antiscaleX, anitscaleY, 1);
		gl.glTranslatef(-x, -y, 0);
	}
	
	public static void setColor(float r, float g, float b, float a) {
		Graphics.r = Math.max(0, Math.min(r, 1));
		Graphics.g = Math.max(0, Math.min(g, 1));
		Graphics.b = Math.max(0, Math.min(b, 1));
		Graphics.a = Math.max(0, Math.min(a, 1));
	}
	
	public static void setColor(Color c) {
		setColor((float)(c.getRed() / 255.0), (float)(c.getGreen() / 255.0), (float)(c.getBlue() / 255.0), (float)(c.getAlpha() / 255.0));
	}
	
	public static void setRotation(float rotation) {
		Graphics.rotation = rotation;
	}
	
	public static void setScale(Vector2 scale) {
		setScale(scale.x, scale.y);
	}
	
	public static void setScale(float scaleX, float scaleY) {
		Graphics.scaleX = scaleX;
		Graphics.scaleY = scaleY;
		
		setAntiScale(1 / scaleX, 1 / scaleY);
	}
	
	private static void setAntiScale(float antiX, float antiY) {
		Graphics.antiscaleX = antiX;
		Graphics.anitscaleY = antiY;
	}
	
	public static void setScaleX(float scaleX) {
		Graphics.scaleX = scaleX;
	}
	
	public static void setScaleY(float scaleY) {
		Graphics.scaleY = scaleY;
	}
	
	public static void setGL(GL2 gl) {
		Graphics.gl = gl;
	}
	
}
