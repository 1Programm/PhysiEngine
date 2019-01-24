package com.github.physiengine.object.components.controllers;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.physics.Path;

public class ObjectController_Path extends ObjectController{

	private static final Vector3f SPEEDS = new Vector3f(5, 0, 0);
	private static final float minDist = 0.1f;
	
	public static final int MODE_END_AFTER_RUN = 0;
	public static final int MODE_LOOP_AFTER_RUN = 1;
	public static final int MODE_REVERSE_AFTER_RUN = 2;
	
	
	private Path<Vector3f> path;
	private Vector3f next;
	
	private int mode;
	private boolean running;
	
	public ObjectController_Path(Path<Vector3f> path, int mode) {
		super(SPEEDS);
		this.path = path;
		next = path.next();
		this.mode = mode;
		this.running = true;
	}

	@Override
	public Transform getTransformation(float posSpeed, float rotSpeed, float scaleSpeed) {
		Transform transform = Transform.ZERO();
		
		if(running) {
			Vector3f dir = new Vector3f();
			Vector3f.sub(next, parent.getPosition(), dir);
			
			float dist = dir.length();
			
			if(dist < minDist) {
				if(path.hasNext() == false) {
					goal();
				}else {
					next = path.next();
				}
			}else {
				dir.normalise();
				
				transform.getPosition().set(dir.x * posSpeed, dir.y * posSpeed, dir.z * posSpeed);
			}
		}
		
		return transform;
	}
	
	private void goal() {
		if(mode == MODE_END_AFTER_RUN) {
			running = false;
		}else if(mode == MODE_LOOP_AFTER_RUN) {
			path.reset();
			next = path.next();
		}else if(mode == MODE_REVERSE_AFTER_RUN) {
			path = path.getReversed();
			next = path.next();
		}
	}

	@Override
	public void init() {}

	@Override
	public void receiveMessage(Component sender, String msg) {}

}
