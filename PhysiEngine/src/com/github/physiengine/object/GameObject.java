package com.github.physiengine.object;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.components.Component;

public class GameObject {
	
	protected Vector3f position;
	protected Vector3f scale;
	protected Vector3f rotation;
	
	
	private List<Component> components;

	
	public GameObject() { init(new Vector3f(), new Vector3f(1, 1, 1), new Vector3f());	}
	public GameObject(float x, float y, float z) { init(new Vector3f(x, y, z), new Vector3f(1, 1, 1), new Vector3f());	}
	public GameObject(Vector3f position) { init(position, new Vector3f(1, 1, 1), new Vector3f());	}
	public GameObject(float x, float y, float z, float scale) { init(new Vector3f(x, y, z), new Vector3f(scale, scale, scale), new Vector3f());	}
	public GameObject(Vector3f position, Vector3f scale) { init(position, scale, new Vector3f());	}
	
	private void init(Vector3f position, Vector3f scale, Vector3f rotation) {
		this.position = position;
		this.scale = scale;
		this.rotation = rotation;
		
		this.components = new ArrayList<>();
		
		if(ObjectSpace.curOpenSpace != null) {
			ObjectSpace.curOpenSpace.add(this);
		}
	}
	
	public void update() {
		for(Component component : components) {
			component.update();
		}
	}

	public GameObject addComponent(Component c) {
		components.add(c);
		return this;
	}
	
	public GameObject removeComponent(Component c){
		components.remove(c);
		return this;
	}
	
	public Component getComponentFromClassName(String name) {
		for(Component component : components) {
			if(component.getName().equals(name)) {
				return component;
			}
		}
		
		return null;
	}
	
	public <T extends Component> T getComponent(Class<T> typ) {
		for(Component component : components) {
			try {
				return typ.cast(component);
			}catch (ClassCastException e) {
				//Not right...
			}
		}
		
		return null;
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public Vector3f getScale() {
		return scale;
	}
	
	public Vector3f getRotation() {
		return rotation;
	}
	
}