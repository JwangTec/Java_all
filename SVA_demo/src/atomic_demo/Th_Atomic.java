package atomic_demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午4:08
 */
public class Th_Atomic extends Thread{

    static int num = 0;
    static AtomicInteger num1 = new AtomicInteger(10);
    public static AtomicIntegerArray num2 = new AtomicIntegerArray(100);

    @Override
    public void run() {
        for (int i = 0; i < num2.length(); i++) {
            num2.addAndGet(i, 1); //i索引+1
        }
        System.out.println("end...");
    }
}
