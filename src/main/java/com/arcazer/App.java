package com.arcazer;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class.getName());

	public static void main(String[] args) {
		try {
			MemoryChecker.simpleMemoryCheck();
		} catch (UnsupportedEncodingException e) {
			logger.catching(e);
		}
		logger.info("Hello, World!");
		logger.debug("Hi");
		logger.info("Yes");
		logger.debug("s");
	}
}
