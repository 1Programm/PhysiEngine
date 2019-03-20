package com.github.testarea.graphics.particlesTests;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.EngineSettings;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.components.particles.ParticleSystem_Fountain;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.ParticleProducer;
import com.github.physiengine.object.components.gfx.Texture;

public class FountainTest extends Scene{
	
	private static String[] textures = {"colors/White"};
	private static String[] models = {"Cube"};
	
	public FountainTest() {
		super(textures, models);
	}

	@Override
	protected void init() {
		registerLight(new Light(new Vector3f(0, 100, 0), new Vector3f(1, 1, 1)));
		
		createEmpty(new Vector3f(0, -1, 0), new Vector3f(10, 1, 10))
		.addComponent(new Model("Cube"))
		.addComponent(new Texture("colors/White"))
		.addComponent(new CameraComponent(15));
		
		createEmpty(new Vector3f(), new Vector3f(1, 10, 1))
		.addComponent(new ParticleProducer(new ParticleSystem_Fountain(1000, "colors/White")));
		
	}	
	
	
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new EngineSettings("Particle: \"Fountain Test\""));
		
		player.addScene("FountainScene", new FountainTest());
		player.loadScene("FountainScene");
		
		player.startGame();
	}

}
