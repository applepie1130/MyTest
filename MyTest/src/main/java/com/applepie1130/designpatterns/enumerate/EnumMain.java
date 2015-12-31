package com.applepie1130.designpatterns.enumerate;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumMain {
	
	private static final Logger logger = LoggerFactory.getLogger(EnumMain.class);

	public static void main(String[] args) {
		
		// enum 전체 
		logger.info("BasicOperation : {}", Arrays.asList(BasicOperation.values()));
		logger.info("ExtendedOperation : {}", Arrays.asList(ExtendedOperation.values()));
		
		// enum 활용
		logger.info("(PLUS) 10 + 20 = {}", BasicOperation.PLUS.apply(10, 20));
		logger.info("(MINUS) 10 - 20 = {}", BasicOperation.MINUS.apply(10, 20));
		logger.info("(MULTI) 10 * 20 = {}", BasicOperation.MULTI.apply(10, 20));
		logger.info("(DIVIDE) 10 / 20 = {}", BasicOperation.DIVIDE.apply(10, 20));
		logger.info("(EXP) 2 ^ 10 = {}", ExtendedOperation.EXP.apply(2, 10));
		logger.info("(REMAINDER) 10 % 3 = {}", ExtendedOperation.REMAINDER.apply(10, 3));
	}

}
