package com.github.physiengine.engine;

import com.github.physiengine.gfx.components.Light;

public interface Scene {
	
	/*
	 * Other info about scene
	 * ex:
	 * 	Gravity, Background Color / Image, UsedMusikClips, UsedAnimations, ...
	 * 
	 */
	
	String[] getUsedTextures();
	String[] getUsedModels();
	
	Light[] initLights();
	ObjectSpace[] initObjects();
	
}
