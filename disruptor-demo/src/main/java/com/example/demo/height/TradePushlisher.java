package com.example.demo.height;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

public class TradePushlisher implements Runnable {
	
	private CountDownLatch latch;
	private Disruptor<Trade> disruptor;
	
	private static int PUB_COUNT = 1;
	
	TradePushlisher(CountDownLatch latch,Disruptor<Trade> disruptor){
		this.latch  = latch;
		this.disruptor = disruptor;
	}

	@Override
	public void run() {
		TradeEventTranslator tradeEventTranslator = new TradeEventTranslator();
		for (int i = 0; i < PUB_COUNT; i++) {
			disruptor.publishEvent(tradeEventTranslator);
		}
		latch.countDown();
		
	}
	
	

}

class TradeEventTranslator implements EventTranslator<Trade>{

	Random random = new Random();
	
	@Override
	public void translateTo(Trade event, long sequence) {
		this.generaTrade(event);
	}

	private void generaTrade(Trade event) {
		event.setPrice(random.nextDouble() * 9999);
		
	}
	
}
