package com.gzy.spring.thirdDay.cap9.test;

import com.gzy.spring.thirdDay.cap9.bean.Moon;
import com.gzy.spring.thirdDay.cap9.bean.Sun;
import com.gzy.spring.thirdDay.cap9.config.Config;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/9/11 16:50
 */
public class TestCap9 {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new  AnnotationConfigApplicationContext(Config.class);

        //String applicationName = applicationContext.getApplicationName();

        //System.out.println(applicationName);
       /* Moon moon = (Moon)applicationContext.getBean(Moon.class);
        System.out.println(moon);
        Sun sun = applicationContext.getBean(Sun.class);
        System.out.println(sun);

        System.out.println(sun.getMoon());*/

        applicationContext.close();

    }
}
