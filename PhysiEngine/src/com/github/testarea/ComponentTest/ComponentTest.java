package com.github.testarea.ComponentTest;

import com.github.physiengine.components.Component;
import com.github.physiengine.components.collision.AABB;
import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.object.GameObject;

public class ComponentTest {

	private static GameObject obj1;
	
	public static void main(String[] args) {
		obj1 = new GameObject();
		
		obj1.addComponent(new AABB());
		obj1.addComponent(new Controller_Keyboard(2));
		
		test();
	}
	
	private static void test() {
			System.out.println("Getting the AABB component through its class:");
			System.out.println("");
			
		AABB collider1 = obj1.getComponent(AABB.class);
		
			System.out.println("----> " + collider1.toString());
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
	
			System.out.println("Getting the AABB component through its name:");
			System.out.println("");
			
		Component collider2 = obj1.GetComponent("collider");
		
			System.out.println("----> " + collider2.toString());
			System.out.println("");
			System.out.println("");
			System.out.println("");
		
		System.out.println("-> Both the same object !");
	}
	
}
