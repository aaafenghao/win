package com.example.demo.lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁相关
 * @author pc
 *
 */
public class BiasDemo {
	static A a;
	public static void main(String[] args) throws InterruptedException {
//		Thread.sleep(5000);
		a = new A();
		System.out.println("---lock before");
		System.out.println(ClassLayout.parseInstance(a).toPrintable());
		System.out.println("---lock after");
		System.out.println(ClassLayout.parseInstance(a).toPrintable());
		
		
//		---lock before
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
//		---lock after
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//		      0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//		      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//		      8     4           (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
//		     12     1   boolean A.flag                                    false
//		     13     3           (loss due to the next object alignment)
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
		
		//第一个字节一样的
		
		//加上睡眠时间
//		---lock before
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//		      0     4           (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
//		      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//		      8     4           (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
//		     12     1   boolean A.flag                                    false
//		     13     3           (loss due to the next object alignment)
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//		---lock after
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//		      0     4           (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
//		      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//		      8     4           (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
//		     12     1   boolean A.flag                                    false
//		     13     3           (loss due to the next object alignment)
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
	}
	
	public static void sync(Object obj) {
		synchronized(obj) {
			System.out.println("随便打印点啥...");
		}
	}

}
