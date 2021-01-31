package COMASoft_demo;

import java.util.concurrent.CountDownLatch;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午5:04
 */
public class Mythread2 extends Thread{

    CountDownLatch cld;

    public Mythread2(CountDownLatch cld) {
        this.cld = cld;
    }

    @Override
    public void run() {
        System.out.println("B");
        cld.countDown();
    }
}
