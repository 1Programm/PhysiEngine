package com.github.physiengine.components.model;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.Component;

public class Model extends Component{

	protected Vector2[] vertecies;

	@Override
	public void update() {}

	public Vector2[] getVertecies() {
		return vertecies;
	}
	
}
