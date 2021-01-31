package COMASoft_demo;

import java.util.concurrent.Exchanger;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午5:48
 */
public class ExThread1 extends Thread{
    Exchanger<String> ex;

    public ExThread1(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        System.out.println("A change B");
        //交换
        try {
            final String messageB = ex.exchange("数据A");
            System.out.println("线程B给的数据为：" + messageB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
