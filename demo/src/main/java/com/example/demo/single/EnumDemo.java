package com.example.demo.single;

public class EnumDemo {

	/**
	 * 内部类延迟加载
	 * @author pc
	 *
	 */
	private enum EnumHolder{
		INSTANCE;
		private EnumDemo instance;
		
		EnumHolder(){
			//调用的时候才会实例化
			
			System.out.println("内部类实例化");
			instance = new EnumDemo();
		} 
		
		private EnumDemo getInstance() {
			return instance;
		}
	}
	
	public static EnumDemo getInstance() {
		return EnumHolder.INSTANCE.getInstance();
	}
	
	public static void main(String[] args) {
		EnumDemo.getInstance();
	}
}
