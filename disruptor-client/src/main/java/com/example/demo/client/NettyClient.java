package com.example.demo.client;

import com.fh.codec.MarshallingCodeCFactory;
import com.fh.entity.TranslatorData;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyClient {
	
	public static final String HOST = "127.0.0.1";
	
	public static final int PORT = 8765;
	
	private EventLoopGroup work = new NioEventLoopGroup();
	
	private ChannelFuture cf;
	
	//可以放到map中
	private Channel channel;

	public NettyClient(){
		this.connect(HOST, PORT);
	}
	
	public void connect(String host,int port) {

		//1、创建两个工作线程组:一个用于接收网络请求,另一个用于实际处理业务请求的
		
		
		
		Bootstrap server = new Bootstrap();
		
		try {
			
			server.group(work)
			.channel(NioSocketChannel.class)
			.option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)//字节缓冲自适应
			.option(ChannelOption.ALLOCATOR,PooledByteBufAllocator.DEFAULT)//缓冲池
			.handler(new LoggingHandler(LogLevel.INFO))
			.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
					ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
					ch.pipeline().addLast(new ClientHandler());
					
				}
				
			});
	
			this.cf = server.connect(host, port).sync();
			System.out.println("Client connect!");
			
			//接下来进行数据的发送
			this.channel = cf.channel();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			
		}
	
	}
	
	public void sendData() {
		for (int i = 0; i < 10; i++) {
			TranslatorData data = new TranslatorData();
			data.setId("id"+i);
			data.setMessage("消息内容"+i);
			data.setName("消息名称"+i);
			this.channel.writeAndFlush(data);
		}
	}
	
	public void close() throws Exception{
		cf.channel().closeFuture().sync();
		//优雅停机
		work.shutdownGracefully();
		System.err.println("Server shutdown!");
	}
}
