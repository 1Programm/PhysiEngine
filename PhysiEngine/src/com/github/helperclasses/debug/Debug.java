package com.github.helperclasses.debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Debug {

	private static final String DEBUG_WARNING = "PHYSIENGINE -> DEBUG -> WARNING";
	private static final String DEBUG_ERROR = "PHYSIENGINE -> DEBUG -> ERROR";
	
	private static final Console console = (in) -> {System.out.println(in);};
	
	private static final List<Class<?>> ignoreLog = new ArrayList<>();
	private static final List<Class<?>> ignoreWarning = new ArrayList<>();
	private static final List<Class<?>> ignoreError = new ArrayList<>();
	
	private static final Map<Class<?>, List<String>> ignoreOtherMessages = new HashMap<>();
	
	
	public static void Log(Class<?> from, String message) {
		if(ignoreLog.contains(from)) return;
		
		console.print("Log: [" + from + "] -> " + message);
	}
	
	public static void Log(Class<?> from, String message, boolean ignoreOthers) {
		if(ignoreLog.contains(from)) return;
		
		if(ignoreOthers) {
			List<String> ignoreMessages = ignoreOtherMessages.get(from); 
			
			if(ignoreMessages == null) {
				ignoreMessages = new ArrayList<>();
				ignoreMessages.add(message);
				ignoreOtherMessages.put(from, ignoreMessages);
			}else {
				if(ignoreMessages.contains(message)) {
					return;
				}else {
					ignoreMessages.add(message);
				}
			}
		}
		
		console.print("Log: [" + from + "] -> " + message);
	}
			
	public static void LogWarning(Class<?> from, String message) {
		if(ignoreWarning.contains(from)) return;
		
		console.print(DEBUG_WARNING + ": [" + from + "] -> " + message);
	}
	
	public static void LogWarning(Class<?> from, String message, boolean ignoreOthers) {
		if(ignoreWarning.contains(from)) return;
		
		if(ignoreOthers) {
			List<String> ignoreMessages = ignoreOtherMessages.get(from); 
			
			if(ignoreMessages == null) {
				ignoreMessages = new ArrayList<>();
				ignoreMessages.add(message);
				ignoreOtherMessages.put(from, ignoreMessages);
			}else {
				if(ignoreMessages.contains(message)) {
					return;
				}else {
					ignoreMessages.add(message);
				}
			}
		}
		
		console.print(DEBUG_WARNING + ": [" + from + "] -> " + message);
	}
	
	public static void LogError(Class<?> from, String message) {
		if(ignoreError.contains(from)) return;
		
		console.print(DEBUG_ERROR + ": [" + from + "] -> " + message);
	}
	
	public static void LogError(Class<?> from, String message, boolean ignoreOthers) {
		if(ignoreError.contains(from)) return;
		
		if(ignoreOthers) {
			List<String> ignoreMessages = ignoreOtherMessages.get(from); 
			
			if(ignoreMessages == null) {
				ignoreMessages = new ArrayList<>();
				ignoreMessages.add(message);
				ignoreOtherMessages.put(from, ignoreMessages);
			}else {
				if(ignoreMessages.contains(message)) {
					return;
				}else {
					ignoreMessages.add(message);
				}
			}
		}
		
		console.print(DEBUG_ERROR + ": [" + from + "] -> " + message);
	}
	
	public static void Ignore(Class<?> cls) {
		if(ignoreLog.contains(cls) == false) ignoreLog.add(cls);
		if(ignoreWarning.contains(cls) == false) ignoreWarning.add(cls); 
		if(ignoreError.contains(cls) == false) ignoreError.add(cls); 
	}
	
	public static void IgnoreLogs(Class<?> cls) {
		if(ignoreLog.contains(cls) == false) ignoreLog.add(cls);
	}
	
	public static void IgnoreWarnings(Class<?> cls) {
		if(ignoreWarning.contains(cls) == false) ignoreWarning.add(cls);
	}
	
	public static void IgnoreErrors(Class<?> cls) {
		if(ignoreError.contains(cls) == false) ignoreError.add(cls);
	}
			
	public static void ListenTo(Class<?> cls, boolean log, boolean warning, boolean error) {
		if(log) {
			if(ignoreLog.contains(cls)) {
				ignoreLog.remove(cls);
			}
		}else {
			IgnoreLogs(cls);
		}
		
		if(warning) {
			if(ignoreWarning.contains(cls)) {
				ignoreWarning.remove(cls);
			}
		}else {
			IgnoreWarnings(cls);
		}
		
		if(error) {
			if(ignoreError.contains(cls)) {
				ignoreError.remove(cls);
			}
		}else {
			IgnoreErrors(cls);
		}
	}
	
			
	private interface Console{
		public void print(String input);
	}
	
}
