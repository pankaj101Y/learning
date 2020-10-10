package com.example.learnings.autowire;

import org.springframework.stereotype.Component;

@Component
public class Foo {

    public Foo() {
        System.out.println("init  foo");
    }

    public void say(){
        System.out.println("foo is here ");
    }
}
