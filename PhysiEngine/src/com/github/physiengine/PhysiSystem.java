package com.github.physiengine;

import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.UpdateMethod;
import com.github.physiengine.gfx.Window;

public final class PhysiSystem {

	private static Window window;
	
	public static void CreateWindow(GameStats stats, UpdateMethod renderMethod) {
		window = Window.Create(stats, renderMethod);
	}
	
	public static Window getCurWindow() {
		return window;
	}
	
	public static final void EXIT() {
		System.exit(0);
	}
	
}
