package com.applepie1130.designpatterns.strategy;


/**
 * 전략패턴 : 클라이언트가 전략을 생성해 전략을 실행하는 컨텍스트에 주입하는 패턴
 * 1) 전략메소드를 가진 객체
 * 2) 전략객체를 사용하는 컨텍스트
 * 3) 전략객체를 생성해 컨텍스트에 의존성을 주입하는 클라이언트
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
		
		Context ctx = new Context();
		
		// 전략 A를 생성하여 수행
		ctx.runContext(new StrategyA());
		
		// 전략 B를 생성하여 수행
		ctx.runContext(new StrategyB());
		
	}
}
