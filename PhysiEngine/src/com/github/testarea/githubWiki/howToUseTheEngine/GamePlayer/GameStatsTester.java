package com.github.testarea.githubWiki.howToUseTheEngine.GamePlayer;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.fileManagement.FileLoader;
import com.github.helperclasses.fileManagement.FileSaver;
import com.github.physiengine.engine.GameStats;

public class GameStatsTester {

	public static void main(String[] args) {
		GameStats stats1 = GameStats.Empty();
		stats1.setVariable("FPS", 10);
		stats1.setVariable("testBool", true);
		stats1.setVariable("testString", "Hey ;D");
		
		FileSaver.saveToFile(stats1, "res/testStats.txt");
		
		
		
		
		GameStats stats2 = GameStats.Empty();
		FileLoader.loadInto(stats2, "res/testStats.txt");
		
		Debug.LogInfo(GameStatsTester.class,  stats2.getVariable("FPS") + ", "
											+ stats2.getVariable("testBool") + ", "
											+ stats2.getVariable("testString"));
		
		
		//First possibly to get a variable
		Object theFPS1_asObject = stats2.getVariable("FPS");
		int theFPS1_asInt = (int)theFPS1_asObject;
		theFPS1_asInt ++;
		
		Debug.LogInfo(GameStatsTester.class, "theFps1: " + theFPS1_asInt);
		
		
		//Second possibly to get a variable (No casting needed)
		int theFPS2_asInt = stats2.getVariable("FPS", Integer.class);
		theFPS2_asInt++;

		Debug.LogInfo(GameStatsTester.class, "theFps2: " + theFPS2_asInt);
	}
	
}
