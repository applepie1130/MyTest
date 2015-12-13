package com.applepie1130.recursion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Recurision을 이용한 피보나치 수열의 Index값에 해당하는 값을 구함
 * 
 * @author applepie1130
 */
public class Fibonacci {
	
	private static final Logger logger = LoggerFactory.getLogger(Fibonacci.class);
	
	public static Integer fibonacci ( Integer index ) {
		
		if ( index == 0 || index == 1 ) {
			return index;
		} else {
			return fibonacci( index - 2 ) + fibonacci( index - 1 ); 
		}
	}
	
	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 * @throws
	 */
	public static void main(String[] args) {
		logger.info("{} 번째의 피보나치 수열의 값은 : {}", 10, fibonacci(10));
	}
	
}
