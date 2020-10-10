package com.sda.spring.core.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoAutowired {

    public static void main(String[] args) {
        //create context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);

        TextEditor textEditor = (TextEditor) applicationContext.getBean("textEditor");
        textEditor.spellCheck();
        textEditor.convertImage();
        textEditor.format();

    }
}
