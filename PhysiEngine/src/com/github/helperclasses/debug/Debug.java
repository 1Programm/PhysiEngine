package com.github.helperclasses.debug;

public class Debug {

	private static final String DEBUG_WARNING = "PHYSIENGINE -> DEBUG -> WARNING";
	private static final String DEBUG_ERROR = "PHYSIENGINE -> DEBUG -> ERROR";
	
	private static final Console console = (in) -> {System.out.println(in);};
	
	
	
	public static void Log(Class<?> from, String message) {
		console.print(": [" + from + "] -> " + message);
	}
			
	public static void LogWarning(Class<?> from, String message) {
		console.print(DEBUG_WARNING + ": [" + from + "] -> " + message);
	}
	
	public static void LogError(Class<?> from, String message) {
		console.print(DEBUG_ERROR + ": [" + from + "] -> " + message);
	}
	
			
			
	private interface Console{
		public void print(String input);
	}
	
}
