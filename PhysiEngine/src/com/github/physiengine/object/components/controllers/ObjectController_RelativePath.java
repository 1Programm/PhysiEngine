package com.github.physiengine.object.components.controllers;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.physics.Path;

public class ObjectController_RelativePath extends ObjectController{

	private static final float minDist = 0.1f;
	
	private Path<Vector3f> path;
	private Vector3f next;
	private Vector3f dir;
	private float dirDistance;
	
	private int mode;
	private boolean running;
	
	public ObjectController_RelativePath(Path<Vector3f> path, float speed, int mode) {
		super(new Vector3f(speed, 0, 0));
		this.path = path;
		this.mode = mode;
		this.running = true;
		
		next();
	}

	@Override
	public Transform getTransformation(float posSpeed, float rotSpeed, float scaleSpeed) {
		Transform transform = Transform.ZERO();
		
		if(running) {
			
			if(dirDistance < minDist) {
				if(path.hasNext() == false) {
					goal();
				}else {
					next();
				}
			}else {
				Vector3f dir = new Vector3f(this.dir);
				
				if(dir.length() != 0) {
					dir.normalise();
				}
				
				dirDistance -= dir.length() * posSpeed;
				
				transform.getPosition().set(dir.x * posSpeed, dir.y * posSpeed, dir.z * posSpeed);
			}
		}
		
		return transform;
	}
	
	private void goal() {
		if(mode == Path.MODE_END_AFTER_RUN) {
			running = false;
		}else if(mode == Path.MODE_LOOP_AFTER_RUN) {
			path.reset();
			next();
		}else if(mode == Path.MODE_REVERSE_AFTER_RUN) {
			path = path.getReversed();
			next();
		}
	}
	
	private void next() {
		if(next != null) {
			Vector3f nNext = path.next();
			
			dir = new Vector3f(
					nNext.x - next.x,
					nNext.y - next.y,
					nNext.z - next.z);
			
			next = nNext;
			dirDistance = dir.length();
		}else {
			next = path.next();
			dir = next;
			dirDistance = dir.length();
		}
	}

	@Override
	public void init() {}

	@Override
	public void receiveMessage(Component sender, String msg) {}

}