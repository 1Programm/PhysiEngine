package com.github.testarea.simplest;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.Texture;
import com.github.physiengine.object.tags.Tag;

public class SimplestScene extends Scene{
	
	@Override
	protected ObjectSpace initObjects() {
		ObjectSpace space = new ObjectSpace(true);
		
		space.addLight(new Vector3f(0, 100, 0), new Light(new Vector3f(1, 1, 1)));
		
		new GameObject()
		.addTags(Tag.Entity)
		.addComponent(new Model("Cube"))
		.addComponent(new Texture("test"))
		.addComponent(new CameraComponent(20));
		
		return space;
	}
	
	
	@Override
	protected String[] initUsedTextures() { return new String[] {"test"}; }
	
	@Override
	protected String[] initUsedModels() { return new String[] {"Cube"}; }
	

	
	
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new PhysiSystem("SimplestTest", 600, 500, 60));
		
		player.addScene("TestScene", new SimplestScene());
		player.loadScene("TestScene");
		
		player.startGame();
	}
	
}
