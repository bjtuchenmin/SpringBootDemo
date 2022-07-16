package com.example.demo.aop;

/**
 * AOP 中的 business object，即执行逻辑业务的类
 */
public class SimpleAdder {
    public int add(int a, int b) {
        System.out.println("---- Now add a and b -----");
        return a + b;
    }
}
