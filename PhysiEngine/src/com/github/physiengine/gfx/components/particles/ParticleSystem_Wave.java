package com.github.physiengine.gfx.components.particles;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.world.Time;

public class ParticleSystem_Wave extends ParticleSystem{

	private ModelTexture texture;
	private float rTimeOffset;
	
	public ParticleSystem_Wave(int size, String textureName, boolean randomTimeOffset) {
		super(size);
		
		texture = AssetsLoader.getTexture(textureName);
		
		if(randomTimeOffset) {
			this.rTimeOffset = (float)(Math.random() * 2 - 1);
		}
	}

	@Override
	protected void initParticle(Particle particle) {
		float lifeLength = (float)(Math.random() * 3 + 2);
		
		//float y = (float) (Math.sin((Time.getSinTime() + rTimeOffset) * lifeLength * 4) / 2);
		float y = calcYPos(lifeLength);
		float x = (float)(Math.random() - 0.5);
		float z = (float)(Math.random() - 0.5);
		
		
		particle.init(
				x, y, z,
				0.1f, 0.1f,
				(float)(Math.random() * 180),
				texture,
				0, 0, 0, 0,
				lifeLength
				);
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		particle.updateTime();
		
		if(particle.passedTime >= particle.lifeLength) {
			return false;
		}
		
		//particle.transform.getPosition().y = (float) (Math.sin((Time.getSinTime() + rTimeOffset) * particle.lifeLength * 4) / 2);
		particle.transform.getPosition().y = calcYPos(particle.lifeLength);
		
		
		particle.transform.addRotation(0, 0, 5);
		
		float scale = 0.1f + particle.getPercentage() * (0 - 0.1f);
		particle.transform.getScale().set(scale, scale, 1);
		
		
		return true;
	}

	private float calcYPos(float length) {
		return Time.getSinTime(rTimeOffset, length);
	}
	
}
