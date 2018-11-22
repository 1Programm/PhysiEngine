package com.github.physiengine.object;

import java.util.HashMap;

import com.github.physiengine.components.Component;

public class GameObject {

	private HashMap<String, Component> components;

	private Transform transform;
	
	/*
	 *  ------- > Später Ergebniss:
	 * 
	 * 
	 * 	GameObject g = new GameObject();
	 *  // g hat position von (0, 0) und size (1, 1);
	 * 
	 * 	g.setPosition(100, 100);
	 * 
	 * 	g.addComponent(new Model_Rectangle());
	 * 	((Model)g.getComponent("model")).image = Loader.LoadImage("/image1.png");
	 * 
	 */
	
	

	public GameObject() {
		components = new HashMap<>();
		transform = new Transform();
	}

	public boolean addComponent(Component c) {
		if (components.containsKey(c.getName())) {
			return false;
		}else {
			components.put(c.getName(), c);
			return true;
		}
	}

	public Component GetComponent(String name) {
		if (!components.containsKey(name))
			return null;

		return components.get(name);
	}

	public Transform getTransform() {
		return transform;
	}

}