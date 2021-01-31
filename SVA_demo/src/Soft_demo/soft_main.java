package Soft_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 线程安全性问题
 * @USER: jwang
 * @DATE: 2021/1/31 下午2:19
 */
public class soft_main {
    /**
     * 可见性：一个线程没有看见另一个线程对共享变量的修改
     *      -- 对于子线程的修改主线程没有看到 -- main线程执行速度很快不清楚多久又会去主内存拷贝，会一直使用旧值
     * JMM内存模型：Java程序中各种变量（线程共享变量）的访问规则，以及在JVM中将变量存储和读取到内存的底层细节
     *      -- 所有共享变量都存在主内存（静态区）中，线程（各个栈）执行会进行拷贝到线程单独的工作内存中进行操作，不会直接读写主内存中的变量值
     * 有序性：有些时候"编译器"编译代码时，会对代码进行"重排"
     * 原子性：一次操作或者多次操作中，要么全部操作得到执行要么都不执行
     *      -- 多个线程对同一共享变量的操作可能会被覆盖
     *
     * 可见性与有序性问题解决方法
     *    - volatile关键字：变量修饰符，只能修饰成员变量，能强制线程每次从主内存获取值，并能保证此变量不会被编译器优化,禁止指令重排
     *              -- 不能解决原子性
     *
     *
     *
     */
    public static void main(String[] args) {
        Thread_demo th1 = new Thread_demo();
        th1.start();

        //主线程，存在死循环
        while (true) {
            if(Thread_demo.flag){
                System.out.println("结束死循环");
                break;
            }
        }
    }
}
