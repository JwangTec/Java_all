package COMASoft_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午5:29
 */
public class Runnable_do implements Runnable{
    method_all ma;

    public Runnable_do(method_all ma) {
        this.ma = ma;
    }

    @Override
    public void run() {

        ma.method1();
    }
}
