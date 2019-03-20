package com.github.physiengine.object;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.object.components.controllers.Mover;
import com.github.physiengine.object.tags.Tag;

public class GameObject {
	
	private Transform transform;
	private List<Tag> tags; 
	
	private boolean enabled;

	private List<Component> components;
	private GameObject parent;
	private List<GameObject> children;
	
	public GameObject() { init(new Vector3f(), new Vector3f(), new Vector3f(1, 1, 1));	}
	public GameObject(float x, float y, float z) { init(new Vector3f(x, y, z), new Vector3f(), new Vector3f(1, 1, 1));	}
	public GameObject(Vector3f position) { init(position, new Vector3f(), new Vector3f(1, 1, 1));	}
	public GameObject(float x, float y, float z, float scale) { init(new Vector3f(x, y, z), new Vector3f(), new Vector3f(scale, scale, scale));	}
	public GameObject(Vector3f position, Vector3f scale) { init(position, new Vector3f(), scale);	}
	public GameObject(Vector3f position, Vector3f rotation, Vector3f scale) { init(position, rotation, scale);	}
	
	private void init(Vector3f position, Vector3f rotation, Vector3f scale) {
		this.transform = new Transform(position, rotation, scale);
		this.tags = new ArrayList<>();
		this.enabled = true;
		this.components = new ArrayList<>();
		this.parent = null;
		this.children = new ArrayList<>();
	}
	
	public GameObject addTags(Tag... tags) {
		for(Tag tag : tags) {
			if(!this.tags.contains(tag)) {
				this.tags.add(tag);
			}
		}
		
		return this;
	}
	
	public boolean hasTag(Tag tag) {
		return tags.contains(tag);
	}
	
	public boolean hasTags(Tag... tags) {
		for(Tag tag : tags) {
			if(!hasTag(tag)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public void update() {
		// Update
		for(Component component : components) {
			component.update();
		}
		
		// Get Velocity
		Mover mover = getComponent(Mover.class);
		
		if(mover != null) {
			Transform velocity = mover.getVelocity();
			
			// Check for collision ... (TODO)
			
			
			// Add Velocity
			
			transform.addTransform(velocity);
		}
	}
	
	public void transform(Transform transformation) {
		Mover mover = getComponent(Mover.class);
		if(mover != null) {
			mover.addVelocity(transformation);
		}else {
			Debug.LogWarning(GameObject.class, "This GameObject has no Mover attached to it - it will not move", true);
		}
	}

	public GameObject addChildren(GameObject... objs) {
		if(objs != null) {
			for(int i=0;i<objs.length;i++) {
				children.add(objs[i]);
			}
		}
		
		return this;
	}
	
	public List<GameObject> getChildren(Tag... tags) {
		if(tags == null) {
			return children;
		}else {
			List<GameObject> list = new ArrayList<>();
			
			for(int i=0;i<children.size();i++) {
				if(children.get(i).hasTags(tags)) {
					list.add(children.get(i));
				}
			}
			
			return list;
		}
	}

	public GameObject addComponent(Component c) {
		components.add(c);
		c.setParent(this);
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
	
	public <T extends Component> void sendMessage(Class<T> cls, Component sender, String msg) {
		for(Component component : components) {
			if(component.getClass() == cls) {
				component.receiveMessage(sender, msg);
			}
		}
	}
	
	public void setParent(GameObject parent) {
		this.parent = parent;
	}
	
	public GameObject getParent() {
		return parent;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public Vector3f getPosition() {
		return new Vector3f(transform.getPosition());
	}
	
	public float getPositionX() {
		return transform.getPosition().x;
	}
	
	public float getPositionY() {
		return transform.getPosition().y;
	}
	
	public float getPositionZ() {
		return transform.getPosition().z;
	}
	
	public Vector3f getRotation() {
		return new Vector3f(transform.getRotation());
	}
	
	public float getRotationX() {
		return transform.getRotation().x;
	}
	
	public float getRotationY() {
		return transform.getRotation().y;
	}
	
	public float getRotationZ() {
		return transform.getRotation().z;
	}
	
	public Vector3f getScale() {
		return new Vector3f(transform.getScale());
	}
	
	public float getScaleX() {
		return transform.getScale().x;
	}
	
	public float getScaleY() {
		return transform.getScale().y;
	}
	
	public float getScaleZ() {
		return transform.getScale().z;
	}
	
}