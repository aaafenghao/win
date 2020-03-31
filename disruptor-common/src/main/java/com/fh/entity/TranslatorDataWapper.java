package com.fh.entity;

import io.netty.channel.ChannelHandlerContext;

public class TranslatorDataWapper {
	
	private TranslatorData data;
	
	private ChannelHandlerContext context;

	public TranslatorData getData() {
		return data;
	}

	public void setData(TranslatorData data) {
		this.data = data;
	}

	public ChannelHandlerContext getContext() {
		return context;
	}

	public void setContext(ChannelHandlerContext context) {
		this.context = context;
	}
	
	

}
