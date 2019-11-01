package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding(SendController.SinkSender.class)
public class SendController {
	
	@Autowired
	private SinkSender sender;

	@GetMapping()
	public String send() {
		sender.output().send(MessageBuilder.withPayload("send Test").build());
		return "success";
	}
	
	public interface SinkSender{
		String OUT_PUT = "output";
		
		@Output(SinkSender.OUT_PUT)
		MessageChannel output();
	}
}
