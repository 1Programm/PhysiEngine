package com.github.physiengine.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.fileManagement.Loader;
import com.github.physiengine.EngineSettings;
import com.github.physiengine.gfx.DisplayManager;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.gfx.renderer.MasterRenderer;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.world.Time;

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
	
	public GamePlayer(EngineSettings settings) {
		this.scenes = new HashMap<>();

		DisplayManager.createDisplay(settings);
		
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
		
		this.curScene.initScene();
	}
	
	public void startGame() {
		if(curScene == null) {
			Debug.LogWarning(GamePlayer.class, "There is no loaded Scene !");
			return;
		}
		
		
		// initializing stuff
		Time.init();
		MasterRenderer.init();
		
		if(cam == null) {
			Debug.Log(getClass(), "returned ERROR - Camera is not initialized");
			return;
		}
		
		while(!Display.isCloseRequested()) {
			for(GameObject obj : curScene.getObjects()) {
				if(obj.isEnabled()) {
					MasterRenderer.addGameObject(obj);
					obj.update();
					
					List<GameObject> children = obj.getChildren();
					if(children != null) {
						for(GameObject child : children) {
							if(child.isEnabled()) {
								MasterRenderer.addGameObject(child);
								child.update();
							}
						}
					}
				}
			}
			
			MasterRenderer.render(curScene.getLights(), cam);

			DisplayManager.updateDisplay();
			
			Time.updateDelta();
		}
		
		// Clean up after ending
		MasterRenderer.cleanUp();
		Loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
