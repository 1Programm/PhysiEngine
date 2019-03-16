package com.github.physiengine.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.fileManagement.Loader;
import com.github.physiengine.PhysiSystem;
import com.github.physiengine.gfx.DisplayManager;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.gfx.renderer.MasterRenderer;
import com.github.physiengine.object.GameObject;

public class GamePlayer {
	
	private static Camera cam;
	
	public static void setCamera(Camera cam) {
		if(GamePlayer.cam != null) {
			Debug.Log(GamePlayer.class, "Camera is overwritten by new one");
		}
		
		GamePlayer.cam = cam;
	}
	
	
	private Map<String, Scene> scenes;
	private Scene curScene;
	
	private ObjectSpace objectSpace;
	private List<Light> lights;
	
	public GamePlayer(PhysiSystem system) {
		this.scenes = new HashMap<>();
		this.lights = new ArrayList<>();

		DisplayManager.createDisplay(system.name, system.fps_cap, system.width, system.height);
		
		AssetsLoader.init();
	}
	
	public void addScene(String name, Scene scene) {
		scenes.put(name, scene);
	}
	
	public void loadScene(String sceneName) {
		Scene scene = scenes.get(sceneName);
		
		if(scene == null) {
			Debug.LogWarning(GamePlayer.class, "Could not load Scene. Scene is null");
			return;
		}
		
		this.curScene = scene;
		
		AssetsLoader.loadTextures(scene.getUsedTextures());
		AssetsLoader.loadModels(scene.getUsedModels());
		
		this.objectSpace = scene.getObjectSpace();
		this.objectSpace.init(this::getScene);

		this.lights.clear();
		this.lights.addAll(objectSpace.getLights());
	}
	
	public void startGame() {
		if(curScene == null) {
			Debug.LogWarning(GamePlayer.class, "There is no loaded Scene !");
			return;
		}
		// initializing stuff
		MasterRenderer.init();
		
		if(cam == null) {
			Debug.Log(getClass(), "returned ERROR - Camera is not initialized");
			return;
		}
		
		while(!Display.isCloseRequested()) {
			for(GameObject obj : objectSpace.getObjects()) {
				MasterRenderer.addGameObject(obj);
				obj.update();
			}
			
			MasterRenderer.render(lights, cam);

			DisplayManager.updateDisplay();
		}
		
		// Clean up after ending
		MasterRenderer.cleanUp();
		Loader.cleanUp();
		DisplayManager.closeDisplay();
	}
	
	private Scene getScene() {
		return curScene;
	}

}
