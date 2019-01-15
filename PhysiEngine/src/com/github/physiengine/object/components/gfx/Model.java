package com.github.physiengine.object.components.gfx;

import com.github.helperclasses.fileManagement.OBJLoader;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.gfx.model.RawModel;
import com.github.physiengine.gfx.model.TexturedModel;
import com.github.physiengine.object.components.Component;

public class Model extends Component{

	private TexturedModel texturedModel;
	private int textureID = 0;
	
	public Model(String objFileName, ModelTexture texture) {
		RawModel model = OBJLoader.loadOBJModel(objFileName);
		texturedModel = new TexturedModel(model, texture);
	}
	
	public TexturedModel getModel() {
		return texturedModel;
	}
	
	public void setTextureID(int id) {
		this.textureID = id;
	}
	
	public float getTextureXOffset() {
		int column = textureID % texturedModel.getTexture().getNumberOfRows();
		return (float) column / (float) texturedModel.getTexture().getNumberOfRows();
	}
	
	public float getTextureYOffset() { 
		int row = textureID / texturedModel.getTexture().getNumberOfRows();
		return (float)row / (float)texturedModel.getTexture().getNumberOfRows();
	}
	
	
	@Override
	public void init() {}
	@Override
	public void update() {}
	
}
