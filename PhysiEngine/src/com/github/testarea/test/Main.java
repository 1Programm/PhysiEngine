package com.github.testarea.test;

import com.github.helperclasses.fileManagement.Loader;
import com.github.physiengine.PhysiSystem;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.components.gfx.Model;

public class Main {

	public static void main(String[] args) {
		GamePlayer player = new GamePlayer(new PhysiSystem("A tester", 1200, 800, 120, PhysiSystem.MODE_GAME_3D));
		
		ObjectSpace space = new ObjectSpace(true);
		
		ModelTexture texture1 = new ModelTexture(Loader.loadTexture("colors/White"));
		
		new GameObject()
		.addComponent(new Model("Dragon", texture1));
		
		player.addSpace(space);
		player.startGame();
		
	}
	
}
