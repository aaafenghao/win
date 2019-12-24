package com.example.demo.jvm;

public class Parent {

    public static String age = "10";

    public static final String name ="110";

    static {
        System.out.println("parent ...");
    }

    public static void  testMethod(){
        System.out.println("test method");
    }
}
