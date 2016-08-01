package com.applepie1130.basic;

import java.util.List;
import java.util.Map;

import com.applepie1130.basic.model.Tcustomer;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class lambdJTest {

	public static void main(String[] args) {
//
//		// 테스트를 위한 데이터 셋팅
//		Map<String, Object> m = Maps.newHashMap();
//		Map<String, Object> sm = Maps.newHashMap();
//		List<Object> l = Lists.newArrayList();
//		
//		l.add("applepie");
//		l.add("wbfldhwjstk");
//		
//		sm.put("music", "장범준");
//		sm.put("movie", "jason bourn");
//		sm.put("coffee", "starbucks");
//		
//		m.put("id", "applepie1130");
//		m.put("myIds", l);
//		m.put("myFv", sm);
//		
//		System.out.println(m);
//		
//		
//		// 테스트를 위한 데이터 셋팅
//		Tcustomer tcustomer = new Tcustomer();
//		tcustomer.setName("김성준");
//		tcustomer.setPhonNumber("010-7612-1130");
//		tcustomer.setAddress("인천남구");
//		
//		List<Tcustomer> lt1 = Lists.newArrayList();
//		List<Tcustomer> lt2 = Lists.newArrayList();
//		lt1.add(tcustomer);
//		
//		// lambdaJ를 활용한 데이터 추출
	}

}

//public static void main(String[] args) {		
//	List<MemberInfoTuple> results = queryString();
//	
//	List<Integer> ages = extract(results, on(MemberInfoTuple.class).getTWebMember().getAge());
//	List<TWebMemberEntity> tWebMembers = extract(results, on(MemberInfoTuple.class).getTWebMember());
//	
//	List<Map<String, Object>> pairs = convert(results, new Converter<MemberInfoTuple, Map<String, Object>>() {
//		@Override
//		public Map<String, Object> convert(MemberInfoTuple from) {
//			Map<String, Object> map = Maps.newHashMap();
//			map.put("age", from.getTWebMember().getAge());	
//			map.put("tCustomer", from.getTCustomer());
//			return map;
//		}
//	});



