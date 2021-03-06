package com.example.demo.lock.weight;

import java.util.concurrent.CountDownLatch;

import org.springframework.util.StopWatch;

/**
 * 重量级锁
 * @author pc
 *
 */
public class WeightDemo {

	static CountDownLatch latch = new CountDownLatch(100000000);
	
	public static void main(String[] args) throws InterruptedException {
		final C c = new C();
		StopWatch process = new StopWatch();
		process.start();
		for (int i = 0; i < 2; i++) {
			new Thread() {
				@Override
				public void run() {
					while(latch.getCount() > 0) {
						c.parse();
					}
				}
			}.start();
		}
		latch.countDown();
		
		latch.await();
		process.stop();
		System.out.println("process time "+process.getTotalTimeMillis());
		
	}
}
