package com.sda.spring.core.config.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoScanConfig {

    public static void main(String[] args) {
        //create context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanConfig.class);

        //get component
        MyComponent myComponent = applicationContext.getBean("myComponent", MyComponent.class);

        //get component with other component injected
        MyComponentWithOtherComponentInjected myComponentWithOtherComponentInjected =
                applicationContext.getBean("myComponentWithOtherComponentInjected",
                        MyComponentWithOtherComponentInjected.class);

        //use bean
        myComponent.complexOperation();

        //empty line
        System.out.println();

        //use other bean
        myComponentWithOtherComponentInjected.veryComplexOperations();
    }
}
