package com.applepie1130.date;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JodaTime을 사용한 날짜 핸들링
 * 
 * @author applepie1130
 */
public class DateHandling {
	
	private static final Logger logger = LoggerFactory.getLogger(DateHandling.class);
	
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
		logger.info("String형태의 시간을 DateTime으로 변환 : {}",
				DateTimeFormat.forPattern("yyyy-MM-dd").parseLocalDateTime("2015-12-11"));
	}
	
	
}
