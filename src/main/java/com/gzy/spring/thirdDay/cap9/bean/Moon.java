package com.gzy.spring.thirdDay.cap9.bean;

import org.springframework.stereotype.Component;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/9/11 16:39
 */
@Component
public class Moon {

    public Moon(){
        System.out.println("Moon constructor ..... ");
    }

    public void init(){
        System.out.println("Moon ... init.......");
    }

    public void destroy(){
        System.out.println("Moon....destroy......");
    }

}
