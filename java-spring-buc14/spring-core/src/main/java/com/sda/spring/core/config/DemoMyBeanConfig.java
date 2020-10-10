package com.sda.spring.core.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMyBeanConfig {

    public static void main(String[] args) {
        //create context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        //get bean
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);

        //use bean
        myBean.complexOperation();
    }
}
