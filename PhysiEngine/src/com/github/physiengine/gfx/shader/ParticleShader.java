package com.github.physiengine.gfx.shader;

import org.lwjgl.util.vector.Matrix4f;

import com.github.helperclasses.math.MathHelp;
import com.github.physiengine.gfx.components.Camera;

public class ParticleShader extends Shader{

	private static final String shaderFile = "ParticleShader";
	
	private int loc_transformationMatrix;
	private int loc_projectionMatrix;
	private int loc_viewMatrix;
	
	public ParticleShader() {
		super(shaderFile);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}

	@Override
	protected void getAllUniformLocations() {
		loc_transformationMatrix = super.getUniformLocation("transformationMatrix");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_transformationMatrix, matrix);
	}
	
	public void loadProjectionMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_projectionMatrix, matrix);
	}
	
	public void loadViewMatrix(Camera camera) {
		Matrix4f viewMatrix = MathHelp.createViewMatrix(camera.getPosition(), camera.getRotation());
		super.loadMatrix(loc_viewMatrix, viewMatrix);
	}

}
