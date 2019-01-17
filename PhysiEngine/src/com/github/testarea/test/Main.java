package com.github.testarea.test;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.components.particles.ParticleSystem_Fountain;
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
				
//				new GameObject()
//				.addComponent(new Model("Dragon"))
//				.addComponent(new Texture("test"));
				
				new GameObject(new Vector3f(0, 0, 0), new Vector3f(10, 1, 10), new Vector3f(0, 0, 0))
				.addComponent(new ParticleProducer(new ParticleSystem_Fountain(1000000, "test")))
				.addComponent(new Component() {
					
					@Override
					public void update() {
						//parent.getTransform().addRotation(0, 0.1f, 0);
					}
					
					@Override
					public void receiveMessage(Component sender, String msg) {}
					
					@Override
					public void init() {}
				});
				
				new GameObject(0, 0, 0, 0.2f)
				.addComponent(new Model("Dragon"))
				.addComponent(new Texture("colors/White"))
				.addComponent(new CameraComponent())
				.addComponent(new ObjectController_Keyboard(new Vector3f(-2, 0, 40), ObjectController_Keyboard.MODE_TURNED_MOVEMENT));
				
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
						"colors/White"
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
