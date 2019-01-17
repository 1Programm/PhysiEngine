package com.github.physiengine.object.components.body;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.RawModel;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.object.components.gfx.Texture;

public class Model extends Component{

	private RawModel model;
	
	public Model(String name) {
		this.model = AssetsLoader.getModel(name);
	}
	
	public Model(RawModel model) {
		this.model = model;
	}
	
	public RawModel getModel() {
		return model;
	}
	
	
	@Override
	public void init() {
		parent.sendMessage(Texture.class, this, "Inited");
	}
	
	@Override
	public void update() {}

	@Override
	public void receiveMessage(Component sender, String msg) {}
	
}
