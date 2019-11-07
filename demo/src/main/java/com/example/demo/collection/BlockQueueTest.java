package com.example.demo.collection;

import java.util.Calendar;

public class BlockQueueTest {
	
	public static void main(String[] args) {
//		System.out.println(System.currentTimeMillis()%1000);
		
		 int nowSecond = Calendar.getInstance().get(Calendar.SECOND);
//		 System.out.println(nowSecond);
		
		for (int i = 0; i < 2; i++) {
			System.out.println((nowSecond+60-i)%60);
		}
//		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
//		
//		queue.add("fenghao");
//		queue.add("haha");
//		queue.add("enen");
//		
//		List<String> lists = new ArrayList<String>();
//		
//		queue.drainTo(lists);
//		
//		lists.forEach(item ->{
//			System.out.println(item);
//		});
	}

}
