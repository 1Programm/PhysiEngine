package com.github.helperclasses.math;

import java.awt.Color;

import com.github.physiengine.PhysiSystem;
import com.github.physiengine.world.Settings;

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
	
	public static float getRotationFrom(Vector2 p1, Vector2 p2) {
		return Vector2.GetAngle(p1, p2);
	}
	
	public static float getGamePosX(float windowX) {
		float x = (windowX / (PhysiSystem.getCurWindow().getWidth()));
		
		
		return x * (Settings.RIGHT - Settings.LEFT) + Settings.LEFT;
	}
	
	public static float getGamePosY(float windowY) {
		float y = (windowY / (PhysiSystem.getCurWindow().getHeight()));
		
		return (y * (Settings.TOP - Settings.BOTTOM) + Settings.BOTTOM ) * (-1);
	}
	
}
