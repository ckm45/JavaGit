package com.ckm;

import java.io.FileWriter;
import java.io.IOException;

public final class MyLogger {
	private static MyLogger instance;
	private FileWriter fw;

	private MyLogger() throws Exception {
		fw = new FileWriter("dummylog.txt ", true);

	}

	public static synchronized MyLogger getInstance() throws Exception {
		if (instance == null) {
			instance = new MyLogger();
		}

		return instance;
	}

	public synchronized void log(String message) throws Exception {
		fw.write(message);
		fw.flush();
	}

	public static void main(String[] args) throws Exception {
		MyLogger logger1 = MyLogger.getInstance();
		logger1.log("first");
		MyLogger logger2 = MyLogger.getInstance();
		logger2.log("second");

	}

}