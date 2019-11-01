package com.example.demo.uc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

import org.apache.catalina.startup.Tomcat;

/**
 * AtomicInteger  ABA问题
 * @author pc
 *
 */
public class AtomicTest {
	
	public static AtomicInteger atomic = new AtomicInteger(0);
	
	public static AtomicStampedReference<Integer> asr = new AtomicStampedReference<Integer>(0, 0);
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				boolean compareAndSet = atomic.compareAndSet(0, 1);
				System.out.println(compareAndSet);
			}
		});
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
					boolean compareAndSet = atomic.compareAndSet(0, 2);
					System.out.println(compareAndSet);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
					boolean compareAndSet = atomic.compareAndSet(1, 0);
					System.out.println(compareAndSet);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		th1.start();
		th2.start();//可以修改成功,但是这个值是被其他线程修改回来的
		th3.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
		
	}

}
