package com.github.testarea.githubWiki.howToUseTheEngine.GamePlayer;

import com.github.helperclasses.debug.Debug;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.GameObject;

public class GamePlayerTester {

	public static void main(String[] args) {
		GamePlayer game = new GamePlayer(GameStats.SimpleGame(1, "Simple Game", 600, 500));
		
		ObjectSpace space1 = new ObjectSpace(true);
		
		new GameObject("Cat") {
			@Override
			public void update() {
				Debug.Log(this.getClass(), "Miauuu");
			}
		};
		
		ObjectSpace.CloseSpace();
		
		
		game.addSpace(space1);
		game.startGame();
	}
	
}
