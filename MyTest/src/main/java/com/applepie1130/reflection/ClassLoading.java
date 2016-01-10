package com.applepie1130.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 클래스로딩 및 선언에 관한 (리플렉션) 
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
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<LoadedClass> loadedClass = (Class<LoadedClass>) Class.forName("com.applepie1130.reflection." + "LoadedClassImpl");
		Constructor<LoadedClass> constructor1 = loadedClass.getConstructor();
		LoadedClass newInstance1 = constructor1.newInstance();
		newInstance1.initEnv(args);
		
		Class<LoadedClass> loadedClass2 = (Class<LoadedClass>) Class.forName("com.applepie1130.reflection." + "LoadedClassImpl2");
		Constructor<LoadedClass> constructors2 = loadedClass2.getConstructor();
		LoadedClass newInstance2 = constructors2.newInstance(); 
		newInstance2.initEnv(args);
	}
}

