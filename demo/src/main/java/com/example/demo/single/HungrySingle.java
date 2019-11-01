package com.example.demo.single;

/**
 * 饿汉模式
 * @author pc
 *
 */
public class HungrySingle {
	
	public static final HungrySingle instance = new HungrySingle();
	
	private HungrySingle() {
		
	}
	
	public HungrySingle getInstance() {
		return instance;
	}

}
