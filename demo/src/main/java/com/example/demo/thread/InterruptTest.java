package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

public class InterruptTest {
	
	public static void main(String[] args) throws Exception {
		Thread sleep = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
//					TimeUnit.SECONDS.sleep(5);
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		sleep.start();
		
		TimeUnit.SECONDS.sleep(3);
		
		System.out.println(sleep.isInterrupted());
		
		sleep.interrupt();
		
		System.out.println(sleep.isInterrupted());
	}
	
	

}
