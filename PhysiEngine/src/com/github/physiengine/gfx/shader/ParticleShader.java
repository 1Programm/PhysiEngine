package com.github.physiengine.gfx.shader;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

public class ParticleShader extends Shader{

	private static final String shaderFile = "ParticleShader";
	
	private int loc_projectionMatrix;
	private int loc_modelViewMatrix;
	
	private int loc_objectColor;
	
	public ParticleShader() {
		super(shaderFile);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}

	@Override
	protected void getAllUniformLocations() {
		loc_projectionMatrix = super.getUniformLocation("projectionMatrix");
		loc_modelViewMatrix = super.getUniformLocation("modelViewMatrix");
		loc_objectColor = super.getUniformLocation("objectColor");
	}
	
	public void loadModelViewMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_modelViewMatrix, matrix);
	}
	
	public void loadProjectionMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_projectionMatrix, matrix);
	}
	
	public void loadColor(Vector4f color) {
		super.loadVector4(loc_objectColor, color);
	}

}
