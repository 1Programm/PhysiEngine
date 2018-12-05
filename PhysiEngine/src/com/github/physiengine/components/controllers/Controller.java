package com.github.physiengine.components.controllers;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.Changes;
import com.github.physiengine.components.Component;

public abstract class Controller extends Component {
	
	@Override
	public void update(Changes c) {
		parent.getTransform().move(updatePos());
	}
	
	public abstract Vector2 updatePos();

}
