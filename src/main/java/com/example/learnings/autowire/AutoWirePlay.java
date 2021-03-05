package com.example.learnings.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AutoWirePlay {

    @Autowired
    Foo foo;

    @Autowired Child base;

    public AutoWirePlay() {
        System.out.println("init autoWirePlay");
//        foo.say();// throws NLE
    }

    @PostConstruct
    public void now(){
        foo.say();
        base.get("csdcs");
    }

    @Component
    public class Inner{
        public Inner() {
            System.out.println("autowiring inner");
            foo.say();// does throws NLE
        }

        @PostConstruct
        public void now(){
            foo.say();
        }
    }

}
