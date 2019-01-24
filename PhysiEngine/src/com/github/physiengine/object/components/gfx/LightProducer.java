package com.github.physiengine.object.components.gfx;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.gfx.components.Light;
import com.github.physiengine.object.components.Component;

public class LightProducer extends Component{

	private Light light;
	
	public LightProducer(Vector3f color) {
		light = new Light(color);
	}
	
	public LightProducer(Light light) {
		this.light = light;
	}
	
	public Light getLight() {
		return light;
	}
	
	@Override
	public void init() {
		light.setParentPosition(parent.getPosition());
		ObjectSpace.curOpenSpace.addLight(light);
	}

	@Override
	public void update() {}

	@Override
	public void receiveMessage(Component sender, String msg) {}

}
