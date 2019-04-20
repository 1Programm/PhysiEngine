package com.github.helperclasses.log;

public interface Logger {

	void trace(String tag, String message);
	
	void debug(String tag, String message);
	
	void info(String tag, String message);

	void warn(String tag, String message);
	
	void error(String tag, String message);
	
	void close() throws Exception;
	
}
