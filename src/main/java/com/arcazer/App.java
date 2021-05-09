package com.arcazer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class.getName());

	public static void main(String[] args) {
			MemoryChecker.simpleMemoryCheck();
		logger.info("Hello, World!");
		logger.debug("Hi");
		logger.info("Yes");
		logger.debug("s");
	}
}
