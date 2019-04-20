package com.github.physiengine.object.tags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.helperclasses.log.Log;

public class Tag {

	private static final Map<String, Tag> tagList = new HashMap<String, Tag>();
	
	public static final Tag GameElement = new Tag("GameElement", 0);
	public static final Tag GuiElement = new Tag("GuiElement", 0);
	
	public static final Tag Entity = new Tag("Entity", 1, GameElement);
	public static final Tag Item = new Tag("Item", 1, GameElement);
	public static final Tag Environment = new Tag("Environment", 1, GameElement);
	
	public static final Tag Enemy = new Tag("Enemy", 2, Entity);
	public static final Tag Friendly = new Tag("Friendly", 2, Entity);
	public static final Tag Neutral = new Tag("Neutral", 2, Entity);
	
	public static final Tag Interactable = new Tag("Interactable", 2, Environment);
	
	
	public static Tag get(String name) {
		return Tag.tagList.get(name);
	}
	
	


	private String name;
	private int weight;
	
	private List<Tag> parents;
	
	public Tag(String name, int weight, Tag... parents) {
		this.name = name;
		this.weight = weight;
		
		this.parents = new ArrayList<Tag>();
		for(Tag tag : parents) {
			this.parents.add(tag);
		}
		
		if(Tag.tagList.containsKey(name)) {
			Log.warn("Creating Tag", "Tag with name: " + name + " already exists and will not be added to the TagList.");
		}else {
			Tag.tagList.put(name, this);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public List<Tag> getParents() {
		return parents;
	}
	
}
