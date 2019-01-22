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

public class SimplestScene {

	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new PhysiSystem("Simple", 600, 500, 60));
		
		player.loadScene(new Scene() {
			
			@Override
			public ObjectSpace[] initObjects() {
				ObjectSpace space = new ObjectSpace(true);
				
				space.addLight(new Vector3f(0, 100, 0), new Light(new Vector3f(1, 1, 1)));
				
				GameObject o = new GameObject()
				.addComponent(new Model("Dragon"))
				.addComponent(new Texture("test"))
				.addComponent(new CameraComponent(20));
				
			
				o.getComponent(Texture.class).getModel().getTexture().setReflectivity(2);
				o.getComponent(Texture.class).getModel().getTexture().setShineDamper(0.1f);
				
				return new ObjectSpace[] {space};
			}
			
			@Override
			public String[] getUsedTextures() { return new String[] {"test", "colors/White"}; }
			
			@Override
			public String[] getUsedModels() { return new String[] {"Dragon"}; }
		});
		
		player.startGame();
	}
	
}
