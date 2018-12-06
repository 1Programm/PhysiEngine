package com.github.testarea.HelperClass_Test;

import com.github.helperclasses.math.MathHelp;
import com.github.helperclasses.math.Vector2;

public class HelperClassTest {

	public static void main(String[] args) {
		
		Vector2 in = new Vector2(2, 2);
		
		Vector2 mirror = new Vector2(1, 0);
		
		Vector2 out = Vector2.getReflection(mirror, in);
		
		in.print("In: ");
		out.print("Out: ");
		
		
		w("");
		w("MathHelp.blendNumbers - Test:");
		w("-----------------------------------");
		
		float f1 = 0.45f;
		float f2 = 12.7f;
		
		float f3 = MathHelp.blendNumbers(f1, f2, 0.4f);
		
		w("F1: " + f1);
		w("F2: " + f2);
		w("blend(F1, F2, 0.4): " + f3);
		w("-----------------------------------");
		
		
		
		
		
		
		w("");
		w("");
		w("");
		w("MathHelp.blendVectors - Test:");
		w("-----------------------------------");
		
		Vector2 pos1 = new Vector2(10, 20);
		Vector2 pos2 = new Vector2(100, -50);
		
		Vector2 pos3 = MathHelp.blendVectors(pos1, pos2, 0.2f);
		
		pos1.print("Pos1");
		pos2.print("Pos2");
		pos3.print("blend(Pos1, Pos2, 0.2)");
		w("-----------------------------------");
		

		
		
		
		
		w("");
		w("");
		w("");
		w("MathHelp.makeStep - Test:");
		w("-----------------------------------");
		
		Vector2 start = new Vector2(10, 20);
		Vector2 end = new Vector2(100, -50);
		
		Vector2 afterStep = MathHelp.makeStep(start, end, 10);
		
		start.print("Start");
		end.print("End");
		afterStep.print("step(Start, End, 10)");
		w("-----------------------------------");
		
		
	}
	
	public static void w(String w) {
		System.out.println(w);
	}
	
}
