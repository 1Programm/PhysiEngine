package com.github.helperclasses.log;

import java.util.ArrayList;
import java.util.List;

public class MultiLogger implements Logger{

	private List<Logger> loggers;
	
	public MultiLogger() {
		loggers = new ArrayList<>();
	}
	
	@Override
	public void trace(String tag, String message) {
		for(int i=0;i<loggers.size();i++) {
			loggers.get(i).trace(tag, message);
		}
	}

	@Override
	public void debug(String tag, String message) {
		for(int i=0;i<loggers.size();i++) {
			loggers.get(i).debug(tag, message);
		}
	}

	@Override
	public void info(String tag, String message) {
		for(int i=0;i<loggers.size();i++) {
			loggers.get(i).info(tag, message);
		}
	}

	@Override
	public void warn(String tag, String message) {
		for(int i=0;i<loggers.size();i++) {
			loggers.get(i).warn(tag, message);
		}
	}

	@Override
	public void error(String tag, String message) {
		for(int i=0;i<loggers.size();i++) {
			loggers.get(i).error(tag, message);
		}
	}

	public MultiLogger addLogger(Logger logger) {
		loggers.add(logger);
		
		return this;
	}
	
	@Override
	public void close() throws Exception {
		for(int i=0;i<loggers.size();i++) {
			loggers.get(i).close();
		}
	}
	
}
