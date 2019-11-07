package com.example.demo.client;




import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fh.entity.TranslatorData;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			TranslatorData response = (TranslatorData)msg;
			System.out.println("Client端:"+ToStringBuilder.reflectionToString(response));
			
		}finally {
			//注意：用完之后要释放
			ReferenceCountUtil.release(msg);
		}
	}

	

}
