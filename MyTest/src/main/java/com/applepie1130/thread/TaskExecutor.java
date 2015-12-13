package com.applepie1130.thread;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * ThreadPoolTaskExecutor 를 이용한 스레드 테스트
 * 
 * @author applepie1130
 */
public class TaskExecutor {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskExecutor.class);

	/**
	 * 메인 메소드
	 * 
	 * @author	applepie1130
	 * @param	args
	 */
	public static void main(String[] args) {
		threadAction();
	}
	
	
	/**
	 * ThreadPoolTaskExecutor 테스트 메소드
	 * 
	 * @author	applepie1130
	 */
	private static void threadAction() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");
		
		logger.info("TaskExecutor Ready!! - {}", taskExecutor);
		
		List<String> command =  Arrays.asList("apple", "banana", "movie", "starbucks", "heart");
		
		// ThreadPoolTaskExecutor Configuration
		taskExecutor.setCorePoolSize(command.size());
		taskExecutor.setMaxPoolSize(command.size() * 2);
		taskExecutor.setQueueCapacity(taskExecutor.getCorePoolSize() * taskExecutor.getMaxPoolSize() * 2);
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		taskExecutor.initialize();
		
		// Thread Run!!
		for ( int i=0; i<command.size(); i++ ) {
			Task task = (Task) context.getBean(Task.class);
			task.setName(command.get(i));
			taskExecutor.execute(task);
		}
		
		// All Close
		context.close();
		logger.info("TaskExecutor All Closed");
	}
}
