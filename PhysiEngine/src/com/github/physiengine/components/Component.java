package com.github.physiengine.components;

import com.github.physiengine.object.*;

public abstract class Component {

	private String name;

	private GameObject parent;

	public Component(String name) {

		this.name = name;

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
