package com.example.learnings.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Base {

    @Autowired
    Foo foo;

    void get(String val){
        foo.say();
         System.out.println("awesfgfhfrgefwer439586u596u49453"+val+ value());
    }

    abstract String value();

}
