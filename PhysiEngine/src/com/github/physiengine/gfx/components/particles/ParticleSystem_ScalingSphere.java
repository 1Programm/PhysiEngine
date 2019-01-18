package com.github.physiengine.gfx.components.particles;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.world.Time;

public class ParticleSystem_ScalingSphere extends ParticleSystem{

	private ModelTexture texture;
	
	public ParticleSystem_ScalingSphere(int size, String textureName) {
		super(size);
		
		texture = AssetsLoader.getTexture(textureName);
	}

	@Override
	protected void initParticle(Particle particle) {
		float x = (float)(Math.random() - 0.5);
		float y = (float)(Math.random() - 0.5);
		float z = (float)(Math.random() - 0.5);
		
		float speed = (float)(Math.random() * 1f);
		
		float dx = -x * speed;
		float dy = -y * speed;
		float dz = -z * speed;
		
		particle.init(
				x, y, z,
				dx, dy, dz,
				0.1f, 0.1f,
				0, 0,
				(float)(Math.random() * 90),
				0,
				texture,
				0, 0, 0, 0,
				5
		);
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		particle.updateTime();
		
		if(particle.passedTime >= particle.lifeLength) {
			return false;
		}
		
		float vx = particle.velocities.getPosition().x * Time.getDelta();
		float vy = particle.velocities.getPosition().y * Time.getDelta();
		float vz = particle.velocities.getPosition().z * Time.getDelta();
		
		particle.transform.addPosition(vx, vy, vz);
		
		
		//particle.color.w = (1 - particle.getPercentage());
		particle.color.x = (1 - particle.getPercentage());
		particle.color.z = particle.getPercentage();
		
		return true;
	}

}
