package com.github.helperclasses.debug;

public class SystemConsole implements ConsoleOut{

	@Override
	public void print(String msg) {
		System.out.print(msg);
	}

	@Override
	public void println(String msg) {
		System.out.println(msg);
	}

}
