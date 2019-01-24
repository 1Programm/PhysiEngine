package com.github.physiengine.gfx.components.particles;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.object.GameObject;

public abstract class ParticleSystem {
	
	private Particle[] particles;
	protected int pointer;
	
	private GameObject parent;
	
	public ParticleSystem(int size) {
		particles = new Particle[size];
		pointer = 0;
	}
	
	public void initParent(GameObject parent) {
		this.parent = parent;
	}
	
	public void update() {
		if(pointer < particles.length) {
			particles[pointer] = initParticle();
			pointer++;
		}
		
		for(int i=0;i<pointer;i++) {
			boolean alive = updateParticle(particles[i]);
			
			if(!alive) {
				initParticle(particles[i], parent.getPosition());
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
	
	private Particle initParticle() {
		Particle particle = new Particle();
		initParticle(particle, parent.getPosition());
		return particle;
	}
	
	protected abstract void initParticle(Particle particle, Vector3f center);
	
	protected abstract boolean updateParticle(Particle particle);
	
}
