package com.example.demo.heightMulti;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.lmax.disruptor.WorkHandler;

public class Consumer implements WorkHandler<Order> {

	private String consumerId;
	
	private static AtomicInteger count = new AtomicInteger(0);
	
	private Random random = new Random();
	
	Consumer(String consumerId){
		this.consumerId = consumerId;
	}
	
	@Override
	public void onEvent(Order event) throws Exception {
		Thread.sleep(1 * random.nextInt(5));
		System.out.println("当前消费者:"+this.consumerId+" 消费者ID:"+event.getId());
	}
	
	public int getCount() {
		return count.get();
	}

}
