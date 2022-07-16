package com.example.demo.beanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean 配置的3种方式之一：使用Java配置，类使用@Configuration注解，方法使用@Bean注解
 */
@Configuration
public class TestJavaConfig {
    @Bean
    public Integer beanConfiguredByJava() {
        System.out.println("-------- 使用 Java 代码配置 bean，在启动时自动执行 -------");
        return Integer.bitCount(200);
    }
}
