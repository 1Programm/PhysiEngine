package com.github.physiengine.components;

import com.github.physiengine.object.*;

public abstract class Component {

	protected String name;
	protected GameObject parent;
	protected boolean enabled;
	
	protected ComponentTyp typ;

	public Component() {
		setupName();
		
		this.enabled = true;
		this.typ = null;
	}
	
	private void setupName() {
		Class<?> c = super.getClass();
		while(!c.getSuperclass().getSimpleName().equals("Component")) {
			c = c.getSuperclass();
		}
		
		this.name = c.getSimpleName().toLowerCase();
	}

	public abstract void update();

	protected void init() {}
	
	public GameObject getParent() {
		return parent;
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
		init();
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public ComponentTyp getTyp() {
		return typ;
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
