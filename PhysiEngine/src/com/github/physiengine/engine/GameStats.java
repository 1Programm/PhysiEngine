package com.github.physiengine.engine;

import java.util.HashMap;

import com.github.helperclasses.interfaces.Loadable;
import com.github.helperclasses.interfaces.Saveable;

public class GameStats implements Loadable, Saveable{
	
	public static GameStats Empty() {
		return new GameStats();
	}
	
	public static GameStats SimpleGame(int fps) {
		GameStats stats = new GameStats();
		stats.setVariable("FPS", fps);
		
		return stats;
	}
	

	private HashMap<String, Data<?>> variables;
	
	
	private GameStats() {
		variables = new HashMap<>();
	}
	
	public void setVariable(String name, int t) {
		variables.put(name, new Data<Integer>(t));
	}
	
	public void setVariable(String name, float t) {
		variables.put(name, new Data<Float>(t));
	}
	
	public void setVariable(String name, double t) {
		variables.put(name, new Data<Double>(t));
	}
	
	public void setVariable(String name, String t) {
		variables.put(name, new Data<String>(t));
	}
	
	public void setVariable(String name, boolean t) {
		variables.put(name, new Data<Boolean>(t));
	}
	
	public void setVariable(String name, char t) {
		variables.put(name, new Data<Character>(t));
	}
	
	public <T> T getVariable(String name, Class<T> c) {
		Data<?> d = variables.get(name);
		
		if(d != null) {
			if(c.getSimpleName().equals(d.className)) {
				return c.cast(d.content);
			}
		}
		
		return null;
	}
	
	public Object getVariable(String name) {
		return variables.get(name).content;
	}
	
	
	private class Data<T>{
		public T content;
		public String className;
		
		public Data(T content) {
			this.content = content;
			className = content.getClass().getSimpleName();
		}
		
		@Override
		public String toString() {
			return "" + content;
		}
	}

	@Override
	public String[] getContent() {
		String[] vars = new String[variables.size()];
		
		int i = 0;
		for(String name : variables.keySet()) {
			vars[i++] = (name + " - " + variables.get(name).className + " - " + variables.get(name).content); 
		}
		
		return vars;
	}

	@Override
	public void loadFromFile(String[] file) {
		for(int i=0;i<file.length;i++) {
			file[i] = file[i].replaceAll(" ", "");
		}
		
		for(int i=0;i<file.length;i++) {
			String[] split = file[i].split("-");
			
			String name = split[0];
			String className = split[1];
			String contentString = split[2];
			
			if(className.equals("Integer")) {
				setVariable(name, Integer.valueOf(contentString));
			}else if(className.equals("Float")) {
				setVariable(name, Float.valueOf(contentString));
			}else if(className.equals("Double")) {
				setVariable(name, Double.valueOf(contentString));
			}else if(className.equals("String")) {
				setVariable(name, contentString);
			}else if(className.equals("Boolean")) {
				setVariable(name, Boolean.valueOf(contentString));
			}else if(className.equals("Character")) {
				setVariable(name, contentString.charAt(0));
			}
		}
	}
}
