package com.gzy.spring.thirdDay.cap9.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/9/11 16:40
 */
@Component
public class Sun {

    private Moon moon;

    public Sun(Moon moon) {
        this.moon = moon;
        System.out.println("..Sun ..Constructor................");

    }

    public Moon getMoon() {
        System.out.println(".getMoon ...Constructor................");
        return moon;
    }

    public void setMoon(@Autowired Moon moon) {
        this.moon = moon;
    }
}
