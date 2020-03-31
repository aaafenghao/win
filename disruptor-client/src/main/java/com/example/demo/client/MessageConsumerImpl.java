package com.example.demo.client;

import com.fh.disruptor.MessageConsumer;
import com.fh.entity.TranslatorData;
import com.fh.entity.TranslatorDataWapper;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class MessageConsumerImpl extends MessageConsumer {

	public MessageConsumerImpl(String consumerId) {
		super(consumerId);
	}

	@Override
	public void onEvent(TranslatorDataWapper event) throws Exception {
		TranslatorData response = event.getData();
		ChannelHandlerContext context = event.getContext();
		try {
			System.out.println("res:"+response.toString());
			
		} finally {
			ReferenceCountUtil.release(response);
		}
	}

}
