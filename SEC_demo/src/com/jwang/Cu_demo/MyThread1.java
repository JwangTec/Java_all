package com.jwang.Cu_demo;

public class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName()+"runnable线程"+i);
        }
    }
}
