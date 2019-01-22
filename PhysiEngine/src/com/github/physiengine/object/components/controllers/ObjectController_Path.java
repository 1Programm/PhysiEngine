package com.github.physiengine.object.components.controllers;

import java.util.Iterator;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.physics.Path;

public class ObjectController_Path extends ObjectController{

	private static final Vector3f SPEEDS = new Vector3f(1, 0, 0);
	
	private Iterator<Vector3f> pathIterator;
	private Vector3f next;
	
	private boolean goal;
	
	public ObjectController_Path(Path<Vector3f> path) {
		super(SPEEDS);
		this.pathIterator = path.iterator();
		this.next = pathIterator.next();
		this.goal = false;
	}

	@Override
	public Transform getTransformation(Vector3f speeds) {
		Transform transform = Transform.ZERO();
		
		if(goal == false) {
			Vector3f dir = new Vector3f();
			Vector3f.sub(next, parent.getTransform().getPosition(), dir);
			
			float dist = dir.length();
			
			if(dist < 1) {
				if(pathIterator.hasNext() == false) {
					goal = true;
				}else {
					next = pathIterator.next();
				}
			}else {
				dir.normalise();
				
				transform.getPosition().set(dir.x * speeds.x, dir.y * speeds.x, dir.z * speeds.z);
			}
		}
		
		return transform;
	}

	@Override
	public void init() {}

	@Override
	public void receiveMessage(Component sender, String msg) {}

}
