package com.example.demo.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component
public class VooleJobFactory extends AdaptableJobFactory {
	
	@Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object createJobInstance = super.createJobInstance(bundle);
		capableBeanFactory.autowireBean(createJobInstance);
		return createJobInstance;
	}
	
	

}
