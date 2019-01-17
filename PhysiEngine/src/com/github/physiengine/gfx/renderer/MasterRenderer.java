package com.github.physiengine.gfx.renderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.debug.Debug;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.components.particles.Particle;
import com.github.physiengine.gfx.components.particles.ParticleSystem;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.gfx.model.TexturedModel;
import com.github.physiengine.gfx.shader.ObjectShader;
import com.github.physiengine.gfx.shader.ParticleShader;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.gfx.Texture;
import com.github.physiengine.world.Time;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class MasterRenderer {
	
	private static final float FOV = 70;
	private static final float NEAR_PLANE = 0.1f;
	private static final float FAR_PLANE = 1000f;
	
	private static final Vector3f skyColor = new Vector3f(0.7f, 0.7f, 0.8f);

	private static Matrix4f projectionMatrix;

	private static ObjectShader objectShader = new ObjectShader();
	private static ParticleShader particleShader = new ParticleShader();
	
	private static Map<TexturedModel, List<GameObject>> objects = new HashMap<>();
	private static Map<ModelTexture, List<Particle>> particles = new HashMap<>();
	
	public static void enableCulling() {
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
	}
	
	public static void disableCulling() {
		GL11.glDisable(GL11.GL_CULL_FACE);
	}
	
	public static void init() {
		enableCulling();
		createProjectionMatrix();
		
		ObjectRenderer.init(objectShader, projectionMatrix);
		ParticleRenderer.init(particleShader, projectionMatrix);
	}
	
	private static float time = 0;
	private static long first = 0;
	
	public static void render(List<Light> lights, Camera cam) {
		time += Time.getDelta();
		if(first == 0) {
			first = System.nanoTime();
		}
		
		prepare();
		
		objectShader.start();
		objectShader.loadSkyColor(skyColor);
		objectShader.loadLights(lights);
		objectShader.loadViewMatrix(cam);
		ObjectRenderer.render(objects);
		objectShader.stop();
		
		particleShader.start();
		ParticleRenderer.render(particles, cam);
		particleShader.stop();
		
		
		objects.clear();
		particles.clear();
		
		
		if(time >= 1) {
			time = 0;
			long second = System.nanoTime();
			//Debug.Log(MasterRenderer.class, "Time Passed: " + ((second - first) / 1000000000.0));
			first = 0;
		}
	}
	
	public static void cleanUp() {
		objectShader.cleanUp();
		particleShader.cleanUp();
	}
	
	
	public static void addGameObject(GameObject obj) {
		Texture texture = obj.getComponent(Texture.class);
		
		if(texture != null) {
			if(texture.getModel() != null) {
				List<GameObject> objs = objects.get(texture.getModel());
				
				if(objs == null) {
					objs = new ArrayList<>();
					objs.add(obj);
					objects.put(texture.getModel(), objs);
				}else {
					objs.add(obj);
				}
			}
		}
	}
	
	public static void addParticleSystem(ParticleSystem system) {
		for(Particle particle : system.getParticles()) {
			List<Particle> parts = particles.get(particle.texture);
			
			if(parts == null) {
				parts = new ArrayList<>();
				parts.add(particle);
				particles.put(particle.texture, parts);
			}else {
				parts.add(particle);
			}
		}
	}
	
	private static void prepare() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(skyColor.x, skyColor.y, skyColor.z, 1);
	}
	
	private static void createProjectionMatrix() {
		float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
		float y_scale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f))) * aspectRatio);
		float x_scale = y_scale / aspectRatio;
		float frustum_length = FAR_PLANE - NEAR_PLANE;
		
		projectionMatrix = new Matrix4f();
		projectionMatrix.m00 = x_scale;
		projectionMatrix.m11 = y_scale;
		projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustum_length);
		projectionMatrix.m23 = -1;
		projectionMatrix.m32 = -((2 * NEAR_PLANE * FAR_PLANE) / frustum_length);
		projectionMatrix.m33 = 0;
	}

}
