package com.example.demo.height;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.util.StopWatch;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventProcessor;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class HeightDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		//构建一个线程池，用于提交
		ExecutorService es = Executors.newFixedThreadPool(8);
		
		ExecutorService es2 = Executors.newFixedThreadPool(5);//核心线程数有问题，必须和handler个数有关,单消费者模式
		//必须和handler一致原因:
		//单消费者--EventProcessor
		//???--目前不太懂
		
		
		//1、构建实例
		Disruptor<Trade> disruptor = new Disruptor<Trade>(
				new EventFactory<Trade>() {

					@Override
					public Trade newInstance() {
						return new Trade();
					}
					
				},
				1024 * 1024, 
				es2, 
				ProducerType.SINGLE, 
				new BusySpinWaitStrategy());
//		2、将消费者关联到disruptor实例上

		//2.1 串行操作
//		disruptor.handleEventsWith(new Handler1())
//		.handleEventsWith(new Handler2())
//		.handleEventsWith(new Handler3());
////		.handleEventsWith(handler4)
////		.handleEventsWith(handler5);
		//2.2 并行操作
//		disruptor.handleEventsWith(new Handler1());
//		disruptor.handleEventsWith(new Handler2());//第一种分别进行调用
//		disruptor.handleEventsWith(new Handler3());
//		disruptor.handleEventsWith(new Handler2(),new Handler3());//第二种 添加多个
		//2.3 串并行同时编码--菱形操作
//		disruptor.handleEventsWith(new Handler1(),new Handler2())//第一种
//		   .handleEventsWith(new Handler3());
//		EventHandlerGroup<Trade> ehGroup = disruptor.handleEventsWith(new Handler1(),new Handler2());//第二种
//		ehGroup.then(new Handler3());
		//2.4 六边形操作
		Handler1 handler1 = new Handler1();
		Handler2 handler2 = new Handler2();
		Handler3 handler3 = new Handler3();
		Handler4 handler4 = new Handler4();
		Handler5 handler5 = new Handler5();
		//
		//      h1--->h2
		//开始                h3
		//      h4--->h5
		//
		disruptor.handleEventsWith(handler1,handler4);
		disruptor.after(handler1).handleEventsWith(handler2);
		disruptor.after(handler4).handleEventsWith(handler5);
		disruptor.after(handler2,handler5).handleEventsWith(handler3);
		
		
//		3、启动实例
		disruptor.start();
		
		CountDownLatch latch = new CountDownLatch(1);
		StopWatch process = new StopWatch();
		process.start();
		es.submit(new TradePushlisher(latch,disruptor));
		
		latch.await();
		
		disruptor.shutdown();
		es.shutdown();
		es2.shutdown();
		process.stop();
		System.out.println("总耗时："+process.getTotalTimeSeconds()+"s");
		
		
	}
}
