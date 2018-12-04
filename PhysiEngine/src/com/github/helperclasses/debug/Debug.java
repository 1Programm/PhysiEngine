package com.github.helperclasses.debug;

public class Debug {
	
	private static final String SYSTEM_INFO = "PHYSIENGINE->Debug->Info";
	private static final String SYSTEM_ERROR = "PHYSIENGINE->Debug->Error";

	private static Console console = (msg) -> {
		System.out.println(msg);
	};
	
	
	
	public static void LogInfo(Class<?> from, String message) {
		console.print(SYSTEM_INFO + ": [" + from.getSimpleName() + "] -> " + message);
	}
	
	public static void LogError(Class<?> from, String message) {
		console.print(SYSTEM_ERROR + ": [" + from.getSimpleName() + "] -> " + message);
	}
	
	
	
	
	public interface Console {
		public void print(String message);
	}
	
}
