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
		
	}

	@Override
	protected boolean updateParticle(Particle particle) {
		// TODO Auto-generated method stub
		return false;
	}

}
