package com.github.testarea.test;

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
import com.github.physiengine.object.components.Component;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.controllers.ObjectController_Keyboard;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.ParticleProducer;
import com.github.physiengine.object.components.gfx.Texture;

public class Main {

	private static PhysiSystem system = new PhysiSystem("A tester", 1200, 800, 120);
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(system);
		
		
		player.loadScene(new Scene() {
			
			@Override
			public ObjectSpace[] initObjects() {
				ObjectSpace space = new ObjectSpace(true);
				
				new GameObject(new Vector3f(0, -10, 0), new Vector3f(10, 1, 10), new Vector3f(0, 0, 0))
				//.addComponent(new ParticleProducer(new ParticleSystem_Upstream(1000, "colors/White", 0, 1, 0.05f, 0)))
				//.addComponent(new ParticleProducer(new ParticleSystem_Wave(10000, "colors/White")))
				.addComponent(new ParticleProducer(new ParticleSystem_MoveToPoint(1000, "colors/Black", new Vector3f(0, 10, 0))))
				.addComponent(new CameraComponent())
				.addComponent(new Component() {
					
					@Override
					public void update() {
						//parent.getTransform().addRotation(0, 0.1f, 0.2f);
					}
					
					@Override
					public void receiveMessage(Component sender, String msg) {}
					
					@Override
					public void init() {}
				});
				
				
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
