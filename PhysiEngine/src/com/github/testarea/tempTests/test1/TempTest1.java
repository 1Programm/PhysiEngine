package com.github.testarea.tempTests.test1;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.EngineSettings;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.controllers.Mover;
import com.github.physiengine.object.components.controllers.ObjectController_Path;
import com.github.physiengine.object.components.controllers.ObjectController_RelativePath;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.Texture;
import com.github.physiengine.physics.Path;

public class TempTest1 extends Scene{
	
	private static String[] usedTextures = {"test", "colors/White", "colors/Black"};
	private static String[] usedModels = {"Cube"};

	public TempTest1() {
		super(usedTextures, usedModels);
	}

	@Override
	protected void init() {
		registerLight(new Light(new Vector3f(0, 10, 0), new Vector3f(1, 1, 1), new Vector3f(0.1f, 0.01f, 0.001f)));
		registerLight(new Light(new Vector3f(5, 2, 5), new Vector3f(0, 1, 0), new Vector3f(0.9f, 0.1f, 0.03f)));
		registerLight(new Light(new Vector3f(-5, 2, 5), new Vector3f(1, 0, 0), new Vector3f(0.9f, 0.1f, 0.03f)));
		registerLight(new Light(new Vector3f(-5, 2, -5), new Vector3f(0, 0, 1), new Vector3f(0.9f, 0.1f, 0.03f)));
		registerLight(new Light(new Vector3f(5, 2, -5), new Vector3f(1, 0, 1), new Vector3f(0.9f, 0.1f, 0.03f)));
		
		createEmpty(new Vector3f(0, -1, 0), new Vector3f(10, 1, 10))
		.addComponent(new Model("Cube"))
		.addComponent(new Texture("colors/White"));
		
		
		
		Path<Vector3f> path1 = new Path<Vector3f>()
				.add(new Vector3f(5,0,5))
				.add(new Vector3f(-5,0,5))
				.add(new Vector3f(-5,0,-5))
				.add(new Vector3f(5,0,-5));
		
		GameObject object1 = createEmpty()
		.addComponent(new Model("Cube"))
		.addComponent(new Texture("test"))
		.addComponent(new Mover())
		.addComponent(new CameraComponent(15))
		.addComponent(new ObjectController_Path(path1, 0.8f, Path.MODE_LOOP_AFTER_RUN));
		
		
		Path<Vector3f> path2 = new Path<Vector3f>()
				.add(new Vector3f(1,1,0))
				.add(new Vector3f(-1,1,0))
				.add(new Vector3f(-1,-1,0))
				.add(new Vector3f(1,-1,0));
		
		GameObject object2 = createEmpty(0, 0, 0)
				.addComponent(new Model("Cube"))
				.addComponent(new Texture("colors/White"))
				.addComponent(new Mover())
				.addComponent(new ObjectController_RelativePath(path2, 0.25f, Path.MODE_LOOP_AFTER_RUN));
		
		object2.setParent(object1, true);
		
		
		Path<Vector3f> path3 = new Path<Vector3f>()
				.add(new Vector3f(2,0,-2))
				.add(new Vector3f(2,0,2))
				.add(new Vector3f(-2,0,2))
				.add(new Vector3f(-2,0,-2));
		
		GameObject object3 = createEmpty(0, 0, 0)
				.addComponent(new Model("Cube"))
				.addComponent(new Texture("colors/Black"))
				.addComponent(new Mover())
				.addComponent(new ObjectController_RelativePath(path3, 1f, Path.MODE_LOOP_AFTER_RUN));
		
		object3.setParent(object2, true);
		
		Path<Vector3f> path4 = new Path<Vector3f>()
				.add(new Vector3f(2,0,2))
				.add(new Vector3f(-2,0,2))
				.add(new Vector3f(-2,0,-2))
				.add(new Vector3f(2,0,-2));
		
		GameObject object4 = createEmpty(0, 0, 0)
				.addComponent(new Model("Cube"))
				.addComponent(new Texture("colors/Black"))
				.addComponent(new Mover())
				.addComponent(new ObjectController_RelativePath(path4, 1f, Path.MODE_LOOP_AFTER_RUN));
		
		object4.setParent(object2, true);
		
		Path<Vector3f> path5 = new Path<Vector3f>()
				.add(new Vector3f(-2,0,2))
				.add(new Vector3f(-2,0,-2))
				.add(new Vector3f(2,0,-2))
				.add(new Vector3f(2,0,2));
		
		GameObject object5 = createEmpty(0, 0, 0)
				.addComponent(new Model("Cube"))
				.addComponent(new Texture("colors/Black"))
				.addComponent(new Mover())
				.addComponent(new ObjectController_RelativePath(path5, 1f, Path.MODE_LOOP_AFTER_RUN));
		
		object5.setParent(object2, true);
		
		Path<Vector3f> path6 = new Path<Vector3f>()
				.add(new Vector3f(-2,0,-2))
				.add(new Vector3f(2,0,-2))
				.add(new Vector3f(2,0,2))
				.add(new Vector3f(-2,0,2));
		
		GameObject object6 = createEmpty(0, 0, 0)
				.addComponent(new Model("Cube"))
				.addComponent(new Texture("colors/Black"))
				.addComponent(new Mover())
				.addComponent(new ObjectController_RelativePath(path6, 1f, Path.MODE_LOOP_AFTER_RUN));
		
		object6.setParent(object2, true);
		
	}
	
	
	
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new EngineSettings());
		
		player.addScene("Temp Test 1", new TempTest1());
		player.loadScene("Temp Test 1");
		
		player.startGame();
	}
	
}
