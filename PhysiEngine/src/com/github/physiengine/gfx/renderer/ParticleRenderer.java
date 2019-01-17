package com.github.physiengine.gfx.renderer;

import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

import com.github.helperclasses.fileManagement.Loader;
import com.github.helperclasses.math.MathHelp;
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
	
	public static void init(ParticleShader shader) {
		ParticleRenderer.shader = shader;
		ParticleRenderer.rectModel = Loader.loadToVAO(VERTS, 2);
	}
	
	public static void render(Map<ModelTexture, List<Particle>> particles) {
		GL30.glBindVertexArray(rectModel.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		
		for(ModelTexture texture : particles.keySet()) {
			prepareTexture(texture);
			
			List<Particle> parts = particles.get(texture);
			for(Particle particle : parts) {
				prepareInstance(particle);
				GL11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, rectModel.getVertexCount());
			}
			
			unbindTexturedModel();
		}
	}
		
	private static void unbindTexturedModel() {
		MasterRenderer.enableCulling();
		
		GL20.glDisableVertexAttribArray(0);
		
		GL30.glBindVertexArray(0);
	}
	
	private static void prepareTexture(ModelTexture texture) {
		if(texture.hasTransparency()) {
			MasterRenderer.disableCulling();
		}
		
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture.getID());
	}
	
	private static void prepareInstance(Particle particle) {
		Matrix4f transformationMatrix = MathHelp.createTransformationMatrix(particle.transform);
		shader.loadTransformationMatrix(transformationMatrix);
	}
	
}
