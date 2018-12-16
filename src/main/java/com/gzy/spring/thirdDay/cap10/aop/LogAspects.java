package com.gzy.spring.thirdDay.cap10.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Discribe 日志切面类
 * @Author gzy
 * @Date 2018/9/11 17:48
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.gzy.spring.thirdDay.cap10.aop.Calculator.div(int,int))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void logStart(JoinPoint joinPoint) {

        System.out.println("logbefore,method:"+joinPoint.getSignature()+" params: "+joinPoint.getArgs().toString());
    }

    @After("pointcut()")
    public void logEnd() {
        System.out.println("logend .....");
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void logReturn(Object result) {
        System.out.println("logreturn result =...."+result);
    }

    @AfterThrowing(value="pointcut()",throwing="exception")
    public void logException(Exception exception){
        System.out.println("运行异常......异常信息是:{"+exception+"}");
    }

    @Around("pointcut()")
    public Object LogAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("pointcut before...");
        Object result = point.proceed();
        System.out.println("around result = "+result);
        System.out.println("pointcut after....");
        return result;

    }


}
