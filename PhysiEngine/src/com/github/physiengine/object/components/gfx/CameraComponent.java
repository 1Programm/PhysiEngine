package com.github.physiengine.object.components.gfx;

import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.gfx.components.Camera;
import com.github.physiengine.object.components.Component;

public class CameraComponent extends Component{
	
	private Camera cam;
	
	@Override
	public void init() {
		this.cam = new Camera(parent);
		GamePlayer.setCamera(cam);
	}

	@Override
	public void update() {
		cam.update();
	}

	@Override
	public void receiveMessage(Component sender, String msg) {
		
	}

}
