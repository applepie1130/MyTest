package com.applepie1130.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.applepie1130.basic.model.Tcustomer;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public class GuavaTest {

//	@org.junit.Test
//	public void test () {
//		int diff = 1101111 ^ 1101111;
//		System.out.println(diff);
//	}
	
	public static void main(String[] args) {
		
		// Guava 제공
//		Map<String, Object> map	= Maps.newHashMap();
//		List<String> list		= Lists.newArrayList();
//		LinkedHashMap<String, Object> lhmap = Maps.newLinkedHashMap();
		
		// Ordering Test
		try {
			List resultList = Lists.newArrayList();
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			
			Tcustomer cst1 = new Tcustomer();
			cst1.setName("applepie");
			cst1.setAge(32);
			cst1.setBirthDate(simpleDateFormat.parse("19861130"));
			cst1.setInsertDate(simpleDateFormat.parse("20170606"));
			
			Tcustomer cst2 = new Tcustomer();
			cst2.setName("banana");
			cst2.setAge(34);
			cst2.setBirthDate(simpleDateFormat.parse("20161129"));
			cst2.setInsertDate(simpleDateFormat.parse("20170605"));
			
			Tcustomer cst3 = new Tcustomer();
			cst3.setName("applepie");
			cst3.setAge(32);
			cst3.setBirthDate(simpleDateFormat.parse("19861129"));
			cst3.setInsertDate(simpleDateFormat.parse("20170606"));
			
			Tcustomer cst4 = new Tcustomer();
			cst4.setName("pineapple");
			cst4.setAge(50);
			cst4.setBirthDate(simpleDateFormat.parse("20161129"));
			cst4.setInsertDate(simpleDateFormat.parse("20170605"));
			
			Tcustomer cst5 = new Tcustomer();
			cst5.setName("kiwi");
			cst5.setAge(10);
			cst5.setBirthDate(simpleDateFormat.parse("20161129"));
			cst5.setInsertDate(simpleDateFormat.parse("20170605"));
			
			Tcustomer cst6 = new Tcustomer();
			cst6.setName("applepie");
			cst6.setAge(32);
			cst6.setBirthDate(simpleDateFormat.parse("19861129"));
			cst6.setInsertDate(simpleDateFormat.parse("20170602"));
			
			resultList.add(cst1);
			resultList.add(cst2);
			resultList.add(cst3);
			resultList.add(cst4);
			resultList.add(cst5);
			resultList.add(cst6);
		
			/**
			 * 소팅 기준
			 * 1) 나이가 가장 많은 순 (desc)
			 * 2) 생일이 가장 빠른 순 (asc)
			 * 3) 등록일이 가장 빠른 순 (asc)
			 */
			
			// Ordring Implements
			Ordering<Tcustomer> byDate = new Ordering<Tcustomer>() {
				@Override
				public int compare(Tcustomer left, Tcustomer right) {
					if ( StringUtils.equals(left.getName(), left.getName()) ) {
						if ( left.getBirthDate().compareTo(right.getBirthDate()) == 0 ) {
							return left.getInsertDate().compareTo(right.getInsertDate());
						} else {
							return left.getBirthDate().compareTo(right.getBirthDate());
						}
					} else {
						return 0;
					}
				}
			};
			
			Ordering<Tcustomer> byAge = new Ordering<Tcustomer>() {
				@Override
				public int compare(Tcustomer left, Tcustomer right) {
					return Ints.compare(right.getAge(), left.getAge());
				}
			};
			
			// Sorting
			Collections.sort(resultList, byDate);
			Collections.sort(resultList, byAge);
			
			System.out.println(resultList);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
