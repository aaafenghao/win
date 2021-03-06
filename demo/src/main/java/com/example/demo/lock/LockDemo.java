package com.example.demo.lock;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * 
 *   主要是了解偏向锁，轻量级锁，重量级锁
 *   
 *      锁标志位:
 *                    偏向锁:01
 *                   轻量级锁:00
 *                   重量级锁:10
 * @author pc
 * 
 *      偏向锁:当存在多线程竞争的时候--膨胀成轻量级锁，之后再某个安全点进行偏向锁撤销
 *
 */
public class LockDemo {
	
	public static void main(String[] args) {
		System.out.println(VM.current().details());
		System.out.println(ClassLayout.parseClass(A.class).toPrintable());
		
//		# Running 64-bit HotSpot VM.
//		# Using compressed klass with 3-bit shift.                              //使用压缩KClass 和3个位移
//		# Objects are 8 bytes aligned.                                          //对象是8字节对齐
//		# Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
//		# Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
//
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE     //对象头
//		      0    12        (object header)                           N/A
//		     12     4        (loss due to the next object alignment)             //对齐字节
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 4 bytes external = 4 bytes total        //空间损失
		
		// 添加一个Boolean类型的字段，之后的打印结果
		
//		# Running 64-bit HotSpot VM.
//		# Using compressed oop with 3-bit shift.
//		# Using compressed klass with 3-bit shift.
//		# Objects are 8 bytes aligned.
//		# Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
//		# Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
//
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//		      0    12           (object header)                           N/A
//		     12     1   boolean A.flag                                    N/A    //实例数据
//		     13     3           (loss due to the next object alignment)
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
		
		//结论--对象的布局-->对象头,实例数据,补全字节(可能会没有)
		
		
		

	}

}
