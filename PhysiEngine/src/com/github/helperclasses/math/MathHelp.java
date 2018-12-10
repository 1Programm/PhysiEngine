package com.github.helperclasses.math;

import java.awt.Color;

public class MathHelp {

	public static float blendNumbers(float num1, float num2, float percentage) {
		return num1 + (num2 - num1) * percentage;
	}
	
	public static Vector2 blendVectors(Vector2 v1, Vector2 v2, float percentage) {
		return new Vector2(blendNumbers(v1.x, v2.x, percentage), blendNumbers(v1.y, v2.y, percentage));
	}
	
	public static Vector2 makeStep(Vector2 start, Vector2 end, float stepSize) {
		Vector2 step = new Vector2(start, end);
		step.normalize();
		step.mul(stepSize);
		
		return Vector2.Add(start, step);
	}
	
	public static Color getColor(Vector3 v) {
		return new Color((int)v.x, (int)v.y, (int)v.z);
	}
	
}
