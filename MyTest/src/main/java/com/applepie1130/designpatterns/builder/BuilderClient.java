package com.applepie1130.designpatterns.builder;

/**
 * 빌더 패턴 
 * 
 * 필요한 객체를 직접 생성하는 대신, 클라이언트는 먼저 필수 인자들을 생성자에 전부 전달하여 빌더 객체를 만든다.
 * 그런다음, 빌더 객체에 정의된 설정 메서드들을 호출하여 선택적 인자들을 추가해 나간다.
 * 마지막으로, 아무런 인자 없이 build 메서드를 호출하여 변경 불가능 객체를 만드는 것이다.
 * 빌더 클래스는 빌더가 만드는 객체 클래스의 정적 멤버 클래스로 정의한다. 
 * 
 * @author applepie1130
 */
public class BuilderClient {
	
	public static void main(String[] args) {
		// 필수필드
		BuilderService bs1 = new BuilderService.Builder(12, "김성준").build();
		
		// 필수필드 + 선택필드1
		BuilderService bs2 = new BuilderService.Builder(12, "김성준").phone("010-1234-4567").build();
		
		// 필수필드 + 선택필드1 + 선택필드2
		BuilderService bs3 = new BuilderService.Builder(12, "김성준").phone("010-1234-4567").address("인천광역시 남구...").build();
		
		System.out.println(bs1);
		System.out.println(bs2);
		System.out.println(bs3);
	}
}
