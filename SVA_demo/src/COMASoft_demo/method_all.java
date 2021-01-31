package COMASoft_demo;

import java.util.concurrent.Semaphore;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午5:27
 */
public class method_all {
    Semaphore sm = new Semaphore(2);

    public void method1(){
        //获得许可
        try {
            sm.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"进入方法执行");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"执行完成，离开");


        //释放许可
        sm.release();
    }
}
