package com.github.physiengine.gfx.shader;

import java.util.List;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.MathHelp;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.components.Light;

public class ObjectShader extends Shader {
	
	private static final int MAX_LIGHTS = 4;

	private static final String VERTEX_FILE = "res/shaders/staticShader.vs";
	private static final String FRAGMENT_FILE = "res/shaders/staticShader.fs";
	
	private int loc_transformationMatrix;
	private int loc_projectionMatrix;
	private int loc_viewMatrix;
	private int loc_objectColor;
	private int loc_lightPosition[];
	private int loc_lightColor[];
	private int loc_lightAttenuation[];
	private int loc_shineDamper;
	private int loc_reflectivity;
	private int loc_useFakeLighting;
	private int loc_skyColor;
	private int loc_numberOfRows;
	private int loc_offset;
	
	public ObjectShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
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
		loc_objectColor = super.getUniformLocation("objectColor");
		loc_shineDamper = super.getUniformLocation("shineDamper");
		loc_reflectivity = super.getUniformLocation("reflectivity");
		loc_useFakeLighting = super.getUniformLocation("useFakeLighting");
		loc_skyColor = super.getUniformLocation("skyColor");
		loc_numberOfRows = super.getUniformLocation("numberOfRows");
		loc_offset = super.getUniformLocation("offset");
		
		loc_lightPosition = new int[MAX_LIGHTS];
		loc_lightColor = new int[MAX_LIGHTS];
		loc_lightAttenuation = new int[MAX_LIGHTS];
		
		for(int i=0;i<MAX_LIGHTS;i++) {
			loc_lightPosition[i] = super.getUniformLocation("lightPosition[" + i + "]");
			loc_lightColor[i] = super.getUniformLocation("lightColor[" + i + "]");
			loc_lightAttenuation[i] = super.getUniformLocation("lightAttenuation[" + i + "]");
		}
	}
	
	public void loadNumberOfRows(int numberOfRows) {
		super.loadFloat(loc_numberOfRows, numberOfRows);
	}
	
	public void loadOffset(float x, float y) {
		super.loadVector2(loc_offset, new Vector2f(x, y));
	}
	
	public void loadSkyColor(Vector3f skyColor) {
		super.loadVector3(loc_skyColor, skyColor);
	}
	
	public void loadFakeLightingVariable(boolean useFake) {
		super.loadBoolean(loc_useFakeLighting, useFake);
	}
	
	public void loadShineVariables(float damper, float reflectivity) {
		super.loadFloat(loc_shineDamper, damper);
		super.loadFloat(loc_reflectivity, reflectivity);
	}
	
	public void loadObjectColor(Vector3f color) {
		super.loadVector3(loc_objectColor, color);
	}

	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_transformationMatrix, matrix);
	}
	
	public void loadViewMatrix(Camera camera) {
		Matrix4f viewMatrix = MathHelp.createViewMatrix(camera.getPosition(), camera.getRotation());
		super.loadMatrix(loc_viewMatrix, viewMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f matrix) {
		super.loadMatrix(loc_projectionMatrix, matrix);
	}
	
	public void loadLights(List<Light> lights) {
		for(int i=0;i<MAX_LIGHTS;i++) {
			if(i<lights.size()) {
				super.loadVector3(loc_lightPosition[i], lights.get(i).getPosition());
				super.loadVector3(loc_lightColor[i], lights.get(i).getColor());
				super.loadVector3(loc_lightAttenuation[i], lights.get(i).getAttenuation());
			}else {
				super.loadVector3(loc_lightPosition[i], new Vector3f(0, 0, 0));
				super.loadVector3(loc_lightColor[i], new Vector3f(0, 0, 0));
				super.loadVector3(loc_lightAttenuation[i], new Vector3f(1, 0, 0));
			}
		}
	}
	
}
