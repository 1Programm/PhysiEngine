package com.github.physiengine.gfx.renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

import com.github.helperclasses.math.MathHelp;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.gfx.model.RawModel;
import com.github.physiengine.gfx.model.TexturedModel;
import com.github.physiengine.gfx.shader.ObjectShader;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.gfx.Texture;

public class ObjectRenderer {
	
	private static ObjectShader shader;
	
	public static void init(ObjectShader shader, Matrix4f projectionMatrix) {
		ObjectRenderer.shader = shader;
		
		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);
		shader.stop();
	}
	
	public static void render(Map<TexturedModel, List<GameObject>> objects, List<Light> lights) {
		for(TexturedModel model : objects.keySet()) {
			prepareTexturedModel(model);
			List<GameObject> instances = objects.get(model);
			
			for(GameObject object : instances) {
				prepareInstance(object);
				loadLights(object, lights);
				GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
			}
			unbindTexturedModel();
		}
	}
	
	private static void prepareTexturedModel(TexturedModel model) {
		RawModel rawModel = model.getRawModel();
		
		GL30.glBindVertexArray(rawModel.getVaoID());
		
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);
		
		ModelTexture texture = model.getTexture();
		shader.loadNumberOfRows(texture.getNumberOfRows());
		
		if(texture.hasTransparency()) {
			MasterRenderer.disableCulling();
		}
		
		shader.loadFakeLightingVariable(texture.isUseFakeLighting());
		shader.loadShineVariables(texture.getShineDamper(), texture.getReflectivity());
		
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
		
	}
	
	private static void unbindTexturedModel() {
		MasterRenderer.enableCulling();
		
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);
		
		GL30.glBindVertexArray(0);
	}
	
	private static void prepareInstance(GameObject object) {
		Matrix4f transformationMatrix = MathHelp.createTransformationMatrix(object.getTransform());
		shader.loadTransformationMatrix(transformationMatrix);
		
		Texture texture = object.getComponent(Texture.class);
		shader.loadOffset(texture.getTextureXOffset(), texture.getTextureYOffset());
		shader.loadObjectColor(texture.getColor());
	}
	
	private static void loadLights(GameObject object, List<Light> lights) {
		List<Light> copy = new ArrayList<>(lights);
		
		int numLights = 4;
		List<Light> nearestLights = new ArrayList<>();
		
		float dist = 0;
		int id = -1;
		
		for(int i=0;i<numLights;i++) {
			id = -1;
			
			for(int o=0;o<copy.size();o++) {
				float dist2 = MathHelp.getDistance(object.getTransform().getPosition(), copy.get(o).getParentPosition());
				
				if(id == -1) {
					dist = dist2;
					id = o;
				} else if(dist > dist2) {
					dist = dist2;
					id = o;
				}
			}
			
			if(id != -1) {
				nearestLights.add(copy.get(id));
				copy.remove(id);
			}
		}
		
		shader.loadLights(nearestLights);
	}
	
}

