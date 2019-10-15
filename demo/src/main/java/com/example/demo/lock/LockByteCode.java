package com.example.demo.lock;

public class LockByteCode {
	
	public synchronized void accessResource() {
		int i = 0;
	   i=i+1;
	}
	
	static A a;
	public void accessResource1() {
		a = new A();
		synchronized (a) {
			int i=0;
			i=i+1;
		}
	}
	
	
//	Classfile /D:/ysstech/eclipse-workspace/demo/target/classes/com/example/demo/lock/LockByteCode.class
//	  Last modified 2019-10-15; size 712 bytes
//	  MD5 checksum 0e4e2c7c2e24a0b844c9c15411033c8b
//	  Compiled from "LockByteCode.java"
//	public class com.example.demo.lock.LockByteCode
//	  minor version: 0
//	  major version: 52
//	  flags: ACC_PUBLIC, ACC_SUPER
//	Constant pool:                                                                                                                 --常量池
//	   #1 = Class              #2             // com/example/demo/lock/LockByteCode
//	   #2 = Utf8               com/example/demo/lock/LockByteCode
//	   #3 = Class              #4             // java/lang/Object
//	   #4 = Utf8               java/lang/Object
//	   #5 = Utf8               a
//	   #6 = Utf8               Lcom/example/demo/lock/A;
//	   #7 = Utf8               <init>
//	   #8 = Utf8               ()V
//	   #9 = Utf8               Code
//	  #10 = Methodref          #3.#11         // java/lang/Object."<init>":()V
//	  #11 = NameAndType        #7:#8          // "<init>":()V
//	  #12 = Utf8               LineNumberTable
//	  #13 = Utf8               LocalVariableTable
//	  #14 = Utf8               this
//	  #15 = Utf8               Lcom/example/demo/lock/LockByteCode;
//	  #16 = Utf8               accessResource
//	  #17 = Utf8               i
//	  #18 = Utf8               I
//	  #19 = Utf8               accessResource1
//	  #20 = Class              #21            // com/example/demo/lock/A
//	  #21 = Utf8               com/example/demo/lock/A
//	  #22 = Methodref          #20.#11        // com/example/demo/lock/A."<init>":()V
//	  #23 = Fieldref           #1.#24         // com/example/demo/lock/LockByteCode.a:Lcom/example/demo/lock/A;
//	  #24 = NameAndType        #5:#6          // a:Lcom/example/demo/lock/A;
//	  #25 = Utf8               StackMapTable
//	  #26 = Class              #27            // java/lang/Throwable
//	  #27 = Utf8               java/lang/Throwable
//	  #28 = Utf8               SourceFile
//	  #29 = Utf8               LockByteCode.java
//	{
//	  static com.example.demo.lock.A a;
//	    descriptor: Lcom/example/demo/lock/A;
//	    flags: ACC_STATIC
//
//	  public com.example.demo.lock.LockByteCode();
//	    descriptor: ()V
//	    flags: ACC_PUBLIC
//	    Code:
//	      stack=1, locals=1, args_size=1
//	         0: aload_0
//	         1: invokespecial #10                 // Method java/lang/Object."<init>":()V
//	         4: return
//	      LineNumberTable:
//	        line 3: 0
//	      LocalVariableTable:
//	        Start  Length  Slot  Name   Signature
//	            0       5     0  this   Lcom/example/demo/lock/LockByteCode;
//
//	  public synchronized void accessResource();
//	    descriptor: ()V
//	    flags: ACC_PUBLIC, ACC_SYNCHRONIZED                                                              --ACC_SYNCHRONIZED  方法加锁关键字
//	    Code:
//	      stack=1, locals=2, args_size=1
//	         0: iconst_0
//	         1: istore_1
//	         2: iinc          1, 1
//	         5: return
//	      LineNumberTable:
//	        line 6: 0
//	        line 7: 2
//	        line 8: 5
//	      LocalVariableTable:
//	        Start  Length  Slot  Name   Signature
//	            0       6     0  this   Lcom/example/demo/lock/LockByteCode;
//	            2       4     1     i   I
//
//	  public void accessResource1();
//	    descriptor: ()V
//	    flags: ACC_PUBLIC
//	    Code:
//	      stack=2, locals=3, args_size=1
//	         0: new           #20                 // class com/example/demo/lock/A
//	         3: dup
//	         4: invokespecial #22                 // Method com/example/demo/lock/A."<init>":()V
//	         7: putstatic     #23                 // Field a:Lcom/example/demo/lock/A;
//	        10: getstatic     #23                 // Field a:Lcom/example/demo/lock/A;
//	        13: dup
//	        14: astore_1
//	        15: monitorenter                                                                                   -- 加锁
//	        16: iconst_0
//	        17: istore_2
//	        18: iinc          2, 1
//	        21: aload_1
//	        22: monitorexit                                                                                      --释放锁
//	        23: goto          29
//	        26: aload_1
//	        27: monitorexit                                                                                      --异常情况下释放锁
//	        28: athrow
//	        29: return
//	      Exception table:
//	         from    to  target type
//	            16    23    26   any
//	            26    28    26   any
//	      LineNumberTable:
//	        line 12: 0
//	        line 13: 10
//	        line 14: 16
//	        line 15: 18
//	        line 13: 21
//	        line 17: 29
//	      LocalVariableTable:
//	        Start  Length  Slot  Name   Signature
//	            0      30     0  this   Lcom/example/demo/lock/LockByteCode;
//	           18       3     2     i   I
//	      StackMapTable: number_of_entries = 2
//	        frame_type = 255 /* full_frame */
//	          offset_delta = 26
//	          locals = [ class com/example/demo/lock/LockByteCode, class com/example/demo/lock/A ]
//	          stack = [ class java/lang/Throwable ]
//	        frame_type = 250 /* chop */
//	          offset_delta = 2
//	}
//	SourceFile: "LockByteCode.java"


}
