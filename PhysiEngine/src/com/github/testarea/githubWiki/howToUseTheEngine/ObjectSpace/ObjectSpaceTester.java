package com.github.testarea.githubWiki.howToUseTheEngine.ObjectSpace;

import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.GameObject;

public class ObjectSpaceTester {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * Creating a Space which will automatically add GameObjects
		 */
		ObjectSpace space1 = new ObjectSpace(true);

		/*
		 * obj1 will be added to space1
		 */
		GameObject obj1 = new GameObject();

		/*
		 * Creating a new ObjectSpace ... 
		 * Now all objects are added to this Space from now on
		 */
		ObjectSpace space2 = new ObjectSpace(true);

		/*
		 * Creating an ObjectSpace which will not automatically add new GameObjects to itself
		 * You have to add GameObjects manually now
		 */
		ObjectSpace space3 = new ObjectSpace(false);

		/*
		 * obj2 will be added to space2 (not to space3 !)
		 */
		GameObject obj2 = new GameObject();
		
		ObjectSpace.IgnoreStart();
		
		GameObject obj3 = new GameObject("noSpace1");
		GameObject obj4 = new GameObject("noSpace2");
		
		ObjectSpace.IgnoreStop();
		
		
		space3.add(obj3);
		space3.add(obj4);
	}
	
}
