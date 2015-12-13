package com.applepie1130.designpatterns.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.applepie1130.thread.TaskExecutor;

public class Proxy implements Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Proxy.class);
	
	Service service;

	@Override
	public void runService() {
		
		logger.info("Proxy에서 Service의 runService() 를 대신 호출해줌"); 
		
		service = new ServiceImpl();
		service.runService();
	}
}
