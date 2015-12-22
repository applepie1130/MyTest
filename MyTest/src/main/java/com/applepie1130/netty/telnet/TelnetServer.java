package com.applepie1130.netty.telnet;
import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

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
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new TelnetServerInitializer());
			
			ChannelFuture future = b.bind(port).sync();
			future.channel().closeFuture().sync();
			
		} catch (Exception e) {
			logger.error("{}", e);
			
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
