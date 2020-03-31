package com.example.demo.server;




import com.fh.disruptor.MessageProducer;
import com.fh.disruptor.RingBufferWorkerPoolFactory;
import com.fh.entity.TranslatorData;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler  extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		/*
		 * TranslatorData data = (TranslatorData)msg;
		 * System.out.println(ToStringBuilder.reflectionToString(data));
		 * 
		 * TranslatorData response = new TranslatorData();
		 * response.setId(UUID.randomUUID().toString()); response.setMessage("hello");
		 * ctx.writeAndFlush(response);
		 */
		
		TranslatorData data = (TranslatorData)msg;
		// 自定义ID生成规则
		String producerId = "SessionId:00";
		MessageProducer producer = RingBufferWorkerPoolFactory.getInstance().getProducer(producerId);
		
		producer.onData(data, ctx);
		
	}
	
	



}
