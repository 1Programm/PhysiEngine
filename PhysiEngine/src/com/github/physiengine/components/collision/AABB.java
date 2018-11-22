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
		float x1 = position.x;
		float x2 = other.position.x;
		
		float y1 = position.y;
		float y2 = other.position.y;
		
		float xw1 = position.x + size.x;
		float xw2 = other.position.x + other.size.x;
		
		float yw1 = position.y + size.y;
		float yw2 = other.position.y + other.size.y;
		
		if(x1 > xw2) return null;
		if(y1 > yw2) return null;
		if(xw1 < x2) return null;
		if(yw1 < y2) return null;
		
		CollisionInfo info = new CollisionInfo();
		
		
		float dx = x1 - xw2;
		float dy = y1 - yw2;
		
		float dw = xw1 - x2;
		float dh = yw1 - y2;
		
		float dxy = Math.abs(dx) < Math.abs(dy) ? dx : dy;
		float dwh = Math.abs(dw) < Math.abs(dh) ? dw : dh;
		
		if(Math.abs(dxy) < Math.abs(dwh)) {
			info.penetrateX = dxy;
		}else {
			info.penetrateY = dwh;
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
