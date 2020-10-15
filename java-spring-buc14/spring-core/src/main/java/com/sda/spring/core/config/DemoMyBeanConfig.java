package com.sda.spring.core.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMyBeanConfig {

    public static void main(String[] args) {
        //create context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        //get bean
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);

        //get bean with other bean injected
        MyBeanWithOtherBeanInjected myBeanWithOtherBeanInjected =
                applicationContext.getBean("myBeanWithOtherBeanInjected", MyBeanWithOtherBeanInjected.class);

        //use bean
        myBean.complexOperation();

        //empty line
        System.out.println();

        //use bean that uses a method from the injected bean
        myBeanWithOtherBeanInjected.veryComplexOperations();
    }
}
