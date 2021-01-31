package COMASoft_demo;

import java.util.concurrent.Exchanger;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午5:48
 */
public class ExThread2 extends Thread{
    Exchanger<String> ex;

    public ExThread2(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        System.out.println("B change A");
        //交换
        try {
            final String messageA = ex.exchange("数据B");
            System.out.println("线程A给的数据为：" + messageA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
