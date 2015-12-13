package com.applepie1130.classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 클래스로딩 및 선언에 관한 
 * 
 * @author		applepie1130
 * @category	LoadedClass, LoadedClassImpl
 */
public class ClassLoading {
	
	private static final Logger logger = LoggerFactory.getLogger(ClassLoading.class);
	
	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 * @throws	ClassNotFoundException 
	 * @throws	IllegalAccessException 
	 * @throws	InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<LoadedClass> loadedClass = (Class<LoadedClass>) Class.forName("com.applepie1130.classes." + "LoadedClassImpl");
		LoadedClass newInstance1 = loadedClass.newInstance();
		newInstance1.initEnv(args);
		
		Class<LoadedClass> loadedClass2 = (Class<LoadedClass>) Class.forName("com.applepie1130.classes." + "LoadedClassImpl2");
		LoadedClass newInstance2 = loadedClass2.newInstance();
		newInstance2.initEnv(args);
	}
}

