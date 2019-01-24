package com.github.physiengine.physics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Path <T> implements Iterator<T>{
	
	private T[] points;
	private int pointer;

	@SuppressWarnings("unchecked")
	public Path(T... points) {
		this.points = points;
		this.pointer = 0;
	}
	
	@Override
	public boolean hasNext() {
		return (pointer >= 0 && pointer < points.length);
	}

	@Override
	public T next() {
		return points[pointer++];
	}
	
	public void reset() {
		this.pointer = 0;
	}
	
	public Path<T> getReversed() {
		List<T> points = new ArrayList<T>();
		for(int i=this.points.length-1;i>=0;i--) {
			points.add(this.points[i]);
		}
		
		T[] ts = this.points;
		
		Path<T> path = new Path<>(points.toArray(ts));
		return path;
	}
	
}
