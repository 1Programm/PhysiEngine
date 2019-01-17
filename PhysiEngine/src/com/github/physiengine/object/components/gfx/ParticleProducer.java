package com.github.physiengine.object.components.gfx;

import com.github.physiengine.gfx.components.particles.ParticleSystem;
import com.github.physiengine.gfx.renderer.MasterRenderer;
import com.github.physiengine.object.components.Component;

public class ParticleProducer extends Component{

	private ParticleSystem system;
	
	public ParticleProducer(ParticleSystem system) {
		this.system = system;
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		MasterRenderer.addParticleSystem(system);
		
		system.update();
	}

	@Override
	public void receiveMessage(Component sender, String msg) {
		
	}

}
