package com.applepie1130.basic;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Test {

	@org.junit.Test
	public void test () {
		int diff = 1101111 ^ 1101111;
		System.out.println(diff);
	}
	
	@org.junit.Test	
	public void useMapService() {
		Map<String, Object> map = Maps.newHashMap();
		List<String> list = Lists.newArrayList();
		LinkedHashMap<String, Object> lhmap = Maps.newLinkedHashMap();
	}
}
