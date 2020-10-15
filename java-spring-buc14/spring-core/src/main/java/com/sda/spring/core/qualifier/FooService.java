package com.sda.spring.core.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    //by using the @Qualifier annotation we tell spring what implementation we want to use
    //for the bean formatter
    //try changing it in barFormatter to see what it prints
    @Autowired
    @Qualifier("fooFormatter")
    private Formatter formatter;

    public void run() {
        formatter.format();
    }
}
