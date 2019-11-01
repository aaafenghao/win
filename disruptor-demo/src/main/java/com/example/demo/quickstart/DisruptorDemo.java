package com.example.demo.quickstart;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * 测试主类
 * @author pc
 * 
 * 1、建立一个工厂Event类，用于创建Event类实例变量
 * 2、需要一个监听事件类，用于处理数据
 * 3、实例哈Disruptor实例，配置一系列的参数
 * 4、编写生产者组件，向disruptor容器投递数据
 *
 */
public class DisruptorDemo {
	
	public static void main(String[] args) {
		
		//参数准备工作
		OrderEventFactory orderEventFactory = new OrderEventFactory();
		int ringBufferSize = 1024 * 1024;
		ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());//有安全隐患
		/**
		 * 1、消息工厂对象
		 * 2、ringBufferSize
		 * 3、Executor --建议使用自定义线程池
		 * 4、生产类型
		 * 5、等待策略
		 */
		//1、实例化对象
		Disruptor<OrderEvent> disruptor = new Disruptor<OrderEvent>(
				orderEventFactory, 
				ringBufferSize,
				pool,
				ProducerType.SINGLE,//单生成者模式
				new BlockingWaitStrategy());
		
		//2、添加消费者监听  构建一个和消费者之间的关联关系
		disruptor.handleEventsWith(new OrderEventHandler());
		
       //3、启动
		disruptor.start();
		
		//4、获取实际存储数据的容器 RingBuffer	
		RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
		
		OrderEventProducer producer = new OrderEventProducer(ringBuffer);
		
		ByteBuffer bb = ByteBuffer.allocate(8);
		for (int i = 0; i < 100; i++) {
			bb.putLong(0, i);
			producer.sendData(bb);
		}
		
		disruptor.shutdown();
		pool.shutdown();
		
		
	}

}
