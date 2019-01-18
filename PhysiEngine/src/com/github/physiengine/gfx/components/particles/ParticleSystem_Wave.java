package com.github.physiengine.gfx.components.particles;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.world.Time;

public class ParticleSystem_Wave extends ParticleSystem{

	private ModelTexture texture;
	
	public ParticleSystem_Wave(int size, String textureName) {
		super(size);
		
		texture = AssetsLoader.getTexture(textureName);
	}

	@Override
	protected void initParticle(Particle particle) {
		float x = (float)(Math.random() * 2 - 1);
		float y = (float)(Math.random() * 2 - 1);
		float z = (float)(Math.random() * 2 - 1);
		
		particle.init(
				x, y, z,
				0.02f, 0.02f,
				(float)(Math.random() * 180),
				texture,
				0, 0, 0, 0,
				(float)(Math.random() * 5)
				);
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		particle.updateTime();
		
		if(particle.passedTime >= particle.lifeLength) {
			return false;
		}
		
		particle.transform.getPosition().y = (float) (Math.sin(Time.getSinTime() * particle.lifeLength * 4) * particle.lifeLength);
		
		particle.transform.addRotation(0, 0, 5);
		
		float scale = 0.1f + particle.getPercentage() * (0 - 0.1f);
		particle.transform.getScale().set(scale, scale, 1);
		
		
		return true;
	}

}
