package com.github.helperclasses.math;

public class Matrix3x3 {

	public static Matrix3x3 getXRot(double rot) {
		rot = Math.toRadians(rot);
		double s = Math.sin(rot);
		double c = Math.cos(rot);
		
		return new Matrix3x3(
				1, 0,  0,
				0, c, -s,
				0, s,  c
		);
	}
	
	public static Matrix3x3 getYRot(double rot) {
		rot = Math.toRadians(rot);
		double s = Math.sin(rot);
		double c = Math.cos(rot);
		
		return new Matrix3x3(
				c, 0, -s,
				0, 1,  0,
				s, 0,  c
		);
	}
	
	public static Matrix3x3 getZRot(double rot) {
		rot = Math.toRadians(rot);
		double s = Math.sin(rot);
		double c = Math.cos(rot);
		
		return new Matrix3x3(
				c, -s, 0,
				s,  c, 0,
				0,  0, 1
		);
	}
	
	public static Matrix3x3 getRotationAround(Vector3 v, double rotation) {
		rotation = Math.toRadians(rotation);
		
		double s = Math.sin(rotation);
		double c = Math.cos(rotation);
		
		v.normalize();
		
		return new Matrix3x3(
				v.x * v.x * (1 - c) + c,        v.x * v.y * (1 - c) - v.z * s,  v.x * v.z * (1 - c) + v.y * s,
				v.x * v.y * (1 - c) + v.z * s,  v.y * v.y * (1 - c) + c,        v.y * v.z * (1 - c) - v.x * s,
				v.x * v.z * (1 - c) - v.y * s,  v.y * v.z * (1 - c) + v.x * s,  v.z * v.z * (1 - c) + c
		);
	}
	
	
	public double[][] values;
	
	public Matrix3x3() {}
	
	public Matrix3x3(double m11, double m12, double m13, double m21, double m22, double m23, double m31, double m32, double m33) {
		this.values = new double[][] {
			{m11, m12, m13},
			{m21, m22, m23},
			{m31, m32, m33}
		};
	}
	
	public Vector3 mul(Vector3 v) {
		Vector3 col0 = getColum(0);
		Vector3 col1 = getColum(1);
		Vector3 col2 = getColum(2);
		
		float x, y, z;
		
		x = Vector3.Dot(v, col0);
		y = Vector3.Dot(v, col1);
		z = Vector3.Dot(v, col2);
		
		return new Vector3(x, y, z);
	}
	
	public Vector3 getColum(int i) {
		return new Vector3((float)values[i][0], (float)values[i][1], (float)values[i][2]);
	}
	
	public Vector3 getRow(int i) {
		return new Vector3((float)values[0][i], (float)values[1][i], (float)values[2][i]);
	}
	
	
	
}
