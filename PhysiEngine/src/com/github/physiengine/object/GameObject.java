package com.github.physiengine.object;

import java.util.HashMap;

import com.github.physiengine.components.Component;
import com.github.physiengine.components.ComponentTyp;
import com.github.physiengine.engine.ObjectSpace;

public class GameObject {

	private String name;
	
	private HashMap<String, Component> components;

	protected Transform transform;

	
	
	public GameObject() { init("NoName", 0, 0, 1, 1, 0); }

	public GameObject(String name) { init(name, 0, 0, 1, 1, 0); }

	public GameObject(String name, float x, float y) { init(name, x, y, 1, 1, 0); }

	public GameObject(String name, float x, float y, float w, float h) { init(name, x, y, w, h, 0); }

	public GameObject(String name, float x, float y, float w, float h, float rotation) { init(name, x, y, w, h, rotation); }

	public GameObject(float x, float y) { init("NoName", x, y, 1, 1, 0); }

	public GameObject(float x, float y, float w, float h) { init("NoName", x, y, w, h, 0); }

	public GameObject(float x, float y, float w, float h, float rotation) { init("NoName", x, y, w, h, rotation); }
	
	
	private void init(String name, float x, float y, float w, float h, float r) {
		this.name = name;
		this.components = new HashMap<>();
		this.transform = new Transform(x, y, w, h, r);
		
		if(ObjectSpace.curOpenSpace != null) {
			ObjectSpace.curOpenSpace.add(this);
		}
	}
	
	public void update() {
		for(String name : components.keySet()) {
			Component c = components.get(name);
			if(c.getTyp() == ComponentTyp.ControllingComponent) {
				c.update();
			}
		}
	}
	
	public void render() {
		for(String name : components.keySet()) {
			Component c = components.get(name);
			if(c.getTyp() == ComponentTyp.GraphicsComponent) {
				c.update();
			}
		}
	}

	public boolean addComponent(String name, Component c) {
		if (components.containsKey(name)) {
			return false;
		}else {
			components.put(name, c);
			c.setParent(this);
			return true;
		}
	}
	
	public boolean addComponent(Component c) {
		return addComponent(c.getName(), c);
	}
	
	public void removeComponent(String name){
		components.remove(name);
	}

	public Component getComponent(String name) {
		if (!components.containsKey(name)) {
			return null;
		}

		return components.get(name);
	}
	
	public Component getComponentFromClassName(String name) {
		for(String n : components.keySet()) {
			if(components.get(n).getName().equals(name)) {
				return components.get(n);
			}
		}
		
		return null;
	}
	
	public <T extends Component> T getComponent(Class<T> typ) {
		for(String name : components.keySet()) {
			try {
				return typ.cast(components.get(name));
			}catch (ClassCastException e) {
				//Not right...
			}
		}
		
		return null;
	}
	
	public Transform getTransform() {
		return transform;
	}
	
	public String getName() {
		return name;
	}
	
}