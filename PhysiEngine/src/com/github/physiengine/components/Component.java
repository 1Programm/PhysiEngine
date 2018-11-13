package com.github.physiengine.components;

import com.github.physiengine.object.*;

public abstract class Component {

	private String name;
	private GameObject parent;
	
	private boolean enabled;

	public Component(String name) {

		this.name = name;
		this.enabled = true;

	}

	public abstract void update();

	public GameObject getParent() {
		return parent;
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
	}

	public String getName() {

		return name;

	}

}
