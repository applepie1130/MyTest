package com.applepie1130.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Task implements Runnable {
	
	private final Logger logger = LoggerFactory.getLogger("THREAD");
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		MDC.put("threadLogFileName", name);
		
		int cnt = 0;
		
		for ( int i=0; i<10; i++ ) {
			logger.info("===========  Run 메소드 시작  ===========");
			logger.info("지금 Task 의 이름은 '{}' 입니다.", name);
			logger.info("===========  Run 메소드 종료  ===========");

			cnt = i;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [name=" + name + "]";
	}
}
