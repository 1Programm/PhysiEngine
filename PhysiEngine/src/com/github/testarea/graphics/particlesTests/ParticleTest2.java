package com.github.testarea.graphics.particlesTests;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.components.particles.ParticleSystem_MoveToPoint;
import com.github.physiengine.gfx.components.particles.ParticleSystem_Wave;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.controllers.ObjectController_Camera;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.ParticleProducer;
import com.github.physiengine.object.components.gfx.Texture;

public class ParticleTest2 implements Scene{

	@Override
	public String[] getUsedTextures() {
		return new String[] {
				"colors/Black",
				"colors/White",
				"test"
		};
	}

	@Override
	public String[] getUsedModels() {
		return new String[] {
				"Cube"
		};
	}

	@Override
	public Light[] initLights() {
		return new Light[] { new Light( new Vector3f(0, 10, 0), new Vector3f(1, 0.5f, 0.5f), new Vector3f(0.1f, 0.1f, 0.01f)) };
	}

	@Override
	public ObjectSpace[] initObjects() {
		ObjectSpace space = new ObjectSpace(true);
		
		new GameObject()
		//.addComponent(new ObjectController_Keyboard(new Vector3f(5, 0, 50), ObjectController_Keyboard.MODE_TURNED_MOVEMENT))
		.addComponent(new ObjectController_Camera(new Vector3f(20, 0, 0)))
		.addComponent(new CameraComponent(0));
		
		for(int x=-2;x<=2;x++) {
			for(int y=-2;y<=2;y++) {
				new GameObject(new Vector3f(x * 40, -1, y * 40), new Vector3f(40, 1, 40), new Vector3f())
				.addComponent(new Model("Cube"))
				.addComponent(new Texture("test"));
			}
		}
		
		
		new GameObject(new Vector3f(0, 5, 19), new Vector3f(2, 10, 2), new Vector3f(0, 0, 0))
		.addComponent(new ParticleProducer(new ParticleSystem_Wave(500, "colors/Black", true)));
		
		new GameObject(new Vector3f(5, 5, 19), new Vector3f(2, 10, 2), new Vector3f(0, 0, 0))
		.addComponent(new ParticleProducer(new ParticleSystem_Wave(500, "colors/Black", true)));
		
		new GameObject(new Vector3f(10, 5, 19), new Vector3f(2, 10, 2), new Vector3f(0, 0, 0))
		.addComponent(new ParticleProducer(new ParticleSystem_Wave(500, "colors/Black", true)));

		new GameObject(new Vector3f(15, 5, 19), new Vector3f(2, 10, 2), new Vector3f(0, 0, 0))
		.addComponent(new ParticleProducer(new ParticleSystem_Wave(500, "colors/Black", true)));

		new GameObject(new Vector3f(-5, 5, 19), new Vector3f(2, 10, 2), new Vector3f(0, 0, 0))
		.addComponent(new ParticleProducer(new ParticleSystem_Wave(500, "colors/Black", true)));

		new GameObject(new Vector3f(-10, 5, 19), new Vector3f(2, 10, 2), new Vector3f(0, 0, 0))
		.addComponent(new ParticleProducer(new ParticleSystem_Wave(500, "colors/Black", true)));

		new GameObject(new Vector3f(-15, 5, 19), new Vector3f(2, 10, 2), new Vector3f(0, 0, 0))
		.addComponent(new ParticleProducer(new ParticleSystem_Wave(500, "colors/Black", true)));
		
		
		for(int i=0;i<20;i++) {
			new GameObject(new Vector3f(i * 4 + 10, 0, -6), new Vector3f(2, 1, 2), new Vector3f())
			.addComponent(new ParticleProducer(new ParticleSystem_MoveToPoint(400, "colors/Black", new Vector3f(0, 7, 0), (i / 25.0f))));

			new GameObject(new Vector3f(i * 4 + 10, 0, 6), new Vector3f(2, 1, 2), new Vector3f())
			.addComponent(new ParticleProducer(new ParticleSystem_MoveToPoint(400, "colors/Black", new Vector3f(0, 7, 0), (i / 25.0f))));
		}
		
		return new ObjectSpace[] {space};
	}

	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new PhysiSystem("Particles 2", 1200, 800, 60));
		player.loadScene(new ParticleTest2());
		player.startGame();
	}
	
	
}
