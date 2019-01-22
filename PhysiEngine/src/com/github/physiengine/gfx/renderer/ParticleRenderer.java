package com.github.physiengine.gfx.renderer;

import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.fileManagement.Loader;
import com.github.helperclasses.math.MathHelp;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.components.particles.Particle;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.gfx.model.RawModel;
import com.github.physiengine.gfx.shader.ParticleShader;

public class ParticleRenderer {
	
	private static final float[] VERTS = {
			-1, 1,
			-1, -1,
			1, 1,
			1, -1
			
	};

	private static ParticleShader shader;
	private static RawModel rectModel;
	
	public static void init(ParticleShader shader, Matrix4f projectionMatrix) {
		ParticleRenderer.shader = shader;
		ParticleRenderer.rectModel = Loader.loadToVAO(VERTS, 2);

		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);
		shader.stop();
	}
	
	public static void render(Map<ModelTexture, List<Particle>> particles, Camera camera) {
		Matrix4f viewMatrix = MathHelp.createViewMatrix(camera.getPosition(), camera.getRotation());
		
		GL30.glBindVertexArray(rectModel.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//GL11.glDepthMask(false);
		
		for(ModelTexture texture : particles.keySet()) {
			prepareTexture(texture);
			
			List<Particle> parts = particles.get(texture);
			for(Particle particle : parts) {
				updateModelViewMatrix(particle, viewMatrix);
				shader.loadColor(particle.color);
				GL11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, rectModel.getVertexCount());
			}
			
			unbindTexturedModel();
		}
		
		//GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}
		
	private static void unbindTexturedModel() {
		MasterRenderer.enableCulling();
	}
	
	private static void prepareTexture(ModelTexture texture) {
		if(texture.hasTransparency()) {
			MasterRenderer.disableCulling();
		}
		
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture.getID());
	}
	
	private static void updateModelViewMatrix(Particle particle, Matrix4f viewMatrix) {
		Matrix4f modelMatrix = new Matrix4f();
		
		if(particle.parentTransform != null) {
			Matrix4f.translate(particle.parentTransform.getPosition(), modelMatrix, modelMatrix);
	
			Matrix4f.rotate((float)Math.toRadians(particle.parentTransform.getRotation().x), new Vector3f(1, 0, 0), modelMatrix, modelMatrix);
			Matrix4f.rotate((float)Math.toRadians(particle.parentTransform.getRotation().y), new Vector3f(0, 1, 0), modelMatrix, modelMatrix);
			Matrix4f.rotate((float)Math.toRadians(particle.parentTransform.getRotation().z), new Vector3f(0, 0, 1), modelMatrix, modelMatrix);
			Matrix4f.scale(particle.parentTransform.getScale(), modelMatrix, modelMatrix);
		}
		
		
		
		Matrix4f.translate(particle.transform.getPosition(), modelMatrix, modelMatrix);
		
		modelMatrix.m00 = viewMatrix.m00;
		modelMatrix.m01 = viewMatrix.m10;
		modelMatrix.m02 = viewMatrix.m20;
		modelMatrix.m10 = viewMatrix.m01;
		modelMatrix.m11 = viewMatrix.m11;
		modelMatrix.m12 = viewMatrix.m21;
		modelMatrix.m20 = viewMatrix.m02;
		modelMatrix.m21 = viewMatrix.m12;
		modelMatrix.m22 = viewMatrix.m22;
		
		
		Matrix4f.rotate((float)Math.toRadians(particle.transform.getRotation().z), new Vector3f(0, 0, 1), modelMatrix, modelMatrix);
		Matrix4f.scale(particle.transform.getScale(), modelMatrix, modelMatrix);
		

		
		Matrix4f modelViewMatrix = Matrix4f.mul(viewMatrix, modelMatrix, null);
		
		
		shader.loadModelViewMatrix(modelViewMatrix);
	}
	
}
