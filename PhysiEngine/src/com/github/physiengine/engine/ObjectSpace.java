package com.github.physiengine.engine;

import java.util.ArrayList;

import com.github.physiengine.object.GameObject;

public class ObjectSpace {

	public static ObjectSpace currentOpenSpace = null;
	
	private static int ignores = 0;
	
	public static void Ignore(int num) {
		if(currentOpenSpace == null) return;
		ignores = num;
	}
	
	public static void IgnoreStart() {
		if(currentOpenSpace == null) return;
		ignores = -1;
	}
	
	public static void IgnoreStop() {
		if(currentOpenSpace == null) return;
		ignores = 0;
	}
	
	public static void CloseOpenSpace() {
		currentOpenSpace = null;
		ignores = 0;
	}
	
	
	
	public ArrayList<GameObject> objects;
	
	public ObjectSpace(boolean isOpen) {
		if(isOpen) {
			currentOpenSpace = this;
		}
		
		objects = new ArrayList<>();
	}
	
	public GameObject add(GameObject obj) {
		if(currentOpenSpace == this) {
			if(ignores != 0) {
				if(ignores > 0) {
					ignores--;
				}
				
				return obj;
			}
		}
		
		objects.add(obj);
		return obj;
	}
	
}
