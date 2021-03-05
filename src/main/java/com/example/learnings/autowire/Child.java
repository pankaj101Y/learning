package com.example.learnings.autowire;

import org.springframework.stereotype.Component;

@Component
public class Child extends Base{

    @Override
    String value() {
        return "base";
    }
}
