package com.github.physiengine;

import com.github.helperclasses.debug.ConsoleOut;
import com.github.helperclasses.debug.SystemConsole;

public class EngineSettings{

	/*
	 * Window Settings
	 */
	private String windowTitle;
	private int windowWidth, windowHeight;
	
	/*
	 * GameLoop Settings
	 */
	private int gameFpsCap;
	private boolean printFPS;
	private ConsoleOut fpsLogConsole;
	
	public EngineSettings() {
		init(
				"No Title",
				600,
				600 / 12 * 9,
				
				30,
				false,
				null
		);
	}
	
	public EngineSettings(String windowTitle) {
		init(
				windowTitle,
				600,
				600 / 12 * 9,
				
				30,
				false,
				null
		);
	}
	
	private void init(String windowTitle, int windowWidth, int windowHeight, int gameFpsCap, boolean printFPS, ConsoleOut fpsLogConsole) {
		this.windowTitle = windowTitle;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		this.gameFpsCap = gameFpsCap;
		this.printFPS = printFPS;
		this.fpsLogConsole = fpsLogConsole;
		
		if(fpsLogConsole == null) {
			fpsLogConsole = new SystemConsole();
		}
	}

	public String getWindowTitle() {
		return windowTitle;
	}

	public EngineSettings setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
		
		return this;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public EngineSettings setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
		
		return this;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public EngineSettings setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
		
		return this;
	}

	public int getGameFpsCap() {
		return gameFpsCap;
	}

	public EngineSettings setGameFpsCap(int gameFpsCap) {
		this.gameFpsCap = gameFpsCap;
		
		return this;
	}

	public boolean isPrintFPS() {
		return printFPS;
	}

	public EngineSettings setPrintFPS(boolean printFPS) {
		this.printFPS = printFPS;
		
		return this;
	}

	public ConsoleOut getFpsLogConsole() {
		return fpsLogConsole;
	}

	public EngineSettings setFpsLogConsole(ConsoleOut fpsLogConsole) {
		this.fpsLogConsole = fpsLogConsole;
		
		return this;
	}
	
	
	
	
	
}
