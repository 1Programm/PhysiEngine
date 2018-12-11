package com.github.physiengine.components.collision;

public class AABB extends Collider {

	@Override
	protected CollisionInfo collideWith(AABB other) {
		float left1 = getX();
		float left2 = other.getX();
		
		float top1 = getY();
		float top2 = other.getY();
		
		float right1 = left1 + getWidth();
		float right2 = left2 + other.getWidth();
		
		float bottom1 = top1 + getHeight();
		float bottom2 = top2 + other.getHeight();
		
		
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


}
