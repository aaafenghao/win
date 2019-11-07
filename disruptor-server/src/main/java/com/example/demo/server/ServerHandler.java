package com.example.demo.server;


import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fh.entity.TranslatorData;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler  extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		TranslatorData data = (TranslatorData)msg;
		System.out.println(ToStringBuilder.reflectionToString(data));
		
		TranslatorData response = new TranslatorData();
		response.setId(UUID.randomUUID().toString());
		response.setMessage("hello");
		ctx.writeAndFlush(response);
		
	}
	
	



}
