package com.applepie1130.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadedClassImpl2 implements LoadedClass {
	
	private static final Logger logger = LoggerFactory.getLogger(LoadedClassImpl2.class);

	@Override
	public void initEnv(String[] args) {
		logger.info("initEnv() 메소드 호출 !!");
	}
}

