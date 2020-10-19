package com.example.learnings;

import com.example.learnings.validation.Person;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StackTraceElement[] stackTraceElements=new Exception("").getStackTrace();
        Person[] people={};
        System.out.println(people.getClass());
        System.out.println(people.getClass().getName());

    }
}
