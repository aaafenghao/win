package com.fh.disruptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

import com.fh.entity.TranslatorDataWapper;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.dsl.ProducerType;

public class RingBufferWorkerPoolFactory {
	
	private static class SingletonHolder{
		final static RingBufferWorkerPoolFactory factory = new RingBufferWorkerPoolFactory();
	}
	
	private RingBufferWorkerPoolFactory() {
		
	}
	
	public static RingBufferWorkerPoolFactory getInstance() {
		return SingletonHolder.factory;
	}
	
	private static Map<String,MessageProducer> messageProducers = new ConcurrentHashMap<String, MessageProducer>();
	
	private static Map<String,MessageConsumer> messageConsumers = new ConcurrentHashMap<String, MessageConsumer>();
	
	private RingBuffer<TranslatorDataWapper> ringBuffer;
	
	private SequenceBarrier sequenceBarrier;
	
	private WorkerPool<?> workerPool;
	
	public void initAndStart(ProducerType type,int bufferSize,WaitStrategy waitStrategy,MessageConsumer[] consumers) {
		//对象构件
		this.ringBuffer = RingBuffer.create(type, new EventFactory<TranslatorDataWapper>() {

					@Override
					public TranslatorDataWapper newInstance() {
						// TODO Auto-generated method stub
						return new TranslatorDataWapper();
					}
				}, 
				bufferSize, waitStrategy);
		//设置序号栅栏
		this.sequenceBarrier = this.ringBuffer.newBarrier();
		//设置工作池
		this.workerPool = new WorkerPool<TranslatorDataWapper>(this.ringBuffer, this.sequenceBarrier, 
				new EventExceptionHadnler(), consumers);
		//放入池中
		for (MessageConsumer messageConsumer : consumers) {
			messageConsumers.put(messageConsumer.getConsumerId(), messageConsumer);
		}
		
		//添加sequence
		this.ringBuffer.addGatingSequences(this.workerPool.getWorkerSequences());
		//启动工作线程池
		this.workerPool.start(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
		
	}
	
	public MessageProducer getProducer(String producerId) {
		MessageProducer producer = messageProducers.get(producerId);
		if(null == producer) {
			producer = new MessageProducer(producerId,this.ringBuffer);
			messageProducers.put(producerId, producer);
		}
		return producer;
	}
	
	/**
	 * 异常静态类
	 * @author pc
	 *
	 */
	static class EventExceptionHadnler implements ExceptionHandler<TranslatorDataWapper>{

		@Override
		public void handleEventException(Throwable ex, long sequence, TranslatorDataWapper event) {
			
		}

		@Override
		public void handleOnStartException(Throwable ex) {
			
		}

		@Override
		public void handleOnShutdownException(Throwable ex) {
			
		}
		
	}
	
	

}
