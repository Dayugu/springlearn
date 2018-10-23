package com.gzy.spring.thirdDay.cap10.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Discribe 日志切面类
 * @Author gzy
 * @Date 2018/9/11 17:48
 */
@Aspect
public class LogAspects {

    @Before("execution(public int com.gzy.spring.thirdDay.cap10.aop.Calculator.div(int,int))")
    public void logStart(){
        System.out.println("除法运行......logStart");
    }
    @After("execution(public int com.gzy.spring.thirdDay.cap10.aop.Calculator.div(int,int))")
    public void logEnd(){
        System.out.println("除法运行......logEnd");
    }

    @Around("execution(public int com.gzy.spring.thirdDay.cap10.aop.Calculator.*(..))")
    public Object logArround(ProceedingJoinPoint p){
        System.out.println("除法运行......logArround....before");
        Object result = null;
        try {
            result = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("除法运行......logArround....after");
        return result;
    }

    @Pointcut("execution(* *.div(..))")
    public void ponitCut(){
        System.out.println("除法运行......pointcuit");

    }



}

