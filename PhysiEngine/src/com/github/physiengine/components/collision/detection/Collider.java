package com.github.physiengine.components.collision.detection;

import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.Component;

public abstract class Collider extends Component{
	
	private Vector2 positionOffset;
	private Vector2 size;
	private float rotationOffset;
	
	private CollisionInfo info;

	public Collider() {
		this.positionOffset = new Vector2();
		this.size = new Vector2(1, 1);
		this.rotationOffset = 0;
	}
	
	public Collider(float offX, float offY, float width, float height, float rotationOffset) {
		this.positionOffset = new Vector2(offX, offY);
		this.size = new Vector2(width, height);
		this.rotationOffset = rotationOffset;
	}
	
	public void detectCollision(Collider other) {
		if(other instanceof AABBCollider) {
			info = collideWith((AABBCollider)other);
		}else if(other instanceof CircleCollider) {
			info = collideWith((CircleCollider)other);
		}
	}
	
	protected abstract CollisionInfo collideWith(AABBCollider other);
	protected abstract CollisionInfo collideWith(CircleCollider other);
	
	@Override
	public void init() {}
	
	@Override
	public void update() {}
	
	public CollisionInfo getCollision() {
		return info;
	}
	
	public Vector2 getPosition() {
		return Vector2.Add(parent.getTransform().getPos(), positionOffset);
	}
	
	public float getX() {
		return parent.getTransform().getPos().x + positionOffset.x;
	}
	
	public float getY() {
		return parent.getTransform().getPos().y + positionOffset.y;
	}
	
	public Vector2 getSize() {
		return Vector2.Mul(parent.getTransform().getScale(), size);
	}
	
	public float getWidth() {
		return parent.getTransform().getScale().x * size.x;
	}
	
	public float getHeight() {
		return parent.getTransform().getScale().y * size.y;
	}
	
	public float getRotation() {
		return parent.getTransform().getRotation() + rotationOffset;
	}
	
}