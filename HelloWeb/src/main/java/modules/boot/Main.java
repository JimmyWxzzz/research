package modules.boot;

import modules.boot.bean.Pet;
import modules.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


//@SpringBootApplication(scanBasePackages = "modules")
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("modules")
public class Main {
    public static void main (String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);

//        Pet tom1 = run.getBean("tomcat", Pet.class);
//        Pet tom2 = run.getBean("tomcat", Pet.class);
//        System.out.println(tom1==tom2);
//
//        User user1 = run.getBean ("user01", User.class);
//        Pet pet1 = run.getBean("tomcat",Pet.class);
//
//        System.out.println(user1.getPet()==pet1);

        boolean tom = run.containsBean("tomcat");
        System.out.println(tom);
        boolean user01 = run.containsBean("user01");
        System.out.println(user01);
        boolean one = run.containsBean("one");
        boolean two = run.containsBean("two");
        System.out.println(one);
        System.out.println(two);

        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println(beanNamesForType.length);
        
    }
}
