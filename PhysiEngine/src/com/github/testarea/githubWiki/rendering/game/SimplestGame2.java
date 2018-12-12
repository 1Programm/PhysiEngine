package com.github.testarea.githubWiki.rendering.game;

import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.components.gfx.Image;
import com.github.physiengine.components.model.Model_Rectangle;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.world.Settings;

public class SimplestGame2 {

	public static void main(String[] args) {
		
		GamePlayer game = new GamePlayer(GameStats.SimpleGame(60, "Test Spiel", 600, 500));
		
		ObjectSpace space = new ObjectSpace(true);
		
		
		for(int i=0;i<400;i++) {
			createObject();
		}
		
		GameObject obj = new GameObject("", 0,0 ,2,2);
		obj.addComponent(new Model_Rectangle());
		obj.addComponent(new Image("/images/crystals/3.png"));
		obj.addComponent(new Controller_Keyboard(0.02f));
		
		
		ObjectSpace.CloseSpace();
		
		game.addSpace(space);
		game.startGame();
		
	}
	
	private static void createObject() {
		float x = (float)(Math.random() * Settings.getUnitsWidth() + Settings.LEFT);
		float y = (float)(Math.random() * Settings.getUnitsHeight() + Settings.BOTTOM);
		
		float r = (float)(Math.random());
		
		GameObject obj = new GameObject("", x,y, 2.5f, 2.5f) {
			@Override
			public void update() {
				this.transform.setRotation(transform.getRotation() + r);
			}
		};
		
		obj.addComponent(new Model_Rectangle());
		obj.addComponent(new Image("/images/crystals/5.png"));
		obj.getComponent(Image.class).setColor(1,1,1,1);
	}
	
}
