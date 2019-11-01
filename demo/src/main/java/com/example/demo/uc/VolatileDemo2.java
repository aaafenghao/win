package com.example.demo.uc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VolatileDemo2 {
	
	volatile static int m = 0;
	
	public static void increment() {
		m++;
	}
	
	public static void main(String[] args) throws Exception {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread() {
				public void run() {
					for (int j = 0; j < 5; j++) {
						increment();
					}
				};
			};
			threads.add(thread);
		}
		threads.forEach(item ->{
			item.start();
		});
		threads.forEach(item ->{
			try {
				item.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
//		System.out.println("开始等待");
//		TimeUnit.SECONDS.sleep(5);
		System.out.println(m);
		
	}

}
