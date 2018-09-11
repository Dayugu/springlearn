package com.gzy.spring.secondday.cap6.config;

import com.gzy.spring.secondday.cap6.bean.Dog;
import org.springframework.beans.factory.FactoryBean;

public class JamesFactoryBean implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        return new Dog();
    }
    /**
     * @Description: TODO
     * @param 
     * @return 
     * @throws
     * @author gzy
     * @date 2018/8/22 16:49
     */
    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }
    //判断是单例模式还是多例模式
    @Override
    public boolean isSingleton() {
        return true;
    }
}
