package com.example.demo.height;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * workHandler 也可以重写该接口
 * @author pc
 *
 */
public class Handler1 implements EventHandler<Trade>,WorkHandler<Trade> {

	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
		this.onEvent(event);
	}

	@Override
	public void onEvent(Trade event) throws Exception {
		System.out.println("handler 1 set name");
		event.setName("handler");
		Thread.sleep(1000);
	}

}
