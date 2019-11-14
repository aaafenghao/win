package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TestVo;


@RestController
//@EnableBinding(SendController.SinkSender.class)
public class SendController {
	
//	@Autowired
//	private SinkSender sender;

	
	
	@GetMapping("json")
	public String send(@RequestBody TestVo vo) {
//		sender.output().send(MessageBuilder.withPayload("send Test").build());
		System.out.println(vo.toString());
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		for (int i = 0; i < stackTrace.length; i++) {
			System.out.println(stackTrace[i].toString());
		}
		return "success";
	}
	
//	public interface SinkSender{
//		String OUT_PUT = "output";
//		
//		@Output(SinkSender.OUT_PUT)
//		MessageChannel output();
//	}
}
