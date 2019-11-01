package com.example.demo.lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * 对象头---包括mark word 和 kClass word  在64位机器上的大小是12字节(经过压缩)
 * @author pc
 *
 */
public class HeaderDemo {
	
	public static void main(String[] args) {
		//无锁状态下的mark word
		A a = new A();
		System.out.println("before hash");
		System.out.println(ClassLayout.parseInstance(a).toPrintable());
		//计算hash
		System.out.println("JVM---"+Integer.toHexString(a.hashCode()));
		System.out.println("after hash");
		System.out.println(ClassLayout.parseInstance(a).toPrintable());
		
//		before hash
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//		      0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//		      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//		      8     4           (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
//		     12     1   boolean A.flag                                    false
//		     13     3           (loss due to the next object alignment)
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//		JVM---5e91993f
//		after hash
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//		      0     4           (object header)                           01 3f 99 91 (00000001 00111111 10011001 10010001) (-1852227839)
//		      4     4           (object header)                           5e 00 00 00 (01011110 00000000 00000000 00000000) (94)
//		      8     4           (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
//		     12     1   boolean A.flag                                    false
//		     13     3           (loss due to the next object alignment)
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
		
		//1-7有值，0-6没有值-->应该是小端存储
		
		//第0个字节主要存储了分代年龄，偏向锁信息，对象状态
		
		//00000001--无锁状态
		
		//第0个字节8位:
//		                下标:0没用
//		                下标1-4:分代年龄
//		                下标5-5:偏向锁
//		                下标6-7:锁标志位
		
		
	}

}
