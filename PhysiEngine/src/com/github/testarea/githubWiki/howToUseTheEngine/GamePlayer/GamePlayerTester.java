package com.github.testarea.githubWiki.howToUseTheEngine.GamePlayer;

import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;

public class GamePlayerTester {

	public static void main(String[] args) {
		GamePlayer game = new GamePlayer(GameStats.SimpleGame(60, "Simple Game", 600, 500));
		
		game.startGame();
	}
	
}
