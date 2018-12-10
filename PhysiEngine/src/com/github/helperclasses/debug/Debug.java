package com.github.helperclasses.debug;

import java.util.ArrayList;

public class Debug {

	private static final String DEBUG_WARNING = "PHYSIENGINE -> DEBUG -> WARNING";
	private static final String DEBUG_ERROR = "PHYSIENGINE -> DEBUG -> ERROR";
	
	private static final Console console = (in) -> {System.out.println(in);};
	
	private static final ArrayList<Class<?>> ignoreLog = new ArrayList<>();
	private static final ArrayList<Class<?>> ignoreWarning = new ArrayList<>();
	private static final ArrayList<Class<?>> ignoreError = new ArrayList<>();
	
	
	public static void Log(Class<?> from, String message) {
		if(ignoreLog.contains(from)) return;
		
		console.print("Log: [" + from + "] -> " + message);
	}
			
	public static void LogWarning(Class<?> from, String message) {
		if(ignoreWarning.contains(from)) return;
		
		console.print(DEBUG_WARNING + ": [" + from + "] -> " + message);
	}
	
	public static void LogError(Class<?> from, String message) {
		if(ignoreError.contains(from)) return;
		
		console.print(DEBUG_ERROR + ": [" + from + "] -> " + message);
	}
	
	public static void Ignore(Class<?> cls) {
		if(ignoreLog.contains(cls) == false) ignoreLog.add(cls);
		if(ignoreWarning.contains(cls) == false) ignoreWarning.add(cls); 
		if(ignoreError.contains(cls) == false) ignoreError.add(cls); 
	}
	
	public static void IgnoreLog(Class<?> cls) {
		if(ignoreLog.contains(cls) == false) ignoreLog.add(cls);
	}
	
	public static void IgnoreWarnings(Class<?> cls) {
		if(ignoreWarning.contains(cls) == false) ignoreWarning.add(cls);
	}
	
	public static void IgnoreErrors(Class<?> cls) {
		if(ignoreError.contains(cls) == false) ignoreError.add(cls);
	}
			
			
	private interface Console{
		public void print(String input);
	}
	
}
