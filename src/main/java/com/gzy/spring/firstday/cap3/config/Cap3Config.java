package com.gzy.spring.firstday.cap3.config;

import com.gzy.spring.firstday.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.gzy.spring.firstday.cap3")
public class Cap3Config {

    /**
     *  prototype：多实例，IOC容器启动的时候，IOC容器并不会调用方法创建对象，而是每次获取的时候才去创建
     *  singleton: 单实例（默认），IOC容器启动的时候会调用方法创建对象并放在IOC容器中，以后每次获取的就是直接从容器中拿同一个bean
     *  request：主要针对web，递交一次请求创建一个实例
     *  session: 同一个session创建一个实例
     * @return
     */
    @Scope("prototype")
    @Bean
    public Person getPerson(){
        return new Person("gzy",18);
    };
}
