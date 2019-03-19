package com.github.physiengine.world;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.math.Transform;

public class WorldSettings {

	private Transform forces;
	private float airFriction; 
	private float unitSize;
	
	public WorldSettings() {
		this.forces = new Transform(
				new Vector3f(0, -0.8f, 0),
				new Vector3f(0, 0, 0),
				new Vector3f(0, 0, 0));
		
		this.airFriction = 0.1f;
		
		this.unitSize = 1;
	}

	public Transform getForces() {
		return forces;
	}

	public WorldSettings setForces(Transform forces) {
		this.forces = forces;
		
		return this;
	}

	public float getAirFriction() {
		return airFriction;
	}

	public WorldSettings setAirFriction(float airFriction) {
		this.airFriction = airFriction;
		
		return this;
	}

	public float getUnitSize() {
		return unitSize;
	}

	public WorldSettings setUnitSize(float unitSize) {
		this.unitSize = unitSize;
		
		return this;
	}
	
}
