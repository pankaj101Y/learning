package com.example.learnings.annotations;


public class Main {

    public static void main(String[] args) {
        Class<?> annotation= Foo.class;

        MyAnnotation myAnnotation=annotation.getAnnotation(MyAnnotation.class);

        System.out.println(myAnnotation.toString());


        System.out.println(myAnnotation.isTrue());
        System.out.println(myAnnotation.value());
    }
}
