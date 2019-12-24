package com.example.demo.jvm;

public class Son extends Parent {

    static {
        System.out.println("son ...");
    }

    public static void testMethod(){
        System.out.println("test mehod son ...");
    }
}
