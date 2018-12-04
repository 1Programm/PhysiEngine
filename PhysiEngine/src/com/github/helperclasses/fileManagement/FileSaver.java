package com.github.helperclasses.fileManagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.github.helperclasses.interfaces.Saveable;

public class FileSaver {
	
	public static void saveFromArray(String[] data, String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			for(String line : data) {
				writer.write(line);
				writer.newLine();
			}
			
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveToFile(Saveable data, String path) {
		saveFromArray(data.getContent(), path);
	}

}
