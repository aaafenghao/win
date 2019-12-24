package com.example.demo.thread;

public class ThreaLocalTest {
	
	public static void main(String[] args) throws Exception {
		InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<String>();
		threadLocal.set("test");
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("child : "+threadLocal.get());
			}
		});
		thread.start();
		Thread.sleep(2000);
		System.out.println("parent : "+threadLocal.get());
		
	}

}
