package S_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: a演示多锁
 * @USER: jwang
 * @DATE: 2021/1/31 下午2:00
 */
public class Person {

    public  synchronized void method(){ //锁对象为this -- p1
        System.out.println(Thread.currentThread().getName()+"aa");
        System.out.println(Thread.currentThread().getName()+"bb");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"cc");
        System.out.println(Thread.currentThread().getName()+"dd");
    }

    public static synchronized void method1(){ //锁对象为类字节码 -- Person.class
        System.out.println(Thread.currentThread().getName()+"aa");
        System.out.println(Thread.currentThread().getName()+"bb");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"cc");
        System.out.println(Thread.currentThread().getName()+"dd");
    }
}
