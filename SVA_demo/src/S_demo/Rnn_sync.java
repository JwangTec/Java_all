package S_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午1:11
 */
public class Rnn_sync implements Runnable{

    int num = 100;

    @Override
    public void run() {
        while (true) {

            synchronized (this){  //加锁
                //都使用rnc这个任务对象，也可以在运行外定义一个其他对象传入
                if(num < 1){
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"正在出售："+num);
                num--;
            } //释放锁
        }
    }
}
