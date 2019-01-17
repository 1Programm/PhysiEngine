package com.github.testarea.test;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.prefabs.TestPlayer;

public class Main {

	private static PhysiSystem system = new PhysiSystem("A tester", 1200, 800, 120);
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(system);
		
		
		player.loadScene(new Scene() {
			
			@Override
			public ObjectSpace[] initObjects() {
				ObjectSpace space = new ObjectSpace(true);
				
				new TestPlayer(new Vector3f(0, 0, 0), "Dragon", "test");
				
				return new ObjectSpace[] {space};
			}
			
			@Override
			public Light[] initLights() {
				return new Light[] {
						new Light(new Vector3f(-20000, 50000, 1000), new Vector3f(1, 1, 1))
				};
			}
			
			@Override
			public Camera initCamera() {
				return new Camera(new Vector3f(0, 5, -20), new Vector3f(0, 180, 0));
			}
			
			@Override
			public String[] getUsedTextures() {
				return new String[] {
						"test"
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
