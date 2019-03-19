package com.github.testarea.physics.pathTest;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.EngineSettings;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.components.particles.ParticleSystem_MovementLine;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.controllers.Mover;
import com.github.physiengine.object.components.controllers.ObjectController_Path;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.ParticleProducer;
import com.github.physiengine.object.components.gfx.Texture;
import com.github.physiengine.physics.Path;

public class PathTester extends Scene{
	
	private static String[] textures = {
			"test", 
			"colors/Black"};
	
	private static String[] models = {"Cube"};
	
	public PathTester() {
		super(textures, models);
	}
	
	@Override
	protected void init() {
		registerLight(new Light(new Vector3f(10, 100, 0), new Vector3f(1, 1, 1)));
		
		for(int x=-10;x<10;x++) {
			for(int y=-10;y<10;y++) {
				createEmpty(x, -1, y)
				.addComponent(new Model("Cube"))
				.addComponent(new Texture("test"));
			}
		}
		
		Path<Vector3f> p = new Path<Vector3f>(new Vector3f(0, 0, 0), new Vector3f(0, 10, 0), new Vector3f(10, 10, 0), new Vector3f(10, 0, 0), new Vector3f(0, 0, 0));
		
		
		createEmpty()
		.addComponent(new Model("Cube"))
		.addComponent(new Texture("test"))
		.addComponent(new Mover())
		.addComponent(new ObjectController_Path(p, 5, Path.MODE_REVERSE_AFTER_RUN))
		.addComponent(new ParticleProducer(new ParticleSystem_MovementLine(5000, 40, "colors/Black")));
		
		
		createEmpty()
		.addComponent(new CameraComponent(10));
		
	}
	
	
	

	

	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new EngineSettings("Physics: \"Path Test\""));
		
		player.addScene("Path Test Scene", new PathTester());
		player.loadScene("Path Test Scene");
		
		player.startGame();
	}
	
}
