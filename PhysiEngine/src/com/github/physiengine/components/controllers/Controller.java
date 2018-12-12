package com.github.physiengine.components.controllers;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.Component;
import com.github.physiengine.components.ComponentTyp;

public abstract class Controller extends Component {
	
	public Controller() {
		typ = ComponentTyp.ControllingComponent;
	}
	
	@Override
	public void update() {
		parent.getTransform().move(updatePos());
	}
	
	public abstract Vector2 updatePos();

}
