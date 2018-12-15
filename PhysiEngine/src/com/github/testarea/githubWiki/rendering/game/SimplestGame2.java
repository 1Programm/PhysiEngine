package com.github.testarea.githubWiki.rendering.game;

import com.github.helperclasses.controll.Input;
import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.collision.detection.AABBCollider;
import com.github.physiengine.components.collision.detection.Collider;
import com.github.physiengine.components.collision.resolution.CircleForceResolver;
import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.components.gfx.Image;
import com.github.physiengine.components.model.Model_Rectangle;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.world.Settings;

public class SimplestGame2 {

	private static GameObject player;
	
	public static void main(String[] args) {
		
		GamePlayer game = new GamePlayer(GameStats.SimpleGame(60, "Test Spiel", 600, 500));
		
		ObjectSpace space = new ObjectSpace(true);
		
		
		for(int i=0;i<200;i++) {
			createObject();
		}
		
		Controller_Keyboard controll = new Controller_Keyboard(0.02f);
		
		player = new GameObject("", 0,0 ,0.5f, 0.5f) {
			@Override
			public void update() {
				super.update();
				
				if(Input.isKeyPressed("SPACE")) {
					controll.setSpeed(0.08f);
				}else {
					controll.setSpeed(0.02f);
				}
			}
		};
		player.addComponent(new Model_Rectangle(null, new Vector2(4f,4f)));
		player.addComponent(new Image("/images/crystals/3.png"));
		player.addComponent(controll);
		player.addComponent(new AABBCollider());
		
		
		ObjectSpace.CloseSpace();
		
		game.addSpace(space);
		game.startGame();
		
	}
	
	private static void createObject() {
		float x = (float)(Math.random() * Settings.getUnitsWidth() + Settings.LEFT);
		float y = (float)(Math.random() * Settings.getUnitsHeight() + Settings.BOTTOM);
		
		float r = (float)(Math.random());
		
		GameObject obj = new GameObject("", x,y, 2f, 2f) {
			@Override
			public void update() {
				super.update();
				this.transform.setRotation(transform.getRotation() + r);
				
				getComponent(Collider.class).detectCollision(player.getComponent(Collider.class));
			}
		};
		
		obj.addComponent(new Model_Rectangle());
		obj.addComponent(new Image("/images/crystals/5.png"));
		obj.getComponent(Image.class).setColor(1,1,1,0.5f);
		obj.addComponent(new AABBCollider());
		obj.addComponent(new CircleForceResolver(-0.01f));
	}
	
}
