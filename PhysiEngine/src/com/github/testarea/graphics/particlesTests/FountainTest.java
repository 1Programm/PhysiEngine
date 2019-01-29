package com.github.testarea.graphics.particlesTests;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.Texture;

public class FountainTest implements Scene{
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new PhysiSystem("Particle Test 1", 800, 600, 60));
		player.loadScene(new FountainTest());
		player.startGame();
	}

	@Override
	public ObjectSpace[] initObjects() {
		ObjectSpace space = new ObjectSpace(true);
		
		space.addLight(new Vector3f(0, 100, 10), new Light(new Vector3f(1, 1, 1)));
		
		new GameObject(new Vector3f(), new Vector3f(10, 1, 10))
		.addComponent(new Model("Cube"))
		.addComponent(new Texture("colors/White"))
		.addComponent(new CameraComponent(10));
		
		return new ObjectSpace[] {space};
	}

	@Override
	public String[] getUsedTextures() {
		return new String[] {
				"colors/White"
		};
	}

	@Override
	public String[] getUsedModels() {
		return new String[] {
				"Cube"
		};
	}

}
