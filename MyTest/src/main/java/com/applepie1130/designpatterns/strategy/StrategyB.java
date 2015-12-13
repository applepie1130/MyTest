package com.applepie1130.designpatterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrategyB implements Strategy {
	
	private static final Logger logger = LoggerFactory.getLogger(StrategyB.class);

	@Override
	public void runStrategy() {
		
		logger.info("I'm Strategy B !!!");
		
	}
}
