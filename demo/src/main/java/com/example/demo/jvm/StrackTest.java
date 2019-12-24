package com.example.demo.jvm;

public class StrackTest {

    public static int index = 0;

    public static void digui(){
        index ++;
        digui();
    }

    /**
     * -Xss1024k
     * 64位的机器上每个线程的栈大小默认是1m
     * @param args
     */
    public static void main(String[] args) {
        try {
            digui();
        }catch (Throwable throwable){
            System.out.println("栈深度:"+index);
            throwable.printStackTrace();
        }
    }
}
