package com.github.testarea.githubWiki.rendering.game;

import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.object.prefabs.RectPlayer;

public class SimplestGame1 {

	public static void main(String[] args) {
		GamePlayer game = new GamePlayer(GameStats.SimpleGame(60, "Test", 600, 500));
		
		game.addObject(new RectPlayer(0, 0, 0.1f));
		
		game.startGame();
	}
	
}
