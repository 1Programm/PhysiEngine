package com.github.physiengine.engine;

public abstract class FPSAnimator implements Runnable{

	private Thread thread; 
	private boolean running = false;
	
	private double FPS;
	private boolean printFPS;
	
	private UpdateMethod updateMethod;
	
	public FPSAnimator(double FPS, boolean printFPS) {
		this.FPS = FPS;
		this.printFPS = printFPS;
	}
	
	public void setUpdateMethod(UpdateMethod updateMethod) {
		this.updateMethod = updateMethod;
	}
	
	public void start() {
		if(running) return;
		
		running = true;
	
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = FPS;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			if(printFPS) {
				frames++;
					
				if(System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					System.out.println("FPS: " + frames + " TICKS: " + updates);
					frames = 0;
					updates = 0;
				}
			}
		}	
	}
	
	private void update() {
		if(updateMethod != null) {
			updateMethod.update();
		}
		
		
	}
}
