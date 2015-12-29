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
public class BuilderService {
	
	private final int number;
	private final String name;
	private final String phone;
	private final String address;
	
	// 최상위 클래스(BuilderService)의 Constructor
	private BuilderService(Builder builder) {
		this.number = builder.number;
		this.name = builder.name;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	// Builder 클래스 구현
	// 멤버클래스는 가급적 public static으로 선언하라..(이펙티브자바 규칙22)
	public static class Builder {
		// 필수인자
		private int number;
		private String name;
		
		// 선택인자 - 기본 값으로 초기화 
		private String phone = "000-0000-0000";
		private String address = null;
		
		// Builder Constructor - Builder 객체 생성시 필수인자 생성자로 전달하여 셋팅
		public Builder(int number, String name) {
			this.number = number;
			this.name = name;
		}
		
		// address Setter
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		// phone Setter
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		// 최상위 클래스의 Constructor 실행 - build()
		public BuilderService build() {
			return new BuilderService(this); 
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BuilderService [number=" + number + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
}
