package com.github.physiengine.object;

import com.github.physiengine.components.Component;
import com.github.physiengine.math.Vector2;

public class Transform extends Component {

	private Vector2 pos, scale;

	private float rotation;

	public Transform(String name) {
		super(name);

		setPos(new Vector2());
		setScale(new Vector2());

	}

	public void update() {

	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public void setPos(float x, float y) {

		pos.x = x;
		pos.y = y;

	}

	public Vector2 getScale() {
		return scale;
	}

	public void setScale(Vector2 scale) {
		this.scale = scale;
	}
	
	public void move(float x, float y) {
		
		pos.add(x,y);
		
	}

}
