package COMASoft_demo;

import atomic_demo.Th_Atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 并发包concurrent
 * @USER: jwang
 * @DATE: 2021/1/31 下午4:29
 */
public class CopyOnWriteArrayXX_main {
    public static void main(String[] args) {
        /**
         * CopyOnWriteArrayList
         * CopyOnWriteArraySet
         * Hashtable:sync锁 --java.util包下的
         * ConcurrentHashMap：CAS机制+局部sync锁（只对桶）
         *
         * CountdownLatch:一个或多个线程等待其他线程完成操作
         *      -构造方法：
         *          -- CountDownLatch(int count):初始化一个指定计数器的CountDownLatch对象
         *              ---count:需要等待的线程数
         *      -成员方法：
         *          -- await() throws InterruptedException: 当前线程等待，当计数器为0时结束等待
         *          -- countDown():计数器减1
         * CyclicBarrier:一组线程到达一个屏障（Barrier）（同步点）被阻塞，直到最后一个线程到达屏障，所有拦截线程又开始执行
         *      -构造方法：
         *          -- CyclicBarrier(int parties, Runnable barrierAction)
         *              parties:到达屏障的线程数量
         *              barrierAction：到达后执行的线程
         *      -成员方法：
         *          --await():每个线程告诉其cy到达屏障，当前线程阻塞
         * Semaphore:控制线程的并发数量--设置几个线程执行
         *      -构造方法：Semaphore(int permits)
         *              permits:表示许可线程的数量
         *      -成员方法：
         *             -- acquire():获取许可
         *             --release()：释放许可
         * Exchange:交换者：是一个用于线程间协作的工具类，用于进行线程间数据交换，
         *      -构造方法：空参构造
         *      -成员方法：exchange(V x):参数：交换的数据，返回值：对方线程传递的数据
         *          -- 一个线程执行该方法后，会一直等待另一个线程也执行该方法
         *
         */

//        current_demo();
//        countDownLatch_demo();

//        CyclicBarrer();

//        semPhore_demo();

        Exchanger<String> ex =new Exchanger<>();
        new ExThread1(ex).start();
        new ExThread2(ex).start();


    }

    private static void semPhore_demo() {
        method_all ma = new method_all();
        Runnable_do rn = new Runnable_do(ma);

        new Thread(rn,"A执行method1").start();
        new Thread(rn,"B执行method1").start();
        new Thread(rn,"C执行method1").start();
    }

    private static void CyclicBarrer() {
        CyclicBarrier cy = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("开始");
            }
        });

        //任务
        MyRunnable mr = new MyRunnable(cy);
        new Thread(mr, "线程1").start();
        new Thread(mr, "线程2").start();
        new Thread(mr, "线程3").start();
        new Thread(mr, "线程4").start();
        new Thread(mr, "线程5").start();
    }

    private static void countDownLatch_demo() {
        final CountDownLatch latch = new CountDownLatch(1);
        new Mythread1(latch).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Mythread2(latch).start();
    }


    private static void current_demo() {
        new MyThread().start();
        new MyThread().start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(MyThread.arr.size()); //最终结果可能会抛异常，或者集合大小不正确
//        System.out.println(MyThread.arr1.size()); //20000
//        System.out.println(MyThread.set1.size()); //最终结果可能会抛异常，或者长度不正确
//        System.out.println(MyThread.set2.size()); //10000
//        System.out.println(MyThread.map1.size()); //最终结果可能会抛异常，或者长度不正确
    }
}
