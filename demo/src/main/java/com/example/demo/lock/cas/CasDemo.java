package com.example.demo.lock.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {
	
	public static AtomicInteger atomic = new AtomicInteger(0);
	
	public static void main(String[] args) {
		int incrementAndGet = atomic.incrementAndGet();
	}

	
}
