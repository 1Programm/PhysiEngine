package com.github.helperclasses.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadGameState {

	public LoadGameState() {

	}

	public static String[] getGameState(String path) {

		ArrayList<String> gameStateArray = new ArrayList<>();

		BufferedReader bf = null;

		try {
			bf = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {

			System.out.println("Error 404: File not found");
		}

		String line = null;

		try {
			line = bf.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}

		while (line != null) {

			gameStateArray.add(line);

			try {
				bf.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		String[] gameState = new String[gameStateArray.size()];
		
		for(int i = 0; i < gameState.length; i++) {
			
			gameState[i] = gameStateArray.get(i);
			
		}

		return gameState;

	}

}
