package com.github.physiengine.components;

import com.github.physiengine.object.*;

public abstract class Component {

	protected String name;
	protected GameObject parent;
	
	protected boolean enabled;

	public Component(String name) {

		this.name = name;
		this.enabled = true;

	}

	public abstract void update(Changes c);

	public GameObject getParent() {
		return parent;
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean b) {
		this.enabled = b;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()) {
			return true;
		}
		return false;
	}

}
