package com.applepie1130.date;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


/**
 * JodaTime을 사용한 날짜 핸들링
 * 
 * @author applepie1130
 */
public class DateHandling {
	
	private static final Logger logger = LoggerFactory.getLogger(DateHandling.class);
	
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	DateTime testDate;
	
	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 * @throws
	 */
	public static void main(String[] args) {
		generateJodaTime();
	}
	
	/**
	 * DateTime을 이용한 JodaTime 테스트 메소드 
	 * 
	 * @author	applepie1130
	 */
	public static void generateJodaTime() {
		DateTime dateTime = new DateTime();
		DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		logger.info("현재시간 : {}", dateTime);
		logger.info("String형태의 시간을 DateTime으로 변환 : {}", pattern.parseLocalDateTime("2016-08-06 13:25:01"));
		logger.info("String형태의 시간을 DateTime으로 변환 : {}", DateTimeFormat.forPattern("yyyy-MM-dd").parseLocalDateTime("2015-12-11"));
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("현재시간 : {}", date);
		logger.info("String형태의 시간을 DateTime으로 변환 : {}", simpleDateFormat.format(date));
	}
}
