package com.github.physiengine.engine;

public interface Scene {
	
	/*
	 * Other info about scene
	 * ex:
	 * 	Gravity, Background Color / Image, UsedMusikClips, UsedAnimations, ...
	 * 
	 */

	ObjectSpace[] initObjects();
	
	String[] getUsedTextures();
	String[] getUsedModels();
	
	
}
