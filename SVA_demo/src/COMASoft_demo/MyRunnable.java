package COMASoft_demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午5:15
 */
public class MyRunnable implements Runnable{

    CyclicBarrier cy;

    public MyRunnable(CyclicBarrier cy) {
        this.cy = cy;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"到了");
        //通知其到达
        try {
            cy.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"离开");
    }

}
