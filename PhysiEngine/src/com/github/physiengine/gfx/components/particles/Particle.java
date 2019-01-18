package com.github.physiengine.gfx.components.particles;

import org.lwjgl.util.vector.Vector4f;

import com.github.helperclasses.math.Transform;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.world.Time;

public class Particle {

	public Transform transform;
	public Transform velocities;
	
	public Transform parentTransform;
	
	public ModelTexture texture;
	public Vector4f color;
	
	public float lifeLength;
	public float passedTime;
	
	public Particle() {
		transform = new Transform();
		velocities = new Transform();
		lifeLength = 0;
		passedTime = 0;
		color = new Vector4f();
	}
	
	public void init(float x, float y, float z, float w, float h, float rot, ModelTexture texture, float r, float g, float b, float a, float lifeLength) {
		transform.set(
				x, y, z,
				w, h, 1,
				0, rot, 0);
		
		velocities = Transform.ZERO();
		
		this.texture = texture;
		this.color.set(r, g, b, a);
		this.lifeLength = lifeLength;
		this.passedTime = 0;
	}
	
	public void init(float x, float y, float z, float vx, float vy, float vz, float w, float h, float vw, float vh, float rot, float vr, ModelTexture texture, float r, float g, float b, float a, float lifeLength) {
		transform.set(
				x, y, z,
				w, h, 1,
				0, rot, 0
		);
		
		velocities.set(
				vx, vy, vz,
				vw, vh, 0,
				0, vr, 0
		);
		
		this.texture = texture;
		this.color.set(r, g, b, a);
		this.lifeLength = lifeLength;
		this.passedTime = 0;
	}
	
	public void updateTime() {
		passedTime += Time.getDelta();
	}
	
	public float getPercentage() {
		return passedTime / lifeLength;
	}
	
}
