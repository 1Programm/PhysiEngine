package com.github.physiengine.engine;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.log.Log;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.GameObject;
import com.github.physiengine.object.tags.Tag;

public abstract class Scene {
	
	private String[] usedTextures;
	private String[] usedModels;
	
	private List<GameObject> objects;
	private List<Light> lights;
	
	/*
	 * Other info about scene
	 * ex:
	 * 	Gravity, Background Color / Image, UsedMusikClips, UsedAnimations, ...
	 * 
	 */
	
	public Scene(String[] usedTextures, String[] usedModels) {
		this.usedTextures = usedTextures;
		this.usedModels = usedModels;
		
		this.objects = new ArrayList<>();
		this.lights = new ArrayList<>();
	}
	
	protected abstract void init();
	
	void initScene() {
		clear();
		init();
	}
	
	private void clear() {
		objects.clear();
		lights.clear();
	}
	
	
	
	
	
	protected void registerLight(Light light) {
		lights.add(light);
		
		if(lights.size() >= 4) {
			Log.warn("Scene registering Light", "Remember There can only be 4 lights used at the same time for 1 Object");
		}
	}
	
	protected GameObject createEmpty() {
		return createEmpty(new Vector3f(), new Vector3f(), new Vector3f(1, 1, 1));
	}
	
	protected GameObject createEmpty(Vector3f position) {
		return createEmpty(position, new Vector3f(), new Vector3f(1, 1, 1));
	}
	
	protected GameObject createEmpty(float x, float y, float z) {
		return createEmpty(new Vector3f(x, y, z), new Vector3f(), new Vector3f(1, 1, 1));
	}
	
	protected GameObject createEmpty(float x, float y, float z, float scale) {
		return createEmpty(new Vector3f(x, y, z), new Vector3f(), new Vector3f(scale, scale, scale));
	}
	
	protected GameObject createEmpty(Vector3f position, Vector3f scale) {
		return createEmpty(position, new Vector3f(), scale);
	}
	
	protected GameObject createEmpty(Vector3f position, Vector3f rotation, Vector3f scale) {
		GameObject empty = new GameObject(position, rotation, scale);
		this.objects.add(empty);
		return empty;
	}
	
	
	
	
	
	
	
	
	
	
	List<Light> getLights(){
		return lights;
	}
	
	String[] getUsedTextures() {		
		return usedTextures;
	}
	
	String[] getUsedModels() {
		return usedModels;
	}
	
	List<GameObject> getObjects() {
		return objects;
	}
	
	public List<GameObject> getObjects(Tag... tags) {
		List<GameObject> objs = new ArrayList<>();
		
		for(GameObject obj : objects) {
			for(Tag tag : tags) {
				if(obj.hasTags(tag)) {
					objs.add(obj);
					break;
				}
			}
		}
		
		return objs;
	}
	
	public GameObject getObject(Tag tag) {
		for(GameObject obj : objects) {
			if(obj.hasTags(tag)) {
				return obj;
			}
		}
		
		return null;
	}
	
	
}
