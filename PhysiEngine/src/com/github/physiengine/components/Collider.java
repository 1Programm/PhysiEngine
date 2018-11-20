package com.github.physiengine.components;

import java.util.ArrayList;

public class Collider extends Component{

	private static ArrayList <String> collisionLayer = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
		{
			add("BaseLayer");
		}
	};
	
	private ArrayList <String> myLayer;

	public Collider(String name) {
		super(name);
		myLayer = new ArrayList<>();
		myLayer.add("BaseLayer");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public class CollisionInfo{
		public float penetrateX, penetrateY, collisionAngel;
			
			public CollisionInfo(float pX, float pY, float cA) {
				penetrateX = pX;
				penetrateY = pY;
				collisionAngel = cA;
			}
			
	}
	
}


