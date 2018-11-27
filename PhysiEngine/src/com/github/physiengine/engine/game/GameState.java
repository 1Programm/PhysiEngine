package com.github.physiengine.engine.game;

import java.util.HashMap;

import com.github.helperclasses.interfaces.Loadable;
import com.github.helperclasses.interfaces.Saveable;
import com.github.helperclasses.string.Strings;

public class GameState implements Saveable, Loadable {

	private String name;
	private HashMap<String, Data<Saveable>> values;

	public GameState() {
		values = new HashMap<>();
	}

	public GameState(String name, String[] keys) {
		this.name = name;
		values = new HashMap<>();

		for (String key : keys) {
			values.put(key, null);
		}
	}

	public void put(String name, int value) {
		if (!values.containsKey(name))
			return;
		values.put(name, new Data<Saveable>(new StaticData<Integer>(value)));
	}

	public void put(String name, float value) {
		if (!values.containsKey(name))
			return;
		values.put(name, new Data<Saveable>(new StaticData<Float>(value)));
	}

	public void put(String name, String value) {
		if (!values.containsKey(name))
			return;
		values.put(name, new Data<Saveable>(new StaticData<String>(value)));
	}

	public void put(String name, boolean value) {
		if (!values.containsKey(name))
			return;
		values.put(name, new Data<Saveable>(new StaticData<Boolean>(value)));
	}

	public void put(String name, Saveable value) {
		if (!values.containsKey(name))
			return;
		values.put(name, new Data<Saveable>(value));
	}

	@Override
	public String[] getContent() {
		String[] ret = new String[values.size() + 1];
		ret[0] = "- " + name + " -";

		int i = 1;
		for (String key : values.keySet()) {
			ret[i++] = values.get(key).getClassName() + " : " + key + " : " + Strings.fromArray(values.get(key).content.getContent());
		}

		return ret;
	}

	@Override
	public void setContent(String[] content) {
		for (int i = 0; i < content.length; i++) {
			content[i] = content[i].replaceAll(" ", "");
		}

		String name = content[0].substring(1, content[0].length() - 1);

		for (int i = 1; i < content.length; i++) {
			String[] line = content[i].split(":");

			String typ = line[0];
			String key = line[1];
			String value = line[2];
		}
	}
	
	
	
	private class Data<Typ extends Saveable> {
		public Typ content;
		
		public Data(Typ content) {
			this.content = content;
		}
		
		public String getClassName() {
			return content.getClass().getName();
		}
	}
	
	private class StaticDataWrapper<Typ> extends Data<Saveable>{

		public StaticDataWrapper(Typ content) {
			super(new StaticData<Typ>(content));
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public String getClassName() {
			return ((StaticData<Typ>)content).content.getClass().getName();
		}
		
	}

	private class StaticData<Typ> implements Saveable {
		private Typ content;

		public StaticData(Typ content) {
			this.content = content;
		}

		@Override
		public String[] getContent() {
			String[] ret = new String[0];

			if (content.getClass() == Integer.class) {
				ret[0] = "" + (int) content;
			}

			if (content.getClass() == Float.class) {
				ret[0] = "" + (float) content;
			}

			else if (content.getClass() == String.class) {
				ret[0] = (String) content;
			}

			else if (content.getClass() == Boolean.class) {
				ret[0] = "" + (boolean) content;
			}

			return ret;
		}
		
		
	}
}
