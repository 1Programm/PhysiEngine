package com.github.physiengine.engine;

import java.util.ArrayList;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.math.Vector2;
import com.github.helperclasses.math.Vector3;
import com.github.physiengine.object.GameObject;

public class GamePlayer {

	private GameStats stats;
	
	private ArrayList<ObjectSpace> spaces;
	
	private FPSAnimator animator;
	
	public GamePlayer(GameStats stats) {
		this.stats = stats;
		this.spaces = new ArrayList<>();
		
		Integer FPS = getFPS();
		
		if(FPS == null) {
			Debug.LogError(this.getClass(), "There is no FPS value in the GameStats. Setup a FPS value by saying something like: stats.setVariable(\"FPS\", 60);");
			return;
		}
		
		animator = new FPSAnimator(FPS);
		animator.setUpdateMethod(updateMethod);
	}
	
	public void startGame() {
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

	public GameStats getStats() {
		return stats;
	}
	
	public Integer getFPS() {
		return stats.getVariable(GameStats.FPS, Integer.class);
	}
	
	public Vector3 getBackgoundColor() {
		return stats.getVariable(GameStats.BACKGROUND, Vector3.class);
	}
	
	public String getBackgroundImagePath() {
		return stats.getVariable(GameStats.BACKGROUND, String.class);
	}
	
	public Vector2 getWindowSize() {
		return stats.getVariable(GameStats.WINDOW_SIZE, Vector2.class);
	}
	
	public int getWindowWidth() {
		Vector2 size = getWindowSize();
		
		if(size == null) {
			Debug.Log(GamePlayer.class, "The Window Size is not set in the GameStats");
			return -1;
		}
		
		return (int)size.x;
	}
	
	public int getWindowHeight() {
		Vector2 size = getWindowSize();
		
		if(size == null) {
			Debug.Log(GamePlayer.class, "The Window Size is not set in the GameStats");
			return -1;
		}
		
		return (int)size.x;
	}
}
