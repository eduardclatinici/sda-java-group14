package com.sda.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    //we need to have a class annotated with @Configuration
    //to create here all our beans with the @Bean annotation (using new)
    //we can inject the already created beans in other beans (dependency injection)
    //--the names of the created beans are actually the name of the methods
    //      in this class that creates the said beans
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBeanWithOtherBeanInjected myBeanWithOtherBeanInjected() {
        return new MyBeanWithOtherBeanInjected(myBean());
    }
}
