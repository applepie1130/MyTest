package com.applepie1130.basic;

import static ch.lambdaj.Lambda.by;
import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.forEach;
import static ch.lambdaj.Lambda.group;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static ch.lambdaj.Lambda.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.IsEqual;
import org.hamcrest.text.StringContains;

import com.applepie1130.basic.model.Tcustomer;
import com.google.common.collect.Lists;

import ch.lambdaj.group.Group;

public class lambdJTest {

	public static void main(String[] args) {
		
		List<Tcustomer> tcustomers = getTestData();
		
		// 이름 기준으로 리스트 생성
		List<String> customerNames = extract(tcustomers, on(Tcustomer.class).getName());
		System.out.println("\n이름 기준으로 리스트 생성");
		System.out.println(customerNames);
		
		// 부서가 IT인 오브젝트 추출
		List<Tcustomer> filteredCustomerDepartment = select(tcustomers, having(on(Tcustomer.class).getDepartment(), StringContains.containsString("IT")));
		System.out.println("\n부서가 IT인 오브젝트 추출");
		System.out.println(filteredCustomerDepartment);
		
		// 나이가 90살인 모든 데이터에 해당하는 이름 추출
		List<String> filteredCustomerNames = extract(
												select(tcustomers, having(on(Tcustomer.class).getAge(), IsEqual.equalTo(90))), 
												on(Tcustomer.class).getName()
												);
		System.out.println("\n나이가 90살인 모든 데이터에 해당하는 이름 추출");
		System.out.println(filteredCustomerNames);
		
		// 나이로 정렬
		List<Tcustomer> sortedAges = sort(tcustomers, on(Tcustomer.class).getAge());
		System.out.println("\n나이로 정렬");
		System.out.println(sortedAges);
		
		// 나이로 정렬 Comparator
		List<Tcustomer> sortedAge = sort(tcustomers, on(Tcustomer.class), new Comparator<Tcustomer>() {
			@Override
			public int compare(Tcustomer o1, Tcustomer o2) {
				return o1.getAge() > o2.getAge() ? 1 : 0;
			}
		});
		System.out.println("\n나이로 정렬 Comparator");
		System.out.println(sortedAge);

		// foreach 수행 후 모든 오브젝트 들에 대해 etc 값 셋팅
		forEach(tcustomers).setEtc("defaultValue");
		System.out.println("\nforeach 수행 후 모든 오브젝트 들에 대해 etc 값 셋팅");
		System.out.println(tcustomers);
		
		// 나이가 같은 데이터로 그룹핑
		// [{age=, children=[]}, {age=, children=[]} ... ] 형식
		Group<Tcustomer> groupingAgeOfCustomer = group(tcustomers, by(on(Tcustomer.class).getAge()));
		System.out.println("\n나이가 같은 데이터로 그룹핑");
		System.out.println(groupingAgeOfCustomer);
		Set<String> groupAgeKeys  = groupingAgeOfCustomer.keySet();
		System.out.println("groupAgeKeys : " + groupAgeKeys);
		List<Tcustomer> findAgeList = groupingAgeOfCustomer.find(90);
		System.out.println("나이가 90인 그룹 데이터 리스트");
		System.out.println(findAgeList);

		// 두 리스트간 비교하여 특정 조건에 대한 데이터를 색출 하는 방법은???
		// 예를 들어 쿠폰리스트 중 쿠폰적용불가리스트와 비교하여 적용가능한 리스트만 return
		
	}

	
	/**
	 * 테스트 데이터 생성 (basic)
	 * @return
	 */
	private static List<Tcustomer> getTestData() {
		List<Tcustomer> tcustomers = Lists.newArrayList();
		Tcustomer tcustomer = new Tcustomer();
		tcustomer.setId("applepie");
		tcustomer.setAge(100);
		tcustomer.setName("김성준");
		tcustomer.setPhonNumber("010-7612-1130");
		tcustomer.setDepartment("IT");
		tcustomers.add(tcustomer);
		
		tcustomer = new Tcustomer();
		tcustomer.setId("banana");
		tcustomer.setAge(90);
		tcustomer.setName("푸조");
		tcustomer.setPhonNumber("010-7612-3310");
		tcustomer.setDepartment("IT");
		tcustomers.add(tcustomer);
		
		tcustomer = new Tcustomer();
		tcustomer.setId("BMW");
		tcustomer.setAge(90);
		tcustomer.setName("BMW");
		tcustomer.setPhonNumber("010-7612-3310");
		tcustomer.setDepartment("IT");
		tcustomers.add(tcustomer);
		
		tcustomer = new Tcustomer();
		tcustomer.setId("kiwi");
		tcustomer.setAge(89);
		tcustomer.setName("폭스바겐");
		tcustomer.setPhonNumber("010-7612-2008");
		tcustomer.setDepartment("HR");
		tcustomers.add(tcustomer);
		
		tcustomer = new Tcustomer();
		tcustomer.setId("kiwi");
		tcustomer.setAge(89);
		tcustomer.setName("케딜락");
		tcustomer.setPhonNumber("010-7612-2009");
		tcustomer.setDepartment("FINANCE");
		tcustomers.add(tcustomer);
		System.out.println("############### Basic Data ##############");
		for (Tcustomer t: tcustomers) {
			System.out.println(t);
		}
		System.out.println("############### Basic Data ##############\n");
		
		return tcustomers;
	}
}