package com.jwang.Cu_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/30 下午6:28
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        //执行的代码
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
    }
}
