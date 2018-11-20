package com.github.helperclasses.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadGameState {

	public LoadGameState() {

	}

	public static ArrayList<String> getFileContent(String path) {

		ArrayList<String> content = new ArrayList<>();

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

			content.add(line);

			try {
				bf.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return content;

	}

}
