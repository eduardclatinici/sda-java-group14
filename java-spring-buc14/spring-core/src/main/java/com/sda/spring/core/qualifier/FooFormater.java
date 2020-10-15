package com.sda.spring.core.qualifier;

import org.springframework.stereotype.Component;

//this is how we define a component and how we specify what name it should have
@Component("fooFormatter")
public class FooFormater implements Formatter {
    @Override
    public String format() {
        System.out.println("foo");
        return "foo";
    }
}
