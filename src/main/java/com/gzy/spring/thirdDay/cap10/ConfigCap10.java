package com.gzy.spring.thirdDay.cap10;

import org.springframework.context.annotation.Configuration;

/**
 * @Discribe 日志切面类的方法需要动态感知div()方法运行
 *             通知方法：
 *                  前置通知 logStart() 在执行div（）除法之前运行 @Before
 *                  后置通知 logEnd() 在目标方法结束之后，不管有没有异常都要执行。 @After
 *                  返回通知 logReturn() 在目标方法正常执行后执行。  @AfterReturn
 *                  异常通知 logException() 在目标方法出现异常时执行    @AfterThrowing
 *                  环绕通知 动态代理，需要手动执行joinPoint.proceed() @Around
 * @Author gzy
 * @Date 2018/9/11 17:45
 */
@Configuration
public class ConfigCap10 {
}
