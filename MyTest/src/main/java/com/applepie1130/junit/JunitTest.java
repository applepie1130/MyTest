package com.applepie1130.junit;

public class JunitTest {

	public static void main(String[] args) {

		// Assertion 테스트 
		// java -ea 옵션 (반대 -da옵션)
		boolean assertsEnabled = false;
		assert assertsEnabled = true;
		
		if (!assertsEnabled) {
			throw new RuntimeException("Assertion 기능이 사용가능해야 합니다!");
		}
		
	}
}
