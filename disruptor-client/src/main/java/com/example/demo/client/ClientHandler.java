package com.example.demo.client;





import com.fh.disruptor.MessageProducer;
import com.fh.disruptor.RingBufferWorkerPoolFactory;
import com.fh.entity.TranslatorData;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		/*
		 * try { TranslatorData response = (TranslatorData)msg;
		 * System.out.println("Client端:"+ToStringBuilder.reflectionToString(response));
		 * 
		 * }finally { //注意：用完之后要释放 ReferenceCountUtil.release(msg); }
		 */
		TranslatorData response = (TranslatorData)msg;
		String producerId = "code:session:11";
		
		MessageProducer producer = RingBufferWorkerPoolFactory.getInstance().getProducer(producerId);
		producer.onData(response, ctx);
		
	}

	

}
