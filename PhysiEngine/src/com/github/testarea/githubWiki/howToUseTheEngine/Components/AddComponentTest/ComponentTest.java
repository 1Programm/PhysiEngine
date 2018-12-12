package com.github.testarea.githubWiki.howToUseTheEngine.Components.AddComponentTest;

import java.awt.Color;

import com.github.physiengine.components.Component;
import com.github.physiengine.components.collision.detection.AABBCollider;
import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.components.gfx.Image;
import com.github.physiengine.object.GameObject;

public class ComponentTest {

	private static GameObject obj1;
	
	public static void main(String[] args) {
		obj1 = new GameObject();
		
		obj1.addComponent("myCollider", new AABBCollider());
		obj1.addComponent(new Controller_Keyboard(2));
		obj1.addComponent(new Image(Color.BLACK));
		
		test();
	}
	
	private static void test() {
			System.out.println("Getting the AABB component through its class:");
			System.out.println("");
			
		AABBCollider collider1 = obj1.getComponent(AABBCollider.class);
		
			System.out.println("----> " + collider1.toString());
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
	
			System.out.println("Getting the AABB component through its name:");
			System.out.println("");
			
		Component collider2 = obj1.getComponent("myCollider");
		
			System.out.println("----> " + collider2.toString());
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			
		System.out.println("-> Both the same object !");
	}
	
}
