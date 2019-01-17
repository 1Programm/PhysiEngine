package com.github.physiengine.gfx.components.particles;

import org.lwjgl.util.vector.Vector3f;

import com.github.helperclasses.debug.Debug;
import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;

public class ParticleSystem_Fountain extends ParticleSystem{

	private ModelTexture texture;
	
	public ParticleSystem_Fountain(Vector3f center, int size, String textureName) {
		super(center, size);
		
		texture = AssetsLoader.getTexture(textureName);
	}

	@Override
	protected void initParticle(Particle particle, Vector3f center) {
		float x = center.x + (float)(Math.random() * 2 - 1);
		float y = center.y + (float)(Math.random() * 2 - 1);
		float z = center.z + (float)(Math.random() * 2 - 1);
		
		particle.init(
				x, y, z,
				0.01f, 0.01f,
				0,
				texture,
				(float)(Math.random() * 5)
				);
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		particle.updateTime();
		
		if(particle.passedTime >= particle.lifeLength) {
			return false;
		}
		
		particle.transform.addRotation(0, 0, 5);
		particle.transform.addScale(0.0001f, 0.0001f, 0);
		
		
		return true;
	}

}
