package com.github.physiengine.gfx.shader;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;

import com.github.helperclasses.math.MathHelp;
import com.github.physiengine.gfx.components.Camera;

public class ObjectShader extends PhysiShader {

	private static final String fileName = "StaticShader";

	private int loc_transformationMatrix;
	private int loc_projectionMatrix;
	private int loc_viewMatrix;
	private int loc_numberOfRows;
	private int loc_offset;
	
	public ObjectShader() {
		super(fileName);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
		super.bindAttribute(2, "normal");
	}

	@Override
	protected void getAllUniformLocations() {
		loc_transformationMatrix = super.getUniformLocation("transformationMatrix");
		loc_projectionMatrix = super.getUniformLocation("projectionMatrix");
		loc_viewMatrix = super.getUniformLocation("viewMatrix");
		loc_numberOfRows = super.getUniformLocation("numberOfRows");
		loc_offset = super.getUniformLocation("offset");
	}
	
	public void loadNumberOfRows(int numberOfRows) {
		super.loadFloat(loc_numberOfRows, numberOfRows);
	}
	
	public void loadOffset(float x, float y) {
		super.loadVector2(loc_offset, new Vector2f(x, y));
	}
	
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_transformationMatrix, matrix);
	}
	
	public void loadProjectionMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_projectionMatrix, matrix);
	}
	
	public void loadViewMatrix(Camera cam) {
		Matrix4f viewMatrix = MathHelp.createViewMatrix(cam.getPosition(), cam.getRotation());
		super.loadMatrix(loc_viewMatrix, viewMatrix);
	}
}
