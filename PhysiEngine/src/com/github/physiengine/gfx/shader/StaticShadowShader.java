package com.github.physiengine.gfx.shader;

import com.github.physiengine.gfx.light.Light;

public class StaticShadowShader extends ShaderProgram{
	
	private static final String vertexFile = "res/shaders/staticShadowVertexShader.txt";
	private static final String fragmentFile = "res/shaders/staticShadowFragmentShader.txt";

	private int location_lightPosition;
	private int location_lightColor;
	private int location_lightStrength;
	
	public StaticShadowShader() {
		super(vertexFile, fragmentFile);
	}

	@Override
	protected void getAllUniformLocations() {
		location_lightPosition = super.getUniformLocation("lightPosition");
		location_lightColor = super.getUniformLocation("lightColor");
		location_lightStrength = super.getUniformLocation("lightStrength");
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
		super.bindAttribute(2, "normal");
	}

	public void loadLight(Light light) {
		super.loadVector2(location_lightPosition, light.getPosition());
		super.loadVector3(location_lightColor, light.getColor());
		super.loadFloat(location_lightStrength, light.getStrength());
	}
	
	
}
