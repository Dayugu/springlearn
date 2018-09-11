package com.gzy.spring.firstday.cp5;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    /**
     * ConditionContext:判断可以使用的上下文
     * AnnotatedTypeMetadata:注释的信息
     * @param conditionContext
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        //能获取到IOC容器正在使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取当前环境变量（包括我们操作系统是WIN还是Linux?）
        Environment environment = conditionContext.getEnvironment();
        String os_name = environment.getProperty("os.name");

        if(os_name.contains("linux")){
            return true;
        }else{
            return false;
        }
    }
}
