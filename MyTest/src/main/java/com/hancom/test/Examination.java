package com.hancom.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Examination {

	public static void main(String[] args) {

		// 문제1
		System.out.println( getReversedInteger( 46312 )) ;

		// 문제2
		int arrayInt[] = { 10, 2, 101, 90 };
		System.out.println( getMedian( arrayInt ) );


		// 문제3
		System.out.println( getFibonacciNumber( 2 ) );
		System.out.println( getFibonacciNumber( 8 ) );
	}

	/**
	 * 문제 1.
	 *
	 */
	private static int getReversedInteger(int num) {
		int tmp;
		int cnt = 1, res = 0;

		tmp = num;

		while (true) { // 몇 자릿수의 정수인지 확인
			tmp /= 10;

			if (tmp == 0)
				break;
			else
				cnt *= 10;
		}

		while (true) { // 각 자릿수의 순서 바꾸기
			tmp = num % 10;
			num /= 10;
			res += cnt * tmp;

			if (num < 1)
				return res;
			else
				cnt /= 10;
		}
	}

	/**
	 * 문제 2.
	 *
	 */
	private static float getMedian(int[] arrayInt) {

		List<Float> arrayListInt = new ArrayList<Float>();

		for ( int i=0, length = arrayInt.length; i<length; i++ ) {
			arrayListInt.add((float) arrayInt[i]);
		}

		// 배열을 오름차순으로 정렬
		Collections.sort(arrayListInt);

		int num = arrayListInt.size();
		float medianResult;

		if (num % 2 == 0) // 값의 개수가 짝수일 경우
			medianResult = (float) (arrayListInt.get(num / 2 - 1) + arrayListInt.get(num / 2)) / 2;
		else // 값의 개수가 홀수일 경우
			medianResult = arrayListInt.get(num / 2);

		return medianResult;
	}

	/**
	 * 문제 3.
	 *
	 */
	private static int getFibonacciNumber(int index) {
		ArrayList<Integer> arrayNum = new ArrayList<Integer>();
		arrayNum.add(0, 0);
		arrayNum.add(1, 1);

		for (int i = 2; i <= index; i++) {
			arrayNum.add(i, arrayNum.get(i - 2) + arrayNum.get(i - 1));
		}

		return arrayNum.get(index);
	}

}
