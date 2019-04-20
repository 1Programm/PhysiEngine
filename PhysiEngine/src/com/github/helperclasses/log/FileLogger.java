package com.github.helperclasses.log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.helperclasses.fileManagement.FileSaver;

public class FileLogger implements Logger {
	
	private String filePath;
	private String ending;
	
	private List<String> traceStack;
	private List<String> debugStack;
	private List<String> infoStack;
	private List<String> warningStack;
	private List<String> errorStack;
	
	public FileLogger(String filePath, String ending) {
		this.filePath = filePath;
		this.ending = ending;
		
		this.traceStack = new ArrayList<>();
		this.debugStack = new ArrayList<>();
		this.infoStack = new ArrayList<>();
		this.warningStack = new ArrayList<>();
		this.errorStack = new ArrayList<>();
	}

	@Override
	public void trace(String tag, String message) {
		String msg = "[trace]: " + getMessage(tag, message);
		
		traceStack.add(msg);
	}

	@Override
	public void debug(String tag, String message) {
		String msg = "[debug]: " + getMessage(tag, message);
		
		debugStack.add(msg);
	}

	@Override
	public void info(String tag, String message) {
		String msg = "[Info]: " + getMessage(tag, message);
		
		infoStack.add(msg);
	}

	@Override
	public void warn(String tag, String message) {
		String msg = "[Warn] >>> " + getMessage(tag, message);
		
		warningStack.add(msg);
	}

	@Override
	public void error(String tag, String message) {
		String msg = ">>> [ERROR] >>> " + getMessage(tag, message);
		
		errorStack.add(msg);
	}

	@Override
	public void close() throws Exception {
		File pathFolder = new File(filePath);
		
		if(!pathFolder.isDirectory()) {
			pathFolder.mkdirs();
		}
		
		write(traceStack, "Trace");
		write(debugStack, "Debug");
		write(infoStack, "Info");
		write(warningStack, "Warning");
		write(errorStack, "Error");
	}
	
	private void write(List<String> lines, String mode) throws IOException {
		if(!lines.isEmpty()) {
			FileSaver.saveFromArray(lines, filePath + mode + ending);
		}
	}
	
	@SuppressWarnings("deprecation")
	private String getMessage(String tag, String message) {
		Date date = new Date();
		
		String time =  date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
		
		return time + " - [" + tag + "] - - - " + message;
	}

}
