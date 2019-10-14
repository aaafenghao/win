package com.example.demo.lock.weight;

import org.openjdk.jol.info.ClassLayout;

import com.example.demo.lock.A;

public class WeightHeaderWait {
	
	static A a;
	public static void main(String[] args) throws Exception{
		a = new A();
		System.out.println("---before lock "+ClassLayout.parseInstance(a).toPrintable());
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				synchronized (a) {
					try {
						synchronized (a) {
							System.out.println("--- before wait "+ClassLayout.parseInstance(a).toPrintable());
							a.wait();
							System.out.println("--- after wait "+ClassLayout.parseInstance(a).toPrintable());
						}
						
					}catch (Exception ignore) {
					}
				}
			};
		};
		thread.start();
		Thread.sleep(5000);
		synchronized (a) {
			a.notifyAll();
		}
		
		
//		---before lock com.example.demo.lock.A object internals:
//			 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//			      0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//			      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//			      8     4           (object header)                           9f c0 00 f8 (10011111 11000000 00000000 11111000) (-134168417)
//			     12     1   boolean A.flag                                    false
//			     13     3           (loss due to the next object alignment)
//			Instance size: 16 bytes
//			Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//			--- before wait com.example.demo.lock.A object internals:
//			 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//			      0     4           (object header)                           10 f4 f0 20 (00010000 11110100 11110000 00100000) (552662032)
//			      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//			      8     4           (object header)                           9f c0 00 f8 (10011111 11000000 00000000 11111000) (-134168417)
//			     12     1   boolean A.flag                                    false
//			     13     3           (loss due to the next object alignment)
//			Instance size: 16 bytes
//			Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
//
//			--- after wait com.example.demo.lock.A object internals:
//			 OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
//			      0     4           (object header)                           4a 25 64 05 (01001010 00100101 01100100 00000101) (90449226)
//			      4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//			      8     4           (object header)                           9f c0 00 f8 (10011111 11000000 00000000 11111000) (-134168417)
//			     12     1   boolean A.flag                                    false
//			     13     3           (loss due to the next object alignment)
//			Instance size: 16 bytes
//			Space losses: 0 bytes internal + 3 bytes external = 3 bytes total
		
		
	}

}
