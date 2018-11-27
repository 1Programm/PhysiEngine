package com.github.physiengine.object;

import java.util.HashMap;

import com.github.physiengine.components.Component;

public class GameObject {

	private HashMap<String, Component> components;

	protected Transform transform;	

	public GameObject() {
		components = new HashMap<>();
		transform = new Transform();
	}

	public boolean addComponent(Component c) {
		if (components.containsKey(c.getName())) {
			return false;
		}else {
			components.put(c.getName(), c);
			c.setParent(this);
			return true;
		}
	}
	
	public void removeComponent(String name){
		components.remove(name);
	}

	public Component GetComponent(String name) {
		if (!components.containsKey(name)) {
			return null;
		}

		return components.get(name);
	}

	public Transform getTransform() {
		return transform;
	}
	
}