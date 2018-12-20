package com.github.testarea.githubWiki.rendering.tests;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.gfx.DisplayManager;
import com.github.physiengine.gfx.ModelLoader;
import com.github.physiengine.gfx.ModelTexture;
import com.github.physiengine.gfx.RawModel;
import com.github.physiengine.gfx.Renderer;
import com.github.physiengine.gfx.TexturedModel;
import com.github.physiengine.gfx.light.Light;
import com.github.physiengine.gfx.shader.StaticShader;
import com.github.physiengine.gfx.shader.StaticShadowShader;

public class Test {

	public static void main(String[] args) {
		DisplayManager.createDisplay("Test", 60, 1280, 780);
		
		float[] verts = {
			
				-0.5f, -0.5f,
				0.5f, -0.5f,
				0.5f, 0.5f,
				-0.5f, 0.5f,
				
		};
		
		int[] indices = {
			0, 1, 2,
			
			2, 3, 0
		};
		
		float[] textCoords = {
			0, 0,
			0, 1,
			1, 1,
			1, 0
		};
		
		float[] normals = {
			0, -1,
			1, 0,
			0, 1,
			-1, 0
		};
		
		StaticShadowShader shader = new StaticShadowShader();
		
		Light light = new Light(new Vector2f(0, 0), new Vector3f(1, 0, 0), 1);
		
		shader.loadLight(light);
		
		RawModel rawModel = ModelLoader.loadModel(verts, textCoords, normals, indices);
		
		ModelTexture modelTexture = new ModelTexture(ModelLoader.loadTexture("res/test.png"));
		
		TexturedModel model = new TexturedModel(rawModel, modelTexture);
		
		while(!Display.isCloseRequested()) {
			Renderer.prepare();
			
			shader.start();
			shader.loadLight(light);
			
			light.getPosition().x += 0.001f;
			
			//shader.setTime((float)(PhysiSystem.getDeltaTime() / 1000000.0));
			
			Renderer.render(model);
			shader.stop();
			
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		ModelLoader.cleanUp();
		
		DisplayManager.closeDisplay();
	}
	
}
