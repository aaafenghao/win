package com.example.demo.uc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 多线程对同一个变量进行计算
 * 每个线程都能获取到其他线程对改变量修改的最新的值
 * @author pc
 *
 */
public class VolatileDemo implements Runnable {
	
	public static volatile int ia = 0;
	static CountDownLatch latch = new CountDownLatch(1);
	
	public static  ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
	
	public static void main(String[] args) throws Exception {
		VolatileDemo demo = new VolatileDemo();
		VolatileDemo demo1 = new VolatileDemo();
		VolatileDemo demo2 = new VolatileDemo();
		pool.execute(demo);
		pool.execute(demo1);
		pool.execute(demo2);
	   System.out.println(ia);
	   pool.shutdown();
	   
	   
	   
//	   Classfile /D:/ysstech/eclipse-workspace/demo/target/classes/com/example/demo/uc/VolatileDemo.class
//	   Last modified 2019-10-16; size 1536 bytes
//	   MD5 checksum 83988e73563f984a929afdd715fe9cb4
//	   Compiled from "VolatileDemo.java"
//	 public class com.example.demo.uc.VolatileDemo implements java.lang.Runnable
//	   minor version: 0
//	   major version: 52
//	   flags: ACC_PUBLIC, ACC_SUPER
//	 Constant pool:                                                                                                     --常量池
//	    #1 = Class              #2             // com/example/demo/uc/VolatileDemo
//	    #2 = Utf8               com/example/demo/uc/VolatileDemo
//	    #3 = Class              #4             // java/lang/Object
//	    #4 = Utf8               java/lang/Object
//	    #5 = Class              #6             // java/lang/Runnable
//	    #6 = Utf8               java/lang/Runnable
//	    #7 = Utf8               ia
//	    #8 = Utf8               I
//	    #9 = Utf8               latch
//	   #10 = Utf8               Ljava/util/concurrent/CountDownLatch;
//	   #11 = Utf8               pool
//	   #12 = Utf8               Ljava/util/concurrent/ExecutorService;
//	   #13 = Utf8               <clinit>
//	   #14 = Utf8               ()V
//	   #15 = Utf8               Code
//	   #16 = Fieldref           #1.#17         // com/example/demo/uc/VolatileDemo.ia:I
//	   #17 = NameAndType        #7:#8          // ia:I
//	   #18 = Class              #19            // java/util/concurrent/CountDownLatch
//	   #19 = Utf8               java/util/concurrent/CountDownLatch
//	   #20 = Methodref          #18.#21        // java/util/concurrent/CountDownLatch."<init>":(I)V
//	   #21 = NameAndType        #22:#23        // "<init>":(I)V
//	   #22 = Utf8               <init>
//	   #23 = Utf8               (I)V
//	   #24 = Fieldref           #1.#25         // com/example/demo/uc/VolatileDemo.latch:Ljava/util/concurrent/CountDownLatch;
//	   #25 = NameAndType        #9:#10         // latch:Ljava/util/concurrent/CountDownLatch;
//	   #26 = Methodref          #27.#29        // java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
//	   #27 = Class              #28            // java/lang/Runtime
//	   #28 = Utf8               java/lang/Runtime
//	   #29 = NameAndType        #30:#31        // getRuntime:()Ljava/lang/Runtime;
//	   #30 = Utf8               getRuntime
//	   #31 = Utf8               ()Ljava/lang/Runtime;
//	   #32 = Methodref          #27.#33        // java/lang/Runtime.availableProcessors:()I
//	   #33 = NameAndType        #34:#35        // availableProcessors:()I
//	   #34 = Utf8               availableProcessors
//	   #35 = Utf8               ()I
//	   #36 = Methodref          #37.#39        // java/util/concurrent/Executors.newFixedThreadPool:(I)Ljava/util/concurrent/ExecutorService;
//	   #37 = Class              #38            // java/util/concurrent/Executors
//	   #38 = Utf8               java/util/concurrent/Executors
//	   #39 = NameAndType        #40:#41        // newFixedThreadPool:(I)Ljava/util/concurrent/ExecutorService;
//	   #40 = Utf8               newFixedThreadPool
//	   #41 = Utf8               (I)Ljava/util/concurrent/ExecutorService;
//	   #42 = Fieldref           #1.#43         // com/example/demo/uc/VolatileDemo.pool:Ljava/util/concurrent/ExecutorService;
//	   #43 = NameAndType        #11:#12        // pool:Ljava/util/concurrent/ExecutorService;
//	   #44 = Utf8               LineNumberTable
//	   #45 = Utf8               LocalVariableTable
//	   #46 = Methodref          #3.#47         // java/lang/Object."<init>":()V
//	   #47 = NameAndType        #22:#14        // "<init>":()V
//	   #48 = Utf8               this
//	   #49 = Utf8               Lcom/example/demo/uc/VolatileDemo;
//	   #50 = Utf8               main
//	   #51 = Utf8               ([Ljava/lang/String;)V
//	   #52 = Utf8               Exceptions
//	   #53 = Class              #54            // java/lang/Exception
//	   #54 = Utf8               java/lang/Exception
//	   #55 = Methodref          #1.#47         // com/example/demo/uc/VolatileDemo."<init>":()V
//	   #56 = InterfaceMethodref #57.#59        // java/util/concurrent/ExecutorService.execute:(Ljava/lang/Runnable;)V
//	   #57 = Class              #58            // java/util/concurrent/ExecutorService
//	   #58 = Utf8               java/util/concurrent/ExecutorService
//	   #59 = NameAndType        #60:#61        // execute:(Ljava/lang/Runnable;)V
//	   #60 = Utf8               execute
//	   #61 = Utf8               (Ljava/lang/Runnable;)V
//	   #62 = Fieldref           #63.#65        // java/lang/System.out:Ljava/io/PrintStream;
//	   #63 = Class              #64            // java/lang/System
//	   #64 = Utf8               java/lang/System
//	   #65 = NameAndType        #66:#67        // out:Ljava/io/PrintStream;
//	   #66 = Utf8               out
//	   #67 = Utf8               Ljava/io/PrintStream;
//	   #68 = Methodref          #69.#71        // java/io/PrintStream.println:(I)V
//	   #69 = Class              #70            // java/io/PrintStream
//	   #70 = Utf8               java/io/PrintStream
//	   #71 = NameAndType        #72:#23        // println:(I)V
//	   #72 = Utf8               println
//	   #73 = Utf8               args
//	   #74 = Utf8               [Ljava/lang/String;
//	   #75 = Utf8               demo
//	   #76 = Utf8               demo1
//	   #77 = Utf8               demo2
//	   #78 = Utf8               MethodParameters
//	   #79 = Utf8               run
//	   #80 = Utf8               i
//	   #81 = Utf8               StackMapTable
//	   #82 = Utf8               SourceFile
//	   #83 = Utf8               VolatileDemo.java
//	 {
//	   public static volatile int ia;
//	     descriptor: I
//	     flags: ACC_PUBLIC, ACC_STATIC, ACC_VOLATILE
//
//	   static java.util.concurrent.CountDownLatch latch;
//	     descriptor: Ljava/util/concurrent/CountDownLatch;
//	     flags: ACC_STATIC
//
//	   public static java.util.concurrent.ExecutorService pool;
//	     descriptor: Ljava/util/concurrent/ExecutorService;
//	     flags: ACC_PUBLIC, ACC_STATIC
//
//	   static {};
//	     descriptor: ()V
//	     flags: ACC_STATIC
//	     Code:
//	       stack=3, locals=0, args_size=0
//	          0: iconst_0
//	          1: putstatic     #16                 // Field ia:I
//	          4: new           #18                 // class java/util/concurrent/CountDownLatch
//	          7: dup
//	          8: iconst_1
//	          9: invokespecial #20                 // Method java/util/concurrent/CountDownLatch."<init>":(I)V
//	         12: putstatic     #24                 // Field latch:Ljava/util/concurrent/CountDownLatch;
//	         15: invokestatic  #26                 // Method java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
//	         18: invokevirtual #32                 // Method java/lang/Runtime.availableProcessors:()I
//	         21: iconst_2
//	         22: imul
//	         23: invokestatic  #36                 // Method java/util/concurrent/Executors.newFixedThreadPool:(I)Ljava/util/concurrent/ExecutorService;
//	         26: putstatic     #42                 // Field pool:Ljava/util/concurrent/ExecutorService;
//	         29: return
//	       LineNumberTable:
//	         line 16: 0
//	         line 17: 4
//	         line 19: 15
//	       LocalVariableTable:
//	         Start  Length  Slot  Name   Signature
//
//	   public com.example.demo.uc.VolatileDemo();
//	     descriptor: ()V
//	     flags: ACC_PUBLIC
//	     Code:
//	       stack=1, locals=1, args_size=1
//	          0: aload_0
//	          1: invokespecial #46                 // Method java/lang/Object."<init>":()V
//	          4: return
//	       LineNumberTable:
//	         line 14: 0
//	       LocalVariableTable:
//	         Start  Length  Slot  Name   Signature
//	             0       5     0  this   Lcom/example/demo/uc/VolatileDemo;
//
//	   public static void main(java.lang.String[]) throws java.lang.Exception;
//	     descriptor: ([Ljava/lang/String;)V
//	     flags: ACC_PUBLIC, ACC_STATIC
//	     Exceptions:
//	       throws java.lang.Exception
//	     Code:
//	       stack=2, locals=4, args_size=1
//	          0: new           #1                  // class com/example/demo/uc/VolatileDemo
//	          3: dup
//	          4: invokespecial #55                 // Method "<init>":()V
//	          7: astore_1
//	          8: new           #1                  // class com/example/demo/uc/VolatileDemo
//	         11: dup
//	         12: invokespecial #55                 // Method "<init>":()V
//	         15: astore_2
//	         16: new           #1                  // class com/example/demo/uc/VolatileDemo
//	         19: dup
//	         20: invokespecial #55                 // Method "<init>":()V
//	         23: astore_3
//	         24: getstatic     #42                 // Field pool:Ljava/util/concurrent/ExecutorService;
//	         27: aload_1
//	         28: invokeinterface #56,  2           // InterfaceMethod java/util/concurrent/ExecutorService.execute:(Ljava/lang/Runnable;)V
//	         33: getstatic     #42                 // Field pool:Ljava/util/concurrent/ExecutorService;
//	         36: aload_2
//	         37: invokeinterface #56,  2           // InterfaceMethod java/util/concurrent/ExecutorService.execute:(Ljava/lang/Runnable;)V
//	         42: getstatic     #42                 // Field pool:Ljava/util/concurrent/ExecutorService;
//	         45: aload_3
//	         46: invokeinterface #56,  2           // InterfaceMethod java/util/concurrent/ExecutorService.execute:(Ljava/lang/Runnable;)V
//	         51: getstatic     #62                 // Field java/lang/System.out:Ljava/io/PrintStream;
//	         54: getstatic     #16                 // Field ia:I
//	         57: invokevirtual #68                 // Method java/io/PrintStream.println:(I)V
//	         60: return
//	       LineNumberTable:
//	         line 22: 0
//	         line 23: 8
//	         line 24: 16
//	         line 25: 24
//	         line 26: 33
//	         line 27: 42
//	         line 28: 51
//	         line 29: 60
//	       LocalVariableTable:
//	         Start  Length  Slot  Name   Signature
//	             0      61     0  args   [Ljava/lang/String;
//	             8      53     1  demo   Lcom/example/demo/uc/VolatileDemo;
//	            16      45     2 demo1   Lcom/example/demo/uc/VolatileDemo;
//	            24      37     3 demo2   Lcom/example/demo/uc/VolatileDemo;
//	     MethodParameters:
//	       Name                           Flags
//	       args
//
//	   public void run();
//	     descriptor: ()V
//	     flags: ACC_PUBLIC
//	     Code:
//	       stack=2, locals=2, args_size=1
//	          0: iconst_0
//	          1: istore_1
//	          2: goto          16
//	          5: getstatic     #16                 // Field ia:I
//	          8: iconst_1
//	          9: iadd
//	         10: putstatic     #16                 // Field ia:I
//	         13: iinc          1, 1
//	         16: iload_1
//	         17: sipush        1000
//	         20: if_icmplt     5
//	         23: return
//	       LineNumberTable:
//	         line 33: 0
//	         line 34: 5
//	         line 33: 13
//	         line 36: 23
//	       LocalVariableTable:
//	         Start  Length  Slot  Name   Signature
//	             0      24     0  this   Lcom/example/demo/uc/VolatileDemo;
//	             2      21     1     i   I
//	       StackMapTable: number_of_entries = 2
//	         frame_type = 252 /* append */
//	           offset_delta = 5
//	           locals = [ int ]
//	         frame_type = 10 /* same */
//	 }
//	 SourceFile: "VolatileDemo.java"

	}	
	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			ia++;
		}
	}

}
