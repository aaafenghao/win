package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskTest {
	
	public static void main(String[] args) throws Exception{
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(5000);
				System.out.println("task is end");
				return "success";
			}
		});
		
		Thread thread = new Thread(task);
		thread.start();
		
		String string = task.get(4, TimeUnit.SECONDS);
		System.out.println(string);
		Thread.sleep(6000);
		
	}

}
