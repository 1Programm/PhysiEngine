package com.github.physiengine.physics;

import java.util.Iterator;

@SuppressWarnings("unchecked") 
public class Path <T> implements Iterable<T>{

	private T[] points;
	
	public Path(T... points) {
		this.points = points;
	}

	@Override
	public Iterator<T> iterator() {
		return new PathIterator(points);
	}
	
	
	private class PathIterator implements Iterator<T>{

		private T[] points;
		private int pointer;
		
		public PathIterator(T... points) {
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
	}
	
	
	
}
