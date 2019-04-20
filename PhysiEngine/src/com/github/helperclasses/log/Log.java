package com.github.helperclasses.log;

public class Log {
	
	public static final int MODE_TRACE = 1;
	public static final int MODE_DEBUG = 2;
	public static final int MODE_INFO = 4;
	public static final int MODE_WARNING = 8;
	public static final int MODE_ERROR = 16;

	public static Logger OUT;
	
	private static int logMode;
	
	public static void setLogger(Logger log) {
		Log.OUT = log;
	}
	
	public static final void trace(String tag, String message) {
		if(isMode(MODE_TRACE)) {
			OUT.trace(tag, message);
		}
	}
	
	public static final void debug(String tag, String message) {
		if(isMode(MODE_DEBUG)) {
			OUT.debug(tag, message);
		}
	}
	
	public static final void info(String tag, String message) {
		if(isMode(MODE_INFO)) {
			OUT.info(tag, message);
		}
	}

	public static final void warn(String tag, String message) {
		if(isMode(MODE_WARNING)) {
			OUT.warn(tag, message);
		}
	}
	
	public static final void error(String tag, String message) {
		if(isMode(MODE_ERROR)) {
			OUT.error(tag, message);
		}
	}
	
	public static final void close() throws Exception{
		OUT.close();
	}
	
	public static final boolean isMode(int mode) {
		return ((logMode & mode) == mode);
	}
	
	public static final void setMode(int mode) {
		Log.logMode = mode;
	}
	
}
