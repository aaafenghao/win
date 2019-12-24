package com.example.demo.jvm;

public class ClassLoadTest {

    static {
        System.out.println("classload init ...");
    }

    /**
     * -XX:+TraceClassLoading
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main ...");

//        System.out.println(Son.age);

//        new Son();
//        Parent son = new Son();

//        Son.testMethod();
        //父类初始化
        //子类初始化
        //常量不会对类的初始化有影响
//        Parent[] parents = new Parent[10];

        System.out.println(Parent.name);//
    }
}
