package com.github.physiengine.gfx.components.particles;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.world.Time;

public class ParticleSystem_MoveToPoint extends ParticleSystem{

	private ModelTexture texture;
	private Vector3f point;
	private float length;
	private float offset;
	
	public ParticleSystem_MoveToPoint(int size, String textureName, Vector3f point, float offset) {
		super(size);
		
		texture = AssetsLoader.getTexture(textureName);
		this.point = point;
		this.length = point.length() / 2.0f;
		this.offset = offset;
	}

	@Override
	protected void initParticle(Particle particle) {
		float x = (float)(Math.random() - 0.5);
		float y = (float)(Math.random() - 0.5);
		float z = (float)(Math.random() - 0.5);
		
		float speed = (float)(Math.random() * 1f);
		
		float dx = (point.x - x) * speed;
		float dy = (point.y - y) * speed;
		float dz = (point.z - z) * speed;
		
		particle.init(
				x, y, z,
				dx, dy, dz,
				0.06f, 0.06f,
				0, 0,
				(float)(Math.random() * 90),
				0,
				texture,
				1, 0, 0, 0,
				length 
		);
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		particle.updateTime();
		
		if(particle.passedTime >= particle.lifeLength) {
			return false;
		}
		
//		point.y = (float) (Math.sin((Time.getSinTime() + offset) * length*3) * length + length);
		point.y = Time.getSinTime(offset, 5) * length * 3;
		
		particle.movePositionByVelocity();
		
		float scale = 0.05f - (0.05f - 0.001f) * particle.getPercentage();
		
		particle.transform.getScale().x = scale;
		particle.transform.getScale().y = scale;
		
		
		particle.color.w = - particle.getPercentage();
		particle.color.x = (1 - particle.getPercentage());
		particle.color.z = particle.getPercentage();
		
		return true;
	}

}
