package S_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: synchronized关键字
 * @USER: jwang
 * @DATE: 2021/1/31 下午1:06
 */
public class sync_demo {

    /**
     * synchronized：互斥效果
     *      同步代码块：synchronized关键字可以用于方法区中的某个区块中，表示只对这个区块的资源进行互斥访问-一个线程正在操作，其他线程等待
     *      synchronized(锁对象){代码块}
     *          -锁对象：可以是任何类的对象，多个锁对象需要唯一才能实现同步
     *
     *      同步方法：synchronized关键字修饰的方法
     *      修饰符 synchronized 返回值类型 方法名（）{}
     *          --锁对象：非静态同步方法：this  静态同步方法：该方法所在类的字节码对象：类名.class
     *                  A线程使用同步代码块，B线程使用同步方法，需要实现同步，锁对象需要一致-同步代码块的锁对象就只能是使用同步方法中对象
     *                  同步代码块+静态同步方法：只能是静态同步方法所在类的字节码对象
     * Lock(接口):加锁和释放锁不固定
     *      实现类：ReentrantLock创建lock对象
     *      方法：lock()--加同步锁
     *           unLock()--释放同步锁
     *
     */
    public static void main(String[] args) {
        Rnn_sync rnc = new Rnn_sync();
//        new Thread(rnc,"线程1").start();
//        new Thread(rnc,"线程2").start();
//        new Thread(rnc,"线程3").start();
//        new Thread(rnc,"线程4").start();

        Method_sync mnc = new Method_sync();
//        new Thread(mnc, "线程1").start();
//        new Thread(mnc, "线程2").start();
//        new Thread(mnc, "线程3").start();
//        new Thread(mnc, "线程4").start();

        Lock_C lnc = new Lock_C();
//        new Thread(lnc, "线程1").start();
//        new Thread(lnc, "线程2").start();
//        new Thread(lnc, "线程3").start();
//        new Thread(lnc, "线程4").start();


        Person p1 = new Person();

        new Thread(new Runnable() {
            @Override
            public void run() {
                p1.method();  //锁对象：在方法上加的同步锁--锁对象为this--p1
            }
        },"线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (p1) { //同步代码块的锁对象就需要指定为p1,这里this为new Runnable()这个对象
                    System.out.println(Thread.currentThread().getName()+"aa");
                    System.out.println(Thread.currentThread().getName()+"bb");
                    System.out.println(Thread.currentThread().getName()+"cc");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"dd");
                }
            }
        },"线程2").start();

    }

}
