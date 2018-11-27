package com.github.helperclasses.saver;

import java.io.FileWriter;
import java.io.IOException;

import com.github.helperclasses.interfaces.Saveable;

public class SaveGameState {

	public SaveGameState() {

	}

	public static boolean saveToFile(Saveable data) {

		boolean success = true;

		String savePath = data.getSavePath();

		String[] newData = data.getContent();

		FileWriter fw;
		try {
			fw = new FileWriter(savePath, true);

			for (String line : newData) {

				fw.write(line);

			}
			fw.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();

			success = false;
		}

		return success;

	}

}
