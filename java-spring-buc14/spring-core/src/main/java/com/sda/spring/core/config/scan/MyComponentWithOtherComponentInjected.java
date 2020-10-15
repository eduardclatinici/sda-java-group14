package com.sda.spring.core.config.scan;

import org.springframework.stereotype.Component;

@Component
public class MyComponentWithOtherComponentInjected {

    MyComponent myComponent;

    //even if with this method we don't need to explicitly use the new keyword to create the beans
    // in the class annotated with @Configuration we still need to define the constructor in the beans
    // where we want to inject other beans for spring to use (it does magic, but we need to help it :D)
    MyComponentWithOtherComponentInjected(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    public void veryComplexOperations() {
        System.out.println("This component has another component injected and it really does some ");
        myComponent.complexOperation();
    }
}
