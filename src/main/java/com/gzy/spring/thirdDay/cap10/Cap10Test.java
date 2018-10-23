package com.gzy.spring.thirdDay.cap10;

import com.gzy.spring.thirdDay.cap10.aop.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/9/11 17:51
 */
public class Cap10Test {

    @Test
    public  void test01(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(ConfigCap10.class);

        Calculator calculator = app.getBean(Calculator.class);

        int result = calculator.div(2, 1);

        System.out.println("result = "+result);

        app.close();

    }
    public void test(){

    }
}
