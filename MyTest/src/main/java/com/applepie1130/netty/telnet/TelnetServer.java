package com.applepie1130.netty.telnet;
import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 텔넷서버
 * 
 * @author applepie1130
 */
@Service
public class TelnetServer {
	
	private static final Logger logger = LoggerFactory.getLogger(TelnetServer.class);
	
	@Autowired
	@Qualifier("tcpSocketAddress")
	private InetSocketAddress port;
	
	public void start() {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		Channel channel = null;
		ChannelFuture channelFuture = null;
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.handler(new LoggingHandler(LogLevel.INFO))
				.childHandler(new TelnetServerInitializer());
			
			channel = b.bind(port).sync().channel();
			
			channelFuture = channel.closeFuture();
			channelFuture.sync();
			
		} catch (Exception e) {
			logger.error("{}", e);
			
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
