package com.github.physiengine.engine;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import com.github.helperclasses.interfaces.LoadAndSaveable;
import com.github.helperclasses.strings.StringUtils;

public class GameStats implements LoadAndSaveable{
	
	public static GameStats Empty() {
		return new GameStats();
	}
	
	public static GameStats SimpleGame(int fps, int winWidth, int winHeight) {
		GameStats stats = new GameStats();
		stats.setVariable("FPS", fps);
		stats.setVariable("WINDOW_WIDTH", winWidth);
		stats.setVariable("WINDOW_HEIGHT", winHeight);
		
		return stats;
	}
	

	private HashMap<String, Data<?>> variables;
	
	
	private GameStats() {
		variables = new HashMap<>();
	}
	
	public void setVariable(String name, int value) {
		variables.put(name, new Data<Integer>(value));
	}
	
	public void setVariable(String name, float value) {
		variables.put(name, new Data<Float>(value));
	}
	
	public void setVariable(String name, double value) {
		variables.put(name, new Data<Double>(value));
	}
	
	public void setVariable(String name, String value) {
		variables.put(name, new Data<String>(value));
	}
	
	public void setVariable(String name, boolean value) {
		variables.put(name, new Data<Boolean>(value));
	}
	
	public void setVariable(String name, char value) {
		variables.put(name, new Data<Character>(value));
	}
	
	public <T extends LoadAndSaveable> void setVariable(String name, T value) {
		variables.put(name, new LoadableData<T>(value));
	}
	
	
	public <T> T getVariable(String name, Class<T> c) {
		Data<?> d = variables.get(name);
		
		if(d != null) {
			if(c.getSimpleName().equals(d.className)) {
				return c.cast(d.content);
			}else if(c.getName().equals(d.className)) {
				return c.cast(d.content);
			}
		}
		
		return null;
	}
	
	public Object getVariable(String name) {
		return variables.get(name).content;
	}

	@Override
	public String[] getContent() {
		String[] vars = new String[variables.size()];
		
		int i = 0;
		for(String name : variables.keySet()) {
			vars[i++] = (name + " - " + variables.get(name).className + " - " + variables.get(name).toString()); 
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
			}else {
				String[] contents = contentString.split(",");
				
				LoadAndSaveable object = null;
				
				try {
					Class<?> cls = Class.forName(className, true, ClassLoader.getSystemClassLoader());
					Constructor<?> constructor = cls.getConstructor();
					object = (LoadAndSaveable) constructor.newInstance();
					
					object.loadFromFile(contents);
					
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
				
				setVariable(name, object);
			}
		}
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
	
	private class LoadableData<T extends LoadAndSaveable> extends Data<T>{

		public LoadableData(T content) {
			super(content);
			this.className = content.getClass().getName();
		}
		
		@Override
		public String toString() {
			return StringUtils.Append(content.getContent(), ", ");
		}
		
	}
}