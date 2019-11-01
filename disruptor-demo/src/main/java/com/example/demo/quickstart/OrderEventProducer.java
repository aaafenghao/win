package com.example.demo.quickstart;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class OrderEventProducer {
	
	  private RingBuffer<OrderEvent> ringBuffer;
	
      public OrderEventProducer(RingBuffer<OrderEvent> ringbuffer) {
    	  	this.ringBuffer = ringbuffer;
      }

      public void sendData(ByteBuffer data) {
    	//1、在生产者发送消息的时候，首先需要从ringbuffer获取一个可用的序号
		  long sequence = ringBuffer.next();
    	  try {
			  //2、根据需要找到具体的OrderEvent对象   此时获取的是一个没有填充数据的对象，属性没有被赋值
			  OrderEvent orderEvent = ringBuffer.get(sequence);
			  //3、进行实际的赋值处理
			  orderEvent.setValue(data.getLong(0));
		}finally {
			  //4、提交发布操作
			  ringBuffer.publish(sequence);
		}
    	  
      }
}
