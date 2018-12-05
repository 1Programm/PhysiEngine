package com.github.helperclasses.fileManagement;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.github.helperclasses.interfaces.Loadable;
import com.github.physiengine.engine.GameStats;

public class FileLoader {

	public static String[] getFile(String path) {
		ArrayList<String> fileLines = new ArrayList<>();

		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));
			
			String line = "";
			
			while((line = bf.readLine()) != null) {
				fileLines.add(line);
			}
			
			bf.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error 404: File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] gameState = new String[fileLines.size()];
		
		for(int i = 0; i < fileLines.size(); i++) {
			gameState[i] = fileLines.get(i);
		}

		return gameState;
	}
	
	public static void loadInto(Loadable toLoad, String path) {
		String[] lines = getFile(path);
		
		toLoad.loadFromFile(lines);
	}
	
	public static BufferedImage loadImage(String path) {
		BufferedImage image = null;

		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Error 404: File not found");
		}

		return image;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Loadable> T GetLoadedObject(String path, Class<T> cls) {
		String[] content = getFile(path);
		
		T object = null;
		
		try {
			Constructor<T> constructor = cls.getConstructor();
			object = constructor.newInstance();
			object.loadFromFile(content);
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException e) {
			if(cls == GameStats.class) {
				GameStats stats = GameStats.Empty();
				stats.loadFromFile(content);
				object = (T)stats;
			}else {
				e.printStackTrace();
			}
		}
		
		return object;
	}
}
