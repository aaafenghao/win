package com.example.demo.uc;


public class Demo extends Thread{
	
	public static int i = 0;
	
	public final static int MAX = 1000;
	
	@Override
	public void run() {

			while(i<MAX) {
				System.out.println(Thread.currentThread().getName()+"获取到:"+(i++));
			}
		}
	}

