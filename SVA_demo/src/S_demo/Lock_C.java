package S_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午1:45
 */
public class Lock_C implements Runnable{
    int num = 100;
    //创建lock对象 多态
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            //加锁
            lock.lock();
            if(num < 1){
                lock.unlock();
                break;
            }
            System.out.println(Thread.currentThread().getName()+"第"+num);
            num--;
            //释放锁
            lock.unlock();
        }
    }
}
