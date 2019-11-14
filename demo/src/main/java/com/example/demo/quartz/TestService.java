package com.example.demo.quartz;

import javax.annotation.PostConstruct;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService {
	
	@Autowired
	private Scheduler scheduler;
	
	public String test() {
		return "success";
	}
	
	@PostConstruct
	public void init() {
		try {
			JobDetail build = JobBuilder.newJob(DemoJob.class).build();
			Trigger trigger = TriggerBuilder.newTrigger().startNow().build();
			scheduler.scheduleJob(build, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
