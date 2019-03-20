package com.github.physiengine.physics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Path<T> implements Iterator<T>{
	
	public static final int MODE_END_AFTER_RUN = 0;
	public static final int MODE_LOOP_AFTER_RUN = 1;
	public static final int MODE_REVERSE_AFTER_RUN = 2;
	
	private List<T> elements;
	private int pointer;

	public Path() {
		this.elements = new ArrayList<>();
		this.pointer = 0;
	}
	
	public Path<T> add(T element){
		elements.add(element);
		
		return this;
	}
	
	@Override
	public boolean hasNext() {
		return (pointer >= 0 && pointer < elements.size());
	}

	@Override
	public T next() {
		return elements.get(pointer++);
	}
	
	public void reset() {
		this.pointer = 0;
	}

	public Path<T> getReversed() {
		Path<T> path = new Path<>();
		
		for(int i=this.elements.size()-1;i>=0;i--) {
			path.add(this.elements.get(i));
		}
		
		return path;
	}
	
}
