package firstday;

import com.gzy.spring.firstday.cap2.config.Cap2Config;
import com.gzy.spring.firstday.cap3.config.Cap3Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap3ConfigTest {

    /**
     * 测试spring容器是否默认是单实例
     */
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Cap3Config.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String val : beanDefinitionNames){
            System.out.println(val);
        }

        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1 == person2);
    }

}
