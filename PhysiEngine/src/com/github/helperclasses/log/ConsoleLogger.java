package com.github.helperclasses.log;

public class ConsoleLogger implements Logger{
	
	@Override
	public void trace(String tag, String message) {
		println("[TRACE]: " + tag + " - - - " + message);
	}

	@Override
	public void debug(String tag, String message) {
		println("[DEBUG]: " + tag + " - - - " + message);
	}

	@Override
	public void info(String tag, String message) {
		println("[INFO]: " + tag + " - - - " + message);
	}

	@Override
	public void warn(String tag, String message) {
		println("> [WARNING]: " + tag + " - - - " + message);
	}

	@Override
	public void error(String tag, String message) {
		println("> > > [ERROR]: " + tag + " - - - " + message);
	}
	
	@Override
	public void close() throws Exception{
		println(" - - - CLOSED - - - ");
	}
	
	private void println(String msg) {
		System.out.println(msg);
	}

}
