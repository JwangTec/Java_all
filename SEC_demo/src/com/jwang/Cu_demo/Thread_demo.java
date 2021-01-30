package com.jwang.Cu_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/30 下午6:15
 */
public class Thread_demo {
    /**
     * 线程：进程的一个执行单元，一个进程至少又一个线程，线程也是独立栈内存空间
     * 线程调度：
     *      --分时调度（轮流使用cpu和分配时间）
     *      --抢占式调度（优先级高的线程先使用，优先级相同-随机）（Java使用抢占式）
     * Thread类：
     *    --构造方法：
     *          Thread():分配一个新的线程对象，系统默认线程名
     *          Thread(String name)
     *          Thread(Runnable target):分配一个带有指定目标新的线程对象，Runnable任务接口
     *          Thread(Runnable target，String name)
     *     --线程作用：执行代码（任务）
     *     --创建线程：
     *          --- 继承Thread类
     *          --- 实现Runnable接口
     *              ---匿名内部类
     *     --创建多条线程
     *          --- 继承的方式 多创建几个线程对象
     *          --- 实现接口的方法
     *
     *     --常用方法：
     *          --- getName()：获取当前线程名称
     *          --- start()：此线程开始执行，JVM调用此线程的run方法
     *          --- run()：此线程要执行的任务（我们需要在此线程执行的代码）
     *          --- sleep(Long millis) - static：暂停
     *          --- currentThread()：当前正在执行线程对象的引用
     *     --继承和实现的方式创建线程的区别
     *          --- 继承为单继承，实现为多实现，也可以继承的同时实现，扩展性比较强，解决单继承缺点
     *          --- 适合多个相同的程序代码的线程去共享一个任务对象
     *          --- 继承的方法：任务和线程在同一个对象，实现：任务和线程是分开的 ，任务可以重复使用--结藕
     *          --- 线程池只能放入实现Runnable或Callable类线程，不能放入直接继承Thread的类
     *                  ---- Callable接口：call方法可以返回一个结果，而run方法不可以
     */

    public static void main(String[] args) {
        /*
        重写Thread类的子类--MyThread类
        子类中重写run方法（写入需要执行的代码）
        创建Thread类的子类对象（线程对象）
        线程对象用start方法，启动并执行线程

        一个Java程序至少有两个线程：一条主线程（main方法），一条垃圾回收线程
         */

        //继承Thread类
        MyThread mt = new MyThread();
        mt.start(); //线程启动，分配一个栈空间
        System.out.println("主线程");

        //实现Runnable接口
        /*
        创建一个实现类实现Runnable接口
        在实现类中重写run方法，放入执行任务
        创建实现类对象
        创建Thread线程对象，把实现类作为参数传入
        线程对象调用start方法，启动线程，执行任务
         */

        MyThread1 mt1 = new MyThread1();
        Thread th = new Thread(mt1);
        th.start();

        //匿名内部类
        final Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println("匿名" + i);
                }
            }
        });

        th3.start();

        //多线程--实现类方法
        MyThread1 c1 = new MyThread1(); //任务对象
        new Thread(c1, "1:").start(); //线程对象
        new Thread(c1, "2:").start();

        //继承
        new MyThread("1:").start(); //任务+线程对象
        new MyThread("2:").start();
    }
}
