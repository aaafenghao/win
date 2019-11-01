package com.example.demo.height;

import com.lmax.disruptor.EventHandler;

public class Handler5 implements EventHandler<Trade> {

	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("handler 5 get price");
		System.out.println("price"+event.getPrice());
		event.setPrice(event.getPrice()+3);
	}

}
