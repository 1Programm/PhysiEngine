package com.github.physiengine.gfx.shader;

public class StaticShader extends ShaderProgram {

	private static final String vertexFile = "res/shaders/staticVertexShader.txt";
	private static final String fragmentFile = "res/shaders/staticFragmentShader.txt";
	
	private int location_time;
	
	public StaticShader() {
		super(vertexFile, fragmentFile);
	}

	@Override
	protected void getAllUniformLocations() {
		location_time = super.getUniformLocation("time");
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}
	
	public void setTime(float time) {
		super.loadFloat(location_time, time);
	}

}
