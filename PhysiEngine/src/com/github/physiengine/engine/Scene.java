package com.github.physiengine.engine;

public interface Scene {
	
	/*
	 * Other info about scene
	 * ex:
	 * 	Gravity, Background Color / Image, UsedMusikClips, UsedAnimations, ...
	 * 
	 */
	
	String[] getUsedTextures();
	String[] getUsedModels();
	
	ObjectSpace[] initObjects();
	
}
