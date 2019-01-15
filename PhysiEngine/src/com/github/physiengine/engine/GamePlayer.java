package com.github.physiengine.engine;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.fileManagement.Loader;
import com.github.physiengine.PhysiSystem;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.renderer.DisplayManager;
import com.github.physiengine.gfx.renderer.MasterRenderer;
import com.github.physiengine.object.GameObject;

public class GamePlayer {
	
	private ArrayList<ObjectSpace> spaces;
	
	public GamePlayer(PhysiSystem system) {
		this.spaces = new ArrayList<>();

		DisplayManager.createDisplay(system.name, system.fps_cap, system.width, system.height);
	}
	
	public void startGame() {
		// initializing stuff
		MasterRenderer.init();
		
		Camera cam = new Camera(new Vector3f(0, 0, -30), new Vector3f());
		
		while(!Display.isCloseRequested()) {
			
			for(ObjectSpace space : spaces) {
				for(GameObject obj : space.getObjects()) {
					MasterRenderer.addGameObject(obj);
				}
			}
			
			MasterRenderer.render(cam);

			DisplayManager.updateDisplay();
		}
		
		// Clean up after ending
		
		MasterRenderer.cleanUp();
		Loader.cleanUp();
		DisplayManager.closeDisplay();
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
