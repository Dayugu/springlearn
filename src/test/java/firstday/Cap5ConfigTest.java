package firstday;

import com.gzy.spring.firstday.Person;
import com.gzy.spring.firstday.cap4.Cap4Config;
import com.gzy.spring.firstday.cp5.Cap5Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap5ConfigTest {

    /**
     * 测试spring容器是否默认是单实例
     */
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Cap5Config.class);

        System.out.println("---------srping容器初始完成-----------");
        Object person = applicationContext.getBean(Person.class);
    }

}
