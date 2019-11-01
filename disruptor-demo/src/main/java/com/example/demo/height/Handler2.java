package com.example.demo.height;

import java.util.UUID;

import com.lmax.disruptor.EventHandler;

public class Handler2 implements EventHandler<Trade> {

	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
			System.out.println("handler 2 set id");
			event.setId(UUID.randomUUID().toString());
			Thread.sleep(2000);
			
	}

}
