package com.github.testarea.graphics.lights;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.controllers.Mover;
import com.github.physiengine.object.components.controllers.ObjectController_Simple;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.Texture;

public class LightsTest1 extends Scene{

	@Override
	protected ObjectSpace initObjects() {
		ObjectSpace space = new ObjectSpace(true);
		
		space.addLight(new Vector3f(5, 3, 5), new Light(new Vector3f(1, 1, 1), new Vector3f(0.5f, 0.1f, 0)));
		space.addLight(new Vector3f(-5, 3, 5), new Light(new Vector3f(1, 0, 0), new Vector3f(0.5f, 0.1f, 0)));
		space.addLight(new Vector3f(5, 3, -5), new Light(new Vector3f(0, 1, 0), new Vector3f(0.5f, 0.1f, 0)));
		space.addLight(new Vector3f(-5, 3, -5), new Light(new Vector3f(0, 0, 1), new Vector3f(0.5f, 0.1f, 0)));
		
		
		for(int x=-5;x<=5;x++) {
			for(int z=-5;z<=5;z++) {
				new GameObject(new Vector3f(x, 1, z))
				.addComponent(new Model("Cube"))
				.addComponent(new Texture((x + z) % 2 == 0 ? "colors/White" : "colors/Black"));
			}
		}
		
		
		GameObject camHolder = 
				new GameObject()
				.addComponent(new CameraComponent(20))
				.addComponent(new Mover())
				.addComponent(
						new ObjectController_Simple()
						.setRotationVel(new Vector3f(0, 10, 0)));
		
		camHolder
		.getComponent(CameraComponent.class)
		.getCamera()
		.setViewMode(Camera.FIRST_PERSON, 15, 0, 25);
		
		
		return space;
	}

	@Override
	protected String[] initUsedTextures() {
		return new String[] {
				"colors/Black",
				"colors/White"
		};
	}

	@Override
	protected String[] initUsedModels() {
		return new String[] {
				"Cube"
		};
	}
	
	
	
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new PhysiSystem("Lights Test 1", 800, 700, 60));
		
		player.addScene("Lights Test 1", new LightsTest1());
		player.loadScene("Lights Test 1");
		
		player.startGame();
	}

}
