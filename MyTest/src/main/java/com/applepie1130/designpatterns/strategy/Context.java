package com.applepie1130.designpatterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Context {
	
	private static final Logger logger = LoggerFactory.getLogger(Context.class);
	
	public void runContext ( Strategy strategy ) {
		logger.info("Context에서 runStrategy() 수행 !!");
		strategy.runStrategy();
	}
}
