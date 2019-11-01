package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
@EnableBinding(value = {StreamHelloApplicationTests.SinkSender.class})
public class StreamHelloApplicationTests {

//	@Test
//	public void contextLoads() {
//	}
	
	@Autowired
	private SinkSender sinkSender;
	
	@Test
	public void testSender() {
		sinkSender.output().send(MessageBuilder.withPayload("send test").build());
	}
	
	public interface SinkSender{
		String OUT_PUT = "input";
		
		@Output(SinkSender.OUT_PUT)
		MessageChannel output();
	}

}
