package com.github.physiengine.components;

public abstract class Component {

	private String name;
	
	private GameObject parent;
	
	public Component(String name) {
		
		this.name = name;
		
	}
	
	public abstract void update();

}
