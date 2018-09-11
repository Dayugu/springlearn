package com.gzy.spring.firstday.cap1;

import com.gzy.spring.firstday.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean("person01")
    public Person getPerson(){
        return new Person("gzy",18);
    };

}
