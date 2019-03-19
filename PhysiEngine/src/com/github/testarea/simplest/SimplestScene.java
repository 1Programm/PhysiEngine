package com.github.testarea.simplest;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.EngineSettings;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.Scene;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.gfx.CameraComponent;
import com.github.physiengine.object.components.gfx.Texture;
import com.github.physiengine.object.tags.Tag;

public class SimplestScene extends Scene{
	
	private static String[] textures = {"test"};
	private static String[] models = {"Cube"};
	
	public SimplestScene() {
		super(textures, models);
	}
	
	@Override
	protected void init() {
		registerLight(new Light(new Vector3f(0, 100, 0), new Vector3f(1, 1, 1)));
		
		createEmpty()
		.addTags(Tag.Entity)
		.addComponent(new Model("Cube"))
		.addComponent(new Texture("test"))
		.addComponent(new CameraComponent(5,0,0.01f));
	}
	
	
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new EngineSettings("Simplest Scene").setPrintFPS(false));
		
		player.addScene("Test Scene", new SimplestScene());
		player.loadScene("Test Scene");
		
		player.startGame();
	}
	
}
