package com.gzy.spring.firstday.cp5;

import com.gzy.spring.firstday.Person;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = "com.gzy.spring.firstday.cp5")
public class Cap5Config {

    @Conditional(WinCondition.class)
    @Bean
    public Person getPersonByOsNameWindow(){
        System.out.println("给容器中添加对象window");
        return new Person("window",18);
    }
    @Conditional(LinuxCondition.class)
    @Bean
    public Person getPersonByOsNameLinux(){
        System.out.println("给容器中添加对象Linux");
        return new Person("window",18);
    }
}
