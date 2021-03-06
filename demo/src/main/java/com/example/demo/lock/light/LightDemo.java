package com.example.demo.lock.light;

import org.openjdk.jol.info.ClassLayout;

import com.example.demo.lock.A;
/**
 *     轻量级锁  自旋锁--达到一定次数，直接膨胀为重量级锁
 *                      自适应自旋锁 -- 适应当前环境，或自选次数增加，或直接膨胀成重量级锁
 *                      
 *                      -XX:UseBiasedLocking
 *                      -XX:BiasedLockingStartupDelay=0
 *                      
 *                      下面的转换成轻量级锁是因为偏向锁延迟，如果虚拟机启动的时候，偏向锁没有延迟，下面的代码是不会转换成轻量级锁的
 * @author pc
 *
 */
public class LightDemo {
	
	static A a;
	public static void main(String[] args) {
//		B b = new B();
//		StopWatch process = new StopWatch();
//		process.start();
//		for (int i = 0; i < 1000000000L; i++) {
//			b.parse();
//		}
//		process.stop();
//		System.out.println("process time "+process.getTotalTimeMillis());
		a = new A();
		System.out.println("--- lock before");
		System.out.println(ClassLayout.parseInstance(a).toPrintable());
		
		sync();
		System.out.println("--- lock after");
		System.out.println(ClassLayout.parseInstance(a).toPrintable());
		
//		--- lock before
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
//		--- lock ing
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//		      0     4           (object header)                           70 f0 84 02 (01110000 11110000 10000100 00000010) (42266736)
//		      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//		      8     4           (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
//		     12     1   boolean A.flag                                    false
//		     13     3           (loss due to the next object alignment)
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//		--- lock after
//		com.example.demo.lock.A object internals:
//		 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//		      0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//		      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//		      8     4           (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
//		     12     1   boolean A.flag                                    false
//		     13     3           (loss due to the next object alignment)
//		Instance size: 16 bytes
//		Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
		
	}
	
	public static void sync() {
		synchronized (a) {
			System.out.println("--- lock ing");
			System.out.println(ClassLayout.parseInstance(a).toPrintable());
		}
	}

}
