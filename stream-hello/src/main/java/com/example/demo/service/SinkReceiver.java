package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * bind 监听
 * @author pc
 *
 */
@EnableBinding(Sink.class)
public class SinkReceiver {
	
	private final static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

	@StreamListener(Sink.INPUT)
	public void receiver(Object payload) {
		logger.info("receiver:"+payload); 
		
		List<String> list = new ArrayList<String>();
		
		
	}
}
