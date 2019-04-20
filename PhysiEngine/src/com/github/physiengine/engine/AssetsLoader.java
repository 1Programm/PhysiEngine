package com.github.physiengine.engine;

import java.util.HashMap;
import java.util.Map;

import com.github.helperclasses.fileManagement.Loader;
import com.github.helperclasses.fileManagement.OBJLoader;
import com.github.helperclasses.fileManagement.PATHS;
import com.github.helperclasses.log.Log;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.gfx.model.RawModel;

public class AssetsLoader {	
	private static ModelTexture placeholderTexture;
	
	private static Map<String, ModelTexture> textures = new HashMap<>();
	private static Map<String, RawModel> models = new HashMap<>();
	
	// ... sound, animations, usw...
	
	public static void init() {
		placeholderTexture = new ModelTexture(Loader.loadTexture(PATHS._DEFAULT_TEXTURE));
	}
	
	public static void loadTextures(String[] textures) {
		Map<String, ModelTexture> tmpTextures = new HashMap<>();
		
		if(textures != null) {
			for(String t : textures) {
				if(!tmpTextures.containsKey(t)) {
					tmpTextures.put(t, new ModelTexture(Loader.loadTexture(t)));
				}else {
					Log.warn("AssetsLoader loading texture", "Double Texture names: " + t);
				}
			}
		}
		
		AssetsLoader.textures = tmpTextures;
	}
	
	public static void loadModels(String[] models) {
		Map<String, RawModel> tmpModels = new HashMap<>();
		
		if(models != null) {
			for(String m : models) {
				if(!tmpModels.containsKey(m)) {
					tmpModels.put(m, OBJLoader.loadOBJModel(m));
				}else {
					Log.warn("AssetsLoader loading texture", "Double Model names: " + m);
				}
			}
		}
		
		AssetsLoader.models = tmpModels;
	}
	
	public static ModelTexture getTexture(String name) {	
		if(textures.containsKey(name)) {
			return textures.get(name);
		}
		
		Log.error("AssetsLoader get texture", "Could not find texture: " + PATHS._TEXTURES + name + ".png");
		return null;
	}
	
	public static ModelTexture getPlacholderTexture() {
		return placeholderTexture;
	}
	
	
	public static RawModel getModel(String name) {	
		if(models.containsKey(name)) {
			return models.get(name);
		}
		
		Log.error("AssetsLoader loading texture", "Could not find model: " + PATHS._OBJECTS + name + ".obj");
		return null;
	}
	
	
	
}
