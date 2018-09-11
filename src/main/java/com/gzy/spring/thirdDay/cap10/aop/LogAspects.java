package com.gzy.spring.thirdDay.cap10.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Discribe 日志切面类
 * @Author gzy
 * @Date 2018/9/11 17:48
 */
@Aspect
public class LogAspects {

    @Before("execution(public int com.gzy.spring.thirdDay.cap10.aop.Calculator.div(int,int))")
    public void logStart(){
        System.out.println("除法运行......");
    }
    @After("execution(public int com.gzy.spring.thirdDay.cap10.aop.Calculator.div(int,int))")
    public void logEnd(){

    }




}
