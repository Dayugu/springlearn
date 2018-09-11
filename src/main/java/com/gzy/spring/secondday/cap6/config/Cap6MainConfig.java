package com.gzy.spring.secondday.cap6.config;

import com.gzy.spring.firstday.Person;
import com.gzy.spring.secondday.cap6.bean.Cat;
import com.gzy.spring.secondday.cap6.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { Cat.class,JamesImportSelector.class})
public class Cap6MainConfig {
    /**
     * 给容器注册组件的方式：
     * 1.@Bean：导入第三方的类或者包的组件，。比如Person为第三方类，需要我们的IOC容器中使用
     * 2.包扫描+组件的标注注解（@ComponentScan: @Controller,@Service，@Respository,@Componet）
     * 3.@Import:快速给容器导入一个组件，注意@Bean有点简单，
     *          a:@Import(要导入到容器中的组件):容器会自动注册这个组件，bean的Id为全类名
     *          b:ImportSelector:是一个接口
     *          c:ImportBeanDefinitionRegistar
     * 4.使用Spring提供的FactoryBean（工厂bean）注册bean
     * @return
     */
    @Bean
    public Person person(){
        return new Person("window",18);
    }

    /**
     * 使用factoryBean注入spring容器
     * @return
     */
    @Bean
    public JamesFactoryBean jamesFactoryBean(){
        return new JamesFactoryBean();
    }
}
