package com.example.demo.heightMulti;

import com.lmax.disruptor.RingBuffer;

public class Producer {
	
	private RingBuffer<Order> ringBuffer;

	public Producer(RingBuffer<Order> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	public void sendData(String uuid) {
		long next = ringBuffer.next();
		try {
			Order order = ringBuffer.get(next);
			order.setId(uuid);
		} finally {
			ringBuffer.publish(next);
		}
		
	}

}
