package com.github.physiengine.engine;

import java.util.List;

import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.tags.Tag;

public abstract class Scene {
	
	private ObjectSpace space;
	private String[] usedTextures;
	private String[] usedModels;
	
	
	
	/*
	 * Other info about scene
	 * ex:
	 * 	Gravity, Background Color / Image, UsedMusikClips, UsedAnimations, ...
	 * 
	 */
	
	protected abstract ObjectSpace initObjects();
	
	protected abstract String[] initUsedTextures();
	protected abstract String[] initUsedModels();
	
	ObjectSpace getObjectSpace() {
		this.space = initObjects();
		return space;
	}
	
	String[] getUsedTextures() {
		if(usedTextures == null) {
			usedTextures = initUsedTextures();
		}
		
		return usedTextures;
	}
	
	String[] getUsedModels() {
		if(usedModels == null) {
			usedModels = initUsedModels();
		}
		
		return usedModels;
	}
	
	public List<GameObject> getObjects(Tag... tags) {
		return space.getObjects(tags);
	}
	
	public GameObject getObject(Tag tag) {
		return space.getObject(tag);
	}
	
	
}
