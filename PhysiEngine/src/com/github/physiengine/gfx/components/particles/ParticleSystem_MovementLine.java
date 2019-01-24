package com.github.physiengine.gfx.components.particles;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;

public class ParticleSystem_MovementLine extends ParticleSystem{

	private int length;
	private ModelTexture texture;
	
	public ParticleSystem_MovementLine(int size, int length, String texture) {
		super(size);
		this.length = length;
		this.texture = AssetsLoader.getTexture(texture);
	}

	@Override
	protected void initParticle(Particle particle, Vector3f center) {
		float x = (float)(Math.random() * 0.3 - 0.15) + center.x;
		float y = (float)(Math.random() * 0.3 - 0.15) + center.y;
		float z = (float)(Math.random() * 0.3 - 0.15) + center.z;
		
		float scale = (float)(Math.random() * 0.05 + 0.01);
		
		particle.init(
				x, y, z,							// Position
				0, 0, 0,							// Velocity
				scale, scale,						// Scale
				0, 0,								// "Scale - Velocity"
				(float)(Math.random() * 90), 	 	// Rotation
				(float)(Math.random() * 40 + 20), 	// Rotation speed
				texture,							// Texture
				0, 0, 0, 0,							// r - g - b - a - additions to the Texture
				length								// Life - length in seconds
		);
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		if(particle.isTimeDead()) {
			return false;
		}
		
		particle.moveRotationByVelocity();
		
		return true;
	}

}
