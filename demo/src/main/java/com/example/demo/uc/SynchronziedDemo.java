package com.example.demo.uc;

public class SynchronziedDemo {
	
	public static int i = 0;
	
	public static void main(String[] args) {
		
		Demo demo1 = new Demo();
		Demo demo2 = new Demo();
		Demo demo3 = new Demo();
		Demo demo4 = new Demo();
		
		demo1.start();
		demo2.start();
		demo3.start();
		demo4.start();
	}

}
