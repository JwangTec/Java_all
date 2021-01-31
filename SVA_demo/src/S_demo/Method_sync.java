package S_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午1:26
 */
public class Method_sync implements Runnable{

    int num = 100;

    @Override
    public void run() {
        while (true){
            if (sellNum()) break;
        }
    }

    private synchronized boolean sellNum() { //加锁
        if(num < 1){
            return true;
        }
        System.out.println(Thread.currentThread().getName()+"第"+num);
        num--;
        return false;
    } //释放锁
}
