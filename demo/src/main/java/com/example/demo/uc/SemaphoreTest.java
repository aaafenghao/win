package com.example.demo.uc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
	

	
	public static void main(String[] args) {
		Semaphore se = new Semaphore(5);
		
		Thread[] thread = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new  Thread(()->{
				try {
					TimeUnit.SECONDS.sleep(2);
					se.acquire();
					System.out.println(Thread.currentThread().getName()+"进去吧");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					TimeUnit.SECONDS.sleep(new Random().nextInt(10));
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				try {
					se.release();
					System.out.println(Thread.currentThread().getName()+"离开了");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			},"汽车"+i);
			thread[i].start();
		}
	}

}
