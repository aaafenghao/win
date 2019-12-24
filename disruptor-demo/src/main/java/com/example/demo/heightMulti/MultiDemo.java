package com.example.demo.heightMulti;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;

public class MultiDemo {
	
	public static void main(String[] args) throws Exception {
		//1、构建ringBuffer
		RingBuffer<Order> ringBuffer = 
				RingBuffer.create(ProducerType.MULTI, 
						          new EventFactory<Order>() {

									@Override
									public Order newInstance() {
										return new Order();
									}
								}, 
						          1024 * 1024, 
						          new YieldingWaitStrategy());
		//2、通过ringbuffer创建屏障
		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
		//3、创建多消费者数组
		Consumer[] consumers = new Consumer[10];
		for (int i = 0; i < consumers.length; i++) {
			consumers[i] = new Consumer("C"+i);
		}
		//4、构建消费者工作池
		WorkerPool<Order> workerPool = new WorkerPool<Order>(ringBuffer, sequenceBarrier, new EventExceptionHadnler(), consumers);
		//5、设置多个消费者的sequence序号,用于单独统计消费进度
		ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
		//6、启动workpool
		workerPool
		  .start(Executors.newFixedThreadPool(10));
		
		CountDownLatch latch = new CountDownLatch(0);
		for (int i = 0; i < 100; i++) {
			Producer producer = new Producer(ringBuffer);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (int j = 0; j < 100; j++) {
						producer.sendData(UUID.randomUUID().toString());
					}
				}
			}).start();
		}
		
		Thread.sleep(2000);
		System.out.println("-----------线程创建完毕，开始生产数据-----------------------------------");
		
		latch.countDown();
		Thread.sleep(10000);
		System.out.println("任务总数"+consumers[2].getCount());
		
		
	}
	
	static class EventExceptionHadnler implements ExceptionHandler<Order>{

		@Override
		public void handleEventException(Throwable ex, long sequence, Order event) {
			
		}

		@Override
		public void handleOnStartException(Throwable ex) {
			
		}

		@Override
		public void handleOnShutdownException(Throwable ex) {
			
		}
		
	}

}
