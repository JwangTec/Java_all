package COMASoft_demo;

import java.util.concurrent.CountDownLatch;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午4:59
 */
public class Mythread1 extends Thread{

    CountDownLatch cld; //用成员变量的方法使其能在整个类中使用

    public Mythread1(CountDownLatch cld){
        this.cld = cld;
    }

    @Override
    public void run() {
        System.out.println("A");
        try {
            cld.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C");
    }
}
