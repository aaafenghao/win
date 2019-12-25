package com.example.demo.uc;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
	
	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(8);
		Thread[] players = new Thread[8];
		
		for (int i = 0; i < players.length; i++) {
			players[i] = new Thread(() ->{
				try {
					TimeUnit.SECONDS.sleep(new Random().nextInt(10));
					System.out.println(Thread.currentThread().getName()+"准备好了!");
					barrier.await();
				} catch (Exception e) {
				}
				System.out.println(Thread.currentThread().getName()+"起跑！！！");
				
			},"player["+i+"]");
			players[i].start();
		}
	}

}
