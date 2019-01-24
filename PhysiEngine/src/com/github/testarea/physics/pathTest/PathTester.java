package com.github.testarea.physics.pathTest;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.components.particles.ParticleSystem_MovementLine;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.controllers.Mover;
import com.github.physiengine.object.components.controllers.ObjectController_Path;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.ParticleProducer;
import com.github.physiengine.object.components.gfx.Texture;
import com.github.physiengine.physics.Path;

public class PathTester implements Scene{

	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new PhysiSystem("Path Tester", 900, 600, 60));
		player.loadScene(new PathTester());
		player.startGame();
	}
	
	@Override
	public ObjectSpace[] initObjects() {
		ObjectSpace space = new ObjectSpace(true);
		
		space.addLight(new Vector3f(10, 100, 0), new Light(new Vector3f(1, 1, 1)));
		
		for(int x=-10;x<10;x++) {
			for(int y=-10;y<10;y++) {
				new GameObject(x, -1, y)
				.addComponent(new Model("Cube"))
				.addComponent(new Texture("test"));
			}
		}
		
		Path<Vector3f> p = new Path<Vector3f>(new Vector3f(0, 0, 0), new Vector3f(0, 10, 0), new Vector3f(10, 10, 0), new Vector3f(10, 0, 0), new Vector3f(0, 0, 0));
		
		
		new GameObject()
		.addComponent(new Model("Cube"))
		.addComponent(new Texture("test"))
		.addComponent(new Mover())
		.addComponent(new ObjectController_Path(p, ObjectController_Path.MODE_REVERSE_AFTER_RUN))
		.addComponent(new ParticleProducer(new ParticleSystem_MovementLine(5000, 40, "colors/Black")));
		
		
		new GameObject()
		.addComponent(new CameraComponent(10));
		
		return new ObjectSpace[] {space};
	}

	@Override
	public String[] getUsedTextures() {
		return new String[] { "test", "colors/Black"};
	}

	@Override
	public String[] getUsedModels() {
		return new String[] { "Cube" };
	}
	
}
