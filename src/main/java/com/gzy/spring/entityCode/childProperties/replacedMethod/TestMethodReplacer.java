package com.gzy.spring.entityCode.childProperties.replacedMethod;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/9/28 10:30
 */
public class TestMethodReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println("I'm changeMethod");
        return null;
    }
}
