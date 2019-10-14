package com.example.demo.uc;


public class Demo extends Thread{
	
	public static int i = 0;
	
	public final static int MAX = 1000;
	
	@Override
	public void run() {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			System.out.println(name+" monitor enter");
			try {
				Thread.sleep(10000);
				System.out.println(name+" monitor exit");
			}catch (Exception ignore) {
			}
//			while(i<MAX) {
//				System.out.println(Thread.currentThread().getName()+"获取到:"+(i++));
//			}
		}
	}

}
