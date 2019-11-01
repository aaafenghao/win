package com.example.demo.quickstart;

import com.lmax.disruptor.EventFactory;

public class OrderEventFactory implements EventFactory<OrderEvent> {

	@Override
	public OrderEvent newInstance() {
		return new OrderEvent();//返回空的数据对象
	}

}
