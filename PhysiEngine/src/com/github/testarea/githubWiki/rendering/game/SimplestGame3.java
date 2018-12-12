package com.github.testarea.githubWiki.rendering.game;

import java.awt.Color;

import com.github.physiengine.components.collision.detection.AABBCollider;
import com.github.physiengine.components.collision.detection.Collider;
import com.github.physiengine.components.collision.resolution.CircleForceResolver;
import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.components.gfx.Image;
import com.github.physiengine.components.model.Model_Rectangle;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.object.GameObject;

public class SimplestGame3 {

	public static void main(String[] args) {
		
		GamePlayer game = new GamePlayer(GameStats.SimpleGame(60, "GameTest", 600, 500));
		
		GameObject o = new GameObject();
		o.addComponent(new Model_Rectangle());
		o.addComponent(new Image(Color.WHITE));
		o.addComponent(new AABBCollider());
		o.addComponent(new Controller_Keyboard(0.02f));
		
		GameObject o1 = new GameObject() {
			@Override
			public void update() {
				super.update();
				getComponent(Collider.class).detectCollision(o.getComponent(Collider.class));
				//o.getComponent(Collider.class).detectCollision(this.getComponent(Collider.class));
			}
		};
		o1.addComponent(new Model_Rectangle());
		o1.addComponent(new Image(Color.gray));
		o1.addComponent(new AABBCollider());
		o1.addComponent(new CircleForceResolver(0.02f));
		
		game.addObject(o);
		game.addObject(o1);
		
		game.startGame();
	}
	
}
