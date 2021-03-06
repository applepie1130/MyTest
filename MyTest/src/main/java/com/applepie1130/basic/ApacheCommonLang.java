package com.applepie1130.basic;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.BooleanUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class ApacheCommonLang {

	private static final Logger logger = LoggerFactory.getLogger(ApacheCommonLang.class);

	/**
	 * 메인 메소드
	 *
	 * @author applepie1130
	 * @param args
	 */
	public static void main(String[] args) {
		// StringUtils 클래스
		stringUtilsTest();

		// ObjectUtils 클래스
		objectUtilsTest();

		// BooleanUtils 클래스
		booleanUtilsTest();

	}


	/**
	 * stringUtilsTest
	 * @author applepie1130
	 *
	 * {@link} https://commons.apache.org/proper/commons-lang/javadocs/api-2.6/org/apache/commons/lang/StringUtils.html
	 *
	 */
	private static void stringUtilsTest() {

		// StringUtils.isEmpty
		logger.info("StringUtils.isEmpty : {}", 	StringUtils.isEmpty(null));							// => "true"
		logger.info("StringUtils.isEmpty : {}", 	StringUtils.isEmpty(""));							// => "true"
		logger.info("StringUtils.isEmpty : {}", 	StringUtils.isEmpty(" "));							// => "false"

		// StringUtils.isNotEmpty
		logger.info("StringUtils.isNotEmpty : {}", 	StringUtils.isNotEmpty(null));						// => "false"
		logger.info("StringUtils.isNotEmpty : {}", 	StringUtils.isNotEmpty(""));						// => "false"
		logger.info("StringUtils.isNotEmpty : {}", 	StringUtils.isNotEmpty(" "));						// => "true"

		// StringUtils.isBlank
		logger.info("StringUtils.isBlank : {}", 	StringUtils.isBlank(null));							// => "true"
		logger.info("StringUtils.isBlank : {}", 	StringUtils.isBlank(""));							// => "true"
		logger.info("StringUtils.isBlank : {}", 	StringUtils.isBlank(" "));							// => "true"

		// StringUtils.isNotBlank
		logger.info("StringUtils.isNotBlank : {}", 	StringUtils.isNotBlank(null));						// => "false"
		logger.info("StringUtils.isNotBlank : {}", 	StringUtils.isNotBlank(""));						// => "false"
		logger.info("StringUtils.isNotBlank : {}", 	StringUtils.isNotBlank(" "));						// => "false"

		// StringUtils.abbreviate : Abbreviates a String using ellipses. This will turn "Now is the time for all good men" into "Now is the time for..."
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
		logger.info("StringUtils.trimToNull : {}",	StringUtils.trimToNull(null));						// => null
		logger.info("StringUtils.trimToNull : {}",	StringUtils.trimToNull(" "));						// => null

		// StringUtils.strip : trim과의 차이는 whitespace까지 걷어준다는 점인데.. 잘 모르겠음?!
		logger.info("StringUtils.strip : {}",	StringUtils.strip(null));								// => null
		logger.info("StringUtils.strip : {}",	StringUtils.strip(""));									// => ""
		logger.info("StringUtils.strip : {}",	StringUtils.strip(" "));								// => ""
		logger.info("StringUtils.strip : {}",	StringUtils.strip(" 1234 "));							// => "1234"
		logger.info("StringUtils.strip : {}",	StringUtils.strip(" 12 3 4 "));							// => "12 3 4"
		logger.info("StringUtils.strip : {}",	StringUtils.strip("  abcyx", "xyz"));					// => "abc"

		// StringUtils.stripToEmpty
		logger.info("StringUtils.stripToEmpty : {}",	StringUtils.stripToEmpty(null));				// => ""
		logger.info("StringUtils.stripToEmpty : {}",	StringUtils.stripToEmpty(""));					// => ""
		logger.info("StringUtils.stripToEmpty : {}",	StringUtils.stripToEmpty(" "));					// => ""
		logger.info("StringUtils.stripToEmpty : {}",	StringUtils.stripToEmpty(" 123 4 "));			// => "123 4"

		// StringUtils.substring
		logger.info("StringUtils.substring : {}",	StringUtils.substring("1234567", 0, 4));			// => "1234"
		logger.info("StringUtils.substring : {}",	StringUtils.substring("1234567", 1, 5));			// => "2345"
		logger.info("StringUtils.substring : {}",	StringUtils.substring(null, 0, 4));					// => null
		logger.info("StringUtils.substring : {}",	StringUtils.substring("", 0, 4));					// => ""

		// StringUtils.join
		String[] context = {"a", "b", "c"};
		logger.info("StringUtils.join : {}",	StringUtils.join(context, ";"));						// => "a;b;c"
		logger.info("StringUtils.join : {}",	StringUtils.join(context, null));						// => "abc"
		logger.info("StringUtils.join : {}",	StringUtils.join(context, ""));							// => "abc"

		// StringUtils.deleteWhitespace
		logger.info("StringUtils.deleteWhitespace : {}",	StringUtils.deleteWhitespace(" a b c "));		// => "abc"
		logger.info("StringUtils.deleteWhitespace : {}",	StringUtils.deleteWhitespace(" "));				// => ""
		logger.info("StringUtils.deleteWhitespace : {}",	StringUtils.deleteWhitespace(null));			// => null

		// StringUtils.remove
		logger.info("StringUtils.remove : {}",	StringUtils.remove("queued", "ue"));					// => "qd"
		logger.info("StringUtils.remove : {}",	StringUtils.remove("queued", "zz"));					// => "queued"
		logger.info("StringUtils.remove : {}",	StringUtils.remove("queued", "u"));						// => "qeed"

		// StringUtils.replaceOnce
		logger.info("StringUtils.replaceOnce : {}",	StringUtils.replaceOnce("aba", "a", null));			// => "aba"
		logger.info("StringUtils.replaceOnce : {}",	StringUtils.replaceOnce("aba", "a", ""));			// => "ba"
		logger.info("StringUtils.replaceOnce : {}",	StringUtils.replaceOnce("aba", "a", "z"));			// => "zba"

		// StringUtils.replace
		logger.info("StringUtils.replace : {}",	StringUtils.replace("aba", "a", null));					// => "aba"
		logger.info("StringUtils.replace : {}",	StringUtils.replace("aba", "a", ""));					// => "b"
		logger.info("StringUtils.replace : {}",	StringUtils.replace("aba", "a", "z"));					// => "zbz"

		// StringUtils.overlay
		logger.info("StringUtils.overlay : {}",	StringUtils.overlay("abcdef", "", 2, 4));				// => "abcdef"
		logger.info("StringUtils.overlay : {}",	StringUtils.overlay("abcdef", "zzzz", 2, 4));			// => "abzzzzef"

		// StringUtils.chop : Remove the last character from a String.
		logger.info("StringUtils.replace : {}",	StringUtils.chop(null));								// => null
		logger.info("StringUtils.replace : {}",	StringUtils.chop("abc\n"));								// => "abc"
		logger.info("StringUtils.replace : {}",	StringUtils.chop("abc\nabc"));							// => "abc\nab"
		logger.info("StringUtils.replace : {}",	StringUtils.chop("a"));									// => ""
		logger.info("StringUtils.replace : {}",	StringUtils.chop("\r\n"));								// => "\r"

		// StringUtils.rightPad : The String is added to the size of size.
		logger.info("StringUtils.rightPad : {}",	StringUtils.rightPad("abc", 3, "z"));				// => "abc"
		logger.info("StringUtils.rightPad : {}",	StringUtils.rightPad("abc", 5, "z"));				// => "abczz"
		logger.info("StringUtils.rightPad : {}",	StringUtils.rightPad("abc", 1, "z"));				// => "abc"

		// StringUtils.leftPad
		logger.info("StringUtils.leftPad : {}",	StringUtils.leftPad("abc", 3, "z"));					// => "abc"
		logger.info("StringUtils.leftPad : {}",	StringUtils.leftPad("abc", 5, "z"));					// => "zzabc"

		// StringUtils.capitalize
		logger.info("StringUtils.capitalize : {}",	StringUtils.capitalize(""));						// => ""
		logger.info("StringUtils.capitalize : {}",	StringUtils.capitalize("cat"));						// => "Cat"
		logger.info("StringUtils.capitalize : {}",	StringUtils.capitalize("cAt"));						// => "CAt"

		// StringUtils.uncapitalize
		logger.info("StringUtils.uncapitalize : {}",	StringUtils.uncapitalize(""));					// => ""
		logger.info("StringUtils.uncapitalize : {}",	StringUtils.uncapitalize("Cat"));				// => "cat"
		logger.info("StringUtils.uncapitalize : {}",	StringUtils.uncapitalize("CAt"));				// => "cAt"

		// StringUtils.swapCase
		logger.info("StringUtils.swapCase : {}",	StringUtils.swapCase(null));						// => "cAT"
		logger.info("StringUtils.swapCase : {}",	StringUtils.swapCase(""));							// => "cAT"
		logger.info("StringUtils.swapCase : {}",	StringUtils.swapCase("The dog has a BONE"));		// => "tHE DOG HAS A bone"

		// StringUtils.countMatches
		logger.info("StringUtils.countMatches : {}",	StringUtils.countMatches("abba", null));		// => "0"
		logger.info("StringUtils.countMatches : {}",	StringUtils.countMatches("abba", ""));			// => "0"
		logger.info("StringUtils.countMatches : {}",	StringUtils.countMatches("abba", "a"));			// => "2"
		logger.info("StringUtils.countMatches : {}",	StringUtils.countMatches("abba", "ab"));		// => "1"
		logger.info("StringUtils.countMatches : {}",	StringUtils.countMatches("abba", "xxx"));		// => "0"

		// StringUtils.defaultString
		logger.info("StringUtils.defaultString : {}",	StringUtils.defaultString(null, "NULL"));		// => "NULL"
		logger.info("StringUtils.defaultString : {}",	StringUtils.defaultString("", "NULL"));			// => ""
		logger.info("StringUtils.defaultString : {}",	StringUtils.defaultString(" ", "NULL"));		// => " "

		// StringUtils.defaultIfEmpty
		logger.info("StringUtils.defaultIfEmpty : {}",	StringUtils.defaultIfEmpty(null, "NULL"));		// => "NULL"
		logger.info("StringUtils.defaultIfEmpty : {}",	StringUtils.defaultIfEmpty("", "NULL"));		// => "NULL"
		logger.info("StringUtils.defaultIfEmpty : {}",	StringUtils.defaultIfEmpty(" ", "NULL"));		// => " "

		// StringUtils.defaultIfBlank
		logger.info("StringUtils.defaultIfBlank : {}",	StringUtils.defaultIfBlank(null, "NULL"));		// => "NULL"
		logger.info("StringUtils.defaultIfBlank : {}",	StringUtils.defaultIfBlank("", "NULL"));		// => "NULL"
		logger.info("StringUtils.defaultIfBlank : {}",	StringUtils.defaultIfBlank(" ", "NULL"));		// => "NULL"

		// StringUtils.reverse
		logger.info("StringUtils.reverse : {}",	StringUtils.reverse(null));								// => null
		logger.info("StringUtils.reverse : {}",	StringUtils.reverse(""));								// => ""
		logger.info("StringUtils.reverse : {}",	StringUtils.reverse("ABC"));							// => "CBA"


		// Base64 Encoding/Decoding
		String plainText = "감사합니다.";
		String encode = Base64.encode(plainText.getBytes());
		String decode = new String(Base64.decode(encode));

		logger.info( "Base64 Encode : {}", encode );
		logger.info( "Base64 Decode : {}", decode );
	}

	/**
	 * objectUtilsTest
	 *
	 * {@link} https://commons.apache.org/proper/commons-lang/javadocs/api-2.6/org/apache/commons/lang/ObjectUtils.html
	 *
	 * @author applepie1130
	 */
	private static void objectUtilsTest() {

		// ObjectUtils.compare
		logger.info("ObjectUtils.compare : {}",	ObjectUtils.compare("20160201", "20160202"));			// => -1
		logger.info("ObjectUtils.compare : {}",	ObjectUtils.compare("20160202", "20160202"));			// => 0
		logger.info("ObjectUtils.compare : {}",	ObjectUtils.compare("20160203", "20160202"));			// => 1
		logger.info("ObjectUtils.compare : {}",	ObjectUtils.compare("20160203", "2016"));				// => 4 양수이긴 하지만, 이 값은 모지?

		// 음수 비교시 이상한결과.. 이건 머지?
		logger.info("ObjectUtils.compare : {}",	ObjectUtils.compare("-1", "0"));						// => -3
		logger.info("ObjectUtils.compare : {}",	ObjectUtils.compare("-5", "-5"));						// => 0
		logger.info("ObjectUtils.compare : {}",	ObjectUtils.compare("-3", "-5"));						// => -2


		// ObjectUtils.defaultIfNull
		logger.info("ObjectUtils.defaultIfNull : {}",	ObjectUtils.defaultIfNull(null, "NULL"));		// => "NULL"
		logger.info("ObjectUtils.defaultIfNull : {}",	ObjectUtils.defaultIfNull("", "NULL"));			// => ""

		// ObjectUtils.notEqual
		Object o = "!";
		logger.info("ObjectUtils.notEqual : {}",	ObjectUtils.notEqual(null, null));					// => false
		logger.info("ObjectUtils.notEqual : {}",	ObjectUtils.notEqual("a", "a"));					// => false
		logger.info("ObjectUtils.notEqual : {}",	ObjectUtils.notEqual(new Object(), new Object()));	// => true

		// ObjectUtils.max
		logger.info("ObjectUtils.max : {}",	ObjectUtils.max("101", "-111"));							// => "101"
		logger.info("ObjectUtils.min : {}",	ObjectUtils.min("-10", "11"));								// => "-10"
		logger.info("ObjectUtils.max : {}",	ObjectUtils.max("-10", "-1"));								// => "-1"	음수 비교시 값이 이상함 ..?
		logger.info("ObjectUtils.min : {}",	ObjectUtils.min("-10", "-1"));								// => "-10"	음수 비교시 값이 이상함 ..?

	}

	/**
	 * booleanUtilsTest
	 *
	 * {@link} https://commons.apache.org/proper/commons-lang/javadocs/api-2.6/org/apache/commons/lang/BooleanUtils.html
	 *
	 * @author applepie1130
	 */
	private static void booleanUtilsTest() {

		// BooleanUtils.isTrue
		logger.info("BooleanUtils.isTrue : {}",	BooleanUtils.isTrue(true));								// => true
		logger.info("BooleanUtils.isTrue : {}",	BooleanUtils.isTrue(null));								// => false

		// BooleanUtils.toBoolean
		logger.info("BooleanUtils.toBoolean : {}",	BooleanUtils.toBoolean(Boolean.TRUE));				// => true
		logger.info("BooleanUtils.toBoolean : {}",	BooleanUtils.toBoolean(Boolean.FALSE));				// => false
		logger.info("BooleanUtils.toBoolean : {}",	BooleanUtils.toBoolean(0));							// => false
		logger.info("BooleanUtils.toBoolean : {}",	BooleanUtils.toBoolean(1));							// => true
		logger.info("BooleanUtils.toBoolean : {}",	BooleanUtils.toBoolean(2));							// => true

		// BooleanUtils.toInteger
		logger.info("BooleanUtils.toInteger : {}",	BooleanUtils.toInteger(true));						// => 1
		logger.info("BooleanUtils.toInteger : {}",	BooleanUtils.toInteger(false));						// => 0

		// BooleanUtils.toStringTrueFalse
		logger.info("BooleanUtils.toStringTrueFalse : {}",	BooleanUtils.toStringTrueFalse(true));		// => "true"
		logger.info("BooleanUtils.toStringTrueFalse : {}",	BooleanUtils.toStringTrueFalse(false));		// => "false"
		logger.info("BooleanUtils.toStringTrueFalse : {}",	BooleanUtils.toStringTrueFalse(null));		// => null

	}

}
