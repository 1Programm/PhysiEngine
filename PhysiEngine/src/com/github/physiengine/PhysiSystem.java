package com.github.physiengine;

public final class PhysiSystem {

	private static final long FIRST_START = System.nanoTime();
	
	public static final double getDeltaTime() {
		return System.nanoTime() - FIRST_START;
	}
	
	public static final void EXIT() {
		System.exit(0);
	}
	
}
