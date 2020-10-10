package com.example.learnings.threading;

public class Main {

    public static void main(String[] args){
        try {
            System.out.println("mian out "+Thread.currentThread().getName());
            new Thread(new ThreadException()).start();
            System.out.println("main in "+Thread.currentThread().getName());
        }catch (Exception e){
            System.out.println("cathc "+Thread.currentThread().getName());
        }
    }
}
