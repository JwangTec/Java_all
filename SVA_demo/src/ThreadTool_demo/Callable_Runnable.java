package ThreadTool_demo;

import java.util.concurrent.Callable;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午6:13
 */
public class Callable_Runnable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("开始");
        Thread.sleep(1000);
        System.out.println("结束");
        return "aa";
    }
}
