package com.github.physiengine;

public final class PhysiSystem {
	
	public static final int MODE_GAME_2D = 1;
	public static final int MODE_GAME_3D = 2;
	
	
	public int mode;
	public String name;
	public int width, height;
	public int fps_cap;
	
	public PhysiSystem(String name, int width, int height, int fps_cap, int mode) {
		this.name = name;
		this.width = width;
		this.height = height;
		this.fps_cap = fps_cap;
		this.mode = mode;
	}
	
	
	
}
