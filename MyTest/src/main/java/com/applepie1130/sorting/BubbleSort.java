package com.applepie1130.sorting;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 버블정렬 테스트
 * 버플정렬 n-1 번회전
 * 
 * @author applepie1130
 */
public class BubbleSort {
	
	private static final Logger logger = LoggerFactory.getLogger(BubbleSort.class);

	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 */
	public static void main(String[] args) {
		
		
		Integer m[] = { 5, 2, 3, 4, 1 };
		
		logger.info("버블 정렬 전 : {} ", Arrays.asList(m));
		
		for ( int i=1; i <= (m.length - 1); i++ ) {	// 총 회전수 (n-1)
			for ( int j=1; j <= (5 - i); j++ ) {
				
				if ( m[j-1] > m[j] ) {
					int temp = m[j-1];
					m[j-1] = m[j];
					m[j] = temp;
				}
			}
		}
		
		logger.info("버블 정렬 후 : {} ", Arrays.asList(m));
	}
}
