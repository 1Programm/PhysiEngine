package com.github.physiengine.gfx.components.particles;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;

public class ParticleSystem_Fountain extends ParticleSystem{

	private ModelTexture texture;
	
	public ParticleSystem_Fountain(int size, String texture) {
		super(size);
		this.texture = AssetsLoader.getTexture(texture);
	}

	@Override
	protected void initParticle(Particle particle, Vector3f center) {
		float dirX = ((float)(Math.random() - 0.5) * 0.5f) * 3;
		float dirY = (float)(Math.random() * 0.5 + 2.7);
		float dirZ = ((float)(Math.random() - 0.5) * 0.5f) * 3;
		
		particle.init(
				center.x, center.y, center.z,
				dirX, dirY, dirZ,
				0.05f, 0.05f,
				0, 0,
				0,
				0,
				texture,
				-1, 0, 0, 0,
				(float)(Math.random() * 1.5 + 4));
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		if(particle.isTimeDead()) {
			return false;
		}
		
		particle.movePositionByVelocity();
		particle.velocities.getPosition().y += -0.02f;
		
		return true;
	}

}
