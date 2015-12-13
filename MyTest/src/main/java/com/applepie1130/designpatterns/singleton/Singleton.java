package com.applepie1130.designpatterns.singleton;


/**
 * 싱글톤 패턴
 * 
 * @author applepie1130
 */
public class Singleton {
	
	private volatile static Singleton singleton;
	
	Singleton () {}
	
	public static Singleton getInstance () {
		
		if ( singleton == null ) {
			synchronized(Singleton.class) {
				if ( singleton == null ) {
					singleton = new Singleton();
				}
			}
		}
		
		return singleton;
	}
	
	
	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 */
	public static void main(String[] args) {
		System.out.println(singleton.getInstance());
		System.out.println(singleton.getInstance().hashCode());
	}
}
