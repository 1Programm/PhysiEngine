package com.github.physiengine.components.collision;

import com.github.physiengine.math.Vector2;

public class AABB extends Collider{
	
	public Vector2 position;
	public Vector2 size;
	
	public AABB() {
		onPositionChanged();
		onSizeChanged();
		onRotationChanged();
	}

	@Override
	protected CollisionInfo collideWith(AABB other) {
		float left1 = position.x;
		float left2 = other.position.x;
		
		float top1 = position.y;
		float top2 = other.position.y;
		
		float right1 = position.x + size.x;
		float right2 = other.position.x + other.size.x;
		
		float bottom1 = position.y + size.y;
		float bottom2 = other.position.y + other.size.y;
		
		
		if(left1 > right2) return null;
		if(right1 < left2) return null;
		if(top1 > bottom2) return null;
		if(bottom1 < top2) return null;
		
		// Is Colliding !!
		
		CollisionInfo info = new CollisionInfo();
		
		float dx = right2 - left1;
		float dy = bottom2 - top1;
		
		float dw = right1 - left2;
		float dh = bottom1 - top2;
		
		info.penetrateX = Math.abs(dx) < Math.abs(dw) ? -dx : dw;
		info.penetrateY = Math.abs(dy) < Math.abs(dh) ? -dy : dh;
		
		if(Math.abs(info.penetrateX) < Math.abs(info.penetrateY)) {
			info.penetrateY = 0;
		}else {
			info.penetrateX = 0;
		}
		
		return info;
	}

	@Override
	protected CollisionInfo collideWith(Circle other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onPositionChanged() {
		this.position = parent.getTransform().getPos();
	}

	@Override
	protected void onSizeChanged() {
		this.size = parent.getTransform().getScale();		
	}

	@Override
	protected void onRotationChanged() {
		//TODO
	}

}
