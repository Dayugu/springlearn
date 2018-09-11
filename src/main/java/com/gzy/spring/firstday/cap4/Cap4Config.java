package com.gzy.spring.firstday.cap4;

import com.gzy.spring.firstday.Person;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = "com.gzy.spring.firstday.cap4")
public class Cap4Config {

    /**
      * 懒加载: 主要针对单实例bean:默认在容器启动的时候创建对象
      * 懒加载: 容器启动时候不创建对象, 仅当第一次使用(获取)bean的时候才创建被初始化
      */
    @Lazy
    @Bean
    public Person getPerson(){
        System.out.println("spring容器开始创建person对象");
        return new Person("gzy",18);
    }
}
