package com.example.demo.single;

/**
 * 懒汉模式
 * @author pc
 *
 */
public class LazySingle {
	
	public volatile static LazySingle instance;
	
	private LazySingle() {
		
	}
	
	/**
	 * 创建对象需要时间，并且非原子操作
	 * @return
	 */
	public static LazySingle getInstance() {
		if(instance == null) {
			instance = new LazySingle();
		}
		return instance;
	}
	
	/**
	 * 比较耗费时间
	 * @return
	 */
	public static  synchronized LazySingle getInstance1() {
		if(instance == null) {
			instance = new LazySingle();
		}
		return instance;
	}
	
	/**
	 * DCL  double check locking
	 * 
	 * 存在编译重排序或者执行重排序的可能
	 * @return
	 */
	public static LazySingle getInstance2() {
		if(instance == null) {
			synchronized (LazySingle.class) {
				if(instance == null) {
					instance = new LazySingle();
				}
			}
		}
		return instance;
	}

}
