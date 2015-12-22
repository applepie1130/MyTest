package com.applepie1130.netty.telnet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 텔넷서버 핸들러
 * 
 * @author applepie1130
 */
public class TelnetServerAction {
	
	private static final Logger logger = LoggerFactory.getLogger(TelnetServerAction.class);
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = null;
		
		try {
			ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			ctx.registerShutdownHook();
			
			TelnetServer telnetServer = ctx.getBean(TelnetServer.class);
			
			telnetServer.start();
			
		} finally {
			ctx.close();
		}
	}
}
