package com.github.helperclasses.math;


import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.gfx.renderer.DisplayManager;
import com.github.physiengine.world.Settings;

public class MathHelp {
	
	public static Matrix4f createViewMatrix(Vector3f position, Vector3f rotation) {
		Matrix4f viewMatrix = new Matrix4f();
		viewMatrix.setIdentity();
		
		Matrix4f.rotate((float) Math.toRadians(rotation.x), new Vector3f(1, 0, 0), viewMatrix, viewMatrix);
		Matrix4f.rotate((float) Math.toRadians(rotation.y), new Vector3f(0, 1, 0), viewMatrix, viewMatrix);
		Matrix4f.rotate((float) Math.toRadians(rotation.z), new Vector3f(0, 0, 1), viewMatrix, viewMatrix);
		
		Vector3f negativPos = new Vector3f(-position.x, -position.y, -position.z);
		Matrix4f.translate(negativPos, viewMatrix, viewMatrix);
		return viewMatrix;
	}
	
	public static Matrix4f createTransformationMatrix(Vector3f translation, Vector3f rotation, Vector3f scale) {
		Matrix4f matrix = new Matrix4f();
		
		matrix.setIdentity();
		
		Matrix4f.translate(translation, matrix, matrix);
		
		Matrix4f.rotate((float)Math.toRadians(rotation.x), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float)Math.toRadians(rotation.y), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float)Math.toRadians(rotation.z), new Vector3f(0, 0, 1), matrix, matrix);
		
		Matrix4f.scale(scale, matrix, matrix);
		
		return matrix;
	}
	
	public static Matrix4f createTransformationMatrix(Transform transform) {
		Matrix4f matrix = new Matrix4f();
		
		matrix.setIdentity();
		
		Matrix4f.translate(transform.getPosition(), matrix, matrix);
		
		Matrix4f.rotate((float)Math.toRadians(transform.getRotation().x), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float)Math.toRadians(transform.getRotation().y), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float)Math.toRadians(transform.getRotation().z), new Vector3f(0, 0, 1), matrix, matrix);
		
		Matrix4f.scale(transform.getScale(), matrix, matrix);
		
		return matrix;
	}
	
	public static float getGamePosX(float windowX) {
		float x = (windowX / (DisplayManager.getWidth()));
		
		return x * (Settings.RIGHT - Settings.LEFT) + Settings.LEFT;
	}
	
	public static float getGamePosY(float windowY) {
		float y = (windowY / (DisplayManager.getHeight()));
		
		return (y * (Settings.TOP - Settings.BOTTOM) + Settings.BOTTOM ) * (-1);
	}
	
}
