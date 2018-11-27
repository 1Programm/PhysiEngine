package com.github.physiengine.components.controllers;

import com.github.physiengine.components.Changes;
import com.github.physiengine.components.Component;
import com.github.physiengine.math.Vector2;

public abstract class Controller extends Component {

	public Controller() {
		super("Controller");
		
	}
	

	@Override
	public void update(Changes c) {
		
		parent.getTransform().move(updatePos());
		
	}
	
	public abstract Vector2 updatePos();

}
