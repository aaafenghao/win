package com.example.demo.height;

import com.lmax.disruptor.EventHandler;

public class Handler4 implements EventHandler<Trade> {

	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("handler 4 set price");
		event.setPrice(17.0);
	}

}
