package com.example.demo.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void testAOP() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("aopConfig.xml");
        Object logicObject = applicationContext.getBean("logicObject");
        SimpleAdder simpleAdder = (SimpleAdder) logicObject;
        simpleAdder.add(4,6);
    }
}
