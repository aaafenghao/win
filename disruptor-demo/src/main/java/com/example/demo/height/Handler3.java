package com.example.demo.height;

import com.lmax.disruptor.EventHandler;

public class Handler3 implements EventHandler<Trade> {

	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("handler 3 : name : "+event.getName()+"; id :"+event.getId()+";instance:"+event.toString()+";price"+event.getPrice());
		
	}

}
