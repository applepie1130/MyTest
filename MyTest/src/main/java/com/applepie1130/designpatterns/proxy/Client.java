package com.applepie1130.designpatterns.proxy;


/**
 * 프록시 : 프록시 패턴은 제어의 흐름을 조정하기위해 중간에 대리자를 두는 패턴
 * 프록시는 대리자
 * 클라이언트에서는 특정 서비스를 바로 실행하지않고, 대리자를 통해 실행하는 패턴
 * 
 * @author applepie1130
 */
public class Client {
	
	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 */
	public static void main(String[] args) {
		
		Service service = new Proxy();
		
		// Proxy가 Service의 runService() 를 대신 호출해줌.
		service.runService();	
	}
}
