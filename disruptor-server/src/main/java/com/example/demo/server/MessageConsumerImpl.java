package com.example.demo.server;

import com.fh.disruptor.MessageConsumer;
import com.fh.entity.TranslatorData;
import com.fh.entity.TranslatorDataWapper;

import io.netty.channel.ChannelHandlerContext;

public class MessageConsumerImpl extends MessageConsumer{

	public MessageConsumerImpl(String consumerId) {
		super(consumerId);
	}

	@Override
	public void onEvent(TranslatorDataWapper event) throws Exception {
		TranslatorData data = event.getData();
		ChannelHandlerContext context = event.getContext();
		
		System.out.println("data:"+data.toString());
		
		TranslatorData response = new TranslatorData();
		response.setId("111");
		response.setMessage("producer");
		response.setName("test");
		
		context.writeAndFlush(response);
	}

}
