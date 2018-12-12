package com.github.helperclasses.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.github.physiengine.gfx.Window;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

public class ImageResource {

	private Texture texture = null;
	
	private BufferedImage image = null;
	
	public ImageResource(String path) {
		URL url = getClass().getResource(path);
		
		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(image != null) {
			image.flush();
		}
	}
	
	public Texture getTexture() {
		if(image  == null) return null;
	
		if(texture == null) {
			texture = AWTTextureIO.newTexture(Window.profile, image, true);
		}
		
		return texture;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
}
