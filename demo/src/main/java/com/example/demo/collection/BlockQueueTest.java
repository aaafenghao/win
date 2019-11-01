package com.example.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockQueueTest {
	
	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		
		queue.add("fenghao");
		queue.add("haha");
		queue.add("enen");
		
		List<String> lists = new ArrayList<String>();
		
		queue.drainTo(lists);
		
		lists.forEach(item ->{
			System.out.println(item);
		});
	}

}
