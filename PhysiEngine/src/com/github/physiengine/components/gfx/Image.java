package com.github.physiengine.components.gfx;

import java.awt.Color;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.Component;
import com.github.physiengine.components.ComponentTyp;
import com.github.physiengine.components.model.Model;
import com.github.physiengine.gfx.ModelLoader;
import com.github.physiengine.gfx.ModelTexture;

public class Image extends Component {

	private ModelTexture texture;
	private float r, g, b, a;
	
	public Image(String path) {
		texture = new ModelTexture(ModelLoader.loadTexture(path));
		r = g = b = a = 1;
		typ = ComponentTyp.GraphicsComponent;
	}
	
	public Image(Color color) {
		this.setColor(color);
		typ = ComponentTyp.GraphicsComponent;
	}
	
	public Image(float r, float g, float b, float a) {
		this.setColor(r, g, b, a);
		typ = ComponentTyp.GraphicsComponent;
	}

	public void update() {
		Model model = parent.getComponent(Model.class);
		
		if(model != null) {
			Vector2[] rect = model.getVertecies();
			Vector2 pos = Vector2.Add(parent.getTransform().getPos(), model.getOffset());
			
			/*Graphics.setScale(parent.getTransform().getScale());
			Graphics.setRotation(parent.getTransform().getRotation());
			Graphics.setColor(r, g, b, a);
			
			if(image != null) {
				Graphics.drawImage(image, rect, parent.getTransform().getPos());
			}else {
				Graphics.drawRect(rect, pos);
			}*/
		}
	}
	
	public void setColor(Color color) {
		this.r = color.getRed() / 255.0f;
		this.g = color.getGreen() / 255.0f;
		this.b = color.getBlue() / 255.0f;
		this.a = color.getAlpha() / 255.0f;
	}
	
	public void setColor(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

}
