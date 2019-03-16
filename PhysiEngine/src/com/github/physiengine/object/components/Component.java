package com.github.physiengine.object.components;

import java.util.function.Supplier;

import com.github.physiengine.engine.Scene;
import com.github.physiengine.object.GameObject;

public abstract class Component {

	protected String name;
	protected GameObject parent;
	protected boolean enabled;
	
	private Supplier<Scene> getScene;

	public Component() {
		setupName();
		
		this.enabled = true;
	}
	
	private void setupName() {
		Class<?> c = super.getClass();
		while(!c.getSuperclass().getSimpleName().equals("Component")) {
			c = c.getSuperclass();
		}
		
		this.name = c.getSimpleName().toLowerCase();
	}

	public abstract void init();
	public abstract void update();
	public abstract void receiveMessage(Component sender, String msg);
	
	public GameObject getParent() {
		return parent;
	}

	public void setParent(GameObject parent, Supplier<Scene> getScene) {
		this.parent = parent;
		this.getScene = getScene;
		init();
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
	
	protected Scene getScene() {
		return getScene.get();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()) {
			return true;
		}
		return false;
	}

}
