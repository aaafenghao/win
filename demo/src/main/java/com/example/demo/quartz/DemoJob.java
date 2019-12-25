package com.example.demo.quartz;



import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoJob implements Job{
	
	@Autowired
	private TestService test;
	
//	@PostConstruct
//	public void init() {
//		System.out.println(test);
//	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("--------------------");
		System.out.println("demo job is execute !!!");
		System.out.println(test.test());
		System.out.println("--------------------");
	}



}
