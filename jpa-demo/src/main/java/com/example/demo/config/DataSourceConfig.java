package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {
	
	@Bean(name = "primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	@Primary
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "secondDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.second")
	public DataSource secondDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "primaryTemplate")
	public JdbcTemplate primaryTemplate(@Qualifier("primaryDataSource") DataSource datasource) {
		return new JdbcTemplate(datasource);
	}
	
	@Bean(name = "secondTemplate")
	public JdbcTemplate secondTemplate(@Qualifier("secondDataSource") DataSource datasource) {
		return new JdbcTemplate(datasource);
	}

}
