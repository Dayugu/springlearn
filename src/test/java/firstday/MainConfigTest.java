package firstday;

import com.gzy.spring.firstday.cap1.MainConfig;
import com.gzy.spring.firstday.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainConfigTest {

    /**
     * 通过xml配置文件获取bean
     */
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("firstday/bean.xml");
        Person persion = (Person)applicationContext.getBean("person");

        System.out.println(persion);

    }

    /**
     * 根据注解注入bean
     */
    @Test
    public void test2(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person persion = (Person)applicationContext.getBean("person");

        System.out.println(persion);

    }

    /**
     * 根据注解注入bean,修改bean注入的名称
     */
    @Test
    public void test3(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person persion = (Person)applicationContext.getBean("person01");

        System.out.println(persion);

    }




}
