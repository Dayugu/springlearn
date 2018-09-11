package com.gzy.spring.firstday.cap2.config;

import com.gzy.spring.firstday.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.gzy.spring.firstday.cap2")
public class Cap2Config {
    @Bean("person01")
    public Person getPerson(){
        return new Person("gzy",18);
    };
}
