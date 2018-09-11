package secondday;

import com.gzy.spring.secondday.cap6.config.Cap6MainConfig;
import com.gzy.spring.secondday.cap6.config.JamesFactoryBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap6Test {
    /**
     * @Description: TODO
     * @param 
     * @return 
     * @throws
     * @author gzy
     * @date 2018/8/22 13:58
     */
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Cap6MainConfig.class);

        //获取FactoryBean注入容器的实例
        Object jamesFactoryBean = context.getBean("jamesFactoryBean");
        System.out.println(jamesFactoryBean.getClass());

        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

    }
}
