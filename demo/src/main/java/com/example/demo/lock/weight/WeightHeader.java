package com.example.demo.lock.weight;

import org.openjdk.jol.info.ClassLayout;

import com.example.demo.lock.A;

public class WeightHeader {
	
	static A a;
	public static void main(String[] args) throws Exception {
		a = new A();
		System.out.println("--- before lock"+ClassLayout.parseInstance(a).toPrintable());
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				synchronized (a) {
					try {
						Thread.sleep(5000);
						System.out.println("--- release lock");
					}catch (Exception ignore) {
					}
				}
			};
		};
		thread.start();
		Thread.sleep(1000);
		//thread   线程内部加锁中
		System.out.println("--- lock ing"+ClassLayout.parseInstance(a).toPrintable()); 
		// 尝试加锁,应该会导致对象信息变化
		sync(); 
		
		System.out.println("--- after lock"+ClassLayout.parseInstance(a).toPrintable());
		
		System.gc();
		System.out.println("--- after gc"+ClassLayout.parseInstance(a).toPrintable());
		
		
//		--- before lockcom.example.demo.lock.A object internals:
//			 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//			      0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//			      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//			      8     4           (object header)                           9f c0 00 f8 (10011111 11000000 00000000 11111000) (-134168417)
//			     12     1   boolean A.flag                                    false
//			     13     3           (loss due to the next object alignment)
//			Instance size: 16 bytes
//			Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//			--- lock ingcom.example.demo.lock.A object internals:
//			 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//			      0     4           (object header)                           b0 ed d9 20 (10110000 11101101 11011001 00100000) (551153072)
//			      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//			      8     4           (object header)                           9f c0 00 f8 (10011111 11000000 00000000 11111000) (-134168417)
//			     12     1   boolean A.flag                                    false
//			     13     3           (loss due to the next object alignment)
//			Instance size: 16 bytes
//			Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//			--- release lock
//			--- main lockcom.example.demo.lock.A object internals:
//			 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//			      0     4           (object header)                           fa e3 74 05 (11111010 11100011 01110100 00000101) (91546618)
//			      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//			      8     4           (object header)                           9f c0 00 f8 (10011111 11000000 00000000 11111000) (-134168417)
//			     12     1   boolean A.flag                                    false
//			     13     3           (loss due to the next object alignment)
//			Instance size: 16 bytes
//			Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//			--- after lockcom.example.demo.lock.A object internals:
//			 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//			      0     4           (object header)                           fa e3 74 05 (11111010 11100011 01110100 00000101) (91546618)
//			      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//			      8     4           (object header)                           9f c0 00 f8 (10011111 11000000 00000000 11111000) (-134168417)
//			     12     1   boolean A.flag                                    false
//			     13     3           (loss due to the next object alignment)
//			Instance size: 16 bytes
//			Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//			--- after gccom.example.demo.lock.A object internals:
//			 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//			      0     4           (object header)                           09 00 00 00 (00001001 00000000 00000000 00000000) (9)
//			      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//			      8     4           (object header)                           9f c0 00 f8 (10011111 11000000 00000000 11111000) (-134168417)
//			     12     1   boolean A.flag                                    false
//			     13     3           (loss due to the next object alignment)
//			Instance size: 16 bytes
//			Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
	}
	
	public static void sync() {
		synchronized (a) {
			System.out.println("--- main lock"+ClassLayout.parseInstance(a).toPrintable());
		}
	}

}
