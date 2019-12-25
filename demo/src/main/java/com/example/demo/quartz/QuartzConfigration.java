package com.example.demo.quartz;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfigration {
	
	 @Autowired
	 private VooleJobFactory vooleJobFactory;
	 
	 @Bean
	 public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setJobFactory(vooleJobFactory);
        return bean;
	 }
	 
	 @Bean(name = "scheduler")
	 public Scheduler scheduler() {
		 return schedulerFactoryBean().getScheduler();
	 }

}
