package com.fh.disruptor;

import com.fh.entity.TranslatorData;
import com.fh.entity.TranslatorDataWapper;
import com.lmax.disruptor.RingBuffer;

import io.netty.channel.ChannelHandlerContext;

public class MessageProducer {
	
	private String producerId;
	
	private RingBuffer<TranslatorDataWapper> ringBuffer;
	
	public MessageProducer(String producerId,RingBuffer<TranslatorDataWapper> ringBuffer) {
		this.producerId = producerId;
		this.ringBuffer = ringBuffer;
	}

	public String getProducerId() {
		return producerId;
	}

	public void setProducerId(String producerId) {
		this.producerId = producerId;
	}
	
	public 	void onData(TranslatorData data,ChannelHandlerContext context) {
			long next = this.ringBuffer.next();
			try {
				TranslatorDataWapper translatorDataWapper = this.ringBuffer.get(next);
				translatorDataWapper.setContext(context);
				translatorDataWapper.setData(data);
			} finally {
				this.ringBuffer.publish(next);
			}
	}

	
}
