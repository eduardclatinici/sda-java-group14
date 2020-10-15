package com.sda.spring.core.config;

public class MyBeanWithOtherBeanInjected {

    //notice that MyBeanWithOtherBeanInjected uses the method "complexStuff" from "MyBean" without insantiating
    //  the myBean variable
    MyBean myBean;

    //this is possible because in the "BeanConfig" class we create both beans and inject the instance of "MyBean"
    //  inside of "MyBeanWithOtherBeanInjected" constructor
    MyBeanWithOtherBeanInjected(MyBean myBean) {
        this.myBean = myBean;
    }

    public void veryComplexOperations() {
        System.out.println("This bean has another bean injected and it really does some ");
        myBean.complexOperation();
    }

}
