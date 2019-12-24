package com.example.demo.jvm;

/**
 * GC测试
 */
public class GCTest {

    /**
     * -XX:+PrintGCDetails --打印GC详细日志
     * -Xmn15m --新生代大小
     * -Xmx20m --堆最大大小
     * -Xms20m --堆最小大小
     * @param args
     */
    public static void main(String[] args) {

        byte[] b = null;
        for (int i = 0; i < 11 ; i++) {
            b = new byte[1*1024*1024];
        }

    }
}
