package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DemoConfig implements ApplicationContextAware {
	
//	@Autowired
//	private DataSource oracleDataSource;
//	
//
//
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		DataSource bean = applicationContext.getBean(DataSource.class);
	}
//	
//	@Bean
//	public JdbcTemplate oracleJdbcTemplete() {
//		return new JdbcTemplate(oracleDataSource);
//	}
	

	
	

}
