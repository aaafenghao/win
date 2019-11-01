package com.example.demo.single;

/**
 * Holder模式
 * @author pc
 *
 */
public class HolderSingle {
	
	private HolderSingle() {
		System.out.println("外部类构造函数初始化");
	}
	

	private static class Holder{
		/**
		 * 调用的时候才会实例化
		 */
		private static HolderSingle instance = new HolderSingle();
		
		
	}
	public static HolderSingle getInstance() {
		return Holder.instance;
	}
	
	public static void main(String[] args) {
		
	}

}
