package firstday;

import com.gzy.spring.firstday.cap2.config.Cap2Config;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap2ConfigTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Cap2Config.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String val : beanDefinitionNames){
            System.out.println(val);
        }
        //System.out.println(beanDefinition);
    }

}
