package com.applepie1130.basic;

import org.apache.commons.lang3.ObjectUtils;

public class NumberTest {

	public static void main(String[] args) {
		Integer n = null;
		System.out.println(ObjectUtils.defaultIfNull(n, 0));
	}
}
