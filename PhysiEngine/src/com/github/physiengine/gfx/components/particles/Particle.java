package com.github.physiengine.gfx.components.particles;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.world.Time;

public class Particle {

	public Transform transform;
	public Transform parentTransform;
	
	public ModelTexture texture;
	
	public float lifeLength;
	public float passedTime;
	
	public Particle() {
		transform = new Transform();
		lifeLength = 0;
		passedTime = 0;
	}
	
	public void init(float x, float y, float z, float w, float h, float r, ModelTexture texture, float lifeLength) {
		transform.set(
				x, y, z,
				w, h, 1,
				0, r, 0);
		
		this.texture = texture;
		this.lifeLength = lifeLength;
		this.passedTime = 0;
	}
	
	public void updateTime() {
		passedTime += Time.getDelta();
	}
	
}
