package com.github.physiengine.engine;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.fileManagement.Loader;
import com.github.physiengine.PhysiSystem;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.renderer.DisplayManager;
import com.github.physiengine.gfx.renderer.MasterRenderer;
import com.github.physiengine.object.GameObject;

public class GamePlayer {
	
	private Scene curScene;
	
	private List<Light> lights;
	private Camera cam;
	private ArrayList<ObjectSpace> spaces;
	
	public GamePlayer(PhysiSystem system) {
		this.lights = new ArrayList<>();
		this.spaces = new ArrayList<>();

		DisplayManager.createDisplay(system.name, system.fps_cap, system.width, system.height);
		
		AssetsLoader.init();
	}
	
	public void loadScene(Scene scene) {
		if(scene == null) {
			Debug.LogWarning(GamePlayer.class, "Could not load Scene. Scene is null");
			return;
		}
		
		this.curScene = scene;
		
		AssetsLoader.loadTextures(scene.getUsedTextures());
		AssetsLoader.loadModels(scene.getUsedModels());
		
		lights.clear();
		for(Light l : scene.initLights()) {
			lights.add(l);
		}
		
		cam = scene.initCamera();
		
		spaces.clear();
		for(ObjectSpace s : scene.initObjects()) {
			spaces.add(s);
		}
	}
	
	public void startGame() {
		if(curScene == null) {
			Debug.LogWarning(GamePlayer.class, "There is no loaded Scene !");
			return;
		}
		// initializing stuff
		MasterRenderer.init();
		
		while(!Display.isCloseRequested()) {
			for(ObjectSpace space : spaces) {
				for(GameObject obj : space.getObjects()) {
					MasterRenderer.addGameObject(obj);
					obj.update();
				}
			}
			
			MasterRenderer.render(lights, cam);

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
