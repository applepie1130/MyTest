package com.applepie1130.lamda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BeginingLamda {

	public static void main(String[] args) {

		List<String> filterTestLamda = filterTestLamda();
		System.out.println(filterTestLamda);

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

		System.out.println(guests);

		return guests.stream()
				.filter( g -> "CJOS".equals(g.getCompany()) )
				.sorted( Comparator.comparing(Guest::getGrade) )
				.map(Guest::getName)
				.collect( Collectors.toList() );
	}
}
