package com.example.customspringbootstarterautoconfigure.service.auto;

import com.example.customspringbootstarterautoconfigure.helloService;
import com.example.customspringbootstarterautoconfigure.service.bean.helloProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(helloService.class)
@EnableConfigurationProperties(helloProperties.class)
public class helloServiceAutoConfiguration {

    @Bean
    public helloService helloService() {
        helloService helloService = new helloService();
        return helloService;
    }
}
