package com.github.physiengine.components.model;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.Component;

public class Model extends Component{

	protected Vector2[] vertecies;

	@Override
	public void update() {}

	public Vector2[] getVertecies() {
		Vector2[] ret = new Vector2[vertecies.length];
		
		Vector2 parPos = parent.getTransform().getPos();
		Vector2 parSize = parent.getTransform().getScale();
		float parRot = parent.getTransform().getRotation();
		
		for(int i=0;i<vertecies.length;i++) {
			ret[i] = (Vector2.Mul(vertecies[i], parSize));
			ret[i].rotate(parRot);
			ret[i].add(parPos);
		}
		
		return ret;
	}
	
}
