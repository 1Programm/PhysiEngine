package com.github.testarea.graphics.particlesTests;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.components.particles.ParticleSystem_MoveToPoint;
import com.github.physiengine.gfx.components.particles.ParticleSystem_Upstream;
import com.github.physiengine.gfx.components.particles.ParticleSystem_Wave;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.controllers.ObjectController_Keyboard;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.ParticleProducer;

public class ParticleTest1 {

	private static PhysiSystem system = new PhysiSystem("A tester", 1200, 800, 120);
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(system);
		
		
		player.loadScene(new Scene() {
			
			@Override
			public ObjectSpace[] initObjects() {
				ObjectSpace space = new ObjectSpace(true);
				
				new GameObject(new Vector3f(0, 0, 10), new Vector3f(5, 1, 5), new Vector3f(0, 0, 0))
				.addComponent(new ParticleProducer(new ParticleSystem_MoveToPoint(10000, "colors/Black", new Vector3f(0, 5, 0), 0)));
			
				new GameObject(new Vector3f(5, 5, 10), new Vector3f(5, 1, 5), new Vector3f(0, 0, 90))
				.addComponent(new ParticleProducer(new ParticleSystem_MoveToPoint(10000, "colors/Black", new Vector3f(0, 5, 0), 0)));
				
				new GameObject(new Vector3f(0, 10, 10), new Vector3f(5, 1, 5), new Vector3f(0, 0, 180))
				.addComponent(new ParticleProducer(new ParticleSystem_MoveToPoint(10000, "colors/Black", new Vector3f(0, 5, 0), 0)));
				
				new GameObject(new Vector3f(-5, 5, 10), new Vector3f(5, 1, 5), new Vector3f(0, 0, 270))
				.addComponent(new ParticleProducer(new ParticleSystem_MoveToPoint(10000, "colors/Black", new Vector3f(0, 5, 0), 0)));
			
				
				new GameObject(0, 0, 0)
				.addComponent(new ParticleProducer(new ParticleSystem_Upstream(20, "colors/White", 0, 1, 0.1f, 0)))
				.addComponent(new ObjectController_Keyboard(new Vector3f(10, 0, 0), ObjectController_Keyboard.MODE_LINEAR_MOVEMENT))
				.addComponent(new CameraComponent(10));
				
				new GameObject(new Vector3f(0, 0, 0), new Vector3f(2, 0.1f, 1), new Vector3f())
				.addComponent(new ParticleProducer(new ParticleSystem_Wave(100, "colors/White", false)));
				
				new GameObject(new Vector3f(5, 0, 0), new Vector3f(2, 0.1f, 1), new Vector3f())
				.addComponent(new ParticleProducer(new ParticleSystem_Wave(100, "colors/White", false)));
				
				new GameObject(new Vector3f(10, 0, 0), new Vector3f(2, 0.1f, 1), new Vector3f())
				.addComponent(new ParticleProducer(new ParticleSystem_Wave(100, "colors/White", false)));
				
				new GameObject(new Vector3f(15, 0, 0), new Vector3f(2, 0.1f, 1), new Vector3f())
				.addComponent(new ParticleProducer(new ParticleSystem_Wave(100, "colors/White", false)));
				
				
				return new ObjectSpace[] {space};
			}
			
			@Override
			public Light[] initLights() {
				return new Light[] {
						new Light(new Vector3f(-20000, 50000, 1000), new Vector3f(1, 1, 1))
				};
			}
			
			@Override
			public String[] getUsedTextures() {
				return new String[] {
						"test",
						"colors/White",
						"colors/Black"
				};
			}
			
			@Override
			public String[] getUsedModels() {
				return new String[] {
						"Dragon"
				};
			}
		});
		
		player.startGame();
		
	}
	
}
