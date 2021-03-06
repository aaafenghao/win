package com.example.demo.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AAA;
import com.example.demo.entity.Haved;
import com.example.demo.entity.Test;
import com.example.demo.reposity.DemoReposity;
import com.example.demo.reposity.HavedReposity;
import com.example.demo.reposity.TestReposity;

@RestController
public class DemoController {

	@Autowired
	private DemoReposity demoReposity;
	@Autowired
	private TestReposity testReposity;
	@Autowired
	private HavedReposity havedReposity;
	
	@Autowired
	@Qualifier("primaryTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("jdbc-mysql")
	public String jdbc_mysql() {
		Haved test = new Haved();
		test.setName("test");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		/*
		 * jdbcTemplate.update(new PreparedStatementCreator() { final String sql =
		 * "insert into haved(NAME) values(?)";
		 * 
		 * @Override public PreparedStatement createPreparedStatement(Connection con)
		 * throws SQLException { PreparedStatement prepareStatement =
		 * con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		 * prepareStatement.setString(1, test.getName()); return prepareStatement; }
		 * },keyHolder);
		 */
		String sql ="insert into test(NAME) values(:name)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(test);
		namedParameterJdbcTemplate.update(sql, paramSource, keyHolder, new String[] {"ID"});
		System.out.println("返回的主键:"+keyHolder.getKey().intValue());
		return "success";
	}
	
	@GetMapping("jdbc")
	public String jdbc() {
		Haved test = new Haved();
		test.setName("test");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		/*
		 * jdbcTemplate.update(new PreparedStatementCreator() { final String sql =
		 * "insert into haved(NAME) values(?)";
		 * 
		 * @Override public PreparedStatement createPreparedStatement(Connection con)
		 * throws SQLException { PreparedStatement prepareStatement =
		 * con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		 * prepareStatement.setString(1, test.getName()); return prepareStatement; }
		 * },keyHolder);
		 */
		String sql ="insert into haved(NAME) values(:name)";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(test);
		namedParameterJdbcTemplate.update(sql, paramSource, keyHolder, new String[] {"ID"});
		System.out.println("返回的主键:"+keyHolder.getKey().intValue());
		return "success";
	}
	
	
	@GetMapping("haved")
	public String haved() {
		Haved test = new Haved();
		test.setName("test");
		Haved save = havedReposity.save(test);
		if(save == null) {
			return "fail";
		}
		return "success";
	}
	
	@GetMapping("test")
	public String test() {
		Test test = new Test();
		test.setName("test");
		Test save = testReposity.save(test);
		if(save == null) {
			return "fail";
		}
		return "success";
	}
	
	@GetMapping("demo")
	public String demo() {
		AAA entity = new AAA();
		entity.setName("test");
		entity.setLikes("likes");
		entity.setTime(new Date());
		entity.setTest(new Date());
		AAA save = demoReposity.save(entity);
		if(save == null) {
			return "fail";
		}
		return "success";
	}
}
