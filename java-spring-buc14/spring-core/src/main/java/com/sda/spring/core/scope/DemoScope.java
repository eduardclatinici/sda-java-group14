package com.sda.spring.core.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoScope {

    //notice how if we run this main method, the singleton bean will print the same hash even though
    //  we take it 2 times from the application context (this means that the application context will
    //      always return the same instance of this bean) while the prototype bean will print
    //          different hashes (meaning that every time we ask the application context to give a bean of
    //              the prototype type it will create a new instance)
    public static void main(String[] args) {
        //create context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);

        createSingletonService(applicationContext);
        System.out.println();
        createPrototypeService(applicationContext);

    }

    private static void createSingletonService(ApplicationContext applicationContext) {
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
