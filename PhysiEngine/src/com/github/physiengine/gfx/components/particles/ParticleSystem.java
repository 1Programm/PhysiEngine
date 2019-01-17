package com.github.physiengine.gfx.components.particles;

import java.util.ArrayList;
import java.util.List;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.object.GameObject;

public abstract class ParticleSystem {

	private Transform parentTransform;
	
	private Particle[] particles;
	protected int pointer;
	
	public ParticleSystem(int size) {
		this.parentTransform = new Transform();
		particles = new Particle[size];
		pointer = 0;
	}
	
	public void initParent(GameObject object) {
		this.parentTransform.set(object.getTransform());
	}
	
	public void update() {
		if(pointer < particles.length) {
			particles[pointer] = initParticle();
			pointer++;
		}
		
		for(int i=0;i<pointer;i++) {
			boolean alive = updateParticle(particles[i]);
			
			if(!alive) {
				initParticle(particles[i]);
			}
		}
	}
	
	public List<Particle> getParticles(){
		List<Particle> parts = new ArrayList<>();
		for(int i=0;i<pointer;i++) {
			parts.add(particles[i]);
		}
		
		return parts;
	}
	
	public Transform getTransform() {
		return parentTransform;
	}
	
	private Particle initParticle() {
		Particle particle = new Particle();
		particle.parentTransform = parentTransform;
		initParticle(particle);
		return particle;
	}
	
	protected abstract void initParticle(Particle particle);
	
	protected abstract boolean updateParticle(Particle particle);
	
}
