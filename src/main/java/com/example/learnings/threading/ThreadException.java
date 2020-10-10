package com.example.learnings.threading;
/*
* exception is responsibility of current thread
* */
public class ThreadException implements Runnable{
    @Override
    public void run() {
        System.out.println("run "+Thread.currentThread().getName());
        excep();
    }

    public void excep(){
        System.out.println("excep "+Thread.currentThread().getName());
        throw new RuntimeException("execrptipn");
    }
}
