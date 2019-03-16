package com.github.physiengine.object.tags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tag {

	private static final Map<String, Tag> tagList = new HashMap<String, Tag>();
	
	public static final Tag GameElement = new Tag("GameElement", 0);
	public static final Tag GuiElement = new Tag("GuiElement", 0);
	
	public static final Tag Entity = new Tag("Entity", 1, GameElement);
	public static final Tag Item = new Tag("Item", 1, GameElement);
	public static final Tag Enviroment = new Tag("Enviroment", 1, GameElement);
	
	
	static {
		addTag(GameElement);
		addTag(GuiElement);
		addTag(Entity);
		addTag(Item);
		addTag(Enviroment);
	}
	
	
	public static void addTag(Tag tag) {
		Tag.tagList.put(tag.name, tag);
	}
	
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
