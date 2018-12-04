package com.github.testarea.githubWiki.howToUseTheEngine.GamePlayer;

import com.github.helperclasses.debug.Debug;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.GameObject;

public class GamePlayerTester {

	public static void main(String[] args) {
		GamePlayer game = new GamePlayer(GameStats.SimpleGame(1));
		
		ObjectSpace space1 = new ObjectSpace(true);
		
		new GameObject("Cat") {
			@Override
			public void update() {
				Debug.LogInfo(this.getClass(), "Miauuu");
			}
		};
		
		ObjectSpace.CloseOpenSpace();
		
		
		game.addSpace(space1);
		game.startGame();
	}
	
}
