package com.github.testarea.graphics.lights;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.EngineSettings;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.controllers.Mover;
import com.github.physiengine.object.components.controllers.ObjectController_Simple;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.Texture;

public class LightsTest1 extends Scene{
	
	private static String[] textures = {
			"colors/Black",
			"colors/White"};
	
	private static String[] models = {"Cube"};
	
	public LightsTest1() {
		super(textures, models);
	}

	@Override
	protected void init() {
		registerLight(new Light(new Vector3f(5, 3, 5), new Vector3f(1, 1, 1), new Vector3f(0.5f, 0.1f, 0)));
		registerLight(new Light(new Vector3f(-5, 3, 5), new Vector3f(1, 0, 0), new Vector3f(0.5f, 0.1f, 0)));
		registerLight(new Light(new Vector3f(5, 3, -5), new Vector3f(0, 1, 0), new Vector3f(0.5f, 0.1f, 0)));
		registerLight(new Light(new Vector3f(-5, 3, -5), new Vector3f(0, 0, 1), new Vector3f(0.5f, 0.1f, 0)));
		
		
		for(int x=-5;x<=5;x++) {
			for(int z=-5;z<=5;z++) {
				createEmpty(new Vector3f(x, 1, z))
				.addComponent(new Model("Cube"))
				.addComponent(new Texture((x + z) % 2 == 0 ? "colors/White" : "colors/Black"));
			}
		}
		
		
		GameObject camHolder = createEmpty()
				.addComponent(new CameraComponent(20))
				.addComponent(new Mover())
				.addComponent(
						new ObjectController_Simple()
						.setRotationVel(new Vector3f(0, 10, 0)));
		
		camHolder
		.getComponent(CameraComponent.class)
		.getCamera()
		.setView(15, 0, 25, false);
	}
	
	
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new EngineSettings("My Game"));
		
		
		player.addScene("Lights Test 1", new LightsTest1());
		player.loadScene("Lights Test 1");
		
		player.startGame();
	}

}
