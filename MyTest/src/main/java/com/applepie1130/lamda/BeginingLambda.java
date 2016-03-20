package com.applepie1130.lamda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * System.out::println		==		x -> System.out.println(x)
 *
 *
 *
 * @author SungJun
 *
 */

public class BeginingLambda {

	public static void main(String[] args) {
		List<String> filterTestLamda = filterTestLamda();
		filterTestLamda.forEach(System.out::println);


		test01_08();
	}

	/*
	 * stream 인터페이스의 filter, sorted, map, collect 기능 알아보기
	 * {@link} http://d2.naver.com/helloworld/4911107
	 */
	private static List<String> filterTestLamda() {

		List<Guest> guests = new ArrayList<>();

		for ( int i=0, guestCnt=5;  i < guestCnt; i++ ) {
			Guest guest = new Guest(i, "appel" + String.valueOf(i), "CJOS", i*12);
			guests.add(guest);
		}

		// 람다를 이용한 foreach
		guests.forEach(System.out::println);

		return guests.stream()
				.filter( g -> "CJOS".equals(g.getCompany()) )
				.sorted( Comparator.comparing(Guest::getGrade) )
//				.map( g -> g.getName() )
				.map( Guest::getName )
				.collect( Collectors.toList() );
	}

	private static void test01_08() {
		String[] names = { "a", "b", "c" };
		List<Runnable> runners = new ArrayList<>();

		for ( String name : names ) {
			runners.add( () -> System.out.println(name) );
		}

		runners.forEach(System.out::println);
	}
}
