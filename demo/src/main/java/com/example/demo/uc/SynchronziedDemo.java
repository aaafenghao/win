package com.example.demo.uc;

/**
 * 这不是一个很好的例子，如果在run方法中添加锁，锁住的是当前的对象，也是无法保证有序性
 * @author pc
 *
 */
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
