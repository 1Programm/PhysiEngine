package com.github.physiengine.object;

import java.util.HashMap;

import com.github.physiengine.components.Component;
import com.github.physiengine.components.Transform;

public class GameObject {

	private HashMap<String, Component> components;
	
	private Transform transform;
	
	public GameObject() {
		
		components = new HashMap<>();
		
	}
	
	public boolean addComponent(Component c) {
		
		if(components.containsKey(c.getName())) {
			
			return false;
			
		}
		
		else {
			
			components.put(c.getName(), c);
			return true;
		}
		
	}
	
	public Component GetComponent(String name){
		if(!components.containsKey(name)) return null;
		
		return components.get(name);
	}

}