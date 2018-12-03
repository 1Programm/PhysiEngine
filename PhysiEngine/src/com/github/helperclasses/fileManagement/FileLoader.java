package com.github.helperclasses.fileManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.github.helperclasses.interfaces.Loadable;
import com.github.helperclasses.interfaces.Saveable;

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
	
	public static void loadInto(Loadable toLoad) {
		if(toLoad instanceof Saveable) {
			String path = ((Saveable)toLoad).getPath();
			loadInto(toLoad, path);
		}else {
			System.out.println("this object doesn't implement Saveable");
		}
	}
	
	public static void loadInto(Loadable toLoad, String path) {
		String[] lines = getFile(path);
		
		toLoad.loadFromFile(lines);
	}

}
