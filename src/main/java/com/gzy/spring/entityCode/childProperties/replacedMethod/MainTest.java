package com.gzy.spring.entityCode.childProperties.replacedMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/9/28 10:37
 */
public class MainTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("entityCode/replacedMethod/replacerTest.xml");

        TestChangeMethod testChangeMethod = (TestChangeMethod)context.getBean("testChangeMethod");

        testChangeMethod.changeMe();

    }
}
