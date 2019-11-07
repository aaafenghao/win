package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.server.NettyServer;

@SpringBootApplication
public class DisruptorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisruptorServerApplication.class, args);
		
		new NettyServer();
	}

}
