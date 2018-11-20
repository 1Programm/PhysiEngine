package com.github.helperclasses.loader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public ImageLoader() {

	}

	public static BufferedImage loadImage(String fileName, String fileType) {

		BufferedImage bi = null;

		try {
			bi = ImageIO.read(new File("/" + fileName + "." + fileType));
		} catch (IOException e) {

			System.out.println("Error 404: File not found");

		}

		return bi;

	}

}
