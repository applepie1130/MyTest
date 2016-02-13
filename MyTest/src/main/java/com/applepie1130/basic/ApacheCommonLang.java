package com.applepie1130.basic;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.BooleanUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApacheCommonLang {

	private static final Logger logger = LoggerFactory.getLogger(ApacheCommonLang.class);

	/**
	 * 메인 메소드
	 *
	 * @author	applepie1130
	 * @param	args
	 */
	public static void main(String[] args) {
		// ObjectUtils 클래스
		objectUtilsTest();

		// StringUtils 클래스
		stringUtilsTest();

		// BooleanUtils 클래스
		booleanUtilsTest();

	}


	/**
	 * objectUtilsTest
	 * @author applepie1130
	 */
	private static void objectUtilsTest() {

//		ObjectUtils.compare(c1, c2);
//		ObjectUtils.equals(object1, object2);
//		ObjectUtils.max(arg0)
//		ObjectUtils.notEqual(object1, object2)
//		ObjectUtils.max(arg0)
//		ObjectUtils.min(arg0)
//		ObjectUtils.toString(obj)
//		ObjectUtils.toString(obj, nullStr)

	}


	/**
	 * stringUtilsTest
	 * @author applepie1130
	 *
	 * {@link} https://commons.apache.org/proper/commons-lang/javadocs/api-2.6/org/apache/commons/lang/StringUtils.html
	 *
	 */
	private static void stringUtilsTest() {

		// StringUtils.abbreviate
		logger.info("StringUtils.abbreviate : {}", 	StringUtils.abbreviate("12345678910", 10));			// => "1234567..."

		// StringUtils.EMPTY
		logger.info("StringUtils.EMPTY : {}",		StringUtils.EMPTY);									// => ""

		// StringUtils.equals
		logger.info("StringUtils.equals : {}",		StringUtils.equals(StringUtils.EMPTY, ""));			// => "true"
		logger.info("StringUtils.equals : {}",		StringUtils.equals(StringUtils.EMPTY, null));		// => "false"

		// StringUtils.difference
		logger.info("StringUtils.difference : {}",	StringUtils.difference("12345", "123456"));			// => "6"
		logger.info("StringUtils.difference : {}",	StringUtils.difference(null, "123456"));			// => "123456"
		logger.info("StringUtils.difference : {}",	StringUtils.difference(StringUtils.EMPTY, ""));		// => ""

		// StringUtils.trim
		logger.info("StringUtils.trim : {}",		StringUtils.trim(" 123456 "));						// => "123456"
		logger.info("StringUtils.trim : {}",		StringUtils.trim(null));							// => null
		logger.info("StringUtils.trim : {}",		StringUtils.trim(""));								// => ""

		// StringUtils.trimToEmpty
		logger.info("StringUtils.trimToEmpty : {}",	StringUtils.trimToEmpty(" 12 3456 "));				// => "123456"
		logger.info("StringUtils.trimToEmpty : {}",	StringUtils.trimToEmpty(null));						// => ""
		logger.info("StringUtils.trimToEmpty : {}",	StringUtils.trimToEmpty(" "));						// => ""

		// StringUtils.trimToNull
		logger.info("StringUtils.trimToNull : {}",	StringUtils.trimToNull(" 12 3456 "));				// => "123456"
		logger.info("StringUtils.trimToNull : {}",	StringUtils.trimToNull(" "));						// => null

//		StringUtils.toEncodedString(bytes, charset)
//		StringUtils.upperCase(str)
//		StringUtils.lowerCase(str)
//		StringUtils.remove(arg0, arg1)
//		StringUtils.replace(text, searchString, replacement)
//		StringUtils.reverse(str)

//		String.valueOf(b)

	}

	/**
	 * booleanUtilsTest
	 * @author applepie1130
	 */
	private static void booleanUtilsTest() {
//		BooleanUtils.compare(x, y)
//		BooleanUtils.isFalse(bool)
//		BooleanUtils.isNotFalse(bool)
//		BooleanUtils.isTrue(bool)
//		BooleanUtils.toBoolean()
//		BooleanUtils.toInteger(bool)
//		BooleanUtils.toInteger(bool, trueValue, falseValue)
//		BooleanUtils.toString(bool, trueString, falseString)
//		BooleanUtils.toStringYesNo(bool)

	}

}
