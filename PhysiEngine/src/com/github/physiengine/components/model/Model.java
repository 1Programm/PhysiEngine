package com.github.physiengine.components.model;

import com.github.physiengine.components.Changes;
import com.github.physiengine.components.Component;
import com.github.physiengine.math.Vector2;
import com.github.physiengine.object.Transform;

public class Model extends Component{

	private Vector2[] baseVertecies;
	
	protected Vector2[] vertecies;
	
	protected Transform localTransform;
	
	public Model() {
		super("model");
	}
	
	public void putVertecies(Vector2[] vertecies) {
		this.baseVertecies = vertecies;
		this.vertecies = new Vector2[vertecies.length];
		
		updateVertecies(parent.getTransform());
	}
	
	public void updateVertecies(Transform t) {
		for(int i=0;i<baseVertecies.length;i++) {
			
		}
	}

	@Override
	public void update(Changes c) {
		
	}

}
