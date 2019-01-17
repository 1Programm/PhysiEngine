package com.github.physiengine.object.components.gfx;

import org.lwjgl.util.vector.Vector3f;

import com.github.physiengine.engine.AssetsLoader;
import com.github.physiengine.gfx.model.ModelTexture;
import com.github.physiengine.gfx.model.TexturedModel;
import com.github.physiengine.object.components.Component;
import com.github.physiengine.object.components.body.Model;

public class Texture extends Component {

	private TexturedModel texturedModel;
	private ModelTexture tmpTexture;
	private String tmpName;
	
	private int textureID = 0;
	private Vector3f color = new Vector3f(1, 1, 1);

	public Texture() {}
	
	public Texture(String name) { tmpName = name; }
	
	public Texture(ModelTexture texture) { tmpTexture = texture; }
	
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
	
	public Texture setColor(float r, float g, float b) {
		this.color.set(r, g, b);
		return this;
	}
	
	public Vector3f getColor() {
		return color;
	}
	
	@Override
	public void init() {
		Model model = parent.getComponent(Model.class);
		
		if(model != null) {
			if(tmpName != null) {
				texturedModel = new TexturedModel(model.getModel(), AssetsLoader.getTexture(tmpName));
			}else if(tmpTexture != null) {
				texturedModel = new TexturedModel(model.getModel(), tmpTexture);
			}else {
				texturedModel = new TexturedModel(model.getModel(), AssetsLoader.getPlacholderTexture());
			}
		}
	}

	@Override
	public void update() {}

	@Override
	public void receiveMessage(Component sender, String msg) {
		if(sender instanceof Model) {
			if(texturedModel == null) {
				init();
			}
		}
	}

}
