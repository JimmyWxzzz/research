package modules.boot.confit;

import modules.boot.bean.Car;
import modules.boot.bean.Pet;
import modules.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingBean(name = "tomcat")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
public class Myconfig {



    @Bean
    public User user01() {
        User user = new User("zhangsan", 18);
        user.setPet(tomcat());
        return user;
    }

    @Bean
    public Pet tomcat() {
        return new Pet("tomcat");
    }


}
