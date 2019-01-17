package com.github.physiengine.object.prefabs;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.body.Model;
import com.github.physiengine.object.components.controllers.ObjectController_Keyboard;
import com.github.physiengine.object.components.gfx.Texture;

public class TestPlayer extends GameObject{

	public TestPlayer(String modelName, String textureName) {
		addComponent(new Model(modelName));
		if(textureName.equals("")) {
			addComponent(new Texture());
		}else {
			addComponent(new Texture(textureName));
		}
		addComponent(new ObjectController_Keyboard(new Vector3f(2, 0, 20), ObjectController_Keyboard.MODE_TURNED_MOVEMENT));
	}
	
	public TestPlayer(Vector3f position, String modelName, String textureName) {
		super(position);
		
		addComponent(new Model(modelName));
		if(textureName.equals("")) {
			addComponent(new Texture());
		}else {
			addComponent(new Texture(textureName));
		}
		addComponent(new ObjectController_Keyboard(new Vector3f(2, 0, 20), ObjectController_Keyboard.MODE_TURNED_MOVEMENT));
	}
	
}
