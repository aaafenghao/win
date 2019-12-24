package com.example.demo.uc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
	
	private static List<String> lists = Arrays.asList("东方","南方","海南");
	
	private static List<String> fightLists = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		
		String origin = "BJ";
		String dest = "SH";
		
		
		Thread[] threads = new Thread[lists.size()];
		CountDownLatch latch = new CountDownLatch(lists.size());
		
		for (int i = 0; i < threads.length; i++) {
			String name = lists.get(i);
			threads[i] = new Thread(() ->{
				System.out.printf("%s 查询从%s到%s的机票信息\n",name,origin,dest);
				
				int val = new Random().nextInt(10);
				try {
					TimeUnit.SECONDS.sleep(val);
					fightLists.add(name+"----"+val);
					System.out.printf("%s公司查询成功!\n",name);
					latch.countDown();
				} catch (Exception e) {
				}
			}); 
			threads[i].start();
		}
		
		latch.await();
		System.out.println("查询结果如下:--------------");
		fightLists.forEach(System.out::println);
		
	}

}
