package com.github.physiengine.components.gfx;

import java.awt.Color;

import com.github.helperclasses.gfx.ImageResource;
import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.Component;
import com.github.physiengine.components.ComponentTyp;
import com.github.physiengine.components.model.Model;
import com.github.physiengine.gfx.Graphics;

public class Image extends Component {

	private ImageResource image;
	private Color color;
	
	public Image(String path) {
		image = new ImageResource(path);
		color = new Color(255, 255, 255, 255);
		typ = ComponentTyp.GraphicsComponent;
	}
	
	public Image(Color color) {
		this.color = color;
		typ = ComponentTyp.GraphicsComponent;
	}

	public void update() {
		Model model = parent.getComponent(Model.class);
		
		if(model != null) {
			Vector2[] rect = model.getVertecies();
			
			Graphics.setScale(parent.getTransform().getScale());
			Graphics.setRotation(parent.getTransform().getRotation());
			Graphics.setColor(color);
			
			if(image != null) {
				Graphics.drawImage(image, rect, parent.getTransform().getPos());
			}else {
				Graphics.drawRect(rect);
			}
		}
	}
	
	public void setColor(Color c) {
		this.color = c;
	}

}
