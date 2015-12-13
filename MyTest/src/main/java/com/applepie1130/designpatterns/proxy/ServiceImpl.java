package com.applepie1130.designpatterns.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.applepie1130.thread.TaskExecutor;

public class ServiceImpl implements Service {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

	@Override
	public void runService() {
		logger.info("ServiceImple에서 runService() 가 수행"); 
	}
}
