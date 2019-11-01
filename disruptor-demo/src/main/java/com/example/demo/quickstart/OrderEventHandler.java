package com.example.demo.quickstart;

import com.lmax.disruptor.EventHandler;

/**
 * 数据接收者
 * 数据监听
 * @author pc
 *
 */
public class OrderEventHandler implements EventHandler<OrderEvent> {

	@Override
	public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("消费者: "+event.getValue());
	}

}
