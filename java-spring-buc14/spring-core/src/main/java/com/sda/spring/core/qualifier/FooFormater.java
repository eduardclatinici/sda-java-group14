package com.sda.spring.core.qualifier;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormater implements Formatter{
    @Override
    public String format() {
        System.out.println("foo");
        return "foo";
    }
}