package com.github.testarea.githubWiki.rendering.game;

import java.awt.Color;

import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.components.gfx.Image;
import com.github.physiengine.components.model.Model_Rectangle;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.GameObject;

public class SimplestGame4 {
	
	private static GameObject player;

	public static void main(String[] args) {
		GamePlayer game = new GamePlayer(GameStats.SimpleGame(60, "Test4", 800, 600));
		
		ObjectSpace space = new ObjectSpace(true);
		

		new GameObject() {
			@Override
			public void update() {
				player.getTransform().getPos().set(this.transform.getPos());
			}
		};
		
		player = new GameObject("player", 0,0);
		player.addComponent(new Model_Rectangle());
		player.addComponent(new Image(Color.white));
		player.addComponent(new Controller_Keyboard(0.1f));
		
		
		
		
		
		game.addSpace(space);
		game.startGame();
	}
	
}
