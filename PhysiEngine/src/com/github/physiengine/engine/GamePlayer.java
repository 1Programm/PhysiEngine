package com.github.physiengine.engine;

import java.util.ArrayList;

import com.github.helperclasses.debug.Debug;
import com.github.physiengine.object.GameObject;

public class GamePlayer {

	private GameStats stats;
	
	private ArrayList<ObjectSpace> spaces;
	
	private FPSAnimator animator;
	
	public GamePlayer(GameStats stats) {
		this.stats = stats;
		this.spaces = new ArrayList<>();
	}
	
	public void startGame() {
		Integer FPS = stats.getVariable("FPS", Integer.class);
		
		if(FPS == null) {
			Debug.LogError(this.getClass(), "There is no FPS value in the GameStats. Setup a FPS value by saying something like: stats.setVariable(\"FPS\", 60);");
			return;
		}
		
		animator = new FPSAnimator(FPS);
		animator.setUpdateMethod(updateMethod);
		animator.start();
	}
	
	private UpdateMethod updateMethod = () -> {
		for(int i=0;i<spaces.size();i++) {
			updateSpace(spaces.get(i));
		}
	};
	
	private void updateSpace(ObjectSpace space) {
		for(int i=0;i<space.size();i++) {
			space.get(i).update();
		}
	}
	
	public void addSpace(ObjectSpace space) {
		this.spaces.add(space);
	}
	
	public void addObject(GameObject object) {
		if(spaces.size() == 0) {
			spaces.add(new ObjectSpace(false));
		}
		
		spaces.get(spaces.size() - 1).add(object);
	}
	
}
