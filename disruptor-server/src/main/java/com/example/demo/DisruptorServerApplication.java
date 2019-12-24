package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.server.MessageConsumerImpl;
import com.example.demo.server.NettyServer;
import com.fh.disruptor.MessageConsumer;
import com.fh.disruptor.RingBufferWorkerPoolFactory;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;

@SpringBootApplication
public class DisruptorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisruptorServerApplication.class, args);
		
		MessageConsumer[] consumers = new MessageConsumer[4];
		for (int i = 0; i < consumers.length; i++) {
			MessageConsumer consumer = new MessageConsumerImpl("server"+i);
			consumers[i] = consumer;
		}
		
		RingBufferWorkerPoolFactory.getInstance().initAndStart(ProducerType.MULTI, 1024 * 1024, new BlockingWaitStrategy(), consumers);
		
		new NettyServer();
	}

}
