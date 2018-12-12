package com.github.physiengine.components.model;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.Component;

public class Model extends Component{

	protected Vector2[] vertecies;
	protected Vector2 offset;
	
	public Model(Vector2 offset) {
		if(offset == null) this.offset = new Vector2();
		else this.offset = offset;
	}

	@Override
	public void update() {}

	public Vector2[] getVertecies() {
		return vertecies;
//		Vector2[] verts = new Vector2[vertecies.length];
//		
//		for(int i=0;i<vertecies.length;i++) {
//			verts[i] = Vector2.Mul(vertecies[i], parent.getTransform().getScale());
//		}
//		
//		return verts;
	}
	
	public Vector2 getOffset() {
		return offset;
	}
	
}
