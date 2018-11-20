package com.github.helperclasses.loader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public ImageLoader() {

	}

	public static BufferedImage loadImage(String path) {

		BufferedImage bi = null;

		try {
			bi = ImageIO.read(new File("/" + path));
		} catch (IOException e) {

			System.out.println("File not found!");

		}

		return bi;

	}

}
