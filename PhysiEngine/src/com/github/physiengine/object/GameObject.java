package com.github.physiengine.object;

import java.util.HashMap;

import com.github.physiengine.components.Component;

public class GameObject {

	private HashMap<String, Component> components;
	
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

}