package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.client.NettyClient;

@SpringBootApplication
public class DisruptorClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisruptorClientApplication.class, args);
		
		new NettyClient().sendData();
	}

}
