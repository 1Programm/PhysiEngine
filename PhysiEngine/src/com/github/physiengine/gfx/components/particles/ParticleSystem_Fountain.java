package com.github.physiengine.gfx.components.particles;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.world.Time;

public class ParticleSystem_Fountain extends ParticleSystem{

	private ModelTexture texture;
	
	public ParticleSystem_Fountain(int size, String textureName) {
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
				(float)(Math.random() * 8)
				);
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		particle.updateTime();
		
		if(particle.passedTime >= particle.lifeLength) {
			return false;
		}
		
		particle.transform.getPosition().y = (float) (Math.sin(Time.getSinTime() * particle.lifeLength * 3) * particle.lifeLength);
		
		particle.transform.addRotation(0, 0, 5);
		particle.transform.addScale(0.0001f, 0.0001f, 0);
		
		
		return true;
	}

}
