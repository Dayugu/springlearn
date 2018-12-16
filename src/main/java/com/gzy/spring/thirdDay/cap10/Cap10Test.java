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
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(ConfigCap10.class);
        Calculator ca = app.getBean(Calculator.class);
        try {
            ca.div(2, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        app.close();

    }
}
