package com.github.helperclasses.gfx;

import java.awt.image.BufferedImage;

public abstract class Animator {

	private double speed;
	private double distanceFPS;

	private int index;
	private BufferedImage[] images;

	public Animator(double frameRate) {
		speed = frameRate;
	}

	/*
	 * Positive Value -> Animation runs foward | Negative Value -> Animation runs
	 * back
	 */
	public final void setSpeed(double rate) {
		speed = rate;
	}

	public double getSpeed() {
		return speed;
	}

	/* Time between Frames */
	public final void setDistance(double dis) {
		distanceFPS = dis;
	}

	public double getDistance() {
		return distanceFPS;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public BufferedImage getCurrent() {
		return images[index];
	}

	public void step() {
		index++;
		if (index == images.length) {
			index = 0;
		}
	}
}
