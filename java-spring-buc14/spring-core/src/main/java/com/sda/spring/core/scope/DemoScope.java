package com.sda.spring.core.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoScope {

    public static void main(String[] args) {
        //create context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);

        createSingletonService(applicationContext);
        System.out.println();
        createPrototypeService(applicationContext);

    }

    private static void createSingletonService(ApplicationContext applicationContext){
        //get bean
        SingletonService singletonService1 = applicationContext.getBean("singletonService", SingletonService.class);

        //get bean
        SingletonService singletonService2 = applicationContext.getBean("singletonService", SingletonService.class);

        //use beans
        System.out.println(singletonService1);
        System.out.println(singletonService2);
    }

    private static void createPrototypeService(ApplicationContext applicationContext) {
        //get bean
        PrototypeService prototypeService1 = applicationContext.getBean("prototypeService", PrototypeService.class);
        //get bean
        PrototypeService prototypeService2 = applicationContext.getBean("prototypeService", PrototypeService.class);
        //use beans
        System.out.println(prototypeService1);
        System.out.println(prototypeService2);
    }
}
