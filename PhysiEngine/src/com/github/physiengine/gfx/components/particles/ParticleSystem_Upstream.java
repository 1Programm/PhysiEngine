package com.github.physiengine.gfx.components.particles;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;

public class ParticleSystem_Upstream extends ParticleSystem{

	private ModelTexture texture;
	
	private float startY;
	private float endY;
	
	private float startS;
	private float endS;
	
	public ParticleSystem_Upstream(int size, String textureName, float startY, float endY, float startS, float endS) {
		super(size, true);
		this.texture = AssetsLoader.getTexture(textureName);
		
		this.startY = startY;
		this.endY = endY;
		this.startS = startS;
		this.endS = endS;
	}

	@Override
	protected void initParticle(Particle particle, Vector3f center) {
		float x = (float)(Math.random() * 2 - 1);
		float z = (float)(Math.random() * 2 - 1);
		
		particle.init(
				x, startY, z, 
				startS, startS,
				(float)(Math.random() * 180),
				texture,
				0, 0, 0, 0,
				(float)(Math.random() * 5 + 1));
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		particle.updateTime();
		
		if(particle.passedTime >= particle.lifeLength) {
			return false;
		}
		
		particle.transform.getPosition().y = startY +(endY - startY) * particle.getPercentage();
		
		float scale = startS + (endS - startS) * particle.getPercentage();
		particle.transform.getScale().set(scale, scale, 0);
		
		
		return true;
	}

}
