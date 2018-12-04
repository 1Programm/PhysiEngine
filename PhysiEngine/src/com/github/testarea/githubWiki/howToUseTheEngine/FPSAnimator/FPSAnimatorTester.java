package com.github.testarea.githubWiki.howToUseTheEngine.FPSAnimator;

import com.github.helperclasses.debug.Debug;
import com.github.physiengine.engine.FPSAnimator;
import com.github.physiengine.engine.UpdateMethod;

public class FPSAnimatorTester {

	public static void main(String[] args) {
		// 10 -> 10 * per second | 1 -> 1 * per second | 0.1 -> every 10 seconds | ...
		FPSAnimator animator = new FPSAnimator(10); 
		
		animator.showFPS(true);
		
		animator.setUpdateMethod(updateMethod);
		
		animator.start();
	}
	
	private static UpdateMethod updateMethod = () -> {
		Debug.LogInfo(FPSAnimatorTester.class, "Testing fps");
	};
	
}
