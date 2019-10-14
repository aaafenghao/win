package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "AAA")
public class AAA {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TIME")
	private Date time;
	@Column(name = "TEST")
	private Date test;
	@Column(name = "LIKES")
	private String likes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getTest() {
		return test;
	}
	public void setTest(Date test) {
		this.test = test;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	
	
	

}
