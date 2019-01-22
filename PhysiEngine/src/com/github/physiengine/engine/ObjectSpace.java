package com.github.physiengine.engine;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.GameObject;

public class ObjectSpace {

	private static int ignores = 0;
	public static ObjectSpace curOpenSpace = null;
	
	public static void Ignore(int num) {
		ignores += num;
	}
	
	public static void IgnoreStart() {
		ignores = -1;
	}
	
	public static void IgnoreStop() {
		ignores = 0;
	}
	
	public static void CloseSpace() {
		curOpenSpace = null;
		ignores = 0;
	}
	
	
	
	
	private List<GameObject> objects;
	private List<Light> lights;
	
	public ObjectSpace(boolean isOpen) {
		objects = new ArrayList<>();
		lights = new ArrayList<>();
		
		if(isOpen) {
			curOpenSpace = this;
		}
	}
	
	public void add(GameObject object) {
		if(this == curOpenSpace) {
			if(ignores != 0) {
				if(ignores > 0) {
					ignores--;
				}
				return;
			}
		}
		
		objects.add(object);
	}
	
	public void addLight(Light light) {
		if(light.getParentPosition() == null) {
			light.setParentPosition(new Vector3f());
		}
		
		lights.add(light);
	}
	
	public void addLight(Vector3f position, Light light) {
		light.setParentPosition(position);
		lights.add(light);
	}
	
	public int size() {
		return objects.size();
	}
	
	public GameObject get(int i) {
		return objects.get(i);
	}
	
	public List<GameObject> getObjects(){
		return objects;
	}
	
	public List<Light> getLights(){
		return lights;
	}
	
}
