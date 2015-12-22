package com.applepie1130.netty.telnet;
import java.net.InetAddress;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 텔넷서버 핸들러
 * 
 * 체널 파이프라인에서 공유되는 데이터 핸들러는 
 * 어노테이션 Sharable가 선언되어야 한다. (제약조건 : Thread Safety)
 * 
 * @author applepie1130
 */
@Component
@Sharable
public class TelnetServerHandler extends SimpleChannelInboundHandler<String> {
	
	private static final Logger logger = LoggerFactory.getLogger(TelnetServerHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.write("환영합니다. " + InetAddress.getLocalHost().getHostName() + "에 접속하셨습니다.!\r\n" );
		ctx.write("현재 시간" + new DateTime() + "입니다.\r\n\n");
		ctx.flush();
	};
	
	/**
	 * Since 5.0, {@code channelRead0(ChannelHandlerContext, I)} has been renamed to
	 * {@link #messageReceived(ChannelHandlerContext, I)} 
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, String request) throws Exception {
		String response;
		boolean close = false;
		
		if ( request.isEmpty() ) { 
			response = "명령을 입력해 주세요.\r\n";
			
		} else if ( "bye".equals(request.toLowerCase()) ) {
			response = "좋은 하루 되세요!\r\n";
			close = true;
			
		} else {
			response = "입력하신 명령이 '" + request + "' 이지요~?\r\n";
		}
		
		// 퓨쳐패턴에 적용
		ChannelFuture future = ctx.write(response);
		
		if ( close ) {
			future.addListener(ChannelFutureListener.CLOSE);
		}
		 
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
