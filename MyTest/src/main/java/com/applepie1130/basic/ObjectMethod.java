package com.applepie1130.basic;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectMethod {
	
	private static final Logger logger = LoggerFactory.getLogger(ObjectMethod.class);

	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 */
	public static void main(String[] args) {
		compareToTest();
	}
	

	/**
	 * compareTo 테스트 
	 * @author applepie1130
	 */
	private static void compareToTest() {
		
		Integer x = -10;
		
		logger.info("x > ? = {}", x.compareTo(-11));
		logger.info("x = ? = {}", x.compareTo(x));
		logger.info("x < ? = {}", x.compareTo(-9));
		logger.info("\n\n");
		
		Double y = 10.1123;
		logger.info("y > ? = {}", y.compareTo(9.0));
		logger.info("y = ? = {}", y.compareTo(y));
		logger.info("y = ? = {}", y.compareTo(10.1123));
		logger.info("y < ? = {}", y.compareTo(11.0));		
		logger.info("y < ? = {}", y.compareTo(10.1124));
		logger.info("\n\n");
		
		
		// String에서는 수치비교가 안된다 ..
		String s = "10";
		logger.info("s > ? = {}", s.compareTo("2"));
		logger.info("s = ? = {}", s.compareTo(s));
		logger.info("s = ? = {}", s.compareTo("10"));
		logger.info("s < ? = {}", s.compareTo("11"));
		logger.info("\n\n");
		
		s = "-10";
		logger.info("s > ? = {}", new BigInteger(s).compareTo(new BigInteger("-11")));
		logger.info("s = ? = {}", new BigInteger(s).compareTo(new BigInteger(s)));
		logger.info("s = ? = {}", new BigInteger(s).compareTo(new BigInteger("-10")));
		logger.info("s < ? = {}", new BigInteger(s).compareTo(new BigInteger("-9")));
		
		Object obj = new Object();
		obj.equals(obj);				// == 비교
		

		String sEqual = null;
		sEqual.equals("");
		
	}
}
