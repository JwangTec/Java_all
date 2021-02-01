package WaitNotify_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/1 下午1:27
 */
public class WN_main {
    public static void main(String[] args) {
        Object lock1 = new Object();

        final Thread n1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("线程1：调用wait等待");
                    try {
                        lock1.wait(); //释放锁，不会进行抢占
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("线程1：被唤醒");
                }
            }
        });

        n1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("线程2：准备调用notify方法唤醒");
                    lock1.notify(); //线程一进入锁阻塞
                } //这里锁被释放，线程一才能获得锁进入runnable
            }
        }).start();
    }
}
