package com.github.physiengine.engine;

import java.util.ArrayList;

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
	
	
	
	
	private ArrayList<GameObject> objects;
	
	public ObjectSpace(boolean isOpen) {
		objects = new ArrayList<>();
		
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
	
	public int size() {
		return objects.size();
	}
	
	public GameObject get(int i) {
		return objects.get(i);
	}
	
	public ArrayList<GameObject> getObjects(){
		return objects;
	}
	
}
