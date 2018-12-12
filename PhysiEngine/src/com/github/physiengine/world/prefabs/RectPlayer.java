package com.github.physiengine.world.prefabs;

import java.awt.Color;

import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.components.gfx.Image;
import com.github.physiengine.components.model.Model_Rectangle;
import com.github.physiengine.object.GameObject;

public class RectPlayer extends GameObject{

	public RectPlayer(float x, float y, float speed) {
		super("Player", x, y);
		
		this.addComponent(new Model_Rectangle());
		this.addComponent(new Image(Color.WHITE));
		this.addComponent(new Controller_Keyboard(speed));
	}
	
}
