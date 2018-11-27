package com.github.helperclasses.string;

import java.util.ArrayList;

public class Strings {

	public static String fromArray(Object[] data) {
		String ret = "(";
		
		for(int i=0;i<data.length;i++) {
			if(i != 0) ret += ", ";
			ret += data[i].toString();
		}
		
		return ret + ")";
	}
	
	public static String fromArrayList(ArrayList<Object> data) {
		String ret = "(";
		
		for(int i=0;i<data.size();i++) {
			if(i != 0) ret += ", ";
			ret += data.get(i).toString();
		}
		
		return ret + ")";
	}
}
